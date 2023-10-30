package br.com.api.trabapi.controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.trabapi.config.JWTUtil;
import br.com.api.trabapi.dto.LoginDTO;
import br.com.api.trabapi.dto.UsuarioDTO;
import br.com.api.trabapi.dto.UsuarioRespostaDTO;
import br.com.api.trabapi.entities.Endereco;
import br.com.api.trabapi.entities.LoginResponse;
import br.com.api.trabapi.entities.Role;
import br.com.api.trabapi.entities.Usuario;
import br.com.api.trabapi.enums.TipoRoleEnum;
import br.com.api.trabapi.repositories.EnderecoRepository;
import br.com.api.trabapi.repositories.RoleRepository;
import br.com.api.trabapi.repositories.UsuarioRepository;
import br.com.api.trabapi.services.EmailService;
import br.com.api.trabapi.services.EnderecoService;
import br.com.api.trabapi.services.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	UsuarioService usuarioService;
	@Autowired
	private JWTUtil jwtUtil;
	@Autowired
	private AuthenticationManager authManager;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	RoleRepository roleRepository;
	@Autowired
	EnderecoService enderecoService;
	@Autowired
	UsuarioRepository usuarioRepository;
	@Autowired
	EnderecoRepository enderecoRepository;

	private EmailService emailService;

	@Autowired
	public void setEmailService(EmailService emailService) {
		this.emailService = emailService;
	}

	@GetMapping("/count")
	public Integer getCount() {

		return usuarioService.getCount();
	}

	@GetMapping("/{id}")
	public UsuarioRespostaDTO acharId(@PathVariable Integer id) {
		return usuarioService.acharId(id);
	}

	@GetMapping("/listar")
	public List<UsuarioRespostaDTO> listar() {
		return usuarioService.listar();
	}

	@DeleteMapping("/deletarLogico/{id}")
	public void deletarLogico(@PathVariable Integer id) {
		emailService.envioEmailDelete(usuarioRepository.findById(id).get());
		usuarioService.deletarLogico(id);
	}

//	@PutMapping("/atualizar/{id}")
//	public Usuario atualizar(@PathVariable Integer id, @RequestBody UsuarioDTO objetousuario) {
//		return usuarioService.atualizar(id, objetousuario);
//	}

	@PutMapping("/recuperarSenha/{id}")
	public void recuperarSenha(@PathVariable Integer id, @RequestParam String senha) {
		usuarioService.recuperarSenha(id, senha);
		emailService.envioEmailRecuperacaoSenha(usuarioRepository.findById(id).get());
	}

	@PutMapping("/recuperarConta/{id}")
	public void recuperarConta(@PathVariable Integer id) {
		usuarioService.recuperarConta(id);
		emailService.envioEmailRecuperacaoConta(usuarioRepository.findById(id).get());
	}

	// Registro de usuario
	@SuppressWarnings("unused")
	@PostMapping("/registro")
	public Usuario cadastro(@RequestParam String email, @RequestBody UsuarioDTO usuario) {

		// usuario = usuarioService.save(usuario);

		// Gerando o token JWT a partir do e-mail do Usuario
		// String token = jwtUtil.generateToken(usuario.getEmail());
		Set<String> usuarioMaiusculo =new HashSet<>();
		
		for (String str : usuario.getRoles()) {
			usuarioMaiusculo.add(str.toUpperCase());
        }
		
		Set<String> strRoles = usuarioMaiusculo;
		Set<Role> roles = new HashSet<>();

		if (strRoles == null) {
			// Se não houver roles especificadas, atribui o papel de USUÁRIO
			Role usuarioRole = roleRepository.findByName(TipoRoleEnum.ROLE_PROPRIETARIO)
					.orElseThrow(() -> new RuntimeException("Erro: Role não encontrada."));
			roles.add(usuarioRole);
		} else {
			// Mapeando roles especificadas para objetos Role
			strRoles.forEach(role -> {
				switch (role) {
				case "PROPRIETARIO":
					Role adminRole = roleRepository.findByName(TipoRoleEnum.ROLE_PROPRIETARIO)
							.orElseThrow(() -> new RuntimeException("Erro: Role não encontrada."));
					roles.add(adminRole);
					break;
				case "INQUILINO":
					Role usuarioRole = roleRepository.findByName(TipoRoleEnum.ROLE_INQUILINO)
							.orElseThrow(() -> new RuntimeException("Erro: Role não encontrada."));
					roles.add(usuarioRole);
				case "FIADOR":
					 usuarioRole = roleRepository.findByName(TipoRoleEnum.ROLE_FIADOR)
					.orElseThrow(() -> new RuntimeException("Erro: Role não encontrada."));
					roles.add(usuarioRole);
				}
			});
		}

		Endereco viaCep = enderecoService.pesquisarEndereco(usuario.getCep());
		Endereco endereco = new Endereco();
		endereco.setCep(usuario.getCep());
		endereco.setComplemento(usuario.getComplemento());
		endereco.setNumero(usuario.getNumero());
		endereco.setBairro(viaCep.getBairro());
		endereco.setLocalidade(viaCep.getLocalidade());
		endereco.setLogradouro(viaCep.getLogradouro());
		endereco.setUf(viaCep.getUf());
		endereco.setAtivo(true);

		Usuario usuarioResumido = new Usuario();
		usuarioResumido.setAtivo(true);
		usuarioResumido.setNomeUsuario(usuario.getNomeUsuario());
		usuarioResumido.setEmail(usuario.getEmail());
		usuarioResumido.setRoles(roles);
		usuarioResumido.setCpf(usuario.getCpf());
		usuarioResumido.setDataNascimento(usuario.getDataNascimento());
		usuarioResumido.setNome(usuario.getNome());
		// Encriptando a senha usando o Bcrypt
		String encodedPass = passwordEncoder.encode(usuario.getPassword());
		usuarioResumido.setPassword(encodedPass);
		usuarioRepository.save(usuarioResumido);

		List<Endereco> enderecos = new ArrayList<>();
		enderecos.add(endereco);
		usuarioResumido.setEndereco(enderecos);
//        String token = jwtUtil.generateTokenWithUsuarioData(usuarioResumido);
//        Collections.singletonMap("jwt-token", token);

		enderecoRepository.save(endereco);
		emailService.envioEmailCadastro(usuario);
		return usuarioRepository.save(usuarioResumido);
	}

	@PostMapping("/login")
	public LoginResponse login(@RequestBody LoginDTO body) {
		try {
			// Criando o token que sera usado no processo de autenticacao
			UsernamePasswordAuthenticationToken authInputToken = new UsernamePasswordAuthenticationToken(
					body.getEmail(), body.getPassword());

			// Autenticando as credenciais de login
			authManager.authenticate(authInputToken);

			// Se o processo de autenticacao foi concluido com sucesso - etapa anterior,
			// eh gerado o JWT
//            String token = jwtUtil.generateToken(body.getEmail());

			Usuario usuario = usuarioService.findByEmail(body.getEmail());
			Usuario usuarioResumido = new Usuario();
			usuarioResumido.setNomeUsuario(usuario.getNomeUsuario());
//			usuarioResumido.setNome(usuario.getNome());
//			usuarioResumido.setCpf(usuario.getCpf());
//			usuarioResumido.setDataNascimento(usuario.getDataNascimento());
//			usuarioResumido.setAtivo(true);
//			usuarioResumido.setAluguels(usuario.getAluguels());
//			usuarioResumido.setApartamentos(usuario.getApartamentos());
//			usuarioResumido.setEndereco(usuario.getEndereco());
			usuarioResumido.setEmail(usuario.getEmail());
			usuarioResumido.setId(usuario.getId());
			usuarioResumido.setRoles(usuario.getRoles());
			// Gerando o token JWT a partir dos dados do Usuario
			String token = jwtUtil.generateTokenWithUsuarioData(usuarioResumido);

			// Responde com o JWT
			return new LoginResponse(token);
		} catch (AuthenticationException authExc) {
			throw new RuntimeException("Credenciais Invalidas");
		}
	}
	
	
	
	// Login de usuario
//	@PostMapping("/login")
//	public Map<String, Object> login(@RequestBody LoginDTO body) {
//		try {
//			// Criando o token que sera usado no processo de autenticacao
//			UsernamePasswordAuthenticationToken authInputToken = new UsernamePasswordAuthenticationToken(
//					body.getEmail(), body.getPassword());
//
//			// Autenticando as credenciais de login
//			authManager.authenticate(authInputToken);
//
//			// Se o processo de autenticacao foi concluido com sucesso - etapa anterior,
//			// eh gerado o JWT
////            String token = jwtUtil.generateToken(body.getEmail());
//
//			Usuario usuario = usuarioService.findByEmail(body.getEmail());
//			Usuario usuarioResumido = new Usuario();
//			usuarioResumido.setNomeUsuario(usuario.getNomeUsuario());
////			usuarioResumido.setNome(usuario.getNome());
////			usuarioResumido.setCpf(usuario.getCpf());
////			usuarioResumido.setDataNascimento(usuario.getDataNascimento());
////			usuarioResumido.setAtivo(true);
////			usuarioResumido.setAluguels(usuario.getAluguels());
////			usuarioResumido.setApartamentos(usuario.getApartamentos());
////			usuarioResumido.setEndereco(usuario.getEndereco());
//			usuarioResumido.setEmail(usuario.getEmail());
//			usuarioResumido.setId(usuario.getId());
//			usuarioResumido.setRoles(usuario.getRoles());
//			// Gerando o token JWT a partir dos dados do Usuario
//			String token = jwtUtil.generateTokenWithUsuarioData(usuarioResumido);
//
//			// Responde com o JWT
//			return Collections.singletonMap("jwt-token", token);
//		} catch (AuthenticationException authExc) {
//			throw new RuntimeException("Credenciais Invalidas");
//		}
//	}

}
package br.com.api.trabapi.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.api.trabapi.entities.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

	@Query(value = "select count(*) from usuario ", nativeQuery = true)
	public Integer contar();

//	@Query(value = "SELECT column FROM   \r\n"
//			+ "	ORDER BY RAND()  \r\n"
//			+ "	LIMIT 1 ")
//	public List<Produto> promo;
	

	Optional<Usuario> findByEmail(String email);
}
package br.com.api.trabapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.trabapi.dto.RoleDTO;
import br.com.api.trabapi.entities.Role;
import br.com.api.trabapi.repositories.RoleRepository;

@Service
public class RoleService {
	
	@Autowired
	RoleRepository roleRepository;

	public Role parseDeRole(RoleDTO objeto) {
		Role role = new Role();
		
		role.setName(objeto.getName());
		
		return role;
	}
	
	public Role save(RoleDTO role) {
		Role rolem =parseDeRole(role);
		return roleRepository.save(rolem);
	}
}

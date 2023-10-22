package br.com.api.trabapi.repositories;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.api.trabapi.entities.Role;
import br.com.api.trabapi.enums.TipoRoleEnum;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>{

	Optional<Role> findByName(TipoRoleEnum roleUser);
	
	@Query(value="select r.* from usuario u \r\n"
			+ "inner join usuario_role ur on u.id = ur.usuario_id\r\n"
			+ "inner join roles r on ur.role_id = r.id\r\n"
			+ "where u.email = :email", nativeQuery=true)
	Set<Role> roles(String email);
	
}

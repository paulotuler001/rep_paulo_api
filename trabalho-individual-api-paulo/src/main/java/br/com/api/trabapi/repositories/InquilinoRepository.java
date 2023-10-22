package br.com.api.trabapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.api.trabapi.entities.Inquilino;

@Repository
public interface InquilinoRepository extends JpaRepository<Inquilino, Integer> {

	@Query(value = "select count(*) from categoria ", nativeQuery = true)
	public Integer contar();

}

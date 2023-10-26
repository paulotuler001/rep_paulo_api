package br.com.api.trabapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.api.trabapi.entities.Apartamento;

@Repository
public interface ApartamentoRepository extends JpaRepository<Apartamento, Integer> {

	@Query(value = "select count(*) from apartamento ", nativeQuery = true)
	public Integer contar();

}

package br.com.api.trabapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.api.trabapi.entities.Aluguel;

@Repository
public interface AluguelRepository extends JpaRepository<Aluguel,Integer> {
	
	@Query(value="select count(*) from aluguel ", nativeQuery=true)
    public Integer contar();
}

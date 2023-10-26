
package br.com.api.trabapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.api.trabapi.entities.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {
	
	@Query(value="select count(*) from endereco ", nativeQuery=true)
    public Integer contar();

}




package com.deloitte.ecommerce.repository;

import com.deloitte.ecommerce.domain.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin("http://localhost:4200")
@RepositoryRestResource
public interface StateRepository extends JpaRepository<State, Integer> {

//    pegar um estado dado um pais (api/states/search/findByCountryCode?code=CODG DO PAIS)
    List<State> findByCountryCode(@Param("code") String code);
}

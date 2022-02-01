package com.deloitte.ecommerce.repository;

import com.deloitte.ecommerce.domain.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;

@CrossOrigin("http://localhost:4200")
public interface ProductRepository extends JpaRepository<Product, Long> {

    //    todo metodo "findby" é considerado como "query" que ja nos da endpoint com o mesmo nome do metodo: search/findByCategoryId?id=1
//    page é uma sublista
    Page<Product> findByCategoryId(@RequestParam("id") Long id, Pageable pageable);
}

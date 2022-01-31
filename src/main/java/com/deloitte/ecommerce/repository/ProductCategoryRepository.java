package com.deloitte.ecommerce.repository;

import com.deloitte.ecommerce.domain.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//@ de customizacao: productCategory é o nome do JSON de entrada e o path /product-category
@RepositoryRestResource(collectionResourceRel = "productCategory", path="product-category")
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {

}

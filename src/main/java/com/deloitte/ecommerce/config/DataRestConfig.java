package com.deloitte.ecommerce.config;

import com.deloitte.ecommerce.domain.Product;
import com.deloitte.ecommerce.domain.ProductCategory;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class DataRestConfig implements RepositoryRestConfigurer {

//    metodo criado atraves do implement method com o botao direito
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        RepositoryRestConfigurer.super.configureRepositoryRestConfiguration(config, cors);

// aqui sim foi codado, desabilitando esses metodos para produo e categoria:
        HttpMethod[] theUnsupportedActions = {HttpMethod.PUT, HttpMethod.POST, HttpMethod.DELETE};

        config.getExposureConfiguration()
            .forDomainType(Product.class)
            .withItemExposure((metdata, httpMethods)-> httpMethods.disable(theUnsupportedActions))
            .withCollectionExposure((metdata, httpMethods)-> httpMethods.disable(theUnsupportedActions));

        config.getExposureConfiguration()
            .forDomainType(ProductCategory.class)
            .withItemExposure((metdata, httpMethods)-> httpMethods.disable(theUnsupportedActions))
            .withCollectionExposure((metdata, httpMethods)-> httpMethods.disable(theUnsupportedActions));

// agra quando tentamos fazer um metodo post, por exemplo, aparece: 405 Method Not Allowed

    }



}

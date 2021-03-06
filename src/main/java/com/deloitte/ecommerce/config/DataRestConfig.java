package com.deloitte.ecommerce.config;

import com.deloitte.ecommerce.domain.Country;
import com.deloitte.ecommerce.domain.Product;
import com.deloitte.ecommerce.domain.ProductCategory;
import com.deloitte.ecommerce.domain.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import javax.persistence.EntityManager;
import javax.persistence.metamodel.EntityType;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Configuration
public class DataRestConfig implements RepositoryRestConfigurer {

    private EntityManager entitiyManager;

    @Autowired
    public DataRestConfig(EntityManager theEntityManager){
        entitiyManager = theEntityManager;
    }

//    metodo criado atraves do implement method com o botao direito
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        RepositoryRestConfigurer.super.configureRepositoryRestConfiguration(config, cors);

// aqui sim foi codado, desabilitando esses metodos para produo e categoria:
        HttpMethod[] theUnsupportedActions = {HttpMethod.PUT, HttpMethod.POST, HttpMethod.DELETE};

        disableHttpMethods(Product.class, config, theUnsupportedActions);
        disableHttpMethods(ProductCategory.class, config, theUnsupportedActions);

        disableHttpMethods(Country.class, config, theUnsupportedActions);
        disableHttpMethods(State.class, config, theUnsupportedActions);

// agra quando tentamos fazer um metodo post, por exemplo, aparece: 405 Method Not Allowed
// chamar metodo auxiliar para "expor" os ids
        exposeIds(config);
    }

//    metodo criado pois o cdg estava se repetindo. selecionando ele -> refactor -> extract method
//    apenas alterarmos adicionando novo parametro classe e alterando a linha forDomainType
    private void disableHttpMethods(Class theClass, RepositoryRestConfiguration config, HttpMethod[] theUnsupportedActions) {
        config.getExposureConfiguration()
            .forDomainType(theClass)
            .withItemExposure((metdata, httpMethods)-> httpMethods.disable(theUnsupportedActions))
            .withCollectionExposure((metdata, httpMethods)-> httpMethods.disable(theUnsupportedActions));
    }

    private void exposeIds(RepositoryRestConfiguration config){

//        pegar a lista de todas as classes
        Set<EntityType<?>> entities = entitiyManager.getMetamodel().getEntities();

//        criando array com os tipos de entidade do entitymanager
        List<Class> entityClasses = new ArrayList<>();

//        pegar os tipos de entidade das entidades
        for(EntityType tempEntityType: entities){
            entityClasses.add(tempEntityType.getJavaType());
        }

//        expor os ids das entidades
        Class[] domainTypes = entityClasses.toArray(new Class[0]);
        config.exposeIdsFor(domainTypes);
    }


}

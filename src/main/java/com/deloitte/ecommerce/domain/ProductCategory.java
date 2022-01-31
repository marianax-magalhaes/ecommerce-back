package com.deloitte.ecommerce.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name="product_category")

//pelo jeito tem bug no @Data quando ha relacao de one to many
@Getter
@Setter
public class ProductCategory implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="category_name")
    private String categoryName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="category")
    private Set<Product> products;

}

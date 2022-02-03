package com.deloitte.ecommerce.domain;

import lombok.Getter;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="country")
@Getter
@Setter
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="code")
    private String code;

    @Column(name="name")
    private String name;

//    one-to-many: pais contem varios estados
    @OneToMany(mappedBy="country")
//    esse json vai fazer que a requisicao traga apenas os paises (sem os estados de cada um)
    @JsonIgnore
    private List<State> states;
}

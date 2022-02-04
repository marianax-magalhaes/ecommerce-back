package com.deloitte.ecommerce.dto;

import lombok.Data;

@Data
public class PurchaseResponse {

//    esse final foi essencial para a implementacao do servico
    private final String orderTracking;

}

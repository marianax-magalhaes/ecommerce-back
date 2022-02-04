package com.deloitte.ecommerce.dto;

import com.deloitte.ecommerce.domain.Address;
import com.deloitte.ecommerce.domain.Customer;
import com.deloitte.ecommerce.domain.Order;
import com.deloitte.ecommerce.domain.OrderItem;
import lombok.Data;

import java.util.Set;

@Data
public class Purchase {
    private Customer customer;

    private Address shippingAddress;

    private Address billingAddress;

    private Order order;

    private Set<OrderItem> orderItems;

}

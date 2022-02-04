package com.deloitte.ecommerce.service;

import com.deloitte.ecommerce.domain.Customer;
import com.deloitte.ecommerce.domain.Order;
import com.deloitte.ecommerce.domain.OrderItem;
import com.deloitte.ecommerce.dto.Purchase;
import com.deloitte.ecommerce.dto.PurchaseResponse;
import com.deloitte.ecommerce.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService{

    private CustomerRepository customerRepository;

//    @Autowired opcional pq so tem um construtor
    public CheckoutServiceImpl(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {
//        recuperar as infos do pedido do dto
        Order order = purchase.getOrder();

//        gerar o rastreio
        String orderTrackingNumber = generationOrderTrackingNumber();
        order.setOrderTrackingNumber(orderTrackingNumber);

//        popular pedido com os itens
        Set<OrderItem> orderItems = purchase.getOrderItems();
        orderItems.forEach(item -> order.add(item));

//        popular pedido com os enderecos
        order.setBillingAddress(purchase.getBillingAddress());
        order.setShoppingAddress(purchase.getShippingAddress());

//        popular cliente com o pedido
        Customer customer = purchase.getCustomer();
        customer.add(order);

//        salvar no banco
        customerRepository.save(customer);

//        retornar resposta
        return new PurchaseResponse(orderTrackingNumber);
    }

    private String generationOrderTrackingNumber() {

//        gerar um UUID aleatorio: uuid é um gerador de id unico
        return UUID.randomUUID().toString();
    }
}

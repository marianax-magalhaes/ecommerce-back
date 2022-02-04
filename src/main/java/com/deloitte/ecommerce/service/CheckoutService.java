package com.deloitte.ecommerce.service;

import com.deloitte.ecommerce.dto.Purchase;
import com.deloitte.ecommerce.dto.PurchaseResponse;

public interface CheckoutService {

    PurchaseResponse placeOrder(Purchase purchase);
}

package com.clara.SecureAccessWebService.Service;

import com.clara.SecureAccessWebService.Entity.Order;
import com.clara.SecureAccessWebService.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * This class handles the logic for the Order entity
 * It is autowired to the OrderRepository class to access the database
 */
@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public Order getOrderById(Long id) {
        Optional<Order> order = orderRepository.findById(id);
        return order.orElse(null);
    }
    public Iterable<Order> getAllOrders() {
        return orderRepository.findAll();
    }
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }
    public String deleteOrder(Long id) {
        orderRepository.deleteById(id);
        return "Order deleted";
    }
    public String updateOrder(Order order) {
        Order existingOrder = orderRepository.findById(order.getId()).orElse(null);
        if (existingOrder != null) {
            existingOrder.setProductName(order.getProductName());
            existingOrder.setQuantity(order.getQuantity());
            orderRepository.save(existingOrder);
            return "Order updated";
        } else {
            return "Order not found";
        }
    }
}
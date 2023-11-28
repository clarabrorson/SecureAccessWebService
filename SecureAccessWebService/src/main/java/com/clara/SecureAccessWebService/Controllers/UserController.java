package com.clara.SecureAccessWebService.Controllers;

import com.clara.SecureAccessWebService.Entity.ApplicationUser;
import com.clara.SecureAccessWebService.Entity.Order;
import com.clara.SecureAccessWebService.Service.OrderService;
import com.clara.SecureAccessWebService.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * This class is the controller for the user level access.
 * The user level access is used to manage the users and orders with crud operations.
 * Unlike the admin level access, the user level access can only read and create users and orders.
 */
@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

    @Autowired private UserService userService;
    @Autowired private OrderService orderService;

    /**
     * The following methods are for the user management.
     * These endpoints are used to manage the users with crud operations.
     */
    @GetMapping("/")
    public String accessLevel(){
        return "User access level";
    }
    @GetMapping("/{id}")
    public ApplicationUser findUserById(@PathVariable int id){
        return userService.getUserById(id);
    }
    @GetMapping("/users")
    public Iterable<ApplicationUser> findAllUsers(){
        return userService.getUsers();
    }

    /**
     * The following methods are for the order management.
     * These endpoints are used to manage the orders with crud operations.
     */
    @GetMapping("/order/{id}")
    public Order findOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }
    @GetMapping("/allOrders")
    public Iterable<Order> findAllOrders() {
        return orderService.getAllOrders();
    }
    @PostMapping("/createOrder")
    public Order createOrder(@RequestBody Order order) {
        return orderService.createOrder(order);
    }
    @DeleteMapping("/deleteOrder/{id}")
    public String deleteOrder(@PathVariable Long id) {
        return "Not authorized";
    }
    @PutMapping("/updateOrder")
    public String updateOrder(@RequestBody Order order) {
        return "Not authorized";
    }
}

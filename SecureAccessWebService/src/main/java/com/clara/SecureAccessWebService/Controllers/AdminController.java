package com.clara.SecureAccessWebService.Controllers;

import com.clara.SecureAccessWebService.Entity.ApplicationUser;
import com.clara.SecureAccessWebService.Entity.Order;
import com.clara.SecureAccessWebService.Service.AdminService;
import com.clara.SecureAccessWebService.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * This class is the controller for the admin level access.
 * The admin level access is used to manage the users and orders with crud operations.
 * Unlike the user level access, the admin level access can delete and update users and orders.
 */
@RestController
@RequestMapping("/admin")
@CrossOrigin("*")
public class AdminController {

    @Autowired private AdminService adminService;
    @Autowired private OrderService orderService;

    /**
     * The following methods are for the user management.
     * These endpoints are used to manage the users with crud operations.
     */
    @GetMapping("/")
    public String accessLevel(){
        return "Admin level access";
    }
    @GetMapping("/{id}")
    public ApplicationUser findUserById(@PathVariable int id){
        return adminService.getUserById(id);
    }
    @GetMapping("/users")
    public Iterable<ApplicationUser> findAllUsers(){
        return adminService.getUsers();
    }
    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable int id){
        return adminService.deleteUser(id);
    }
    @PutMapping("/update")
    public ApplicationUser updateUser(@RequestBody ApplicationUser user){
        return adminService.updateUser(user);
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
        return orderService.deleteOrder(id);
    }
    @PutMapping("/updateOrder")
    public String updateOrder(@RequestBody Order order) {
        return orderService.updateOrder(order);
    }

}
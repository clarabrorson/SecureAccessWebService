package com.clara.SecureAccessWebService.Repository;

import com.clara.SecureAccessWebService.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This interface extends the JpaRepository interface
 * It is used to perform CRUD operations on the Order table
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}

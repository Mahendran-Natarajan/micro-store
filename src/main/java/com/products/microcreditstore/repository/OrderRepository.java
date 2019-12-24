package com.products.microcreditstore.repository;

import com.products.microcreditstore.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The interface Order repository.
 */
public interface OrderRepository extends JpaRepository<Orders, Long> {
}

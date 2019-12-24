package com.products.microcreditstore.repository;

import com.products.microcreditstore.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The interface Product repository.
 */
public interface ProductRepository extends JpaRepository<Product, Long> {
}

package com.pat.dashboard.repository;

import com.pat.dashboard.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product, Long> {
}

package com.pat.dashboard.repository;

import com.pat.dashboard.model.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductTypeRepository extends JpaRepository<ProductType, Long> {

}

package com.pat.dashboard.service;

import com.pat.dashboard.model.ProductType;
import com.pat.dashboard.repository.IProductTypeRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class ProductTypeService {

    @Autowired
    private IProductTypeRepository productTypeRepository;

    public List<ProductType> findAll() {
        return productTypeRepository.findAll();
    }

    public void save(ProductType productType) {
        productTypeRepository.save(productType);
    }

    public ProductType get(long id) {
        return productTypeRepository.findById(id).get();
    }

    public void delele(long id) {
        productTypeRepository.deleteById(id);
    }

}

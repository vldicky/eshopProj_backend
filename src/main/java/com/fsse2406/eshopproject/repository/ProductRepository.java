package com.fsse2406.eshopproject.repository;

import com.fsse2406.eshopproject.data.product.entity.ProductEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<ProductEntity,Integer> {
    boolean existsByPid(int pid);
}

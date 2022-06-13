package com.example.reverse_am.repository;

import com.example.reverse_am.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    List<Product> findByInWareHouseFalse();
    List<Product> findByVerificationFalseAndInWareHouseTrue();
    List<Product> findByVerificationTrue();
}

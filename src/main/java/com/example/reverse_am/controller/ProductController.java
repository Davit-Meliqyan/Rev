package com.example.reverse_am.controller;

import com.example.reverse_am.dto.productDTO.AdminProductDTO;
import com.example.reverse_am.dto.productDTO.UserProductDTO;
import com.example.reverse_am.dto.productDTO.WorkerProductDTO;
import com.example.reverse_am.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/admin")
    public ResponseEntity<?> getProductsAdmin(){
        return ResponseEntity.ok().body(this.productService.getProductsAdmin());
    }

    @GetMapping("/user")
    public ResponseEntity<?> getProductsUser(){
        return ResponseEntity.ok().body(this.productService.getProductsUser());
    }

    @GetMapping("/worker")
    public ResponseEntity<?> getProductsWorker(){
        return ResponseEntity.ok().body(this.productService.getProductsWorker());
    }

    @PostMapping("/user/new")
    public ResponseEntity<?> createProduct(@Valid @RequestBody UserProductDTO productDTO){
        Assert.notNull(productDTO,"Product is null ");
        Assert.notNull(productDTO.getCategory(),"Category is null ");
        Assert.notNull(productDTO.getUser(),"User is null ");
        UserProductDTO product = this.productService.createProduct(productDTO);
        return ResponseEntity.ok().body(product);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable("id")Long id, @Valid @RequestBody UserProductDTO productDTO){
        Assert.notNull(productDTO,"Product is null ");
        Assert.notNull(productDTO.getCategory(),"Category is null ");
        Assert.notNull(productDTO.getUser(),"User is null ");
        UserProductDTO product = this.productService.updateProductUser(id,productDTO);
        return ResponseEntity.ok().body(product);
    }

    @PutMapping("/worker/{id}")
    public ResponseEntity<?> updateProductWorker(@PathVariable("id")Long id, @Valid @RequestBody WorkerProductDTO productDTO){
        Assert.notNull(productDTO,"Product is null ");
        Assert.notNull(productDTO.getCategory(),"Category is null ");
        WorkerProductDTO product = this.productService.updateProductWorker(id,productDTO);
        return ResponseEntity.ok().body(product);
    }

    @PutMapping("/admin/{id}")
    public ResponseEntity<?> updateProductAdmin(@PathVariable("id")Long id, @Valid @RequestBody AdminProductDTO productDTO){
        Assert.notNull(productDTO,"Product is null ");
        AdminProductDTO product = this.productService.updateProductAdmin(id,productDTO);
        return ResponseEntity.ok().body(product);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable("id")Long id){
        this.productService.deleteProduct(id);
        return ResponseEntity.ok().body("Product is deleted ");
    }

}

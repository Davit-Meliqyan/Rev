package com.example.reverse_am.mappers;

import com.example.reverse_am.dto.productDTO.*;
import com.example.reverse_am.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.reverse_am.entities.enums.Condition.NOT_DEFINED;

@Component
public class ProductMapper {

    private final UserMapper userMapper;
    private final CategoryMapper categoryMapper;

    @Autowired
    public ProductMapper(UserMapper userMapper, CategoryMapper categoryMapper) {
        this.userMapper = userMapper;
        this.categoryMapper = categoryMapper;
    }

    public UserProductDTO toUserProductDTO(Product product) {
        return new UserProductDTO(product.getName(), product.getDescription(), product.getCondition(),
                userMapper.toUserDTO(product.getUser()), categoryMapper.toCategoryDTO(product.getCategory()));
    }

    public UserViewProductDTO toUserViewProductDTO(Product product) {
        return new UserViewProductDTO(
                product.getRevCoin(), product.getName(), product.getDescription(),
                product.getCondition(), categoryMapper.toCategoryDTO(product.getCategory()));
    }

    public WorkerProductDTO toWorkerProductDTO(Product product) {
        return new WorkerProductDTO(product.getName(), product.getDescription(), product.getCondition(),
       //         product.getInWareHouse(),
                categoryMapper.toCategoryDTO(product.getCategory()));
    }

    public WorkerViewProductDTO toWorkerViewProductDTO(Product product) {
        return new WorkerViewProductDTO(
                product.getName(), product.getDescription(), categoryMapper.toCategoryDTO(product.getCategory()));
    }

    public AdminProductDTO toAdminProductDTO(Product product) {
        return new AdminProductDTO(//product.getVerification(),
                 product.getRevCoin());
    }

    public AdminViewProductDTO toAdminViewProductDTO(Product product) {
        return new AdminViewProductDTO(
                product.getName(), product.getDescription(),
                product.getCondition(), categoryMapper.toCategoryDTO(product.getCategory()));
    }

    public Product toProduct(UserProductDTO productDTO) {
        return new Product(productDTO.getName(),
                productDTO.getDescription() == null ? "Not defined" : productDTO.getDescription(),
                productDTO.getCondition() == null ? NOT_DEFINED : productDTO.getCondition(),
                false, 0L, false,
                userMapper.toUser(productDTO.getUser()), categoryMapper.toCategory(productDTO.getCategory()));
    }


    public List<UserViewProductDTO> mapAllToUserViewProductDTO(List<Product> products) {
        return products.stream()
                .map(this::toUserViewProductDTO)
                .collect(Collectors.toList());
    }

    public List<WorkerViewProductDTO> mapAllToWorkerViewProductDTO(List<Product> workerList) {
        return workerList.stream()
                .map(this::toWorkerViewProductDTO)
                .collect(Collectors.toList());
    }

    public List<AdminViewProductDTO> mapAllToAdminViewProductDTO(List<Product> adminList) {
        return adminList.stream()
                .map(this::toAdminViewProductDTO)
                .collect(Collectors.toList());
    }


//    public Product toProduct(WorkerProductDTO productDTO){
//        return new Product(productDTO.getName(), productDTO.getDescription(), productDTO.getCondition(),
//                false, 0L, productDTO.getInWareHouse(), userMapper.toUser(productDTO.getUser())
//                ,categoryMapper.toCategory(productDTO.getCategory()));
//    }
//
//    public Product toProduct(AdminProductDTO productDTO){
//        return new Product(productDTO.getName(), productDTO.getDescription(), productDTO.getCondition(),
//                productDTO.getVerification(), productDTO.getRevCoin(), productDTO.getInWareHouse(),
//                userMapper.toUser(productDTO.getUser()) ,categoryMapper.toCategory(productDTO.getCategory()));
//    }

}

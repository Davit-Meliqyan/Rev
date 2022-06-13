package com.example.reverse_am.dto.productDTO;

import com.example.reverse_am.dto.CategoryDTO;
import com.example.reverse_am.entities.enums.Condition;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class AdminViewProductDTO {

    @Size(min = 3,max = 45)
    private String name;
    private String description;
    private Condition condition;
    @NotNull
    private CategoryDTO category;

    public AdminViewProductDTO() {
    }

    public AdminViewProductDTO(String name, String description, Condition condition, CategoryDTO category) {
        this.name = name;
        this.description = description;
        this.condition = condition;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    public CategoryDTO getCategory() {
        return category;
    }

    public void setCategory(CategoryDTO category) {
        this.category = category;
    }
}

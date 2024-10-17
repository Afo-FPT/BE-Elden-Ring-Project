package com.isp392.ecommerce.service;

import com.isp392.ecommerce.dto.request.CreateCategoryRequest;
import com.isp392.ecommerce.dto.response.CategoryResponse;
import com.isp392.ecommerce.entity.Category;
import com.isp392.ecommerce.exception.AppException;
import com.isp392.ecommerce.exception.ErrorCode;
import com.isp392.ecommerce.repository.CategoryRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Category createCategory(CreateCategoryRequest request) {
        if(categoryRepository.existsByCateName(request.getCateName()))
            throw new AppException(ErrorCode.CATEGORY_EXISTED);

        return categoryRepository.save(Category.builder()
                        .cateName(request.getCateName())
                .build());
    }


    public List<Category> getAllCategories() {
        return categoryRepository.findAll().stream().toList();
    }

    public Category getCategory(String id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.CATEGORY_NOT_EXISTED));

        return category;
    }

    public void deleteCategory(String id) {
        categoryRepository.deleteById(id);
    }
}

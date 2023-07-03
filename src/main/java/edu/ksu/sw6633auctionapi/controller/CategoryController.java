package edu.ksu.sw6633auctionapi.controller;

import edu.ksu.sw6633auctionapi.entity.Category;
import edu.ksu.sw6633auctionapi.service.CategoryService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categories")
public class CategoryController {

//    private CategoryService categoryService;
//
//    public CategoryController(CategoryService categoryService) {
//        this.categoryService = categoryService;
//    }
//
//    @PostMapping
//    public Category createCategory(@RequestBody Category category){
//        return categoryService.createCategory(category);
//    }
}

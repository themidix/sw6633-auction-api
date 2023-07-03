package edu.ksu.sw6633auctionapi.mapper;

import edu.ksu.sw6633auctionapi.dto.CategoryDTO;
import edu.ksu.sw6633auctionapi.entity.Category;
import org.springframework.beans.BeanUtils;

public class CategoryMapper {

    public CategoryDTO fromCategory(Category category){
        CategoryDTO categoryDTO = new CategoryDTO();
        BeanUtils.copyProperties(category,categoryDTO);
        return categoryDTO;
    }

    public Category fromCategoryDTO(CategoryDTO categoryDTO){
        Category category = new Category(auctionItem);
        BeanUtils.copyProperties(categoryDTO,category);
        return category;
    }
}

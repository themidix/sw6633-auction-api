package edu.ksu.sw6633auctionapi.service.impl;

import edu.ksu.sw6633auctionapi.dto.CategoryDTO;
import edu.ksu.sw6633auctionapi.entity.Category;
import edu.ksu.sw6633auctionapi.mapper.CategoryMapper;
import edu.ksu.sw6633auctionapi.repository.CategoryRepository;
import edu.ksu.sw6633auctionapi.service.CategoryService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;
    private CategoryMapper categoryMapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    @Override
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        Category category = categoryMapper.fromCategoryDTO(categoryDTO);
        Category savedCategory = categoryRepository.save(category);
        return categoryMapper.fromCategory(savedCategory);
    }

    @Override
    public CategoryDTO updateCategory(CategoryDTO categoryDTO) {
        return null;
    }

    @Override
    public void removeCategory(Long categoryId) {

    }
}

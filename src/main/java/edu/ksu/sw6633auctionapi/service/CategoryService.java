package edu.ksu.sw6633auctionapi.service;

import edu.ksu.sw6633auctionapi.dto.CategoryDTO;
public interface CategoryService {

    CategoryDTO createCategory(CategoryDTO categoryDTO);

    CategoryDTO updateCategory(CategoryDTO categoryDTO);

    void removeCategory(Long categoryId);
}

package edu.ksu.sw6633auctionapi.runner;

import edu.ksu.sw6633auctionapi.dto.CategoryDTO;
import edu.ksu.sw6633auctionapi.entity.Category;
import edu.ksu.sw6633auctionapi.mapper.CategoryMapper;
import edu.ksu.sw6633auctionapi.service.CategoryService;
import edu.ksu.sw6633auctionapi.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class RunnerApp implements CommandLineRunner {

    @Autowired
    private RoleService roleService;
    @Autowired
    private CategoryService categoryService;

    @Override
    public void run(String... args) throws Exception {
//        createRoles();
//        createCategory();
    }

    private void createRoles() {
        Arrays.asList("Admin", "RegisteredUser", "GuestUser").forEach(role -> roleService.createRole(role));
    }

    private void createCategory(){
        CategoryMapper categoryMapper= new CategoryMapper();

        Arrays.asList("Automobiles", "Antiques","Jewelery","Watches", "Home & Garden","Electronics").forEach(category -> {
                Category cat = new Category(category);
                CategoryDTO categoryDTO = categoryMapper.fromCategory(cat);
                categoryService.createCategory(categoryDTO);
            });

        }
}

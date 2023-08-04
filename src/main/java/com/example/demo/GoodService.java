package com.example.demo;

import java.util.List;

public interface GoodService {

    Good createGood(GoodDto good);

    List<Good> findAll();

    List<Good> findByCategory(Long categoryId);

    Good updateGoodById(GoodDto good);

    String deleteById(Long id);

    Category createCategory(Category category);

    Category updateCategory(Category category);

    String deleteCategory(Long id);

    List<Category> findAllCategory();
}

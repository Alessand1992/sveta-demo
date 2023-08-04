package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class GoodServiceImpl implements GoodService {

    private GoodRepo goodRepo;
    private CategoryRepo categoryRepo;

    @Override
    public Good createGood(GoodDto good) {
        Good good1 = new Good();
        good1.setName(good.getName());
        good1.setCost(good.getCost());
        good1.setDescription(good.getDescription());
        try {
            good1.setCategory(categoryRepo.getReferenceById(good.getCategory()));
        }catch (Exception e){
            log.error("Category not found");
        }
        return goodRepo.save(good1);
    }

    @Override
    public List<Good> findAll() {
        return goodRepo.findAll();
    }

    @Override
    public List<Good> findByCategory(Long categoryId) {
        return goodRepo.findAllByCategory(categoryRepo.getReferenceById(categoryId));
    }


    @Override
    public Good updateGoodById(GoodDto good) {
        Good good1 = new Good();
        good1.setName(good.getName());
        good1.setCost(good.getCost());
        good1.setDescription(good.getDescription());
        try {
            good1.setCategory(categoryRepo.getReferenceById(good.getCategory()));
        }catch (Exception e){
            log.error("Category not found");
        }
        return goodRepo.save(good1);
    }

    @Override
    public String deleteById(Long id) {
        Good good = goodRepo.getReferenceById(id);
        good.setCategory(null);
        goodRepo.save(good);
        goodRepo.deleteById(id);
        return "Товар удален";
    }

    @Override
    public Category createCategory(Category category) {
        return categoryRepo.save(category);
    }

    @Override
    public Category updateCategory(Category category) {
        Category category1 = categoryRepo.getReferenceById(category.getId());
        category1.setName(category.getName());
        return categoryRepo.save(category1);
    }

    @Override
    public String deleteCategory(Long id) {
        List<Good> allGoodWithCategory = goodRepo.findAllByCategory(categoryRepo.getReferenceById(id));
        allGoodWithCategory.forEach(x -> x.setCategory(null));
        goodRepo.saveAll(allGoodWithCategory);
        categoryRepo.deleteById(id);
        return "Категория удалена";
    }

    @Override
    public List<Category> findAllCategory() {
        return categoryRepo.findAll();
    }
}

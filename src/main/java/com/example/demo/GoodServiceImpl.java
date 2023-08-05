package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class GoodServiceImpl implements GoodService {

    private final GoodRepo goodRepo;
    private final CategoryRepo categoryRepo;

    @Override
    public Good createGood(GoodDto goodDto) {
        Good good = new Good();
        good.setName(goodDto.getName());
        good.setCost(goodDto.getCost());
        good.setDescription(goodDto.getDescription());
        setCategory(goodDto.getCategory(), good);
        return goodRepo.save(good);
    }

    @Override
    public List<Good> findAll() {
        return goodRepo.findAll();
    }

    @Override
    public List<Good> findByCategory(Long categoryId) {
        Category category = categoryRepo.getReferenceById(categoryId);
        return goodRepo.findAllByCategory(category);
    }

    @Override
    public Good updateGoodById(GoodDto goodDto) {
        Good good = goodRepo.getReferenceById(goodDto.getId());
        good.setName(goodDto.getName());
        good.setCost(goodDto.getCost());
        good.setDescription(goodDto.getDescription());
        setCategory(goodDto.getCategory(), good);
        return goodRepo.save(good);
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
        Category existingCategory = categoryRepo.getReferenceById(category.getId());
        existingCategory.setName(category.getName());
        return categoryRepo.save(existingCategory);
    }

    @Override
    public String deleteCategory(Long id) {
        Category category = categoryRepo.getReferenceById(id);
        if (category != null) {
            List<Good> allGoodWithCategory = goodRepo.findAllByCategory(category);
            allGoodWithCategory.forEach(x -> x.setCategory(null));
            goodRepo.saveAll(allGoodWithCategory);
            categoryRepo.deleteById(id);
            return "Категория удалена";
        } else {
            return "Категория не найдена";
        }
    }

    @Override
    public List<Category> findAllCategory() {
        return categoryRepo.findAll();
    }

    private void setCategory(Long categoryId, Good good) {
        if (categoryId != null) {
            Optional<Category> categoryOptional = categoryRepo.findById(categoryId);
            categoryOptional.ifPresent(good::setCategory);
        }
    }
}
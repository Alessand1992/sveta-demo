package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface GoodRepo extends JpaRepository<Good,Long> {

    ArrayList<Good> findAllByCategory(Category category);
}

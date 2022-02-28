package com.cg.service;

import com.cg.model.CategoryGroup;
import com.cg.repository.CategoryGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CategoryGroupServiceImpl implements CategoryGroupService {

    @Autowired
    private CategoryGroupRepository categoryGroupRepository;


    @Override
    public List<CategoryGroup> findAll() {
        return categoryGroupRepository.findAll();
    }

    @Override
    public Optional<CategoryGroup> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public CategoryGroup getById(Long id) {
        return null;
    }

    @Override
    public CategoryGroup save(CategoryGroup categoryGroup) {
        return categoryGroupRepository.save(categoryGroup);
    }

    @Override
    public void remove(Long id) {

    }
}

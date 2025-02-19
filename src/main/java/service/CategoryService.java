package service;

import model.CategoryEntity;
import repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    // Lấy tất cả danh mục
    public List<CategoryEntity> getAllCategories() {
        return repository.findAll();
    }

    // Tìm danh mục theo tên
    public Optional<CategoryEntity> getCategoryByName(String name) {
        return repository.findByName(name);
    }

    // Lưu danh mục mới vào database
    public CategoryEntity saveCategory(CategoryEntity category) {
        return repository.save(category);
    }

    // Xóa danh mục theo ID
    public void deleteCategory(Long id) {
        repository.deleteById(id);
    }
}
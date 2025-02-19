package controller;

import model.CategoryEntity;
import service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/category")
public class CategoryAPIController {

    @Autowired
    private CategoryService service;

    // Lấy danh sách tất cả danh mục
    @GetMapping("")
    public ResponseEntity<List<CategoryEntity>> getAllCategories() {
        return ResponseEntity.ok(service.getAllCategories());
    }

    // Lấy danh mục theo tên
    @GetMapping("/get")
    public ResponseEntity<CategoryEntity> getCategory(@RequestParam("name") String name) {
        Optional<CategoryEntity> category = service.getCategoryByName(name);
        return category.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Tạo danh mục mới
    @PostMapping("/save")
    public ResponseEntity<CategoryEntity> saveCategory(@RequestBody CategoryEntity category) {
        return ResponseEntity.ok(service.saveCategory(category));
    }

    // Xóa danh mục theo ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        service.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }
}
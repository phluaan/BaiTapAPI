package model;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // ID tự tăng
    private Long id;

    private String name;
}

package com.example.persistant.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Long categoryId;

    @Column(unique = true)
    private String name;

    @JsonManagedReference
    @OneToMany(targetEntity = Subcategory.class, fetch = FetchType.LAZY, mappedBy = "category")
    private List<Subcategory> subCategory;
}


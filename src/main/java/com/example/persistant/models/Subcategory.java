package com.example.persistant.models;


import com.fasterxml.jackson.annotation.*;
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

public class Subcategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sub_category_id")
    private Long subCategoryId;

    @Column(unique = true)
    private String subcategoryName;

    @JsonManagedReference
    @OneToMany(targetEntity = Comercio.class, fetch = FetchType.LAZY, mappedBy = "subCategory")
    private List<Comercio> comercio;

    @JsonBackReference
    @ManyToOne(targetEntity = Category.class)
    @JoinColumn(name="category_id")
    private Category category;
}

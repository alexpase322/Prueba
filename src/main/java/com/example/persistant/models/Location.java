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
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id_location")
    private Long idLocation;

    @Column(columnDefinition = "VARCHAR(255)")
    private String siteLocation;

    private boolean status;

    @OneToMany(targetEntity = Comercio.class, fetch = FetchType.LAZY, mappedBy = "location")
    @JsonManagedReference
    private List<Comercio> comercio;
}

package com.example.persistant.models;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ComercioStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comercio_status_id")
    private Long comercioStatusId;

    private String status;

    @OneToMany(targetEntity = Comercio.class, fetch = FetchType.LAZY, mappedBy = "comercioStatus")
    @JsonManagedReference
    private List<Comercio> comercio;
}

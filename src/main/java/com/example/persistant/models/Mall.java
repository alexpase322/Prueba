package com.example.persistant.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
public class Mall {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mall")
    private Long idMall;

    private String name;

    @ManyToOne(targetEntity = Comercio.class)
    @JoinColumn(name = "comercio_id")
    @JsonBackReference
    private Comercio comercio;

    @OneToMany(targetEntity = Admin.class, fetch = FetchType.LAZY, mappedBy = "mall")
    @Column(nullable = false)
    @JsonManagedReference
    private List<Admin> admin;

    @OneToMany(targetEntity = MallWatchman.class, fetch = FetchType.LAZY, mappedBy = "mall")
    @Column(nullable = false)
    @JsonManagedReference
    private List<MallWatchman> mall;

}

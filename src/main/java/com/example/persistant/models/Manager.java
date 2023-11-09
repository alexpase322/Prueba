package com.example.persistant.models;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Manager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_manager")
    private Long idManager;

    private String name;

    @Column(name="last_name")
    private String lastName;

    private String password;
    private String email;
    @Column(name = "citizen_id")
    private int citizenId;

}

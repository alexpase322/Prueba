package com.example.persistant.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Watchman {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "watchman_id")
    private Long watchmanId;

    private String name;

    @Column(name ="last_name")
    private String lastName;

    @OneToMany(targetEntity = MallWatchman.class, fetch = FetchType.LAZY, mappedBy = "watchman")
    //@JsonManagedReference
    @JsonIgnore
    private List<MallWatchman> watchman;
}

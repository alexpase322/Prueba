package com.example.persistant.models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class MallWatchman {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mall_watchman")
    private Long idMallWatchman;

    @ManyToOne(targetEntity = Mall.class)
    @JsonBackReference
    @JoinColumn(name = "mall_id")
    private Mall mall;

    @ManyToOne(targetEntity = Watchman.class)
    //@JsonBackReference
    @JoinColumn(name = "watchman_id")
    private Watchman watchman;
}

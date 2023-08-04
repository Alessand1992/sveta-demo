package com.example.demo;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "goods")
public class Good {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column
    private String name;
    @Column
    private int cost;
    @Column
    private String description;
    @JoinColumn
    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;
}

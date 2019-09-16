package com.kaizencode.sensei.model;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    @Enumerated(value = EnumType.STRING)
    private DifficultyLevel difficultyLevel;

}

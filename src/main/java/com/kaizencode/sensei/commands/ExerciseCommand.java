package com.kaizencode.sensei.commands;

import com.kaizencode.sensei.model.DifficultyLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ExerciseCommand {
    private Long id;
    private String name;
    private String description;
    private DifficultyLevel difficulty;
}

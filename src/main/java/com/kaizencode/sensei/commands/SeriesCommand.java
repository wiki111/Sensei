package com.kaizencode.sensei.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Synchronized;

@Getter
@Setter
@NoArgsConstructor
public class SeriesCommand {
    private Long id;
    private ExerciseCommand exercise;
    private  int reps;
}

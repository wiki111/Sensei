package com.kaizencode.sensei.converters;

import com.kaizencode.sensei.commands.ExerciseCommand;
import com.kaizencode.sensei.model.Exercise;
import io.micrometer.core.lang.Nullable;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CommandToExercise implements Converter<ExerciseCommand, Exercise> {
    @Synchronized
    @Nullable
    @Override
    public Exercise convert(ExerciseCommand exerciseCommand) {
        if(exerciseCommand == null){
            return null;
        }
        Exercise exercise = new Exercise();
        exercise.setDescription(exerciseCommand.getDescription());
        exercise.setDifficultyLevel(exerciseCommand.getDifficulty());
        exercise.setId(exerciseCommand.getId());
        exercise.setName(exerciseCommand.getName());
        return exercise;
    }
}

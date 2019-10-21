package com.kaizencode.sensei.converters;

import com.kaizencode.sensei.commands.ExerciseCommand;
import com.kaizencode.sensei.model.Exercise;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ExerciseToCommand implements Converter<Exercise, ExerciseCommand> {
    @Override
    public ExerciseCommand convert(Exercise exercise) {
        if(exercise == null){
            return null;
        }
        ExerciseCommand command = new ExerciseCommand();
        command.setId(exercise.getId());
        command.setDescription(exercise.getDescription());
        command.setName(exercise.getName());
        command.setDifficulty(exercise.getDifficultyLevel());
        return command;
    }
}

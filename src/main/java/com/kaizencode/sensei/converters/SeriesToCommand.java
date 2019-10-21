package com.kaizencode.sensei.converters;

import com.kaizencode.sensei.commands.SeriesCommand;
import com.kaizencode.sensei.model.Series;
import io.micrometer.core.lang.Nullable;
import jdk.jfr.Name;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class SeriesToCommand implements Converter<Series, SeriesCommand> {
    private final ExerciseToCommand exerciseConverter;

    public SeriesToCommand(ExerciseToCommand exerciseConverter) {
        this.exerciseConverter = exerciseConverter;
    }

    @Synchronized
    @Nullable
    @Override
    public SeriesCommand convert(Series series) {
        if(series == null){
            return null;
        }
        SeriesCommand command = new SeriesCommand();
        command.setId(series.getId());
        command.setReps(series.getReps());
        command.setExercise(exerciseConverter.convert(series.getExercise()));
        return command;
    }
}

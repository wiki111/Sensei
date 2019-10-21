package com.kaizencode.sensei.converters;

import com.kaizencode.sensei.commands.SeriesCommand;
import com.kaizencode.sensei.model.Series;
import io.micrometer.core.lang.Nullable;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CommandToSeries implements Converter<SeriesCommand, Series> {
    private final CommandToExercise exerciseConverter;

    public CommandToSeries(CommandToExercise exerciseConverter) {
        this.exerciseConverter = exerciseConverter;
    }

    @Synchronized
    @Nullable
    @Override
    public Series convert(SeriesCommand seriesCommand) {
        if(seriesCommand == null) return null;
        Series series = new Series();
        series.setId(seriesCommand.getId());
        series.setReps(seriesCommand.getReps());
        series.setExercise(exerciseConverter.convert(seriesCommand.getExercise()));
        return series;
    }
}

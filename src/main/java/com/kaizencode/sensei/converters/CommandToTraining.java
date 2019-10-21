package com.kaizencode.sensei.converters;

import com.kaizencode.sensei.commands.TrainingCommand;
import com.kaizencode.sensei.model.Training;
import io.micrometer.core.lang.Nullable;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;

import java.util.stream.Collectors;

public class CommandToTraining implements Converter<TrainingCommand, Training> {
    private final CommandToTrainingPlan planConverter;
    private final CommandToSeries seriesConverter;

    public CommandToTraining(CommandToTrainingPlan planConverter, CommandToSeries seriesConverter) {
        this.planConverter = planConverter;
        this.seriesConverter = seriesConverter;
    }

    @Synchronized
    @Nullable
    @Override
    public Training convert(TrainingCommand trainingCommand) {
        if(trainingCommand == null) return null;
        Training training = new Training();
        training.setId(trainingCommand.getId());
        training.setTrainingTime(trainingCommand.getDate());
        training.setSeries(trainingCommand.getTrainingSeries().stream().map(s -> seriesConverter.convert(s)).collect(Collectors.toList()));
        training.setTrainingPlan(planConverter.convert(trainingCommand.getPlan()));
        return training;
    }
}

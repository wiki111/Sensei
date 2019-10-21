package com.kaizencode.sensei.converters;

import com.kaizencode.sensei.commands.TrainingCommand;
import com.kaizencode.sensei.model.Training;
import io.micrometer.core.lang.Nullable;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import java.util.stream.Collectors;

@Component
public class TrainingToCommand implements Converter<Training, TrainingCommand> {
    private final TrainingPlanToCommand planConverter;
    private final SeriesToCommand seriesConverter;

    public TrainingToCommand(TrainingPlanToCommand planConverter, SeriesToCommand seriesConverter) {
        this.planConverter = planConverter;
        this.seriesConverter = seriesConverter;
    }

    @Synchronized
    @Nullable
    @Override
    public TrainingCommand convert(Training training) {
        if(training == null) return null;
        TrainingCommand command = new TrainingCommand();
        command.setId(training.getId());
        command.setDate(training.getTrainingTime());
        command.setPlan(planConverter.convert(training.getTrainingPlan()));
        command.setTrainingSeries(training.getSeries().stream().map(s -> seriesConverter.convert(s)).collect(Collectors.toList()));
        return command;
    }
}

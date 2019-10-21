package com.kaizencode.sensei.converters;

import com.kaizencode.sensei.commands.TrainingPlanCommand;
import com.kaizencode.sensei.model.TrainingPlan;
import io.micrometer.core.lang.Nullable;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class CommandToTrainingPlan implements Converter<TrainingPlanCommand, TrainingPlan> {
    private final CommandToCategory categoryConverter;
    private final CommandToSeries seriesConverter;

    public CommandToTrainingPlan(CommandToCategory categoryConverter, CommandToSeries seriesConverter) {
        this.categoryConverter = categoryConverter;
        this.seriesConverter = seriesConverter;
    }

    @Synchronized
    @Nullable
    @Override
    public TrainingPlan convert(TrainingPlanCommand trainingPlanCommand) {
        if(trainingPlanCommand == null) return null;
        TrainingPlan trainingPlan = new TrainingPlan();
        trainingPlan.setId(trainingPlanCommand.getId());
        trainingPlan.setName(trainingPlanCommand.getName());
        trainingPlan.setDescription(trainingPlanCommand.getDescription());
        trainingPlan.setPlannedSeries(
                trainingPlanCommand.getSeriesCommands().stream().map(s -> seriesConverter.convert(s)).collect(Collectors.toList())
        );
        trainingPlan.setTrainingPlanCategories(
                trainingPlanCommand.getCategoriesCommands().stream().map(c -> categoryConverter.convert(c)).collect(Collectors.toList())
        );
        return trainingPlan;
    }
}

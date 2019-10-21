package com.kaizencode.sensei.converters;

import com.kaizencode.sensei.commands.SeriesCommand;
import com.kaizencode.sensei.commands.TrainingPlanCommand;
import com.kaizencode.sensei.model.TrainingPlan;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TrainingPlanToCommand implements Converter<TrainingPlan, TrainingPlanCommand> {
    private final CategoryToCommand categoryConverter;
    private final SeriesToCommand seriesConverter;

    public TrainingPlanToCommand(CategoryToCommand categoryConverter, SeriesToCommand seriesConverter) {
        this.categoryConverter = categoryConverter;
        this.seriesConverter = seriesConverter;
    }

    @Override
    public TrainingPlanCommand convert(TrainingPlan trainingPlan) {
        if(trainingPlan == null) return null;
        TrainingPlanCommand command = new TrainingPlanCommand();
        command.setId(trainingPlan.getId());
        command.setName(trainingPlan.getName());
        command.setDescription(trainingPlan.getDescription());
        command.setSeriesCommands(
                trainingPlan.getPlannedSeries()
                        .stream()
                        .map(plan -> seriesConverter.convert(plan))
                        .collect(Collectors.toList())
        );
        command.setCategoriesCommands(
                trainingPlan.getTrainingPlanCategories()
                        .stream()
                        .map(cat -> categoryConverter.convert(cat))
                        .collect(Collectors.toList())
        );
        return command;
    }
}

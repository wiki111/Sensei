package com.kaizencode.sensei.commands;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class TrainingPlanCommand {
    private Long id;
    private String name;
    private String description;
    private List<SeriesCommand> seriesCommands;
    private List<CategoryCommand> categoriesCommands;
}

package com.kaizencode.sensei.commands;

import com.kaizencode.sensei.model.TrainingPlan;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class TrainingCommand {
    private Long id;
    private TrainingPlanCommand plan;
    private Date date;
    private List<SeriesCommand> trainingSeries;
}

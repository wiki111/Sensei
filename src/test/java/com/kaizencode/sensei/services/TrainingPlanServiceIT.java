package com.kaizencode.sensei.services;

import com.kaizencode.sensei.commands.TrainingPlanCommand;
import com.kaizencode.sensei.converters.CommandToTraining;
import com.kaizencode.sensei.converters.CommandToTrainingPlan;
import com.kaizencode.sensei.converters.TrainingPlanToCommand;
import com.kaizencode.sensei.model.TrainingPlan;
import com.kaizencode.sensei.repositories.TrainingPlanRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TrainingPlanServiceIT {

    public static final String NEW_DESCRIPTION = "New test description";
    @Autowired
    TrainingPlanService service;
    @Autowired
    TrainingPlanRepository repository;
    @Autowired
    CommandToTrainingPlan commandToTrainingPlan;
    @Autowired
    TrainingPlanToCommand trainingPlanToCommand;

    @Transactional
    @Test
    public void testUpdateSaveTrainingPlan() throws Exception{
        Iterable<TrainingPlan> plans = repository.findAll();
        TrainingPlan testPlan = plans.iterator().next();
        TrainingPlanCommand command = trainingPlanToCommand.convert(testPlan);

        command.setDescription(NEW_DESCRIPTION);
        TrainingPlanCommand savedPlan = service.savePlanCommand(command);

        assertEquals(NEW_DESCRIPTION, savedPlan.getDescription());
        assertEquals(testPlan.getId(), savedPlan.getId());
        assertEquals(testPlan.getPlannedSeries().size(), savedPlan.getSeriesCommands().size());
        assertEquals(testPlan.getTrainingPlanCategories().size(), savedPlan.getCategoriesCommands().size());
    }

    /*
    This test proves that Spring Data Jpa Repository 'save' method doesn't ignore null fields in entities. Because of
    that it is necessary to explicitly handle scenarios, when only certain fields are to be updated, while ignoring
    the rest.
    @Transactional
    @Test
    public void testSaveIgnoreNullFields() throws Exception{
        Iterable<TrainingPlan> plans = repository.findAll();
        TrainingPlan testPlan = plans.iterator().next();
        TrainingPlanCommand command = trainingPlanToCommand.convert(testPlan);

        String originalDescription = command.getDescription();
        command.setDescription(null);
        TrainingPlanCommand savedPlan = service.savePlanCommand(command);

        assertEquals(originalDescription, savedPlan.getDescription());
        assertEquals(testPlan.getId(), savedPlan.getId());
        assertEquals(testPlan.getPlannedSeries().size(), savedPlan.getSeriesCommands().size());
        assertEquals(testPlan.getTrainingPlanCategories().size(), savedPlan.getCategoriesCommands().size());
    }
     */

}

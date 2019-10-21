package com.kaizencode.sensei.services;

import com.kaizencode.sensei.converters.CommandToTrainingPlan;
import com.kaizencode.sensei.converters.TrainingPlanToCommand;
import com.kaizencode.sensei.model.TrainingPlan;
import com.kaizencode.sensei.repositories.TrainingPlanRepository;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class TrainingPlanDefaultServiceTest {

    TrainingPlanDefaultService trainingPlanDefaultService;

    @Mock
    TrainingPlanRepository trainingPlanRepository;

    @Mock
    CommandToTrainingPlan commandToPlan;

    @Mock
    TrainingPlanToCommand planToCommand;

    @BeforeEach
    public void setUp() throws Exception{
        MockitoAnnotations.initMocks(this);

        trainingPlanDefaultService = new TrainingPlanDefaultService(trainingPlanRepository, commandToPlan, planToCommand);
    }

    @org.junit.jupiter.api.Test
    void getTrainingPlans() {

        TrainingPlan testTrainingPlan = new TrainingPlan();
        List<TrainingPlan> testList = new ArrayList<>();
        testList.add(testTrainingPlan);
        Iterable<TrainingPlan> trainingPlansIter = testList;

        when(trainingPlanRepository.findAll()).thenReturn(trainingPlansIter);

        List<TrainingPlan> trainingPlans = trainingPlanDefaultService.getTrainingPlans();

        assertEquals(trainingPlans.size(), 1);
    }


}
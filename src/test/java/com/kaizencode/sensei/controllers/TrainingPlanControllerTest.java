package com.kaizencode.sensei.controllers;

import com.kaizencode.sensei.model.TrainingPlan;
import com.kaizencode.sensei.services.TrainingPlanService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TrainingPlanControllerTest {

    @Mock
    TrainingPlanService trainingPlanService;
    @Mock
    Model model;
    @Mock
    List<TrainingPlan> trainingPlanList;
    TrainingPlanController controller;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        controller = new TrainingPlanController(trainingPlanService);
    }

    @Test
    void showTrainingPlans() {
        when(trainingPlanService.getTrainingPlans()).thenReturn(trainingPlanList);
        ArgumentCaptor<List<TrainingPlan>> captor = ArgumentCaptor.forClass(List.class);
        String returnValue = controller.showTrainingPlans(model);
        verify(model, times(1)).addAttribute(eq("trainingPlans"), captor.capture());
        assertEquals(returnValue, "trainingplans/list");
        assertEquals(trainingPlanList, captor.getValue());

    }
}
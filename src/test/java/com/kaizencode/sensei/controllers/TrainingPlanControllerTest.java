package com.kaizencode.sensei.controllers;

import com.kaizencode.sensei.commands.TrainingPlanCommand;
import com.kaizencode.sensei.model.TrainingPlan;
import com.kaizencode.sensei.services.TrainingPlanService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

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

    @Test
    void showTrainingPlanById() throws Exception{
        TrainingPlan trainingPlan = new TrainingPlan();
        trainingPlan.setId(1L);

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

        when(trainingPlanService.getTrainingPlanById(anyLong())).thenReturn(trainingPlan);

        mockMvc.perform(get("/trainingplans/plan/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("/trainingplans/show"))
                .andExpect(model().attribute("trainingPlan", trainingPlan));

    }

    @Test
    void testPostNewPlanForm() throws Exception{
        TrainingPlanCommand command = new TrainingPlanCommand();
        command.setId(2L);

        when(trainingPlanService.savePlanCommand(any())).thenReturn(command);

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

        mockMvc.perform(post("/trainingplan/")
        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
        .param("id", "")
        .param("description", "test"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/trainingplans/2/show"));
    }
}
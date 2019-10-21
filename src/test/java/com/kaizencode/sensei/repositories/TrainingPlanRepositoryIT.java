package com.kaizencode.sensei.repositories;

import com.kaizencode.sensei.model.TrainingPlan;
import com.kaizencode.sensei.model.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
class TrainingPlanRepositoryIT {

    TrainingPlan testTrainingPlan;
    Category testCategory;

    @Autowired
    TrainingPlanRepository trainingPlanRepository;

    @BeforeEach
    void setUp() {
        testTrainingPlan = new TrainingPlan();
        testCategory = new Category();

        testTrainingPlan.setName("Test training plan");

        testCategory.setName("ExampleCategory");

        testTrainingPlan.getTrainingPlanCategories().add(testCategory);

        trainingPlanRepository.save(testTrainingPlan);
    }

    @Test
    void findAllByTrainingPlanCategories() {
        List<TrainingPlan> trainingPlans = trainingPlanRepository.findAllByTrainingPlanCategories_Name("ExampleCategory");
        assertEquals("Test training plan", trainingPlans.get(0).getName());
    }
}
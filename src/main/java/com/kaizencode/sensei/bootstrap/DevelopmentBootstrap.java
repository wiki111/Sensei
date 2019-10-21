package com.kaizencode.sensei.bootstrap;

import com.kaizencode.sensei.model.*;
import com.kaizencode.sensei.repositories.TrainingPlanRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.LinkedList;

@Component
public class DevelopmentBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private TrainingPlanRepository trainingPlanRepository;

    public DevelopmentBootstrap(TrainingPlanRepository trainingPlanRepository) {
        this.trainingPlanRepository = trainingPlanRepository;
    }

    private void initData(){
        TrainingPlan trainingPlan = new TrainingPlan();
        trainingPlan.setDescription("This is a test training plan created with bootstrap");
        trainingPlan.setName("Test training plan");

        LinkedList<Series> plannedSeries = new LinkedList<>();

        Exercise exercise1 = new Exercise();
        exercise1.setDescription("Test exercise 1.");
        exercise1.setDifficultyLevel(DifficultyLevel.EASY);
        exercise1.setName("Test exercise 1.");

        Exercise exercise2 = new Exercise();
        exercise2.setDescription("Test exercise 2.");
        exercise2.setDifficultyLevel(DifficultyLevel.MEDIUM);
        exercise2.setName("Test exercise 2.");

        Exercise exercise3 = new Exercise();
        exercise3.setDescription("Test exercise 3.");
        exercise3.setDifficultyLevel(DifficultyLevel.MASTER);
        exercise3.setName("Test exercise 3.");

        Series series1 = new Series();
        series1.setExercise(exercise1);
        series1.setReps(10);

        Series series2 = new Series();
        series2.setExercise(exercise2);
        series2.setReps(20);

        Series series3 = new Series();
        series3.setExercise(exercise3);
        series3.setReps(30);

        plannedSeries.add(series1);
        plannedSeries.add(series2);
        plannedSeries.add(series3);

        Category category = new Category();
        category.setName("ExampleCategory");
        ArrayList<TrainingPlan> trainingPlanArrayList = new ArrayList<>();
        trainingPlanArrayList.add(trainingPlan);
        ArrayList<Category> categories = new ArrayList<>();
        categories.add(category);
        trainingPlan.setTrainingPlanCategories(categories);

        trainingPlan.setPlannedSeries(plannedSeries);

        //Because of cascade operations only trainingPlan or exampleTraining can be saved - not both, because
        //after saving trainingPlan it and all child objects become detached, and because of that when
        //saving exampleTraining persistence operations cannot be cascaded down to child objects.
        trainingPlanRepository.save(trainingPlan);

    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }
}

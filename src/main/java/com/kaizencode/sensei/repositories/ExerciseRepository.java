package com.kaizencode.sensei.repositories;

import com.kaizencode.sensei.model.Exercise;
import org.springframework.data.repository.CrudRepository;

public interface ExerciseRepository extends CrudRepository<Exercise, Long> {
}

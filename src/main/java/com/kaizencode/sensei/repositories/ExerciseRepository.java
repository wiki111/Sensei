package com.kaizencode.sensei.repositories;

import com.kaizencode.sensei.models.Exercise;
import org.springframework.data.repository.CrudRepository;

public interface ExerciseRepository extends CrudRepository<Exercise, Long> {
}

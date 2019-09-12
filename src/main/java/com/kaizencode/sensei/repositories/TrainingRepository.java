package com.kaizencode.sensei.repositories;

import com.kaizencode.sensei.models.Training;
import org.springframework.data.repository.CrudRepository;

public interface TrainingRepository extends CrudRepository<Training, Long> {
}

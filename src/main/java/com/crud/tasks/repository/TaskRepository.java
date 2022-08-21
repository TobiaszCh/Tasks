package com.crud.tasks.repository;

import com.crud.tasks.domain.Task;

import org.jetbrains.annotations.NotNull;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository extends CrudRepository<Task, Long> {

    @Override
    @NotNull
    List<Task> findAll();

    @Override
    @SuppressWarnings("unchecked")
    @NotNull
    Task save(@NotNull Task task);

    @Override
    @NotNull
    Optional<Task> findById(@NotNull Long id);

    @Override
    void deleteById(@NotNull Long id);


}

package com.example.taskmanager.Repository;

import com.example.taskmanager.Entity.Priority;
import com.example.taskmanager.Entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    void deleteById(Long id);

    Optional<Task> getTaskById(Long id);

    void deleteTasksByUserId(Long id);

    List<Task> getTasksByUserId(Long id);

    List<Task> getTasksByPriorityOrderByStatus(Priority priority);
}

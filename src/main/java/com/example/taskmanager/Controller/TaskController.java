package com.example.taskmanager.Controller;

import com.example.taskmanager.DTO.TaskDTO;
import com.example.taskmanager.Service.TaskService;
import com.example.taskmanager.Entity.Status;
import com.example.taskmanager.Entity.Task;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/task-api/v1/tasks")
@RequiredArgsConstructor
@RestController
public class TaskController {
    private final TaskService taskService;

    @GetMapping
    public List<TaskDTO> getAllTasks() {
       return taskService.getAllTasks();
    }


    @GetMapping("/id/{id}")
    public TaskDTO getTaskById(@PathVariable Long id) {
        return taskService.getTaskById(id);
    }

    @PostMapping("/add")
    public Task addTasks(@RequestBody Task task) {return taskService.addTasks(task);}

    @PostMapping("/delete/{id}")
    public void deleteTasks (@PathVariable Long id) {taskService.deleteTasks(id);}

    @PatchMapping("/update_status/{taskid}")
    public void updateStatus(@PathVariable Long taskid, @RequestBody Status new_status){
        taskService.updateStatus(taskid, new_status);
    }
}

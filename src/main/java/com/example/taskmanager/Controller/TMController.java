package com.example.taskmanager.Controller;

import com.example.taskmanager.DTO.TaskDTO;
import com.example.taskmanager.Service.TMService;
import com.example.taskmanager.Entity.Priority;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user-api/v1/TM")
@AllArgsConstructor
public class TMController {

    private final TMService tmService;

    @GetMapping("/userid/{userid}")
    public List<TaskDTO> getTasksByUserID(@PathVariable Long userid) {;
        return tmService.getTaskByUserID(userid);
    }


    @DeleteMapping("/delete_all/{userid}")
    public void deleteTasksByUserId(@PathVariable Long userid) {
        tmService.deleteUserWithTaskByID(userid);
    }

    @GetMapping("/get_bypriority/{priority}")
    List<TaskDTO> getTasksByPriorityOrderByStatus(@PathVariable Priority priority) {
        return tmService.getTasksByPriorityOrderByStatus(priority);
    }


}


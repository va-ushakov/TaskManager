package com.example.taskmanager.DTO;

import com.example.taskmanager.Entity.Priority;
import com.example.taskmanager.Entity.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaskDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private String name;

    private String description;

    private Priority priority;

    private Status status;

}

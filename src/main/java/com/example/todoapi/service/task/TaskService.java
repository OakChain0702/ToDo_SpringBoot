package com.example.todoapi.service.task;

import com.example.todoapi.repositry.repository.task.TaskRecord;
import com.example.todoapi.repositry.repository.task.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskEntity find(Long taskId) {
      return  taskRepository.select(taskId).map(record -> new TaskEntity(record.getId(), record.getTitle()))
                .orElseThrow(() -> new TaskEntityNotFoundException(taskId));
    }

    public List<TaskEntity> find(int limit, long offset){
        return taskRepository.selectList(limit, offset).stream()
                .map(record -> new TaskEntity(record.getId(), record.getTitle()))
                .collect(Collectors.toList());
    }

    public TaskEntity create(String title) {
        var record = new TaskRecord(null, title);
        taskRepository.insert(record);

        return new TaskEntity(record.getId(), record.getTitle());
    }

    public TaskEntity update(Long taskId, String title) {
        taskRepository.update(new TaskRecord(taskId, title));
        return find(taskId);
    }
}

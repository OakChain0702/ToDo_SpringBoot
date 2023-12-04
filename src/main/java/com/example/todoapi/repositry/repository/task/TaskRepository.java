package com.example.todoapi.repositry.repository.task;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Optional;

@Mapper
public interface TaskRepository {

    @Select("SELECT id, title FROM tasks Where id = #{taskId}")
    public Optional<TaskRecord> select(Long taskId);
}

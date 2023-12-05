package com.example.todoapi.repositry.repository.task;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.Optional;

@Mapper
public interface TaskRepository {

    @Select("SELECT id, title FROM tasks Where id = #{taskId}")
    Optional<TaskRecord> select(Long taskId);

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("INSERT INTO tasks (title) VALUES (#{title})")
    void insert(TaskRecord record);
}

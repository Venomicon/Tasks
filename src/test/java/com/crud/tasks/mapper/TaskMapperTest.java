package com.crud.tasks.mapper;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TaskMapperTest {
    @Autowired
    TaskMapper taskMapper;

    @Test
    public void testTaskMapping() {
        //Given
        Task task = new Task(1L, "Title", "Content");

        //When
        TaskDto mappedTaskDto = taskMapper.mapToTaskDto(task);
        Task mappedTask = taskMapper.mapToTask(mappedTaskDto);

        //Then
        Assert.assertEquals(Task.class, mappedTask.getClass());
        Assert.assertEquals(TaskDto.class, mappedTaskDto.getClass());
    }

    @Test
    public void testTaskListMapping() {
        //Given
        List<Task> tasks = new ArrayList<>();
        Task task1 = new Task(1L, "Title1", "Content");
        tasks.add(task1);

        //When
        List<TaskDto> mappedTaskDtoList = taskMapper.mapToTaskDtoList(tasks);

        //Then
        Assert.assertEquals(1, mappedTaskDtoList.size());

        mappedTaskDtoList.forEach(taskDto -> {
            Assert.assertEquals("Title1", taskDto.getTitle());
            Assert.assertEquals("Content", taskDto.getContent());
        });
    }
}

package com.crud.tasks.service;

import com.crud.tasks.domain.Task;
import com.crud.tasks.repository.TaskRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DbServiceTest {
    @InjectMocks
    private DbService dbService;

    @Mock
    TaskRepository taskRepository;

    @Test
    public void testSaveTask() {
        //When
        Task task = new Task(1L, "Title", "Content");

        when(taskRepository.save(task)).thenReturn(task);

        //When
        Task savedTask = dbService.saveTask(task);

        //Then
        Assert.assertTrue(savedTask.equals(task));
    }


    @Test
    public void testGetAllTasks() {
        //When
        Task task1 = new Task(1L, "Title1", "Content");
        Task task2 = new Task(2L, "Title2", "Content");
        List<Task> tasks = new ArrayList<>();
        tasks.add(task1);
        tasks.add(task2);

        when(taskRepository.findAll()).thenReturn(tasks);

        //When
        List<Task> fetchedTasks = dbService.getAllTasks();

        //Then
        Assert.assertEquals(2, fetchedTasks.size());
    }

    @Test
    public void testGetTask() {
        //When
        Task task = new Task(1L, "Title", "Content");

        when(taskRepository.findById(1L)).thenReturn(Optional.of(task));

        //When
        Optional<Task> fetchedTask = dbService.getTask(1L);

        //Then
        Assert.assertTrue(fetchedTask.isPresent());
        Assert.assertTrue(fetchedTask.get().equals(task));
    }

    @Test
    public void testDeleteTask() {
        //When
        Task task = new Task(1L, "Title", "Content");

        when(taskRepository.save(task)).thenReturn(task);

        //When
        dbService.saveTask(task);
        dbService.deleteTask(1L);

        //Then
        Assert.assertFalse(dbService.getTask(1L).isPresent());
    }
}

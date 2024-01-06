package com.lotre.service;

import com.lotre.Entity.Project;
import com.lotre.Entity.Task;
import com.lotre.Entity.User;

import java.util.List;
import java.util.Optional;

public interface ProjectService {
    Project createProject(String projectName);
    Task createTask(String taskName, Long projectId);
    Task updateTaskk(Task task);
    void joinProject(Long projectId);
    void addMember(User user);
    void removeMember(User user);
    Task createTask(String taskName);
    void deleteTask(Task task);
    Task updateTask(Task task);

    List<Project> getAllProjects();

    Optional<Project> getProjectById(Long projectId);

    List<Task> getAllTasksByProject(Long projectId);

    List<User> getAllUsers();

    Optional<User> getUserById(Long userId);
}

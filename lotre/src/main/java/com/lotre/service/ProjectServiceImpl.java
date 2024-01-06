package com.lotre.service;

import com.lotre.Entity.Project;
import com.lotre.Entity.Task;
import com.lotre.Entity.User;
import com.lotre.repos.ProjectRepository;
import com.lotre.repos.TaskRepository;
import com.lotre.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Project createProject(String projectName) {
        Project project = Project.builder()
                .name(projectName)
                .build();

        return projectRepository.save(project);
    }

    @Override
    public Task createTask(String taskName, Long projectId) {
        Optional<Project> projectOptional = projectRepository.findById(projectId);

        if (projectOptional.isPresent()) {
            Project project = projectOptional.get();

            Task task = Task.builder()
                    .name(taskName)
                    .project(project)
                    .build();

            project.getTasks().add(task);
            projectRepository.save(project);

            return taskRepository.save(task);
        } else {
            // Handle the case where the project with the given ID is not found.
            return null;
        }
    }

    @Override
    public Task updateTaskk(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Task updateTask(Task task) {
        // Assuming you have validation and update logic here
        return taskRepository.save(task);
    }

    @Override
    public void joinProject(Long projectId) {
        // Implement the logic to join a project
    }

    @Override
    public void addMember(User user) {
        // Assuming you have validation and add member logic here
        userRepository.save(user);
    }

    @Override
    public void removeMember(User user) {
        // Assuming you have validation and remove member logic here
        userRepository.delete(user);
    }

    @Override
    public Task createTask(String taskName) {
        Task task = Task.builder()
                .name(taskName)
                .build();

        return taskRepository.save(task);
    }

    @Override
    public void deleteTask(Task task) {
        // Assuming you have validation and delete task logic here
        taskRepository.delete(task);
    }
    @Override
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    @Override
    public Optional<Project> getProjectById(Long projectId) {
        return projectRepository.findById(projectId);
    }

    @Override
    public List<Task> getAllTasksByProject(Long projectId) {
        Optional<Project> projectOptional = projectRepository.findById(projectId);

        return (List<Task>) projectOptional.map(Project::getTasks).orElse(null);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getUserById(Long userId) {
        return userRepository.findById(userId);
    }
}

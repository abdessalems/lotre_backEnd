package com.lotre.Controller;


import com.lotre.Entity.Project;
import com.lotre.Entity.Task;
import com.lotre.Entity.User;
import com.lotre.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @PostMapping("/create")
    public Project createProject(@RequestParam String projectName) {
        return projectService.createProject(projectName);
    }

    @PostMapping("/{projectId}/tasks/create")
    public Task createTask(@RequestParam String taskName, @PathVariable Long projectId) {
        return projectService.createTask(taskName, projectId);
    }


    @PostMapping("/{projectId}/join")
    public void joinProject(@PathVariable Long projectId) {
        projectService.joinProject(projectId);
    }

    @PostMapping("/addMember")
    public void addMember(@RequestBody User user) {
        projectService.addMember(user);
    }

    @PostMapping("/removeMember")
    public void removeMember(@RequestBody User user) {
        projectService.removeMember(user);
    }

    @PostMapping("/createTask")
    public Task createTask(@RequestParam String taskName) {
        return projectService.createTask(taskName);
    }

    @DeleteMapping("/deleteTask")
    public void deleteTask(@RequestBody Task task) {
        projectService.deleteTask(task);
    }

    @PutMapping("/updateTask")
    public Task updateTaskk(@RequestBody Task task) {
        return projectService.updateTaskk(task);
    }
    @PutMapping("/tasks/update")
    public Task updateTask(@RequestBody Task task) {
        return projectService.updateTask(task);
    }
    @GetMapping("/all")
    public List<Project> getAllProjects() {
        return projectService.getAllProjects();
    }

    @GetMapping("/{projectId}")
    public Optional<Project> getProjectById(@PathVariable Long projectId) {
        return projectService.getProjectById(projectId);
    }

    @GetMapping("/{projectId}/tasks")
    public List<Task> getAllTasksByProject(@PathVariable Long projectId) {
        return projectService.getAllTasksByProject(projectId);
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return projectService.getAllUsers();
    }

    @GetMapping("/users/{userId}")
    public Optional<User> getUserById(@PathVariable Long userId) {
        return projectService.getUserById(userId);
    }
}

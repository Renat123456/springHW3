package com.example.demo.service;

import com.example.demo.Model.Project;
import com.example.demo.Model.Timesheet;
import com.example.demo.repository.ProjectRepository;
import com.example.demo.repository.TimesheetRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;



@Service // то же самое, что и Component
public class ProjectService {
    private final ProjectRepository repository;

    public ProjectService(ProjectRepository repository) {
        this.repository = repository;
    }

    public Optional<Project> getById(Long id) {
        return repository.getById(id);
    }

    public List<Project> getAll() {
        return repository.getAll();
    }

    public Project create(Project project) {
        return repository.create(project);
    }

    public void delete(Long id) {
        repository.delete(id);
    }
}

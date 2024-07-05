package com.example.demo.repository;

import com.example.demo.Model.Project;
import com.example.demo.Model.Timesheet;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository // @Component для классов, работающих с данными
public class ProjectRepository {

    private static Long sequence = 1L;
    public static final List<Project> projects = new ArrayList<>();

    public Optional<Project> getById(Long id) {
        // select * from projects where id = $id
        return projects.stream()
                .filter(it -> Objects.equals(it.getId(), id))
                .findFirst();
    }

    public List<Project> getAll() {
        return List.copyOf(projects);
    }

    public Project create(Project project) {
        project.setId(sequence++);
        projects.add(project);
        return project;
    }

    public void delete(Long id) {
        projects.stream()
                .filter(it -> Objects.equals(it.getId(), id))
                .findFirst()
                .ifPresent(projects::remove); // если нет - иногда посылают 404 Not Found
    }

}

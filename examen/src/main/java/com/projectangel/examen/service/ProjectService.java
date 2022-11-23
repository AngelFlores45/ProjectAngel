package com.projectangel.examen.service;

import com.projectangel.examen.model.Project;

import java.util.List;
import java.util.Optional;

public interface ProjectService {
    public Project saveProject(Project project);

    public List<Project> getAllProject();

    Optional<Project> findById(int id);

    void delete(Project project);

    void updateProjectDeatils(Project emp);

}

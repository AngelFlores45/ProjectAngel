package com.projectangel.examen.repository;

import com.projectangel.examen.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.yaml.snakeyaml.events.Event;

import java.util.Optional;

@Repository
public interface ProjectRepository  extends JpaRepository<Project, Integer> {
    Optional<Project> findById(Event.ID id);

    Optional<Project> findById(Long id);
}

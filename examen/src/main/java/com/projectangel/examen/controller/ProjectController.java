package com.projectangel.examen.controller;

import com.projectangel.examen.model.Project;
import com.projectangel.examen.repository.ProjectRepository;
import com.projectangel.examen.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/project")
@CrossOrigin
public class ProjectController {
@Autowired
    private ProjectService projectService;

    @PostMapping("/add")
    public String add (@RequestBody Project project){
        projectService.saveProject(project);
        return "New project is added";
    }
    @GetMapping("/getAll")
    public List<Project> getAllProject(){
        return projectService.getAllProject();
    }
    @GetMapping("/item/{id}")
    public  Project get(@PathVariable int id) {
        Optional<Project> project = projectService.findById(id);
        if(project.isPresent()){
            return project.get();
        }else {
            throw  new RuntimeException("Project not found for the id"+id);
        }
    }
    @PutMapping("/item/{id}")
    public  void updateProject(@RequestBody Project emp){
        projectService.updateProjectDeatils(emp);
    }
    @DeleteMapping("/item/{id}")
    public  String delete(@PathVariable int id) {
        Optional<Project> project = projectService.findById(id);
        if(project.isPresent()){
            projectService.delete(project.get());
            return "Project is delete with id "+ id;
        }else {
            throw  new RuntimeException("Project not found for the id"+id);
        }
    }
}

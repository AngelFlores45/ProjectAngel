package com.projectangel.examen.service;

import com.projectangel.examen.model.Project;
import com.projectangel.examen.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectServiceImpl implements ProjectService{

    @Autowired
    private ProjectRepository projectRepository;
    @Override
    public Project saveProject(Project project) {
        return projectRepository.save(project);
    }
    //public Project deleteProject(int id){
      //  Project project=projectRepository.
        //return projectRepository.delete(id);}

    @Override
    public List<Project> getAllProject() {
        return projectRepository.findAll();
    }

    @Override
    public Optional<Project> findById(int id) {
        return projectRepository.findById(id);
    }

    @Override
    public void delete(Project project) {
         projectRepository.delete(project);
    }

    @Override
    public void updateProjectDeatils(Project emp) {
        int id=emp.getId();
    Optional<Project> empDeatils=projectRepository.findById(id);
    if (empDeatils.isPresent()){
        Project dbProject = empDeatils.get();
        dbProject.setName(emp.getName());
        dbProject.setAddress(emp.getAddress());
        projectRepository.saveAndFlush(dbProject);
    }else {
        System.out.println("Project record not exists with this id"+id);
    }

    }
}

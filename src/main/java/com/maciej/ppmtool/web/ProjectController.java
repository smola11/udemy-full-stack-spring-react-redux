package com.maciej.ppmtool.web;

import com.maciej.ppmtool.domain.Project;
import com.maciej.ppmtool.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

    @Autowired
    ProjectService projectService;

    @PostMapping("")
    public ResponseEntity<Project> createNewProject(@RequestBody Project project) {
        System.out.println("In controller");
        Project savedProject = projectService.saveOrUpdateProject(project);
        return new ResponseEntity<>(savedProject, HttpStatus.CREATED);
    }
}

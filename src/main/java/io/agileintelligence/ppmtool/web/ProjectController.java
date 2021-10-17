<<<<<<< HEAD
package io.agileintelligence.ppmtool.web;


import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.agileintelligence.ppmtool.domain.Project;
import io.agileintelligence.ppmtool.services.MapValidationErrorService;
import io.agileintelligence.ppmtool.services.ProjectService;

@CrossOrigin
@RestController
@RequestMapping ("/api/project")
public class ProjectController {
	
@Autowired
private ProjectService projectService;

@Autowired
private MapValidationErrorService mapValidationErrorService;

@PostMapping("")
public ResponseEntity<?>createNewProject(@Valid @RequestBody Project project, BindingResult result, Principal principal){
	ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
	
	if(errorMap!=null) return errorMap;
	
	Project project1 = projectService.saveOrUpdateProject(project,principal.getName());
	
	return new ResponseEntity<Project>(project1,HttpStatus.CREATED);
}


@GetMapping("/{projectId}")
public ResponseEntity<?>getProjectById(@PathVariable String projectId,Principal principal){
	
	Project project = projectService.findProjectByIdentifier(projectId,principal.getName());
	
	return new ResponseEntity<Project>(project,HttpStatus.OK);
}

@GetMapping("/all")
public Iterable<Project>getAllProjects(Principal principal){return projectService.findAllById(principal.getName());}
	
	

@DeleteMapping("/{projectId}")
public ResponseEntity<?>deleteProject(@PathVariable String projectId,Principal principal){
	
projectService.deleteProjectByIdentifier(projectId,principal.getName());

return new ResponseEntity<String>("Project with ID: "+projectId+" was deleted",HttpStatus.OK);
}
}


||||||| empty tree
=======
package io.agileintelligence.ppmtool.web;


import io.agileintelligence.ppmtool.domain.Project;
import io.agileintelligence.ppmtool.services.MapValidationErrorService;
import io.agileintelligence.ppmtool.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/project")
@CrossOrigin
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private MapValidationErrorService mapValidationErrorService;


    @PostMapping("")
    public ResponseEntity<?> createNewProject(@Valid @RequestBody Project project, BindingResult result, Principal principal){

        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
        if(errorMap!=null) return errorMap;

        Project project1 = projectService.saveOrUpdateProject(project, principal.getName());
        return new ResponseEntity<Project>(project1, HttpStatus.CREATED);
    }


    @GetMapping("/{projectId}")
    public ResponseEntity<?> getProjectById(@PathVariable String projectId, Principal principal){

        Project project = projectService.findProjectByIdentifier(projectId, principal.getName());

        return new ResponseEntity<Project>(project, HttpStatus.OK);
    }


    @GetMapping("/all")
    public Iterable<Project> getAllProjects(Principal principal){return projectService.findAllProjects(principal.getName());}


    @DeleteMapping("/{projectId}")
    public ResponseEntity<?> deleteProject(@PathVariable String projectId, Principal principal){
        projectService.deleteProjectByIdentifier(projectId, principal.getName());

        return new ResponseEntity<String>("Project with ID: '"+projectId+"' was deleted", HttpStatus.OK);
    }
}
>>>>>>> origin/master

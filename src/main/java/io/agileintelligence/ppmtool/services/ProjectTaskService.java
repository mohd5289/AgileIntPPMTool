package io.agileintelligence.ppmtool.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.agileintelligence.ppmtool.domain.Backlog;
import io.agileintelligence.ppmtool.domain.ProjectTask;
import io.agileintelligence.ppmtool.repositories.BacklogRepository;
import io.agileintelligence.ppmtool.repositories.ProjectTaskRepository;

@Service
public class ProjectTaskService {

	
	
	@Autowired
	private BacklogRepository backlogRepository;
	
	
	@Autowired
	private ProjectTaskRepository projectTaskRepository;
	
	
	
	
	
	public ProjectTask addProjectTask(String projectIdentifier,ProjectTask projectTask) {
  Backlog backlog =backlogRepository.findByProjectIdentifier(projectIdentifier);
   projectTask.setBacklog(backlog);
   
   Integer BacklogSequence = backlog.getPTSequence();
     BacklogSequence++;
     backlog.setPTSequence(BacklogSequence);
   projectTask.setProjectSequence(backlog.getProjectIdentifier()+"-"+BacklogSequence);
      projectTask.setProjectIdentifier(projectIdentifier);		
		
     
    
     if(projectTask.getPriority()==null) {
    	projectTask.setPriority(3);
    }
    if(projectTask.getStatus()=="" || projectTask.getStatus()==null) {
    	
   	projectTask.setStatus("TO_DO");
    }
		
		return projectTaskRepository.save(projectTask);
		
	}
	
	
	
	public Iterable<ProjectTask>findBacklogById(String id){
		return projectTaskRepository.findByProjectIdentifierOrderByPriority(id);
	}
	
	
	
	
	
}

package io.agileintelligence.ppmtool.repositories;

import org.springframework.data.repository.CrudRepository;

import io.agileintelligence.ppmtool.domain.Project;

public interface ProjectRepository extends CrudRepository<Project,Long>{

	@Override
	Iterable<Project>findAllById(Iterable<Long>iterable);
	

Project findByProjectIdentifier(String projectId);



}

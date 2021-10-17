<<<<<<< HEAD
package io.agileintelligence.ppmtool.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import io.agileintelligence.ppmtool.domain.ProjectTask;


@Repository
public interface ProjectTaskRepository extends CrudRepository<ProjectTask,Long> {


  List<ProjectTask> findByProjectIdentifierOrderByPriority(String id);


  ProjectTask findByProjectSequence(String sequence);


}
||||||| empty tree
=======
package io.agileintelligence.ppmtool.repositories;

import io.agileintelligence.ppmtool.domain.ProjectTask;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectTaskRepository extends CrudRepository<ProjectTask, Long> {

    List<ProjectTask> findByProjectIdentifierOrderByPriority(String id);

    ProjectTask findByProjectSequence(String sequence);
}
>>>>>>> origin/master

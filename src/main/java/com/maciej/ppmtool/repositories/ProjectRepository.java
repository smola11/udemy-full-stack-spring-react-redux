package com.maciej.ppmtool.repositories;

import com.maciej.ppmtool.domain.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {

    Project findByProjectIdentifier(String pojectId);

    @Override
    Iterable<Project> findAll();
}

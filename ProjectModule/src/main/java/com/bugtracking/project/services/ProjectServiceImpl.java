package com.bugtracking.project.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bugtracking.project.entities.Project;
import com.bugtracking.project.exceptions.IdNotFoundException;
import com.bugtracking.project.repository.IProjectRepository;
import com.google.common.base.Optional;

@Transactional
@Service("ps")
public class ProjectServiceImpl implements IProjectService {

	@Autowired
	IProjectRepository pr;

	@Override
	public List<Project> getall() {
		// TODO Auto-generated method stub
		return pr.findAll();
	}

	@Override
	public Project getproject(long projId) {
		// TODO Auto-generated method stub
		java.util.Optional<Project> proj = pr.findById(projId);
		if (proj.isPresent())
			return proj.get();
		else
			throw new IdNotFoundException("Id not found");
	}

	@Override
	public Project deleteproject(long projId) {
		if (pr.existsById(projId)) {
			Project prj =pr.getById(projId);
			pr.deleteById(projId);
			return prj;
		} else
			throw new IdNotFoundException("Id not found");
	}

	@Override
	public Project createproject(Project p) {
		// TODO Auto-generated method stub
		return pr.save(p);
	}

	@Override
	public Project updateproject(long projId, Project p) {
		// TODO Auto-generated method stub
		if (pr.existsById(projId)) {
			
			return pr.save(p);
		} else {
			throw new IdNotFoundException("Provided id is not there");
		}
	}
}

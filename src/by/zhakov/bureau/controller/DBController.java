package by.zhakov.bureau.controller;

import java.util.List;

import by.zhakov.bureau.dao.ProjectDAO;
import by.zhakov.bureau.dao.SpecialistDAO;
import by.zhakov.bureau.dao.SpecificationDAO;
import by.zhakov.bureau.exceptions.BureauException;
import by.zhakov.bureau.model.Project;
import by.zhakov.bureau.model.Specialist;
import by.zhakov.bureau.model.Specification;
import by.zhakov.bureau.model.SpecificationDetails;

public class DBController {

	public List<Specification> getSpecsForUser(String username) throws BureauException{
		return SpecificationDAO.getSpecsForUser(username);
	}
	
	public List<SpecificationDetails> getSpecDetails(int specId) throws BureauException{
		return SpecificationDAO.getSpecDetails(specId);
	}
	
	public List<Project> getUnpayedProjects() throws BureauException{
		return ProjectDAO.getUnpayedProjects();
	}
	
	public List<Project> getProjects() throws BureauException{
		return ProjectDAO.getProjects();
	}
	
	public List<Specialist> getSpecialists() throws BureauException{
		return SpecialistDAO.getSpecialists();
	}
	
	public void assignSpecialist(int idSpecialist, int idProject){
		SpecialistDAO.assignProjectToSpec(idSpecialist, idProject);
	}
}

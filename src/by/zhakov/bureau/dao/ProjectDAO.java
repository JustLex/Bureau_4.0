package by.zhakov.bureau.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import by.zhakov.bureau.db.ConnectionsPool;
import by.zhakov.bureau.db.Queries;
import by.zhakov.bureau.model.Project;

public class ProjectDAO {
	private static Logger log = Logger.getLogger(QualificationDAO.class);
	
	public static List<Project> getUnpayedProjects(){
		Connection c = ConnectionsPool.getInstance().getConnection();
		List<Project> result = new ArrayList<>();
		try {
			PreparedStatement statement = c.prepareStatement(Queries.getUnpayedProjects);
			ResultSet results = statement.executeQuery();
			result =  getProjectsFromResult(results);
		} catch (SQLException e) {
			log.error("getSpec dao exception", e);
		}
		return result;
	}
	
	public static List<Project> getProjects(){
		Connection c = ConnectionsPool.getInstance().getConnection();
		List<Project> result = new ArrayList<>();
		try {
			PreparedStatement statement = c.prepareStatement(Queries.getProjects);
			ResultSet results = statement.executeQuery();
			result = getProjectsFromResult(results);
		} catch (SQLException e) {
			log.error("getSpec dao exception", e);
		}
		return result;
	}
	
	private static List<Project> getProjectsFromResult(ResultSet set) throws SQLException{
		List<Project> resultList = new ArrayList<>();
		if (set.first()){
            do {
            	int id = set.getInt("idSpecification");
            	Date startDate = set.getDate("startDate");
            	Date endDate = set.getDate("endDate");
            	String name = set.getString("name");
            	int idSpec = set.getInt("idSpecification");
            	resultList.add(new Project(id, startDate, endDate, name, idSpec));
            } while (set.next());
		}
		return resultList;
	}
}

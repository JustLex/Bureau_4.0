package by.zhakov.bureau.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import by.zhakov.bureau.db.ConnectionsPool;
import by.zhakov.bureau.db.Queries;
import by.zhakov.bureau.model.Specialist;

public class SpecialistDAO {
	private static Logger log = Logger.getLogger(QualificationDAO.class);
	
	public static List<Specialist> getUnassignedWorkers(String qualification){
		Connection c = ConnectionsPool.getInstance().getConnection();
		List<Specialist> resultList = new ArrayList<>();
		try {
			PreparedStatement statement = c.prepareStatement(Queries.getUnassignedWorkers);
			statement.setString(1, qualification);
			ResultSet result = statement.executeQuery();
			if (result.first()){
                do {
                	int id = result.getInt("idSpecialist");
                	int idQualification = result.getInt("idQualification");
                	int salary = result.getInt("salary");
                	String name = result.getString("name");
                	resultList.add(new Specialist(id, idQualification, salary, -1, name));
                } while (result.next());
			}
		} catch (SQLException e) {
			log.error("getSpec dao exception", e);
		}
		return resultList;
	}
	
	public static List<Specialist> getSpecialists(){
		Connection c = ConnectionsPool.getInstance().getConnection();
		List<Specialist> resultList = new ArrayList<>();
		try {
			PreparedStatement statement = c.prepareStatement(Queries.getSpecialists);
			ResultSet result = statement.executeQuery();
			if (result.first()){
                do {
                	int id = result.getInt("idSpecialist");
                	int idQualification = result.getInt("idQualification");
                	int salary = result.getInt("salary");
                	String name = result.getString("name");
                	int idProject = result.getInt("idProject");
                	resultList.add(new Specialist(id, idQualification, salary, idProject, name));
                } while (result.next());
			}
		} catch (SQLException e) {
			log.error("getSpec dao exception", e);
		}
		return resultList;
	}
	
	public static void assignProjectToSpec(int idSpecialist, int idProject){
		Connection c = ConnectionsPool.getInstance().getConnection();
		try {
			PreparedStatement statement = c.prepareStatement(Queries.assignProjectToWorker);
			statement.setInt(1, idProject);
			statement.setInt(2, idSpecialist);
			statement.executeUpdate();
		} catch (SQLException e) {
			log.error("getSpec dao exception", e);
		}
	}
}

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
import by.zhakov.bureau.model.Specification;
import by.zhakov.bureau.model.SpecificationDetails;

public class SpecificationDAO {
	private static Logger log = Logger.getLogger(QualificationDAO.class);
	
	public static List<Specification> getSpecsForUser(String username){
		Connection c = ConnectionsPool.getInstance().getConnection();
		List<Specification> resultList = new ArrayList<>();
		try {
			PreparedStatement statement = c.prepareStatement(Queries.getSpecsForUser);
			statement.setString(1, username);
			ResultSet result = statement.executeQuery();
			if (result.first()){
                do {
                	int id = result.getInt("idSpecification");
                	int idUser = result.getInt("idUser");
                	resultList.add(new Specification(id, idUser));
                } while (result.next());
			}
		} catch (SQLException e) {
			log.error("getSpec dao exception", e);
		}
		return resultList;
	}
	
	public static List<SpecificationDetails> getSpecDetails(int specId){
		Connection c = ConnectionsPool.getInstance().getConnection();
		List<SpecificationDetails> resultList = new ArrayList<>();
		try {
			PreparedStatement statement = c.prepareStatement(Queries.getSpecDetails);
			statement.setInt(1, specId);
			ResultSet result = statement.executeQuery();
			if (result.first()){
                do {
                	int id = result.getInt("idSpecificationDetails");
                	int requiredStuff = result.getInt("requiredWorkersCount");
                	int idRequiredQualification = result.getInt("idRequiredQualification");
                	int idSpec = result.getInt("idSpecification");
                	resultList.add(new SpecificationDetails(id, idSpec, idRequiredQualification, requiredStuff));
                } while (result.next());
			}
		} catch (SQLException e) {
			log.error("getSpecDetails dao exception", e);
		}
		return resultList;
	}

}

package by.zhakov.bureau.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import by.zhakov.bureau.db.ConnectionsPool;
import by.zhakov.bureau.db.Queries;

public class QualificationDAO {
	private static Logger log = Logger.getLogger(QualificationDAO.class);
	
	public static String getQualification(int id){
		Connection c = ConnectionsPool.getInstance().getConnection();
		String result = "";
		try {
			PreparedStatement statement = c.prepareStatement(Queries.getQualificationName);
			statement.setInt(1, id);
			ResultSet results = statement.executeQuery();
			if (results.first()){
                result = results.getString("name");
			}
		} catch (SQLException e) {
			log.error("qualification dao exception", e);
		}
		return result;
	}
}

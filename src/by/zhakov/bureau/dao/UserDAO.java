package by.zhakov.bureau.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import by.zhakov.bureau.db.ConnectionsPool;
import by.zhakov.bureau.db.Queries;
import by.zhakov.bureau.model.User;

public class UserDAO {
	private static Logger log = Logger.getLogger(UserDAO.class);
	
	public static User getUser(String login, String password){
		Connection c = ConnectionsPool.getInstance().getConnection();
		User result = null;
		try {
			PreparedStatement statement = c.prepareStatement(Queries.loginUser);
			statement.setString(1, login);
			statement.setString(2, password);
			ResultSet results = statement.executeQuery();
			if (results.first()){
				int id = results.getInt("idUser");
				String name = results.getString("name");
				String phone = results.getString("phone");
				String address = results.getString("address");
				boolean isAdmin = results.getBoolean("isAdmin");
				result = new User(id, name, phone, address, isAdmin, login, password);
			}
		} catch (SQLException e) {
			log.error("getSpec dao exception", e);
		}
		return result;
	}
}

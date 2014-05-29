package by.zhakov.bureau.db;

import java.util.ResourceBundle;

public class Queries {
	private static ResourceBundle bundle = 
			ResourceBundle.getBundle("by.zhakov.bureau.db.queries");
	public static String getSpecsForUser = bundle.getString("getSpecsForUsername");
	public static String getSpecDetails = bundle.getString("getSpecDetails");
	public static String getQualificationName = bundle.getString("getQualificationName");
	public static String getUnpayedProjects = bundle.getString("getUnpayedProjects");
	public static String getUnassignedWorkers = bundle.getString("getUnassignedWorkers");
	public static String assignProjectToWorker = bundle.getString("assignProjectToWorker");
	public static String getSpecialists = bundle.getString("getSpecialists");
	public static String getProjects = bundle.getString("getProjects");
	public static String loginUser = bundle.getString("loginUser");
}

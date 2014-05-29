package by.zhakov.bureau.commands;

import javax.servlet.http.HttpServletRequest;

import by.zhakov.bureau.config.ConfigurationManager;
import by.zhakov.bureau.dao.SpecificationDAO;

public class DetailsCommand implements ICommand {

	@Override
	public String execute(HttpServletRequest request) {
		String specs  = request.getParameter("spec");
		request.setAttribute("details", 
				SpecificationDAO.getSpecDetails(Integer.parseInt(specs)));
		
		return ConfigurationManager.getInstance().getProperty(ConfigurationManager.DETAILS_PAGE_PATH);
	}

}

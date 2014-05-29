package by.zhakov.bureau.commands;

import javax.servlet.http.HttpServletRequest;

import by.zhakov.bureau.config.ConfigurationManager;
import by.zhakov.bureau.dao.SpecificationDAO;
import by.zhakov.bureau.dao.UserDAO;
import by.zhakov.bureau.model.User;

public class LoginCommand implements ICommand{
	public String execute(HttpServletRequest request)
    {
        String page = null;
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        User user = UserDAO.getUser(userName, password);
        if (user != null)
        {

            request.getSession().setAttribute("username", user.getName());
            if (user.isAdmin()){
            	request.getSession().setAttribute("userrole", "admin");
            	page = ConfigurationManager.getInstance().getProperty(ConfigurationManager.ADMIN_PAGE_PATH);
            } else {
            	request.getSession().setAttribute("userrole", "user");
        		request.setAttribute("specification", SpecificationDAO.getSpecsForUser(userName));
            	page = ConfigurationManager.getInstance().getProperty(ConfigurationManager.USER_PAGE_PATH);
            }            
        }
        else
        {
            request.getSession().setAttribute("error", "no_user");
            page = ConfigurationManager.getInstance().getProperty(ConfigurationManager.LOGIN_PAGE_PATH);
        }
        return page;
    };
}

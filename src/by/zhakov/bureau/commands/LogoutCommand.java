package by.zhakov.bureau.commands;

import javax.servlet.http.HttpServletRequest;

import by.zhakov.bureau.config.ConfigurationManager;

public class LogoutCommand implements ICommand{
	@Override
    public String execute(HttpServletRequest request) {
        String page = null;
        request.getSession().setAttribute("username", null);
        page = ConfigurationManager.getInstance().getProperty("LOGIN_PAGE_PATH");
        return page;
    }
}

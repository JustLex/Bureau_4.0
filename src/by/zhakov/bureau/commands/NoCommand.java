package by.zhakov.bureau.commands;

import javax.servlet.http.HttpServletRequest;

import by.zhakov.bureau.config.ConfigurationManager;

public class NoCommand implements ICommand {

	@Override
	public String execute(HttpServletRequest request) {
		String page = ConfigurationManager.getInstance().getProperty(ConfigurationManager.MAIN_PAGE_PATH);
        return page;
	}

}

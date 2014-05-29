package by.zhakov.bureau.commands;

import javax.servlet.http.HttpServletRequest;

public interface ICommand {
	public String execute(HttpServletRequest request);
}

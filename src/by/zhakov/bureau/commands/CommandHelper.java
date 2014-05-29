package by.zhakov.bureau.commands;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

public class CommandHelper {
	private static CommandHelper instance = null;
    private HashMap<String, ICommand> commands = new HashMap<String, ICommand>();
    private CommandHelper()
    {
        commands.put("login", new LoginCommand());
        commands.put("logout", new LogoutCommand());
        commands.put("details", new DetailsCommand());
    }
    public ICommand getCommand(HttpServletRequest request)
    {
        String action = request.getParameter("command");
        ICommand command = commands.get(action);
        if (command == null)
        {
            command = new NoCommand();
        }
        return command;
    }
    public static CommandHelper getInstance()
    {
        if (instance == null)
        {
            instance = new CommandHelper();
        }
        return instance;
    }
}

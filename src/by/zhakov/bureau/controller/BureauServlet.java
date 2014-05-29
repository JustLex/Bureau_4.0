package by.zhakov.bureau.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import by.zhakov.bureau.commands.CommandHelper;
import by.zhakov.bureau.commands.ICommand;

public class BureauServlet extends HttpServlet {
	private static final long serialVersionUID = 357913336408695802L;


    public static Logger log = Logger.getLogger(BureauServlet.class);

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        process(req, resp);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        process(req, resp);
    }

    public void process(HttpServletRequest request, HttpServletResponse response)
    {
        String page = null;
        ICommand command = CommandHelper.getInstance().getCommand(request);
        page = command.execute(request);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
        try
        {
            dispatcher.forward(request, response);
        }
        catch (ServletException | IOException e)
        {
            log.error(e.getMessage());
        }
    }
}

package com.javarush.kgurov.parameters;

import static com.javarush.kgurov.constant.Constants.*;

import com.javarush.kgurov.service.Service;
import com.javarush.kgurov.service.UserService;
import com.javarush.kgurov.users.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

@WebServlet(name = START_SERVLET, urlPatterns = URL_PATTERN)
public class StartServlet extends HttpServlet {
    private final Service userService = UserService.getInstance();
    static final Logger logger = LogManager.getLogger(StartServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("Get to /start from {}", req.getRemoteAddr());
        req.getRequestDispatcher(START_PAGE_PATH).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        logger.info("Post to /start from {}", req.getRemoteAddr());

        HttpSession session = req.getSession();
        String address = req.getRemoteAddr() + ":" + req.getRemotePort();
        String name = req.getParameter("name");
        User newUser = new User(name, address);
        userService.create(newUser);
        logger.info("User create success userName:{}, userId:{}: "
                , newUser.getName()
                , newUser.getId());
        session.setAttribute(ADDRESS_ATTRIBUTE, address);
        session.setAttribute(NAME_ATTRIBUTE, name);
        session.setAttribute(ID_ATTRIBUTE, newUser.getId());
        session.setAttribute(SCORE_ATTRIBUTE, newUser.getScore());
        resp.sendRedirect(QUEST_REDIRECT_URL);
    }
}
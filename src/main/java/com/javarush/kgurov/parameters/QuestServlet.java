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

@WebServlet(name = "QuestServlet", urlPatterns = {"/quest/*"})
public class QuestServlet extends HttpServlet {

    private final Service userService = UserService.getInstance();
    private static final Logger logger = LogManager.getLogger(QuestServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("Get to /quest from {}", req.getRemoteAddr());
        req.getRequestDispatcher(QUEST_PAGE_PATH).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("Post to /quest from {}", req.getRemoteAddr());
        HttpSession session = req.getSession();
        long id = (long) session.getAttribute("id");
        User user = userService.get(id).orElseThrow(() -> new ServletException("User not found"));

        int answer = Integer.parseInt(req.getParameter(ANSWER_PARAMETER));

        if (answer == 1) {
            user.nextLevel();
            logger.info("Score user {} upped", req.getRemoteAddr());
            if (user.getScore() > 2) {
                logger.info("User {} win", req.getRemoteAddr());
                resp.sendRedirect(WIN_REDIRECT_URL);
            } else {
                session.setAttribute("score", user.getScore());
                resp.sendRedirect(req.getRequestURI());
            }
        } else if (answer == 0) {
            logger.info("User {} defeated", req.getRemoteAddr());
            session.removeAttribute("score");
            resp.sendRedirect(LOSE_REDIRECT_URL);
        } else {
            resp.sendRedirect(req.getRequestURI());
        }
    }
}
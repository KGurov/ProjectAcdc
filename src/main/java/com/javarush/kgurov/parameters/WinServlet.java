package com.javarush.kgurov.parameters;

import static com.javarush.kgurov.constant.Constants.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

@WebServlet(urlPatterns = "/win", name = "WinServlet")
public class WinServlet extends HttpServlet {
    private static final Logger logger = LogManager.getLogger(WinServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("Get to /win from {}", req.getRemoteAddr());
        req.getRequestDispatcher(WIN_PAGE_PATH).forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession();
        try {
            session.removeAttribute(SCORE_ATTRIBUTE);
            logger.info("User's {} score removed successfully, game restarted", req.getRemoteAddr());
        } catch (Exception e) {
            logger.error("Failed to remove user's score", e);
        }
        resp.sendRedirect(HOME_REDIRECT_URL);
    }
}
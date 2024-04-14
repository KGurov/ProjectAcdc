package com.javarush.kgurov.parameters;

import com.javarush.kgurov.constant.Constants;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;


@WebServlet(name = "LoseServlet", urlPatterns = "/lose")
public class LoseServlet extends HttpServlet {
    private static final Logger logger = LogManager.getLogger(LoseServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userAddress = req.getRemoteAddr();
        logger.info("User's {} lose", userAddress);
        req.getRequestDispatcher(Constants.VIEW_LOSE_JSP).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String userAddress = req.getRemoteAddr();
        try {
            HttpSession session = req.getSession();
            session.removeAttribute(Constants.SCORE_ATTRIBUTE);
            logger.info("User's {} score remove success, game restarted", userAddress);
        } catch (Exception e) {
            logger.error("Failed to remove score for user " + userAddress, e);
        }
        resp.sendRedirect(Constants.HOME_REDIRECT_URL);
    }
}
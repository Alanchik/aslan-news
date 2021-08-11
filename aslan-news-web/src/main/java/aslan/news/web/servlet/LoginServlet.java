package aslan.news.web.servlet;

import com.chahan.domain.exception.LoginException;
import com.chahan.domain.service.AuthService;
import com.chahan.domain.service.AuthServiceImpl;
import com.chahan.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private AuthService loginService = AuthServiceImpl.getLoginServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User user = null;
        try {
            user = loginService.signIn(username, password);
        } catch (LoginException e) {
            req.setAttribute("username", username);
            req.setAttribute("password", password);
            req.setAttribute("errorMessage", e.getMessage());
            req.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(req, resp);
        }
        req.getSession().setAttribute("user", user);
        resp.sendRedirect(req.getContextPath() + "/articles");
    }
}

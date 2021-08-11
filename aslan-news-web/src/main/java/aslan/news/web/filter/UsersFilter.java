package aslan.news.web.filter;

import com.chahan.domain.exception.ApplicationException;
import com.chahan.models.User;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static java.util.Objects.isNull;

@WebFilter(urlPatterns = {"/addArticle", "/deleteArticles", "/updateArticles"})
public class UsersFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException, ApplicationException {
        User user = (User) req.getSession().getAttribute("user");
        if (isNull(user)) {
            res.sendRedirect(req.getContextPath() + "/login");
        } else {
            super.doFilter(req, res, chain);
        }
    }
}

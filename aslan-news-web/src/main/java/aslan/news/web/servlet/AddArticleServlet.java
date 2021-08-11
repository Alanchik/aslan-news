package aslan.news.web.servlet;

import com.chahan.domain.exception.ApplicationException;
import com.chahan.domain.service.ArticleService;
import com.chahan.domain.service.ArticleServiceImpl;
import com.chahan.models.Article;
import com.chahan.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet("/addArticle")
public class AddArticleServlet extends HttpServlet {

    private ArticleService articleService = ArticleServiceImpl.getArticleService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/addArticle.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        String text = req.getParameter("text");
        Article article = null;
        try {
            User user = (User) req.getSession().getAttribute("user");
            article = articleService.addArticle(title, text, LocalDateTime.now(), user.getId());
        } catch (ApplicationException e) {
            req.setAttribute("title", title);
            req.setAttribute("text", text);
            req.setAttribute("errorMessage", e.getMessage());
            req.getRequestDispatcher("/WEB-INF/jsp/addArticle.jsp").forward(req, resp);
        }
        req.setAttribute("article", article);
        req.getRequestDispatcher("/WEB-INF/jsp/article.jsp").forward(req, resp);
    }
}

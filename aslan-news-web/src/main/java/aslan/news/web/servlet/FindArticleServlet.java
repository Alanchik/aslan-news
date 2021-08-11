package aslan.news.web.servlet;

import com.chahan.domain.service.ArticleService;
import com.chahan.domain.service.ArticleServiceImpl;
import com.chahan.models.Article;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/findArticle")
public class FindArticleServlet extends HttpServlet {

    private ArticleService articleService = ArticleServiceImpl.getArticleService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/findArticle.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        Article article = null;
        try {
            article = articleService.findArticleByTitle(title);
        } catch (Exception e) {
            req.setAttribute("title", title);
            req.setAttribute("errorMessage", e.getMessage());
            e.printStackTrace();
            req.getRequestDispatcher("/WEB-INF/jsp/findArticle.jsp").forward(req, resp);
        }
        req.setAttribute("article", article);
        req.getRequestDispatcher("/WEB-INF/jsp/article.jsp").forward(req, resp);
    }
}

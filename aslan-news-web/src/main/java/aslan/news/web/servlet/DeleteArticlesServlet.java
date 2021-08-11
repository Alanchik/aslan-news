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
import java.util.List;

@WebServlet("/deleteArticles")
public class DeleteArticlesServlet extends HttpServlet {

    private ArticleService articleService = ArticleServiceImpl.getArticleService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Article> articles = articleService.readAllArticles();
        req.setAttribute("articles", articles);
        req.getRequestDispatcher("/WEB-INF/jsp/deleteArticles.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String urlParam = req.getParameter("id");
        List<Article> returnNewArticles = articleService.deleteArticle(Long.valueOf(urlParam));
        req.setAttribute("articles", returnNewArticles);
        req.getRequestDispatcher("/WEB-INF/jsp/deleteArticles.jsp").forward(req, resp);
    }
}

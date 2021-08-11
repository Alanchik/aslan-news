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

@WebServlet("/article")
public class ArticleServlet extends HttpServlet {

    private ArticleService articleService = ArticleServiceImpl.getArticleService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String urlParam = req.getParameter("title");
        Article article = articleService.findArticleByTitle(urlParam);
        req.setAttribute("article", article);
        req.getRequestDispatcher("/WEB-INF/jsp/article.jsp").forward(req, resp);
    }
}

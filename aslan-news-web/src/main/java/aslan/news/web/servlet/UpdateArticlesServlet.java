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

@WebServlet("/updateArticles")
public class UpdateArticlesServlet extends HttpServlet {

    private ArticleService articleService = ArticleServiceImpl.getArticleService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Article> articles = articleService.readAllArticles();
        req.setAttribute("articles", articles);
        req.getRequestDispatcher("/WEB-INF/jsp/updateArticles.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String urlParam = req.getParameter("id");
        Article article = null;
        try {
            article = articleService.findArticleByID(Long.valueOf(urlParam));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        req.setAttribute("article", article);
        req.getRequestDispatcher("/WEB-INF/jsp/updateFormArticle.jsp").forward(req, resp);
    }
}

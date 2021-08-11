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
import java.time.LocalDateTime;

@WebServlet("/updateFormArticle")
public class UpdateFormArticle extends HttpServlet {

    private ArticleService articleService = ArticleServiceImpl.getArticleService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String newTitle = req.getParameter("title");
        String newText = req.getParameter("text");
        String getID = req.getParameter("id");
        Article article = new Article();
        try {
            article.setId(Long.valueOf(getID));
            article.setTitle(newTitle);
            article.setText(newText);
            article.setDate(LocalDateTime.now());
            articleService.updateArticle(article);
        } catch (Exception e) {
            e.printStackTrace();
        }
        resp.sendRedirect(req.getContextPath() + "/updateArticles");
    }
}

package anuda.me.coronaback.external_responses;

import java.util.List;

public class NewsAPIResponse {

    private String status;
    private int totalResults;
    private List<NewsAPIArticle> articles;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public List<NewsAPIArticle> getArticles() {
        return articles;
    }

    public void setArticles(List<NewsAPIArticle> articles) {
        this.articles = articles;
    }
}

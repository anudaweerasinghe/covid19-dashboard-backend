package anuda.me.coronaback.controllers;


import anuda.me.coronaback.external_responses.NewsAPIArticle;
import anuda.me.coronaback.helpers.APICall;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("news")
public class NewsController {

    @RequestMapping(value = "local", method = RequestMethod.GET)
    public ResponseEntity<?> getLocalNews(){

        List<NewsAPIArticle> newsFirstArticles = new APICall().localNewsAPICall("https://www.newsfirst.lk/feed/");
        List<NewsAPIArticle> adaDeranaArticles = new APICall().localNewsAPICall("http://www.adaderana.lk/rss.php");

        List<NewsAPIArticle> localNewsArticles = new ArrayList<>();

        for(int i = 0; i<10; i++){
            localNewsArticles.add(newsFirstArticles.get(i));
            localNewsArticles.add(adaDeranaArticles.get(i));
        }

        for(int i=10; i<20; i++){
            localNewsArticles.add(adaDeranaArticles.get(i));
        }

        return new ResponseEntity<Object>(localNewsArticles, HttpStatus.OK);

    }

    @RequestMapping(value = "local/min", method = RequestMethod.GET)
    public ResponseEntity<?> getLocalNewsMinified(){

        List<NewsAPIArticle> newsFirstArticles = new APICall().localNewsAPICall("https://www.newsfirst.lk/feed/");
        List<NewsAPIArticle> adaDeranaArticles = new APICall().localNewsAPICall("http://www.adaderana.lk/rss.php");

        List<NewsAPIArticle> localNewsArticles = new ArrayList<>();

        for(int i = 0; i<3; i++){
            localNewsArticles.add(newsFirstArticles.get(i));
            localNewsArticles.add(adaDeranaArticles.get(i));
        }

        return new ResponseEntity<Object>(localNewsArticles, HttpStatus.OK);

    }

    @RequestMapping(value = "global", method = RequestMethod.GET)
    public ResponseEntity<?> getGlobalNews() {

        List<NewsAPIArticle> cnnArticles = new APICall().newsAPICall("cnn");
        List<NewsAPIArticle> bbcArticles = new APICall().newsAPICall("bbc-news");
        List<NewsAPIArticle> reutersArticles = new APICall().newsAPICall("reuters");

        List<NewsAPIArticle> globalNewsArticles = new ArrayList<>();

        for(int i=0;i<10;i++){

            if(cnnArticles.get(i).getAuthor()==null){
                cnnArticles.get(i).setAuthor("CNN");
            }
            if(bbcArticles.get(i).getAuthor()==null){
                bbcArticles.get(i).setAuthor("BBC News");
            }
            if(reutersArticles.get(i).getAuthor()==null){
                reutersArticles.get(i).setAuthor("Reuters");
            }



            globalNewsArticles.add(cnnArticles.get(i));
            globalNewsArticles.add(bbcArticles.get(i));
            globalNewsArticles.add(reutersArticles.get(i));

        }

        return new ResponseEntity<Object>(globalNewsArticles, HttpStatus.OK);

    }

    @RequestMapping(value = "global/min", method = RequestMethod.GET)
    public ResponseEntity<?> getGlobalNewsMinified() {

        List<NewsAPIArticle> cnnArticles = new APICall().newsAPICall("cnn");
        List<NewsAPIArticle> bbcArticles = new APICall().newsAPICall("bbc-news");
        List<NewsAPIArticle> reutersArticles = new APICall().newsAPICall("reuters");

        List<NewsAPIArticle> globalNewsArticles = new ArrayList<>();

        for(int i=0;i<2;i++){

            if(cnnArticles.get(i).getAuthor()==null){
                cnnArticles.get(i).setAuthor("CNN");
            }
            if(bbcArticles.get(i).getAuthor()==null){
                bbcArticles.get(i).setAuthor("BBC News");
            }
            if(reutersArticles.get(i).getAuthor()==null){
                reutersArticles.get(i).setAuthor("Reuters");
            }



            globalNewsArticles.add(cnnArticles.get(i));
            globalNewsArticles.add(bbcArticles.get(i));
            globalNewsArticles.add(reutersArticles.get(i));

        }

        return new ResponseEntity<Object>(globalNewsArticles, HttpStatus.OK);

    }


}

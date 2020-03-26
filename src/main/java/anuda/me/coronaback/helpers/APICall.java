package anuda.me.coronaback.helpers;

import anuda.me.coronaback.external_responses.*;
import com.mashape.unirest.http.HttpResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.request.GetRequest;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.feed.synd.SyndFeedImpl;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class APICall {

//    public List<NewsAPIArticle> localnewsAPICall(String source){
//
//        try{
//
//        URL feedSource = new URL("http://www.adaderana.lk/rss.php");
//        if(source.equals("derana")){
//            feedSource = new URL("http://www.adaderana.lk/rss.php");
//        }else if(source.equals("news-first")){
//                feedSource = new URL("https://www.newsfirst.lk/feed/");
//        }
//
//        SyndFeedInput input = new SyndFeedInput();
//        SyndFeed feed = input.build(new XmlReader(feedSource));
//
//        System.out.println(feed);
//
//        return null;
//
//        }catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }

    public List<NewsAPIArticle> newsAPICall(String source){
        try {
        NewsAPIResponse response = new NewsAPIResponse();
        String url = "https://newsapi.org/v2/top-headlines?sources="+source+"&apiKey=45c90edbb71e4bc89563905aeb265c17";

        ObjectMapper mapper = new ObjectMapper();

        GetRequest jsonResponse = Unirest.get(url);
        HttpResponse<String> jsonResponse2 = jsonResponse.asString();


        response = mapper.readValue(jsonResponse2.getBody(), NewsAPIResponse.class);

        return response.getArticles();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public HPBResponse slhpbCall(){

        try{

            HPBResponse response = new HPBResponse();
            String url = "https://www.hpb.health.gov.lk/api/get-current-statistical";

            ObjectMapper mapper = new ObjectMapper();

            GetRequest jsonResponse = Unirest.get(url);
            HttpResponse<String> jsonResponse2 = jsonResponse.asString();

            response = mapper.readValue(jsonResponse2.getBody(), HPBResponse.class);

            return response;

        } catch (Exception e){

            return null;

        }

    }

    public HerokuAllResponse herokuAllCall(){
        try{

            HerokuAllResponse response = new HerokuAllResponse();
            String url = "https://coronavirus-19-api.herokuapp.com/all";

            ObjectMapper mapper = new ObjectMapper();

            GetRequest jsonResponse = Unirest.get(url);
            HttpResponse<String> jsonResponse2 = jsonResponse.asString();

            response = mapper.readValue(jsonResponse2.getBody(), HerokuAllResponse.class);

            return response;

        } catch (Exception e){

            return null;

        }
    }

    public List<HerokuCountriesResponse> herokuCountriesCall(){
        try{

            List<HerokuCountriesResponse> response = new ArrayList<>();
            String url = "https://coronavirus-19-api.herokuapp.com/countries";

            ObjectMapper mapper = new ObjectMapper();

            GetRequest jsonResponse = Unirest.get(url);
            HttpResponse<String> jsonResponse2 = jsonResponse.asString();

            response = mapper.readValue(jsonResponse2.getBody(), mapper.getTypeFactory().constructCollectionType(List.class, HerokuCountriesResponse.class));

            return response;

        } catch (Exception e){

            return null;

        }
    }

}

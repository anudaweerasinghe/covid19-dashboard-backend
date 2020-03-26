package anuda.me.coronaback.helpers;

import anuda.me.coronaback.external_responses.HPBResponse;
import anuda.me.coronaback.external_responses.HerokuAllResponse;
import anuda.me.coronaback.external_responses.HerokuCountriesResponse;
import com.mashape.unirest.http.HttpResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.request.GetRequest;

import java.util.ArrayList;
import java.util.List;

public class APICall {

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

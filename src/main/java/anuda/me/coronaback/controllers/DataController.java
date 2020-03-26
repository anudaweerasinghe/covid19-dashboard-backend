package anuda.me.coronaback.controllers;


import anuda.me.coronaback.entities.History;
import anuda.me.coronaback.external_responses.HPBResponse;
import anuda.me.coronaback.external_responses.HerokuAllResponse;
import anuda.me.coronaback.external_responses.HerokuCountriesResponse;
import anuda.me.coronaback.helpers.APICall;
import anuda.me.coronaback.repositories.HistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("data")
public class DataController {

    @Autowired
    private HistoryRepository historyRepository;

    @RequestMapping(value = "graphs", method = RequestMethod.GET)
    public ResponseEntity<?> getStatsForSl(){

        try{

            List<History> historicalData = historyRepository.findAll();

            return new ResponseEntity<Object>(historicalData, HttpStatus.OK);

        }catch (Exception e){
            return new ResponseEntity<Object>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @RequestMapping(value = "test", method = RequestMethod.GET)
    public ResponseEntity<?>test(){
        List<HerokuCountriesResponse> response = new APICall().herokuCountriesCall();

        return new ResponseEntity<Object>(response, HttpStatus.OK);
    }
}

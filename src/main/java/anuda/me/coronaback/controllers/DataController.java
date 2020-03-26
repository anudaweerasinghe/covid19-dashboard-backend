package anuda.me.coronaback.controllers;


import anuda.me.coronaback.entities.History;
import anuda.me.coronaback.external_responses.HPBData;
import anuda.me.coronaback.external_responses.HPBResponse;
import anuda.me.coronaback.external_responses.HerokuAllResponse;
import anuda.me.coronaback.external_responses.HerokuCountriesResponse;
import anuda.me.coronaback.helpers.APICall;
import anuda.me.coronaback.repositories.HistoryRepository;
import anuda.me.coronaback.responses.SLData;
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
    public ResponseEntity<?> getGraphs(){

        try{

            HPBResponse hpbResponse = new APICall().slhpbCall();
            History todaysRecord = historyRepository.findByDateText(hpbResponse.getData().getUpdate_date_time().substring(0, 10));

            if(todaysRecord == null){
                todaysRecord = new History();
            }

            todaysRecord.setDateText(hpbResponse.getData().getUpdate_date_time().substring(0, 10));
            todaysRecord.setGlobalConfirmedCases(hpbResponse.getData().getGlobal_total_cases());
            todaysRecord.setGlobalNewCases(hpbResponse.getData().getGlobal_new_cases());
            todaysRecord.setLocalConfirmedCases(hpbResponse.getData().getLocal_total_cases());
            todaysRecord.setLocalNewCases(hpbResponse.getData().getLocal_new_cases());

            historyRepository.save(todaysRecord);


            List<History> historicalData = historyRepository.findAll();

            return new ResponseEntity<Object>(historicalData, HttpStatus.OK);

        }catch (Exception e){
            return new ResponseEntity<Object>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @RequestMapping(value = "stats/sl", method = RequestMethod.GET)
    public ResponseEntity<?> getStatsForSl(){


            HPBResponse hpbResponse = new APICall().slhpbCall();
            HPBData hpbData = hpbResponse.getData();
            List<HerokuCountriesResponse> herokuCountriesResponse = new APICall().herokuCountriesCall();

            SLData slData = new SLData();

            slData.setConfirmedCases(hpbData.getLocal_total_cases());
            slData.setNewCases(hpbData.getLocal_new_cases());
            slData.setUnderObservation(hpbData.getLocal_total_number_of_individuals_in_hospitals());
            slData.setRecoveries(hpbData.getLocal_recovered());
            slData.setDeaths(hpbData.getLocal_deaths());
            slData.setNewDeaths(hpbData.getLocal_new_deaths());

            for(int i=0; i<herokuCountriesResponse.size(); i++){

                if(herokuCountriesResponse.get(i).getCountry().equals("Sri Lanka")){
                    slData.setCasesPerMillion(herokuCountriesResponse.get(i).getCasesPerOneMillion());
                    slData.setDeathsPerMillion(herokuCountriesResponse.get(i).getDeathsPerOneMillion());
                    slData.setCritical(herokuCountriesResponse.get(i).getCritical());
                }

            }

            return new ResponseEntity<Object>(slData, HttpStatus.OK);


    }
}

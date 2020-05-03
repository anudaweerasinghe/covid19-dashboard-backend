package anuda.me.coronaback.controllers;


import anuda.me.coronaback.entities.History;
import anuda.me.coronaback.external_responses.HPBData;
import anuda.me.coronaback.external_responses.HPBResponse;
import anuda.me.coronaback.external_responses.HerokuAllResponse;
import anuda.me.coronaback.external_responses.HerokuCountriesResponse;
import anuda.me.coronaback.helpers.APICall;
import anuda.me.coronaback.repositories.HistoryRepository;
import anuda.me.coronaback.responses.GlobalData;
import anuda.me.coronaback.responses.SLData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("data")
public class DataController {

    @Autowired
    private HistoryRepository historyRepository;

    @RequestMapping(value = "graphs", method = RequestMethod.GET)
    public ResponseEntity<?> getGraphs(@RequestParam(required = false) String type){

        try{

            HPBResponse hpbResponse = new APICall().slhpbCall();
            if(type.equals("ln")) {

                History todaysRecord = historyRepository.findByDateText(hpbResponse.getData().getUpdate_date_time().substring(0, 10));


                if (todaysRecord == null) {
                    todaysRecord = new History();
                }

                todaysRecord.setDateText(hpbResponse.getData().getUpdate_date_time().substring(0, 10));
                todaysRecord.setGlobalConfirmedCases(hpbResponse.getData().getGlobal_total_cases());
                todaysRecord.setGlobalNewCases(hpbResponse.getData().getGlobal_new_cases());
                todaysRecord.setLocalConfirmedCases(hpbResponse.getData().getLocal_total_cases());
                todaysRecord.setLocalNewCases(hpbResponse.getData().getLocal_new_cases());

                historyRepository.save(todaysRecord);

            }
            List<History> historicalData = historyRepository.findAll();
            List<String> dates = new ArrayList<>();
            List<Integer> localNewCases = new ArrayList<>();
            List<Integer> localConfirmedCases = new ArrayList<>();
            List<Integer> globalNewCases = new ArrayList<>();
            List<Integer> globalConfirmedCases = new ArrayList<>();

            for(int i=0; i<historicalData.size();i++){
                dates.add(historicalData.get(i).getDateText());
                localConfirmedCases.add(historicalData.get(i).getLocalConfirmedCases());
                localNewCases.add(historicalData.get(i).getLocalNewCases());
                globalConfirmedCases.add(historicalData.get(i).getGlobalConfirmedCases());
                globalNewCases.add(historicalData.get(i).getGlobalNewCases());
            }
            if(type!=null) {
                if (type.equals("dates")) {
                    return new ResponseEntity<Object>(dates, HttpStatus.OK);
                } else if (type.equals("ln")) {
                    return new ResponseEntity<Object>(localNewCases, HttpStatus.OK);

                } else if (type.equals("lc")) {
                    return new ResponseEntity<Object>(localConfirmedCases, HttpStatus.OK);

                } else if (type.equals("gn")) {
                    return new ResponseEntity<Object>(globalNewCases, HttpStatus.OK);

                } else if (type.equals("gc")) {
                    return new ResponseEntity<Object>(globalConfirmedCases, HttpStatus.OK);

                } else {
                    return new ResponseEntity<Object>(historicalData, HttpStatus.OK);
                }
            }

            return new ResponseEntity<Object>(historicalData, HttpStatus.OK);

        }catch (Exception e){
            e.printStackTrace();
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
            slData.setTotalTests(hpbData.getTotal_pcr_testing_count());

            for(int i=0; i<herokuCountriesResponse.size(); i++){

                if(herokuCountriesResponse.get(i).getCountry().equals("Sri Lanka")){
                    slData.setCasesPerMillion(herokuCountriesResponse.get(i).getCasesPerOneMillion());
                    slData.setDeathsPerMillion(herokuCountriesResponse.get(i).getDeathsPerOneMillion());
                    slData.setCritical(herokuCountriesResponse.get(i).getCritical());
                }

            }

            return new ResponseEntity<Object>(slData, HttpStatus.OK);


    }

    @RequestMapping(value = "stats/global", method = RequestMethod.GET)
    public ResponseEntity<?> getStatsGlobal(){


        HPBResponse hpbResponse = new APICall().slhpbCall();
        HPBData hpbData = hpbResponse.getData();
        HerokuAllResponse herokuAllResponse = new APICall().herokuAllCall();

        GlobalData globalData = new GlobalData();

        globalData.setConfirmedCases(herokuAllResponse.getCases());
        globalData.setNewCases(hpbData.getGlobal_new_cases());
        globalData.setRecoveries(herokuAllResponse.getRecovered());
        globalData.setDeaths(herokuAllResponse.getDeaths());
        globalData.setNewDeaths(hpbData.getGlobal_new_deaths());

        return new ResponseEntity<Object>(globalData, HttpStatus.OK);


    }

    @RequestMapping(value = "stats", method = RequestMethod.GET)
    public ResponseEntity<?> getStatsByCountry(@RequestParam String country){

        country = country.toLowerCase();

        if(country.equals("us")){
            country = "usa";
        }else if(country.equals("united states of america")){
            country = "usa";
        }else if(country.equals("united states")) {
            country = "usa";
        }else if(country.equals("united kingdom")){
            country = "uk";
        }else if(country.equals("england")){
            country = "uk";
        }else if(country.equals("south korea")){
            country = "s. korea";
        }else if(country.equals("korea")){
            country = "s. korea";
        }else if(country.equals("united arab emirates")){
            country = "uae";
        }

        List<HerokuCountriesResponse> herokuCountriesResponse = new APICall().herokuCountriesCall();

        HerokuCountriesResponse countryData = new HerokuCountriesResponse();
        for(int i=0; i<herokuCountriesResponse.size(); i++){

            if(herokuCountriesResponse.get(i).getCountry().toLowerCase().equals(country)){
                countryData = herokuCountriesResponse.get(i);
            }
        }

        return new ResponseEntity<Object>(countryData, HttpStatus.OK);
    }



    @RequestMapping(value = "countries", method = RequestMethod.GET)
    public ResponseEntity<?> getCountriesListForDropDown(){

        List<HerokuCountriesResponse> herokuCountriesResponse = new APICall().herokuCountriesCall();
        List<String> countries = new ArrayList<>();

        for (int i = 0; i < herokuCountriesResponse.size(); i++) {

            countries.add(herokuCountriesResponse.get(i).getCountry());

        }
        return new ResponseEntity<Object>(countries, HttpStatus.OK);
    }
}

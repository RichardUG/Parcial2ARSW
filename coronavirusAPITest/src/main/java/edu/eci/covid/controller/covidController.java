package edu.eci.covid.controller;

import edu.eci.covid.service.covidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/covid")
public class covidController {
    @Autowired
    @Qualifier("covidServices")
    private covidService covidService;

    @RequestMapping(path = "/generalStats",method = RequestMethod.GET)
    public ResponseEntity<?> getGeneralStats(){
        try {
            System.out.println("contriller");
            return new ResponseEntity<> (covidService.getGeneralStats(), HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            System.out.println(ex);
            return new ResponseEntity<>("Error 404",HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(path = "/covidByCity/{country}",method = RequestMethod.GET)
    public ResponseEntity<?> getCovidByCountry(@PathVariable String country ){
        try {
            return new ResponseEntity<> (covidService.getCovidByCountry(country), HttpStatus.ACCEPTED);
        } catch (Exception ex) {
            return new ResponseEntity<>("Error 404",HttpStatus.NOT_FOUND);
        }
    }
}

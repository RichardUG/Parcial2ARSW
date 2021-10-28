package edu.eci.covid.service;

import edu.eci.covid.cache.cache;
import edu.eci.covid.connection.covidException;
import edu.eci.covid.connection.impl.HttpConnectionImpl;
import edu.eci.covid.controller.notFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service("covidServices")
public class covidService {
    @Autowired
    @Qualifier("cache")
    private cache cache;

    @Autowired
    @Qualifier("connection")
    private HttpConnectionImpl httpConnection;

    public String getCovidByCountry(String city) throws covidException, IOException {
        String data = cache.getCovidByCountry(city);
        return  data;
    }

    public String getGeneralStats() throws IOException {
        System.out.println("service");
        return httpConnection.getGeneralStats();
    }
}

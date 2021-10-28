package edu.eci.covid.cache;

import edu.eci.covid.connection.covidException;
import edu.eci.covid.connection.impl.HttpConnectionImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.concurrent.ConcurrentHashMap;

@Service("cache")
public class cache {
    @Autowired
    @Qualifier("connection")
    HttpConnectionImpl http;
    private ConcurrentHashMap<String, String> countries = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, LocalDateTime> time = new ConcurrentHashMap<>();

    public String getCovidByCountry(String name) throws IOException, covidException {
        if(time.containsKey(name)) {
            LocalDateTime weatherTime = time.get(name);
            if(LocalDateTime.now().isAfter(weatherTime.plusMinutes(5))) {
                String covidStadistics = http.getCovidByCountry(name);
                countries.replace(name, covidStadistics);
                time.replace(name, LocalDateTime.now());
                return covidStadistics;
            }
            return countries.get(name);
        }else{
            String country = http.getCovidByCountry(name);
            countries.put(name,country);
            time.put(name, LocalDateTime.now());
            return country;
        }
    }
}

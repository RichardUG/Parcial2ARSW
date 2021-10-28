package edu.eci.covid.connection.impl;

import edu.eci.covid.connection.HttpConnection;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

@Service("connection")
public class HttpConnectionImpl implements HttpConnection {

    @Override
    public String getCovidByCountry(String country) throws IOException {
        String USER_AGENT = "Mozilla/5.0";
        String GET_URL = "http://covid-19-coronavirus-statistics.p.rapidapi.com/v1/total?="+country+"&rapidapi-key=4d67717417msh9293a8777f5292ep1c8fefjsn51a590a47cbb";
        URL obj = new URL(GET_URL);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);
        int responseCode = con.getResponseCode();
        System.out.println("GET Response Code :: " + responseCode);
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            System.out.println(response.toString());
            return response.toString();
        } else {
            return null;
        }
    }

    @Override
    public String getGeneralStats() throws IOException {
        System.out.println("connect");
        String USER_AGENT = "Mozilla/5.0";
        String GET_URL = "http://covid-19-coronavirus-statistics.p.rapidapi.com/v1/stats?rapidapi-key=4d67717417msh9293a8777f5292ep1c8fefjsn51a590a47cbb";
        URL obj = new URL(GET_URL);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);
        int responseCode = con.getResponseCode();
        System.out.println("GET Response Code :: " + responseCode);
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            System.out.println(response.toString());
            return response.toString();
        } else {
            return null;
        }
    }
}

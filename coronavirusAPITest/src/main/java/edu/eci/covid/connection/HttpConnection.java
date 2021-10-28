package edu.eci.covid.connection;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ProtocolException;

public interface HttpConnection {
    String getCovidByCountry(String name) throws IOException;

    String getGeneralStats() throws IOException;
}

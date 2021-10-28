package edu.eci.covid.connection;

public class covidException extends Exception{
    public covidException(String message) {
        super(message);
    }
    public covidException(String message, Throwable cause) {
        super(message, cause);
    }
}

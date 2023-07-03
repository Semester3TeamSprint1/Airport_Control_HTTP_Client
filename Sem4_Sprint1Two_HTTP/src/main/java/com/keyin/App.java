package com.keyin;

import com.keyin.http.cli.HTTPRestCLIApplication;
import com.keyin.http.client.RESTClient;

public class App {
    public static void main(String[] args) {

        // make a switch statement here to take in commandline arguments ***********************************************

        HTTPRestCLIApplication cliApp = new HTTPRestCLIApplication();

        cliApp.setRestClient(new RESTClient());


        if(args[0].equalsIgnoreCase("generate")){
            cliApp.generateAircraftReport();
            cliApp.generateAirportReport();
            cliApp.generateCityReport();
            cliApp.generatePassengerReport();
        } else if (args[0].equalsIgnoreCase("aircrafts")) {
            cliApp.generateAircraftReport();
        } else if (args[0].equalsIgnoreCase("airports")) {
            cliApp.generateAirportReport();
        } else if (args[0].equalsIgnoreCase("cities")) {
            cliApp.generateCityReport();
        } else if (args[0].equalsIgnoreCase("passengers")) {
            cliApp.generatePassengerReport();
        } else if (args[0].equalsIgnoreCase("aircraftSearch")) {
            cliApp.getAircraftByIdReport(Integer.parseInt(args[1]));
        } else if (args[0].equalsIgnoreCase("airportSearch")) {
            cliApp.getAirportByIdReport(Integer.parseInt(args[1]));
        } else if (args[0].equalsIgnoreCase("citySearch")) {
            cliApp.getCityByIdReport(Integer.parseInt(args[1]));
        } else if (args[0].equalsIgnoreCase("passengerSearch")) {
            cliApp.getPassengerByIdReport(Integer.parseInt(args[1]));
        } else if (args[0].equalsIgnoreCase("airportByCity")) {
            cliApp.getAirportsByCityIdReport(Integer.parseInt(args[1]));
        } else if (args[0].equalsIgnoreCase("passengerAircraftList")) {
            cliApp.getAircraftsPassengerAttendanceReport(Integer.parseInt(args[1]));
        } else if (args[0].equalsIgnoreCase("passengerAirportList")) {
            cliApp.getAirportPassengerVisitedReport(Integer.parseInt(args[1]));
        } else if (args[0].equalsIgnoreCase("browser")) {
            cliApp.getBrowserPeekReport();
        } else if (args[0].equalsIgnoreCase("browserData")) {
            cliApp.getBrowserDataReport();
        } else if (args[0].equalsIgnoreCase("undo")){
            cliApp.getUndoBrowser();
        } else if (args[0].equalsIgnoreCase("redo")) {
            cliApp.getRedoBrowser();
        } else if (args[0].length() < 1){
            System.out.println();
            System.out.println("Error: Must add arguments to access data!");
        } else {
            System.out.println();
            System.out.println("Error: Must add valid arguments!");
        }

    }
}
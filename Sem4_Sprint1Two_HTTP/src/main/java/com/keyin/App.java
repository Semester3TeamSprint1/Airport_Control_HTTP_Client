// HTTP Client to access Main database. Issues with HTTP Client mentioned below with corresponding function.
// Data shows out of order as well, unsure how to fix.
// Darla Ward, Danielle Reid and Jarod Chambers-Genge
// Completed on: July 5, 2023

package com.keyin;

import com.keyin.http.cli.HTTPRestCLIApplication;
import com.keyin.http.client.RESTClient;

public class App {
    public static void main(String[] args) {

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
        } else if (args[0].equalsIgnoreCase("passengerAircraftList")) { // TODO: Function doesn't work. Unsure why.
            cliApp.getAircraftsPassengerAttendanceReport(Integer.parseInt(args[1]));
        } else if (args[0].equalsIgnoreCase("passengerAirportList")) { // TODO: Function doesn't work. Unsure why.
            cliApp.getAirportPassengerVisitedReport(Integer.parseInt(args[1]));
        } else if (args[0].equalsIgnoreCase("browser")) { // TODO: Response shows correct, but it's saying no requests have been made to the server?
            cliApp.getBrowserPeekReport();
        } else if (args[0].equalsIgnoreCase("browserData")) { // TODO: Response shows correct, but it's saying no requests have been made to the server?
            cliApp.getBrowserDataReport();
        } else if (args[0].equalsIgnoreCase("undo")){ // TODO: Response shows correct, but it's saying no requests have been made to the server?
            cliApp.getUndoBrowser();
        } else if (args[0].equalsIgnoreCase("redo")) { // TODO: Response shows correct, but it's saying no requests have been made to the server?
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
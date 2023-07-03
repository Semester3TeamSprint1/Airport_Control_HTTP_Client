package com.keyin.http.cli;

import com.keyin.domain.*;
import com.keyin.http.client.RESTClient;

import java.util.List;

public class HTTPRestCLIApplication {

    private RESTClient restClient;

    public RESTClient getRestClient() {
        if (restClient == null) {
            restClient = new RESTClient();
        }
        return restClient;
    }

    public void setRestClient(RESTClient restClient) {
        this.restClient = restClient;
    }

    // Aircraft methods

    public String generateAircraftReport() {
        List<Aircraft> aircraftList = getRestClient().getAllAircraft();
        StringBuilder report = new StringBuilder();

        for (int i = 0; i < aircraftList.size(); i++) {
            Aircraft aircraft = aircraftList.get(i);
            report.append(aircraft.getType())
                    .append(" - ")
                    .append(aircraft.getAirlineName());

            if (i != aircraftList.size() - 1) {
                report.append(", ");
            }
        }

        String reportString = report.toString();
        System.out.println("----------------Aircrafts----------------");
        System.out.println(reportString);
        return reportString;
    }

    public String getAircraftByIdReport(int id) {
        Aircraft aircraft = getRestClient().getAircraftById(id);
        StringBuilder report = new StringBuilder();

        if (aircraft.getType() != null) {
            report.append(aircraft.getType())
                    .append(" - ")
                    .append(aircraft.getAirlineName());

            String reportString = report.toString();
            System.out.println("Aircraft ID: " + id);
            System.out.println(reportString);
            return reportString;
        } else {
            System.out.println("There are no aircrafts linked with ID No. " + id);
            return "";
        }
    }

    /* TODO: remove if above works.
    public String generateAircraftReport() {
        List<Aircraft> aircraftList = getRestClient().getAllAircraft();
        StringBuffer report = new StringBuffer();

        for (Aircraft aircraft : aircraftList) {
            report.append(aircraft.getType());
            report.append(" - ");
            report.append(aircraft.getAirlineName());

            if (aircraftList.indexOf(aircraft) != (aircraftList.size() - 1)) {
                report.append(", ");
            }
        }
        System.out.println("All aircraft's");
        System.out.println(report.toString());
        return report.toString();
    }

    public String getAircraftByIdReport(int id) {
        Aircraft aircraft = getRestClient().getAircraftById(id);
        StringBuffer report = new StringBuffer();
        report.append(aircraft.getType());
        report.append(" - ");
        report.append(aircraft.getAirlineName());
        if (aircraft.getType() != null ) {
            System.out.println("Aircraft with id: " + id);
            System.out.println(report.toString());
        } else {
            System.out.println("There are no aircraft's with id: " + id);
        }

        return report.toString();
    }
*/
   // Airport methods
    public String generateAirportReport() {
        List<Airport> airportList = getRestClient().getAllAirport();
        StringBuilder report = new StringBuilder();

        for (int i = 0; i < airportList.size(); i++) {
            Airport airport = airportList.get(i);
            report.append(airport.getName())
                    .append(" - ")
                    .append(airport.getId());

            if (i != airportList.size() - 1) {
                report.append(", ");
            }
        }

        String reportString = report.toString();
        System.out.println("----------------Airports----------------");
        System.out.println(reportString);
        return reportString;
    }

    public String getAirportByIdReport(int id) {
        Airport airport = getRestClient().getAirportById(id);
        StringBuilder report = new StringBuilder();

        if (airport.getName() != null) {
            report.append(airport.getName())
                    .append(" - ")
                    .append(airport.getId());

            String reportString = report.toString();
            System.out.println("Airport ID: " + id);
            System.out.println(reportString);
            return reportString;
        } else {
            System.out.println("There are no airports linked with ID No. " + id);
            return "";
        }
    }

    public String getAirportsByCityIdReport(int id) {
        List<Airport> airportList = getRestClient().getAirportsByCityId(id);
        StringBuilder report = new StringBuilder();

        for (int i = 0; i < airportList.size(); i++) {
            Airport airport = airportList.get(i);
            report.append(airport.getName())
                    .append(" - ")
                    .append(airport.getId());

            if (i != airportList.size() - 1) {
                report.append(", ");
            }
        }

        String reportString = report.toString();

        if (report.length() <= 0) {
            System.out.println("There are no airports in the city linked with ID No. " + id);
        } else {
            System.out.println("All airports in the city linked with ID No. " + id);
            System.out.println(reportString);
        }

        return reportString;
    }
/* todo remove if above works.

    public String generateAirportReport() {
        List<Airport> airportList = getRestClient().getAllAirport();
        StringBuffer report = new StringBuffer();

        for (Airport airport : airportList) {
            report.append(airport.getName());
            report.append(" - ");
            report.append(airport.getId());

            if (airportList.indexOf(airport) != (airportList.size() - 1)) {
                report.append(", ");
            }
        }
        System.out.println("All airports");
        System.out.println(report.toString());
        return report.toString();
    }

    public String getAirportByIdReport(int id) {
        Airport airport = getRestClient().getAirportById(id);
        StringBuffer report = new StringBuffer();
        report.append(airport.getName());
        report.append(" - ");
        report.append(airport.getId());
        if (airport.getName() != null) {
            System.out.println("Airport with id: " + id);
            System.out.println(report.toString());
        } else {
            System.out.println("There are no airports with id: " + id);
        }

        return report.toString();
    }

    public String getAirportsByCityIdReport(int id) {
        List<Airport> airportList = getRestClient().getAirportsByCityId(id);
        StringBuffer report = new StringBuffer();

        for (Airport airport : airportList) {
            report.append(airport.getName());
            report.append(" - ");
            report.append(airport.getId());

            if (airportList.indexOf(airport) != (airportList.size() - 1)) {
                report.append(", ");
            }
        }
        if(report.length() <= 0){
            System.out.println("There are no airports in the city with id: " + id);
        } else {
            System.out.println("All airports in the city with id: " + id);
            System.out.println(report.toString());
        }
        return report.toString();
    }
 */
  // City methods
public String generateCityReport() {
    List<City> cityList = getRestClient().getAllCity();
    StringBuilder report = new StringBuilder();

    for (int i = 0; i < cityList.size(); i++) {
        City city = cityList.get(i);
        report.append(city.getName())
                .append(" - ")
                .append(city.getProvince());

        if (i != cityList.size() - 1) {
            report.append(", ");
        }
    }

    String reportString = report.toString();
    System.out.println("----------------Cities----------------");
    System.out.println(reportString);
    return reportString;
}

    public String getCityByIdReport(int id) {
        City city = getRestClient().getCityById(id);
        StringBuilder report = new StringBuilder();

        if (city.getName() != null) {
            report.append(city.getName())
                    .append(" - ")
                    .append(city.getProvince());

            String reportString = report.toString();
            System.out.println("City linked with ID No. " + id);
            System.out.println(reportString);
            return reportString;
        } else {
            System.out.println("There is no city linked with ID No. " + id);
            return "";
        }
    }
    /* todo: remove if above works

    public String generateCityReport() {
        List<City> cityList = getRestClient().getAllCity();
        StringBuffer report = new StringBuffer();

        for (City city : cityList) {
            report.append(city.getName());
            report.append(" - ");
            report.append(city.getProvince());

            if (cityList.indexOf(city) != (cityList.size() - 1)) {
                report.append(", ");
            }
        }
        System.out.println("All cities");
        System.out.println(report.toString());
        return report.toString();
    }

    public String getCityByIdReport(int id) {
        City city = getRestClient().getCityById(id);
        StringBuffer report = new StringBuffer();
        report.append(city.getName());
        report.append(" - ");
        report.append(city.getProvince());
        if (city.getName() != null){
            System.out.println("City with id: " + id);
            System.out.println(report.toString());
        } else {
            System.out.println("There is not city with id: " + id);
        }
        return report.toString();
    }
     */
   // Passenger methods

    public String generatePassengerReport() {
        List<Passenger> passengerList = getRestClient().getAllPassenger();
        StringBuilder report = new StringBuilder();

        for (int i = 0; i < passengerList.size(); i++) {
            Passenger passenger = passengerList.get(i);
            report.append(passenger.getFirstname())
                    .append(" ")
                    .append(passenger.getLastName())
                    .append(" - ")
                    .append(passenger.getPhoneNumber());

            if (i != passengerList.size() - 1) {
                report.append(", ");
            }
        }

        String reportString = report.toString();
        System.out.println("----------------Passengers----------------");
        System.out.println(reportString);
        return reportString;
    }

    public String getPassengerByIdReport(int id) {
        Passenger passenger = getRestClient().getPassengerById(id);
        StringBuilder report = new StringBuilder();

        if (passenger.getFirstname() != null) {
            report.append(passenger.getFirstname())
                    .append(" ")
                    .append(passenger.getLastName())
                    .append(" - ")
                    .append(passenger.getPhoneNumber());

            String reportString = report.toString();
            System.out.println("Passenger linked with ID No. " + id);
            System.out.println(reportString);
            return reportString;
        } else {
            System.out.println("There is no passenger linked with ID No. " + id);
            return "";
        }
    }

    public String getAircraftsPassengerAttendanceReport(int id) {
        List<Aircraft> aircraftList = getRestClient().getAircraftsPassengerAttendanceReport(id);
        StringBuilder report = new StringBuilder();

        for (int i = 0; i < aircraftList.size(); i++) {
            Aircraft aircraft = aircraftList.get(i);
            report.append(aircraft.getType())
                    .append(" - ")
                    .append(aircraft.getAirlineName());

            if (i != aircraftList.size() - 1) {
                report.append(", ");
            }
        }

        String reportString = report.toString();

        if (report.length() <= 0) {
            System.out.println("The passenger linked with ID No. " + id + " has no flight record.");
        } else {
            System.out.println("----------------Passenger ID No. " + id + " linked aircrafts----------------");
            System.out.println(reportString);
        }

        return reportString;
    }

    public String getAirportPassengerVisitedReport(int id) {
        List<Airport> airportList = getRestClient().getAirportPassengerVisited(id);
        StringBuilder report = new StringBuilder();

        for (int i = 0; i < airportList.size(); i++) {
            Airport airport = airportList.get(i);
            report.append(airport.getName())
                    .append(" - ")
                    .append(airport.getId());

            if (i != airportList.size() - 1) {
                report.append(", ");
            }
        }

        String reportString = report.toString();

        if (report.length() <= 0) {
            System.out.println("The passenger linked with ID No. " + id + " has no airport attendance.");
        } else {
            System.out.println("----------------Passenger ID No. " + id + " linked airports----------------");
            System.out.println(reportString);
        }

        return reportString;
    }
/* todo remove if above works.

    public String generatePassengerReport() {
        List<Passenger> passengerList = getRestClient().getAllPassenger();
        StringBuffer report = new StringBuffer();

        for (Passenger passenger : passengerList) {
            report.append(passenger.getFirstname() + " " + passenger.getLastName());
            report.append(" - ");
            report.append(passenger.getPhoneNumber());

            if (passengerList.indexOf(passenger) != (passengerList.size() - 1)) {
                report.append(", ");
            }
        }
        System.out.println("All passengers");
        System.out.println(report.toString());
        return report.toString();
    }

    public String getPassengerByIdReport(int id) {
        Passenger passenger = getRestClient().getPassengerById(id);
        StringBuffer report = new StringBuffer();
        report.append(passenger.getFirstname() + " " + passenger.getLastName());
        report.append(" - ");
        report.append(passenger.getPhoneNumber());

        if (passenger.getFirstname() != null){
            System.out.println("Passenger with id: " + id);
            System.out.println(report.toString());
        } else {
            System.out.println("There is no passenger with id: " + id);
        }

        return report.toString();
    }

    public String getAircraftPassengerBeenOnReport(int id) {
        List<Aircraft> aircraftList = getRestClient().getAircraftPassengerBeenOn(id);
        StringBuffer report = new StringBuffer();

        for (Aircraft aircraft : aircraftList) {
            report.append(aircraft.getType());
            report.append(" - ");
            report.append(aircraft.getAirlineName());

            if (aircraftList.indexOf(aircraft) != (aircraftList.size() - 1)) {
                report.append(", ");
            }
        }

        if(report.length() <= 0){
            System.out.println("The passenger with id: " + id + " has not been on any planes");
        } else {
            System.out.println("All aircraft's passenger with id: " + id + " has been on");
            System.out.println(report.toString());
        }

        return report.toString();
    }

    public String getAirportPassengerVisitedReport(int id) {
        List<Airport> airportList = getRestClient().getAirportPassengerVisited(id);
        StringBuffer report = new StringBuffer();

        for (Airport airport : airportList) {
            report.append(airport.getName());
            report.append(" - ");
            report.append(airport.getId());

            if (airportList.indexOf(airport) != (airportList.size() - 1)) {
                report.append(", ");
            }
        }

        if(report.length() <= 0){
            System.out.println("The passenger with id: " + id + " has not been on any airports");
        } else {
            System.out.println("All airports passenger with id: " + id + " has visited");
            System.out.println(report.toString());
        }
        return report.toString();
    }
 */

   // Actions
   public String getBrowserPeekReport() {
       Browser browser = getRestClient().getBrowserPeek();

       StringBuilder report = new StringBuilder();
       report.append(browser.getCalledMethod())
               .append(" - ")
               .append(browser.getUrl())
               .append(" - ")
               .append(browser.getTimestamp());

       if (browser.getCalledMethod() != null) {
           String reportString = report.toString();
           System.out.println("The last request made to the server:");
           System.out.println(reportString);
           return reportString;
       } else {
           System.out.println("No requests have been made to the server yet. The browser stack is empty.");
           return "";
       }
   }

    public String getBrowserDataReport() {
        List<Browser> browserList = getRestClient().getBrowserData();
        StringBuilder report = new StringBuilder();

        for (int i = 0; i < browserList.size(); i++) {
            Browser browser = browserList.get(i);
            report.append(browser.getCalledMethod())
                    .append(" - ")
                    .append(browser.getUrl())
                    .append(" - ")
                    .append(browser.getTimestamp());

            if (i != browserList.size() - 1) {
                report.append(", ");
            }
        }

        String reportString = report.toString();

        if (report.length() <= 0) {
            System.out.println("No requests have been made to the server yet. The browser stack is empty.");
        } else {
            System.out.println("All requests made to the server:");
            System.out.println(reportString);
        }

        return reportString;
    }

    public String getUndoBrowser() {
        Browser browser = getRestClient().undoBrowser();

        StringBuilder report = new StringBuilder();
        report.append(browser.getCalledMethod())
                .append(" - ")
                .append(browser.getUrl())
                .append(" - ")
                .append(browser.getTimestamp());

        if (browser.getCalledMethod() != null) {
            String reportString = report.toString();
            System.out.println("The last request made to the server:");
            System.out.println(reportString);
            return reportString;
        } else {
            System.out.println("Cannot undo any further. The browser stack is empty.");
            return "";
        }
    }

    public String getRedoBrowser() {
        Browser browser = getRestClient().redoBrowser();

        StringBuilder report = new StringBuilder();
        report.append(browser.getCalledMethod())
                .append(" - ")
                .append(browser.getUrl())
                .append(" - ")
                .append(browser.getTimestamp());

        if (browser.getCalledMethod() != null) {
            String reportString = report.toString();
            System.out.println("The last request made to the server:");
            System.out.println(reportString);
            return reportString;
        } else {
            System.out.println("Cannot redo any further. You reached the top of the browser stack.");
            return "";
        }
    }
}
/* todo: remove if top works

    public String getBrowserPeekReport() {
        Browser browser = getRestClient().getBrowserPeek();

        StringBuffer report = new StringBuffer();
        report.append(browser.getCalledMethod());
        report.append(" - ");
        report.append(browser.getUrl());
        report.append(" - ");
        report.append(browser.getTimestamp());

        if (browser.getCalledMethod() != null){
            System.out.println("The last request made to the server");
            System.out.println(report.toString());
        } else {
            System.out.println("No requests have been made to the server yet, the browser stack is empty");
        }
        return report.toString();
    }

    public String getBrowserDataReport() {
        List<Browser> browserList = getRestClient().getBrowserData();
        StringBuffer report = new StringBuffer();

        for (Browser browser : browserList) {
            report.append(browser.getCalledMethod());
            report.append(" - ");
            report.append(browser.getUrl());
            report.append(" - ");
            report.append(browser.getTimestamp());

            if (browserList.indexOf(browser) != (browserList.size() - 1)) {
                report.append(", ");
            }
        }

        if (report.length() <= 0){
            System.out.println("No requests have been made to the server yet, the browser stack is empty");
            System.out.println(report.toString());
        } else {
            System.out.println("All requests made to the server");
            System.out.println(report.toString());
        }
        return report.toString();
    }

    public String getUndoBrowser() {
        Browser browser = getRestClient().undoBrowser();

        StringBuffer report = new StringBuffer();
        report.append(browser.getCalledMethod());
        report.append(" - ");
        report.append(browser.getUrl());
        report.append(" - ");
        report.append(browser.getTimestamp());

        if (browser.getCalledMethod() != null){
            System.out.println("The last request made to the server");
            System.out.println(report.toString());
        } else {
            System.out.println("cannot undo any further the browser stack is empty");
        }
        return report.toString();
    }

    public String getRedoBrowser() {
        Browser browser = getRestClient().redoBrowser();

        StringBuffer report = new StringBuffer();
        report.append(browser.getCalledMethod());
        report.append(" - ");
        report.append(browser.getUrl());
        report.append(" - ");
        report.append(browser.getTimestamp());

        if (browser.getCalledMethod() != null){
            System.out.println("The last request made to the server");
            System.out.println(report.toString());
        } else {
            System.out.println("cannot redo any further you reached the top of the browser stack");
        }
        return report.toString();
    }

}

 */


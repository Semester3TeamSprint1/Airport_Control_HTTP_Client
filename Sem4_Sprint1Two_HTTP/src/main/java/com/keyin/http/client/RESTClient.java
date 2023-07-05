package com.keyin.http.client;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.keyin.domain.*;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class RESTClient {

        private static final String baseURL = "http://localhost:8080/";

        private HttpClient client;
        private ObjectMapper mapper;

        public RESTClient() {
            client = HttpClient.newHttpClient();
            mapper = new ObjectMapper();
            mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        }

        public List<Aircraft> getAllAircraft() {
            List<Aircraft> aircraftList = new ArrayList<>();
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(baseURL + "aircraft")).build();

            try {
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
                if (response.statusCode() == 200) {
                    System.out.println("********** " + response.body() + " **********");
                    aircraftList = mapper.readValue(response.body(), new TypeReference<List<Aircraft>>() {});
                } else {
                    System.out.println("Error: " + response.statusCode());
                }
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }

            return aircraftList;
        }

        public Aircraft getAircraftById(int id) {
            Aircraft aircraft = new Aircraft();
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(baseURL + "aircraft/" + id)).build();

            try {
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
                if (response.statusCode() == 200) {
                    System.out.println("********** " + response.body() + " **********");
                    aircraft = mapper.readValue(response.body(), new TypeReference<Aircraft>() {});
                } else {
                    System.out.println("Error: " + response.statusCode());
                }
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }

            return aircraft;
        }

        public List<Airport> getAllAirport() {
            List<Airport> airportList = new ArrayList<>();
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(baseURL + "airport")).build();

            try {
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
                if (response.statusCode() == 200) {
                    System.out.println("********** " + response.body() + " **********");
                    airportList = mapper.readValue(response.body(), new TypeReference<List<Airport>>() {});
                } else {
                    System.out.println("Error: " + response.statusCode());
                }
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }

            return airportList;
        }

        public Airport getAirportById(int id) {
            Airport airport = new Airport();
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(baseURL + "airport/" + id)).build();

            try {
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
                if (response.statusCode() == 200) {
                    System.out.println("********** " + response.body() + " **********");
                    airport = mapper.readValue(response.body(), new TypeReference<Airport>() {});
                } else {
                    System.out.println("Error: " + response.statusCode());
                }
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }

            return airport;
        }
    public List<Airport> getAirportsByCityId(int id) {
        List<Airport> airportList = new ArrayList<>();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(baseURL + "airport/getByCityId/" + id)).build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                System.out.println("********** " + response.body() + " **********");
                airportList = mapper.readValue(response.body(), new TypeReference<List<Airport>>() {});
            } else {
                System.out.println("Error: " + response.statusCode());
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        return airportList;
    }

    public List<City> getAllCity() {
        List<City> cityList = new ArrayList<>();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(baseURL + "city")).build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                System.out.println("********** " + response.body() + " **********");
                cityList = mapper.readValue(response.body(), new TypeReference<List<City>>() {});
            } else {
                System.out.println("Error: " + response.statusCode());
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        return cityList;
    }

    public City getCityById(int id) {
        City city = new City();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(baseURL + "city/" + id)).build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                System.out.println("********** " + response.body() + " **********");
                city = mapper.readValue(response.body(), new TypeReference<City>() {});
            } else {
                System.out.println("Error: " + response.statusCode());
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return city;
    }

    public List<Passenger> getAllPassenger() {
        List<Passenger> passengerList = new ArrayList<>();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(baseURL + "passenger")).build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                System.out.println("********** " + response.body() + " **********");
                passengerList = mapper.readValue(response.body(), new TypeReference<List<Passenger>>() {});
            } else {
                System.out.println("Error: " + response.statusCode());
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        return passengerList;
    }

    public Passenger getPassengerById(int id) {
        Passenger passenger = new Passenger();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(baseURL + "passenger/" + id)).build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                System.out.println("********** " + response.body() + " **********");
                passenger = mapper.readValue(response.body(), new TypeReference<Passenger>() {});
            } else {
                System.out.println("Error: " + response.statusCode());
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return passenger;
    }

    public List<Aircraft> getAircraftsPassengerAttendanceReport(int id) {
        List<Aircraft> aircraftList = new ArrayList<>();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(baseURL + "passenger/" + id + "/getAircraft")).build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                System.out.println("********** " + response.body() + " **********");
                aircraftList = mapper.readValue(response.body(), new TypeReference<List<Aircraft>>() {});
            } else {
                System.out.println("Error: " + response.statusCode());
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        return aircraftList;
    }

    public List<Airport> getAirportPassengerVisited(int id) {
        List<Airport> airportList = new ArrayList<>();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(baseURL + "passenger/" + id + "/getAirport")).build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                System.out.println("********** " + response.body() + " **********");
                airportList = mapper.readValue(response.body(), new TypeReference<List<Airport>>() {});
            } else {
                System.out.println("Error: " + response.statusCode());
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        return airportList;
    }

    public Browser getBrowserPeek() {
        Browser browser = new Browser();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(baseURL + "browser")).build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                System.out.println("********** " + response.body() + " **********");
                browser = mapper.readValue(response.body(), new TypeReference<Browser>() {});
            } else {
                System.out.println("Error: " + response.statusCode());
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return browser;
    }

    public List<Browser> getBrowserData() {
        List<Browser> browserList = new ArrayList<>();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(baseURL + "allBrowserData")).build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                System.out.println("********** " + response.body() + " **********");
                browserList = mapper.readValue(response.body(), new TypeReference<List<Browser>>() {});
            } else {
                System.out.println("Error: " + response.statusCode());
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        return browserList;
    }

    public Browser undoBrowser() {
        Browser browser = new Browser();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(baseURL + "undoBrowser")).build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                System.out.println("********** " + response.body() + " **********");
                browser = mapper.readValue(response.body(), new TypeReference<Browser>() {});
            } else {
                System.out.println("Error: " + response.statusCode());
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return browser;
    }

    public Browser redoBrowser() {
        Browser browser = new Browser();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(baseURL + "redoBrowser")).build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                System.out.println("********** " + response.body() + " **********");
                browser = mapper.readValue(response.body(), new TypeReference<Browser>() {});
            } else {
                System.out.println("Error: " + response.statusCode());
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return browser;
    }
}
package com.covidtracker.tracerapp.Service;


import com.covidtracker.tracerapp.models.LocationDataSet;
import jakarta.annotation.PostConstruct;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

@Service
public class Data {

    //
    //allstats
    List <LocationDataSet> allStats = new ArrayList<>();

    public List<LocationDataSet> getAllStats() {
        return allStats;
    }

    @PostConstruct
    @Scheduled (cron = "0 0 0 1 * *")
    public void fetchVirusData() throws IOException, InterruptedException {
        List <LocationDataSet> newStat = new ArrayList<>();
        HttpClient client = HttpClient.newHttpClient();
//    request -> get new url
//    response = >  send(request, body handler)
//sent - > request -> bodyhandler
        String URL = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_confirmed_global.csv";
        HttpRequest request = HttpRequest.newBuilder(URI.create(URL)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());


        StringReader reader = new StringReader(response.body());


        Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(reader);
        for (CSVRecord record : records) {

            int latestCases = Integer.parseInt(record.get(record.size()-1));
            int prevDayCases = Integer.parseInt(record.get(record.size()-2));
//            String customerNo = record.get("Country/Region");
            LocationDataSet locDat = new LocationDataSet();
            locDat.setCountry(record.get("Country/Region"));
            locDat.setState(record.get("Province/State"));
            locDat.setTotalCases(latestCases);
            locDat.setDiffFromYesterday(latestCases - prevDayCases);
            System.out.println(locDat);
            newStat.add(locDat);


        }
        this.allStats = newStat;

    }
}
//    HttpRequest


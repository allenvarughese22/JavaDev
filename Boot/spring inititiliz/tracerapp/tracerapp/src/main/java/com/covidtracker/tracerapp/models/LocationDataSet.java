package com.covidtracker.tracerapp.models;

public class LocationDataSet {

    private String state;
    private  int totalCases;
    private  int diffFromYesterday;

    public int getDiffFromYesterday() {
        return diffFromYesterday;
    }

    public void setDiffFromYesterday(int diffFromYesterday) {
        this.diffFromYesterday = diffFromYesterday;
    }

    @Override
    public String toString() {
        return "LocationDataSet{" +
                "state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", totalCases=" + totalCases +
                '}';
    }

    private String country;


    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getTotalCases() {
        return totalCases;
    }

    public void setTotalCases(int totalCases) {
        this.totalCases = totalCases;
    }


}

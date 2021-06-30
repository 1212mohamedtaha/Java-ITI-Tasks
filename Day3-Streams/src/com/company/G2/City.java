package com.company.G2;

public class City {
    private int cityID;
    private String city;
    private String countryID;
    private boolean isCapital;
    private int population;
    private String hh;

    public String getHh() {
        return hh;
    }

    public City(int cityID, String city, String countryID, boolean isCapital, int population, String hh) {

        this.cityID = cityID;
        this.city = city;
        this.countryID = countryID;
        this.isCapital = isCapital;
        this.population = population;
        this.hh = hh;

    }

    public int getCityID() {
        return cityID;
    }

    public void setCityID(int cityID) {
        this.cityID = cityID;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountryID() {
        return countryID;
    }

    public void setCountryID(String countryID) {
        this.countryID = countryID;
    }

    public boolean isCapital() {

        return isCapital;
    }

    public void setCapital(boolean capital) {
        isCapital = capital;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    /**@Override
    public String toString() {
        return "City{" +
                "cityID=" + cityID +
                ", city='" + city + '\'' +
                ", countryID='" + countryID + '\'' +
                ", isCapital=" + isCapital +
                ", population=" + population +
                '}';
    }**/
    @Override
    public String toString() {
        return    city  +" :"+ population ;
    }
}

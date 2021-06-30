package com.company.G2;

public class Country {
    public Country(String countryCode,String country) {
        this.country = country;
        this.countryCode = countryCode;
    }

    private String country;
    private String countryCode;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    @Override
    public String toString() {
        return  countryCode + ": "
                ;
    }
}

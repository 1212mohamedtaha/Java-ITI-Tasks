package com.company.G2;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class CSVDAO {
    List<City>  citiesList = new ArrayList<>();
    List<Country> countriesList = new ArrayList<>();
    public CSVDAO() {
    }


    public List<City> readCityCSV(String path){
        File cityFile = new File(path);
        List<String> lines = new ArrayList<>();
        try {
            lines = Files.readAllLines(cityFile.toPath());
        } catch (IOException e) {
            System.out.println("Error while opening the City File");
        }

        for (int Line =1; Line < lines.size(); Line ++){   // Reading Line by Line
            String line = lines.get(Line);

            String[] fields = line.split(",");

            for (int field = 0; field< fields.length; field ++){  //Reading field by field
                fields[field] = fields[field].trim();
            }
            try{
                boolean isCapital=false;
                int pop = Integer.parseInt(fields[4]);
                int cID = Integer.parseInt(fields[0]);

                if (fields[3].equals("primary") ){
                    isCapital = true; }
                String cityStr = fields[1];
                String countryIDStr = fields[2];

                City city = new City(cID,cityStr,countryIDStr,isCapital,pop,fields[3]);
                this.citiesList.add(city);}
            catch(Exception e) {
                int pop = 0;
                boolean isCapital= false;
                int cID = Integer.parseInt(fields[0]);
                if (fields[3].equals("primary")) {
                    isCapital = true; }

                String cityStr = fields[1];
                String countryIDStr = fields[2];
                City city = new City(cID,cityStr,countryIDStr,isCapital,pop,fields[3]);

            }
        }
        return citiesList;
    }


    public List<Country> readCountryCSV(String path){
        File countryFile = new File(path);
        List<String> lines = new ArrayList<>();
        try {
            lines = Files.readAllLines(countryFile.toPath());
        } catch (IOException e) {
            System.out.println("Error while opening the Country File");
        }

        for (int Line =1; Line < lines.size(); Line ++){   // Reading Line by Line
            String line = lines.get(Line);

            String[] fields = line.split(",");

            for (int field = 0; field< fields.length; field ++){  //Reading field by field
                fields[field] = fields[field].trim();
            }

                String countryStr = fields[0];

                String codeStr = fields[1];

                Country country = new Country(codeStr,countryStr);
                countriesList.add(country);}
        Set<String> deDupCountryCode = new LinkedHashSet<>();
        Set<String> deDupCountryName = new LinkedHashSet<>();

        for (Country co :countriesList){
            deDupCountryCode.add(co.getCountryCode());
            deDupCountryName.add(co.getCountry());}
        countriesList.clear();
        List<String> deDupCountryCodeList = new ArrayList<>();
        List<String> deDupCountryNameList = new ArrayList<>();
        deDupCountryCodeList.addAll(deDupCountryCode);
        deDupCountryNameList.addAll(deDupCountryName);
        List<Country> reducedCountriesList = new ArrayList<>();
        for (int i = 0; i< deDupCountryCode.size(); i++ ){
            Country country = new Country(deDupCountryCodeList.get(i),deDupCountryNameList.get(i));
            reducedCountriesList.add(country);
            ;}

        return reducedCountriesList;
    }
}

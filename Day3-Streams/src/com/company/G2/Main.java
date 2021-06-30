package com.company.G2;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
/** Lab Exercise 1 **/
    public static void main(String[] args) {
        String cityPath = "src/resources/cities.csv"; // This is the path
        String countryPath = "src/resources/countries.csv"; // This is the path 

        CSVDAO cityDAO = new CSVDAO();
        CSVDAO countryDAO = new CSVDAO();

        List<City> cities = cityDAO.readCityCSV(cityPath);
        List<Country> countries = countryDAO.readCountryCSV(countryPath);

// Creating The Map
    Map<String,List<City>> merged = new HashMap<>();
    for (Country cou: countries ){
        //i++; if(i>2){break;}
        List<City> citiesInCountry = new ArrayList<>();
        for (City cit : cities){

          if (cit.getCountryID().equals(cou.getCountryCode())) {
              citiesInCountry.add(cit);

            }
        }
        merged.put(cou.getCountryCode(),citiesInCountry);
    }
        //System.out.println(merged);

        merged.forEach((k,v)->v.stream()
                .map(c -> c.getPopulation()).sorted().collect(Collectors.toList()));
       //System.out.println(merged1);
        merged.forEach((k,v)->v.stream()
            .map(City::getPopulation)
            .sorted()
            .collect(Collectors.toList()));

        System.out.println("Reading files and sorting cities according to the population" );
        System.out.println(merged);

        System.out.println("Press Enter for exercise 2" );
/** Lab Exercise 2 **/

        try { System.in.read(); } catch (IOException e) { e.printStackTrace(); }
        String Longer = CompareStrings.betterString("string1","string22",(s1,s2)->s1.length()>s2.length());
        System.out.println("The better string using BiPredicate" );
        System.out.println(Longer);

    boolean isLetter = CompareStrings.isLetter("Stop",s0-> {
        for (int i = 0; i < s0.length(); i++)
        {
            if (!Character.isLetter(s0.charAt(i)))
            { return false; }
        }return true;
    } );
        System.out.println("The Result of testing the string" );
        System.out.println(isLetter);

        System.out.println("Press Enter for exercise 3" );
/** Lab Exercise 3 **/
        ///////////////////////////////////////////////
        try { System.in.read(); } catch (IOException e) { e.printStackTrace(); }

        List<Optional<City>> collect =
                merged.values().stream().map(x -> x.stream()
                .max(Comparator.comparing(City::getPopulation))).collect(Collectors.toList());
        System.out.println("Highest population city for each country:" );
        System.out.println(collect);
        ///////////////////////////////////////////////

//Highest population city of each country

        ///////////////////////////////////////////////////
        List<City> capitals = new ArrayList<>();
        for (List<City> cityList:merged.values()){
            try {
                capitals.add(cityList.stream().filter(c-> c.isCapital()).findFirst().get());

            }catch (NoSuchElementException e){}
        }
        Optional<City> highestPopulationCapital = capitals.stream().max(Comparator.comparing(City::getPopulation));
        System.out.println("The highest population Capital is ");
        System.out.println(highestPopulationCapital);


        System.out.println("Press Enter for exercise 4" );

        ////////////////////////////////////////////////////
        try { System.in.read(); } catch (IOException e) { e.printStackTrace(); }

        double median, lowerQuartile, upperQuartile,average;

        List<Integer> sortedCity = cities.stream().map(City::getPopulation).sorted().collect(Collectors.toList());

        if (sortedCity.size() % 2 == 0) {
            median = (sortedCity.get((sortedCity.size()/2)) + sortedCity.get((sortedCity.size())/2 + 1))  /2;
            lowerQuartile = (sortedCity.get(sortedCity.size()/4) + sortedCity.get((sortedCity.size())/4+ 1))  /2;
            upperQuartile = (sortedCity.get(sortedCity.size()*3/4) + sortedCity.get((sortedCity.size()*3/4)+1))  /2;
        }
        else {
            median =  sortedCity.get(sortedCity.size()/2);
            lowerQuartile =  sortedCity.get(sortedCity.size())/4;
            upperQuartile =  sortedCity.get(sortedCity.size())*.75;
        }

        System.out.println("median population = "+ median  );
        System.out.println( "lowerQuartile = "+lowerQuartile );
        System.out.println("upperQuartile = " + upperQuartile );
    }

}
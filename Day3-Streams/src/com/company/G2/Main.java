package com.company.G2;

import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
/** Lab Exercise 1 **/
    public static void main(String[] args) {
        String cityPath = "C:\\Users\\Mohamed Taha\\Desktop\\Java\\Java and UML_Amr Elshafey\\Day 3\\citi.csv"; // This is the path ?
        String countryPath = "C:\\Users\\Mohamed Taha\\Desktop\\Java\\Java and UML_Amr Elshafey\\Day 3\\countri.csv"; // This is the path ?

        CSVDAO cityDAO = new CSVDAO();
        CSVDAO countryDAO = new CSVDAO();

        List<City> cities = cityDAO.readCityCSV(cityPath);
        List<Country> countries = countryDAO.readCountryCSV(countryPath);

//int i = 0;
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
       //Map<String,List<City>> merged1 = cities.stream().collect(Collectors.groupingBy(City::getCountryID));
        Map<String,List<City>> merged2 = cities.stream().collect(Collectors.groupingBy(City::getCountryID));

        //merged.forEach((k,v)->v.stream().map(c -> c.getPopulation()).sorted().collect(Collectors.toList()));
       //System.out.println(merged1);
        /**merged.forEach((k,v)->v.stream()
            .map(City::getPopulation)
            .sorted()
            .collect(Collectors.toList()));
        System.out.println(merged);**/

/** Lab Exercise 2 **/


    /**String Longer = CompareStrings.betterString("string1","string22",(s1,s2)->s1.length()>s2.length());
        System.out.println(Longer);

    boolean isLetter = CompareStrings.isLetter("Stop",s0-> {
        for (int i = 0; i < s0.length(); i++)
        {
            if (!Character.isLetter(s0.charAt(i)))
            { return false; }
        }return true;
    } );
        System.out.println(isLetter);**/
/** Lab Exercise 3 **/
        ///////////////////////////////////////////////

        /**List<Optional<City>> collect =
                merged.values().stream().map(x -> x.stream()
                .max(Comparator.comparing(City::getPopulation))).collect(Collectors.toList());
        System.out.println(collect);**/
        ///////////////////////////////////////////////

        /**List<Optional<Integer>> highestPopulationPerCounty = merged.values()
                .stream().map(x-> x.stream()
                        .map(City::getPopulation)
                        .max(Double::compare)
        ).collect(Collectors.toList());
        System.out.println(highestPopulationPerCounty);**/
//Highest population city of each country
        /**merged.forEach((k,v)-> System.out.println(v.stream()
                .max(Comparator.comparingInt(City::getPopulation))));**/
        ///////////////////////////////////////////////////
        /**Integer highestPopulationCapital = merged.values()
                .stream()
                .mapToInt(City::getPopulation)
                .max()
                .getAsInt();**/


        ////////////////////////////////////////////////////
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

        System.out.println(median  );
        System.out.println( lowerQuartile );
        System.out.println(upperQuartile );
        System.out.println(5/2);
    }

}
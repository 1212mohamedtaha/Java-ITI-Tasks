package org.example;

import org.knowm.xchart.*;
import java.awt.*;
import java.util.*;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.knowm.xchart.style.Styler;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Hello world!
 *
 */
public class XChartExample
{
    public static void main( String[] args ) {
        /**First we create the XChart object **/
// Read.

        Path pathInput = Paths.get( "src/main/resources/data/titanic.csv" );
        List < Passenger > list = XChartExample.getPassengersFromCSV( pathInput );
        //System.out.println(list);
        XChartExample xChartExample = new XChartExample();
        xChartExample.graphPassengerAges (list); /** A Histogram of distribution of ages. Data records That missed age were filtered **/
        xChartExample.graphPieGender(list); /** Pie chart showing ratio between males and females on the ship*/
        xChartExample.graphPieSurvived(list); /** Pie chart showing  ratio between no. of passengers who survived on the ship*/



    }


/** Using Apache-commons to read CSV**/
    /** This Method will read the csv file anr return an arrylist of passenger objects*/
    public static List<Passenger> getPassengersFromCSV(Path path) {
        //List<Passenger> allPassengers = new ArrayList<Passenger>();
        List<Passenger> allPassengers = List.of(); /** Creating the ArrayList ? */
        try {

            int initialCapacity = (int) Files.lines(path).count(); /** Counting the number of lines in the file */

            allPassengers = new ArrayList<>(initialCapacity);           /** Creating the ArrayList  */
            // Read CSV file. For each row, instantiate and collect `DailyProduct`.
            BufferedReader reader = Files.newBufferedReader(path);             /** Creating a BufferReader object to raed the csv*/
            Iterable<CSVRecord> records = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(reader);   /** Iterating the BufferReader to records*/
            for (CSVRecord record : records)              /** For each record*/ {
                int pClass = Integer.parseInt(record.get("pclass"));
                int survived = Integer.parseInt(record.get("survived"));
                String name = record.get("name");
                int sex;
                if (record.get("sex").equals("male")) {
                    sex = 0;
                } else {
                    sex = 1;
                }

                float age;
                if (!record.get("age").equals("")) { // 263 missing
                    age = Float.parseFloat(record.get("age"));
                } else {
                    age = 0;
                }
                int sibsp = Integer.parseInt(record.get("sibsp"));
                int parch = Integer.parseInt(record.get("parch"));
                String ticket = record.get("ticket");
                float fare;
                if (!record.get("fare").equals("")) { // 263 missing
                    fare = Float.parseFloat(record.get("fare"));
                } else {
                    fare = 0;
                }
                String cabin = record.get("cabin");
                String embarked = record.get("embarked");
                String boat = record.get("boat");
                String body = record.get("body");
                String home_dest = record.get("home_dest");
                // Instantiate `Person` object, and collect it.
                Passenger passenger = new Passenger(pClass, survived, name, sex, age, sibsp, parch, ticket, fare, cabin, embarked, boat, body, home_dest);
                allPassengers.add(passenger);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return allPassengers;
    }
/** A histogram to represent age**/
        public  void graphPassengerAges(List<Passenger> passengerList) {
            List<Float> survivedByAge = passengerList.stream().filter((c)-> c.getSurvived() == 1 )
                    .map(Passenger::getAge)
                    .filter(age -> age > 0).collect(Collectors.toList());
            List<Float> pAges = passengerList.stream().map(Passenger::getAge).filter(age -> age > 0)
                    .collect(Collectors.toList());




            /** Creating & Styling**/
            CategoryChart chart = new CategoryChartBuilder().width (1024).height (768)
                    .title ("Age Histogram").yAxisTitle ("Number of passengers")
                    .xAxisTitle("Age").build ();
            chart.getStyler ().setLegendPosition (Styler.LegendPosition.InsideNE);
            chart.getStyler ().setHasAnnotations (true);
            chart.getStyler ().setStacked (true);

            Histogram histogram = new Histogram(pAges,20 , 0 , 100);
            Histogram histogram2 = new Histogram(survivedByAge,20 , 0 , 100);

            chart.addSeries("Age Histogram" ,histogram.getxAxisData(),histogram.getyAxisData());
            chart.addSeries("Survived " ,histogram2.getxAxisData(),histogram.getyAxisData());


            new SwingWrapper<>(chart).displayChart ();
        }

    public  void graphPieGender(List<Passenger> passengerList) {
       Map<Integer,Long> all = passengerList.stream()
               .collect(Collectors.groupingBy(Passenger::getSex,Collectors.counting()));
        // Create Chart

        PieChart chart = new PieChartBuilder().width(800).height(600).title(getClass().getSimpleName()).build();

        // Customize Chart
        Color[] sliceColors = new Color[] { new Color(100, 0, 200), new Color(0, 200, 150) };
        chart.getStyler().setSeriesColors(sliceColors);

        chart.addSeries("Male",all.get(0));
        chart.addSeries("Female",all.get(1));

        new SwingWrapper<>(chart).displayChart();
    }

    public  void graphPieSurvived(List<Passenger> passengerList) {
        Map<Integer,Long> result = passengerList.stream()
                .collect(Collectors.groupingBy(Passenger::getSurvived,Collectors.counting()));
        // Create Chart
        PieChart chart = new PieChartBuilder().width(800).height(600).title(getClass().getSimpleName()).build();

        // Customize Chart
        Color[] sliceColors = new Color[] { new Color(200, 0, 50), new Color(0, 200, 50) };
        chart.getStyler().setSeriesColors(sliceColors);
        chart.addSeries("Didn't survive",result.get(0));
        chart.addSeries("Survived",result.get(1));

        new SwingWrapper<>(chart).displayChart();
    }

}

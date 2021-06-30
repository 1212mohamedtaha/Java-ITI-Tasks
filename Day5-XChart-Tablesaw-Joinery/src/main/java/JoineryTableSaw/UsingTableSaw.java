package JoineryTableSaw;

import tech.tablesaw.api.*;
import tech.tablesaw.joining.DataFrameJoiner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Collectors;


public class UsingTableSaw {

    public static void main(String[] args) throws IOException {
        Table table1 = Table.read().csv("src/main/resources/data/titanic.csv");
        table1 = UsingTableSaw.removeDuplicates(table1);

            Table structure = table1.structure();
            System.out.println("Table 1 Summary: "+table1.summary());

            System.out.println(structure);
            System.out.println("Shape is: "+ table1.shape());

            /** join merge add **/

            /** Creating a table from the existing table **/
            Table table2 = table1.select("name", "sex", "age", "ticket", "fare");
            System.out.println("Shape is: " + table2.shape());
            /** Adding columns to the new table **/
            StringColumn home_dest = (StringColumn) table1.column("home_dest");
            table2.insertColumn(0, home_dest);

            IntColumn pclass = (IntColumn) table1.column("pclass");
            table2.insertColumn(1, pclass);

            IntColumn survived = (IntColumn) table1.column("survived");
            table2.insertColumn(2, survived);
            /** Removing a column **/
            table2.removeColumns("home_dest");
            System.out.println(table2.structure());
            /** Creating a new table table3 and joining
             table2 with table 3 in table 4**/
            Table table3 = table1.select("cabin", "home_dest", "name");


            Table table4 = table2.joinOn("name").fullOuter(table3);
            table4 = UsingTableSaw.removeDuplicates(table4);


                System.out.println("Table 2 Summary: "+table2.summary());
                System.out.println("Table 4 Summary: "+table4.summary());
                table4.write().csv("src/main/resources/data/titanicResult.csv");






        }





    public  static Table removeDuplicates(Table table1){
        ArrayList<String> noDub = new ArrayList<>();
        int l = 0;

        for (Row row : table1) {

            String n = row.getString("name");
            if (noDub.contains(n)) {
                System.out.println("Duplicate name in row " + l + " " + n);
                table1 = table1.dropRows(l);
            }
            noDub.add(n);
            l = l + 1;
        }
        return table1;
    }
}


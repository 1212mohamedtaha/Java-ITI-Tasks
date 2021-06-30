package JoineryTableSaw;

import joinery.DataFrame;

import java.io.IOException;

public class UsingJoinery {
    public static void main(String[] args) throws IOException {

            /** Loading the CSV file**/
            DataFrame<Object> df1= DataFrame.readCsv ("src/main/resources/data/titanic.csv");

            System.out.println(df1.describe());
        System.out.println("DataFrame 1: "+"\n"+ df1.head(5));


        /** join merge add **/

            DataFrame<Object> df2 = df1.retain("name", "sex", "age", "ticket", "fare");
            DataFrame<Object> df3 = df1.retain("cabin", "home_dest", "name");

            DataFrame<Object> df4 = df2.join(df3);
        System.out.println("DataFrame 4: "+"\n"+ df4.head(5));


    }



}

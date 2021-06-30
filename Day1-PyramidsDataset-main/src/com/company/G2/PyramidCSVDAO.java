package com.company.G2;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class PyramidCSVDAO {
    List<Pyramid>  pyramidInfo  ;  // initializing the list

    String Path ;     // This is the path ?



    public PyramidCSVDAO(String fileName)  {   // Constructor that an object will take a string carrying the file path
        this.Path = fileName;
        this.pyramidInfo = new ArrayList<Pyramid>();

    }

    public List<Pyramid> readPyramidFromCSV(){    // The Method that will read and return a list of pyrmids
        File pyramidFile = new File(Path);     // Creating a file object
        List<String> lines = null;  // initializing the list of strings that will carry the lines


        try {
            lines = Files.readAllLines(pyramidFile.toPath());  // Trying to read the file and store it at lines ,, I don't know what toPath() does.
        } catch (Exception e){
            System.out.println("error during reading the file");}

        for (int L =1; L < lines.size(); L ++){   // Reading Line by Line
            String line = lines.get(L);

            String[] fields = line.split(",");

            for (int field = 0; field< fields.length; field ++){  //Reading field by field
                fields[field] = fields[field].trim();
            }
            try{
            double x = Double.parseDouble(fields[7]);
                Pyramid pyramid = new Pyramid(fields[2],fields[0],fields[4],x);
                this.pyramidInfo.add(pyramid);}
            catch(Exception e) {
                double x = 0;
                Pyramid pyramid = new Pyramid(fields[2],fields[0],fields[4],x);
                this.pyramidInfo.add(pyramid);
            }

        }
        return pyramidInfo;
        }

}

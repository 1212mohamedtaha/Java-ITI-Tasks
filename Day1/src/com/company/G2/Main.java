package com.company.G2;

import java.awt.*;
import java.io.File;
import java.util.List;

public class Main {
    static String Path = "C:\\Users\\Mohamed Taha\\Desktop\\Java\\Java and UML_Amr Elshafey\\pyramids.csv"; // This is the path ?

    public static void main(String[] args) {
        PyramidCSVDAO pDAO = new PyramidCSVDAO(Path);

        List<Pyramid> pyramids = pDAO.readPyramidFromCSV();

        int i = 0;
        for(Pyramid p:pyramids) {
            System.out.println("#" + i++ +". " +  p );
        }



        /**File file = new File("C:\\Users\\Mohamed Taha\\Desktop\\Java\\Java and UML_Amr Elshafey\\");
        System.out.println("This is the Start:");
        String[] fileList = file.list();
        for (String name:fileList){
            System.out.println(name);
        }
        System.out.println("This is the End:");**/
    }
}

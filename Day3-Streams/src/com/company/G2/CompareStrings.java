package com.company.G2;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class CompareStrings {


    static String  betterString
            (String s1, String s2, BiPredicate<String,String> biPredicate){

        if (biPredicate.test(s1,s2)){return  s1;}
        else {return  s2;}
    }
    static  boolean isLetter(String s , Predicate<String> predicate){

        if (predicate.test(s) ){return  true;}
        else {return false;}
    }
}

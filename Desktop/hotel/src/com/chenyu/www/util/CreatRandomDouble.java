package com.chenyu.www.util;


import java.util.Random;

public class CreatRandomDouble {
    public static double randomDouble(double min, double max){
        return min+((max-min)*new Random().nextDouble());
    }
}

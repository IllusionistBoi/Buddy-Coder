package com.rd;

public class Main {

    public static void main(String[] args) {

        double outputFunction1 = calcFeetAndInchesToCentimeters(7, (float) 10);
        System.out.println(outputFunction1);

        double outputFunction2 = calcFeetAndInchesToCentimeters(157);
        System.out.println(outputFunction2);

    }

    public static double calcFeetAndInchesToCentimeters (float feet, float inches) {
        if(feet <= 0 || inches <=0 || inches >=12)
            return -1;
        else {
            // Calculate convert feet and inches into cm
            // 1 inch = 2.54 cm
            // 1 feet = 30.49 cm

            double ConvertedCm = (feet * 30.48 + inches * 2.54);
            return ConvertedCm;
        }
    }

    public static double calcFeetAndInchesToCentimeters(float inches) {
        if( inches <= 0)
            return -1;
        else {

            double ConvertedFeet = (double) (inches/12);
            return ConvertedFeet;
        }
    }
}

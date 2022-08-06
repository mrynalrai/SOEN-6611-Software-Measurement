package com.mrynalrai;

import java.io.IOException;

public class Assignment {
    public static void main(String args[]) {
        double lat1 = 53.32055556;
        double lon1 = -1.729722222;
        double lat2 = 53.31861111;
        double lon2 = -1.699722222;
        System.out.println(distance(lat1, lat2,
                lon1, lon2) + " K.M");
    }

    public static double distance(double lat1,
                                  double lat2, double lon1,
                                  double lon2)
    {
        try {
            if (!isValid(lat1, "latitude") || !isValid(lon1, "longitude") || !isValid(lat2, "latitude") || !isValid(lon2, "longitude")) {
                throw  new Exception("Invalid Coordinate");
            }
        } catch (Exception msg) {
            System.out.println(msg);
            System.exit(1);
        }

        // The math module contains a function
        // named toRadians which converts from
        // degrees to radians.
        lon1 = Math.toRadians(lon1);
        lon2 = Math.toRadians(lon2);
        lat1 = Math.toRadians(lat1);
        lat2 = Math.toRadians(lat2);

        // Haversine formula
        double dlon = lon2 - lon1;
        double dlat = lat2 - lat1;
        double a = Math.pow(Math.sin(dlat / 2), 2)
                + Math.cos(lat1) * Math.cos(lat2)
                * Math.pow(Math.sin(dlon / 2),2);

        double c = 2 * Math.asin(Math.sqrt(a));

        // Radius of earth in kilometers. Use 3956
        // for miles
        double r = 6371;

        // calculate the result
        return(c * r);
    }

    public static boolean isValid (double coordinate, String type) {
        if (type == "latitude") {
            if (coordinate >= -90 && coordinate <= 90) {
                return true;
            } else {
                return false;
            }
        } else if (type == "longitude") {
            if (coordinate >= -180 && coordinate <= 180) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
}

package com.movil.boliviaXplore.services.filter.distance;

public class HaversineDistance implements Distance{
    
    private static final double EARTH_RADIUS = 6371.0; // Radio de la Tierra en kilómetros
    
    @Override
    public double calculateDistance(double long1, double lat1, double long2, double lat2){
        double lat1Rad = Math.toRadians(lat1);
        double lon1Rad = Math.toRadians(long1);
        double lat2Rad = Math.toRadians(lat2);
        double lon2Rad = Math.toRadians(long2);

        double deltaLat = lat2Rad - lat1Rad;
        double deltaLon = lon2Rad - lon1Rad;

        double angularDistance = Math.sin(deltaLat / 2) * Math.sin(deltaLat / 2) +
                   Math.cos(lat1Rad) * Math.cos(lat2Rad) *
                   Math.sin(deltaLon / 2) * Math.sin(deltaLon / 2);
        double centralDiscante = 2 * Math.atan2(Math.sqrt(angularDistance), Math.sqrt(1 - angularDistance));

        double distance = EARTH_RADIUS * centralDiscante;
        return distance;
    }
}

import java.util.HashMap;
import java.util.Map;

public class HotelLocator {
    // Koordinat hotel
    private static final double HOTEL_LATITUDE = -6.2088;
    private static final double HOTEL_LONGITUDE = 106.8456;

    // Daftar lokasi lainnya beserta koordinatnya
    private static final Map<String, Coordinate> LOCATIONS = new HashMap<>();

    static {
        LOCATIONS.put("Lokasi A", new Coordinate(-6.2075, 106.8449));
        LOCATIONS.put("Lokasi B", new Coordinate(-6.2092, 106.8459));
        LOCATIONS.put("Lokasi C", new Coordinate(-6.2100, 106.8465));
        // Tambahkan lokasi lain jika diperlukan
    }

    public static void main(String[] args) {
        // Menemukan lokasi terdekat
        String nearestLocation = findNearestLocation();
        System.out.println("Lokasi terdekat dari hotel: " + nearestLocation);
    }

    private static String findNearestLocation() {
        String nearestLocation = null;
        double minDistance = Double.MAX_VALUE;

        for (Map.Entry<String, Coordinate> entry : LOCATIONS.entrySet()) {
            String locationName = entry.getKey();
            Coordinate coordinate = entry.getValue();

            double distance = calculateDistance(HOTEL_LATITUDE, HOTEL_LONGITUDE, coordinate.latitude, coordinate.longitude);

            if (distance < minDistance) {
                minDistance = distance;
                nearestLocation = locationName;
            }
        }

        return nearestLocation;
    }

    private static double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        // Formula Haversine
        double earthRadius = 6371; // Radius bumi dalam kilometer
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
                        Math.sin(dLon / 2) * Math.sin(dLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return earthRadius * c;
    }

    private static class Coordinate {
        double latitude;
        double longitude;

        Coordinate(double latitude, double longitude) {
            this.latitude = latitude;
            this.longitude = longitude;
        }
    }
}

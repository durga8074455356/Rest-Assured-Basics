package advanced;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;

public class CreateDateFieldsUsingPOJO {

    static class PlaceRequestBody {

        private Location location;
        private int accuracy;
        private String name;
        private String phone_number;
        private String address;
        private String[] types;
        private String website;
        private String language;

        // Getters and setters

        public Location getLocation() {
            return location;
        }

        public void setLocation(Location location) {
            this.location = location;
        }

        public int getAccuracy() {
            return accuracy;
        }

        public void setAccuracy(int accuracy) {
            this.accuracy = accuracy;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPhone_number() {
            return phone_number;
        }

        public void setPhone_number(String phone_number) {
            this.phone_number = phone_number;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String[] getTypes() {
            return types;
        }

        public void setTypes(String[] types) {
            this.types = types;
        }

        public String getWebsite() {
            return website;
        }

        public void setWebsite(String website) {
            this.website = website;
        }

        public String getLanguage() {
            return language;
        }

        public void setLanguage(String language) {
            this.language = language;
        }

        static class Location {
            private double lat;
            private double lng;

            // Getters and setters

            public double getLat() {
                return lat;
            }

            public void setLat(double lat) {
                this.lat = lat;
            }

            public double getLng() {
                return lng;
            }

            public void setLng(double lng) {
                this.lng = lng;
            }
        }

        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
        private LocalDate dateField;

        public LocalDate getDateField() {
            return dateField;
        }

        public void setDateField(LocalDate dateField) {
            this.dateField = dateField;
        }

        private Instant timestampField;

        public Instant getTimestampField() {
            return timestampField;
        }

        public void setTimestampField(Instant timestampField) {
            this.timestampField = timestampField;
        }
    }

    @Test
    public void createJsonWithDefaultDateFormat() throws IOException {
        PlaceRequestBody requestBody = new PlaceRequestBody();
        requestBody.setDateField(LocalDate.now());
        requestBody.setAccuracy(50);
        requestBody.setName("Frontline house");
        requestBody.setPhone_number("(+91) 983 893 3937");
        requestBody.setAddress("29, side layout, cohen 09");
        requestBody.setTypes(new String[]{"shoe park", "shop"});
        requestBody.setWebsite("http://google.com");
        requestBody.setLanguage("French-IN");

        PlaceRequestBody.Location location = new PlaceRequestBody.Location();
        location.setLat(-38.383494);
        location.setLng(33.427362);
        requestBody.setLocation(location);

        // Serialize POJO to JSON
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(requestBody);
        System.out.println("JSON with default date format: \n" + json);

        // Print the date
        System.out.println("Date: " + requestBody.getDateField());
    }

    @Test
    public void createJsonWithCustomDateFormat() throws IOException {
        PlaceRequestBody requestBody = new PlaceRequestBody();
        requestBody.setDateField(LocalDate.now());
        requestBody.setAccuracy(50);
        requestBody.setName("Frontline house");
        requestBody.setPhone_number("(+91) 983 893 3937");
        requestBody.setAddress("29, side layout, cohen 09");
        requestBody.setTypes(new String[]{"shoe park", "shop"});
        requestBody.setWebsite("http://google.com");
        requestBody.setLanguage("French-IN");

        PlaceRequestBody.Location location = new PlaceRequestBody.Location();
        location.setLat(-38.383494);
        location.setLng(33.427362);
        requestBody.setLocation(location);

        // Serialize POJO to JSON with custom date format
        ObjectMapper mapper = new ObjectMapper();
        mapper.setDateFormat(new java.text.SimpleDateFormat("dd-MM-yyyy"));
        String json = mapper.writeValueAsString(requestBody);
        System.out.println("JSON with custom date format: \n" + json);

        // Print the date
        System.out.println("Date: " + requestBody.getDateField());
    }
    

    @Test
    public void createJsonWithTimestamp() throws IOException {
        PlaceRequestBody requestBody = new PlaceRequestBody();
        requestBody.setTimestampField(Instant.now());
        requestBody.setAccuracy(50);
        requestBody.setName("Frontline house");
        requestBody.setPhone_number("(+91) 983 893 3937");
        requestBody.setAddress("29, side layout, cohen 09");
        requestBody.setTypes(new String[]{"shoe park", "shop"});
        requestBody.setWebsite("http://google.com");
        requestBody.setLanguage("French-IN");

        PlaceRequestBody.Location location = new PlaceRequestBody.Location();
        location.setLat(-38.383494);
        location.setLng(33.427362);
        requestBody.setLocation(location);

        // Serialize POJO to JSON
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(requestBody);
        System.out.println("JSON with timestamp: \n"+ json);
    }
}
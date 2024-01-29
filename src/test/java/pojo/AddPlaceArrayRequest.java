package pojo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

public class AddPlaceArrayRequest {
    private Location location;
    private int accuracy;
    private String name;
    private String phone_number;
    private String address;
    private List<String> types;
    private String website;
    private String place_id;
//    @JsonIgnore
    private String language;
    
    // Add getters and setters for the above attributes
//    @JsonIgnoreProperties(value = {"accuracy"})
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
//    @JsonInclude(JsonInclude.Include.NON_DEFAULT)
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

    public List<String> getTypes() {
        return types;
    }

    public void setTypes(List<String> types) {
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
    public void setPlaceId(String place_id) {
    	this.place_id=place_id;
    	
    }
    
   
} 
class Location {
    private double lat;
    private double lng;
    
    

    // Getter for lat
    public double getLat() {
        return lat;
    }

    // Setter for lat
    public void setLat(double lat) {
        this.lat = lat;
    }

    // Getter for lng
    public double getLng() {
        return lng;
    }

    // Setter for lng
    public void setLng(double lng) {
        this.lng = lng;
    }
    public Location(double lat, double lng) {
        this.lat = lat;
        this.lng = lng;
    }
}

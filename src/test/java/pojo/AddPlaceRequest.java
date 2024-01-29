package pojo;


public class AddPlaceRequest
{
	 public static class PlaceAddRequest {
	        private Location location;
	        private int accuracy;
	        private String name;
	        private String phone_number;
	        private String address;
	        private String[] types;
	        private String website;
	        private String language;
	        private String place_id;

	        public PlaceAddRequest(Location location, int accuracy, String name, String phone_number,
	                               String address, String[] types, String website, String language) {
	            this.location = location;
	            this.accuracy = accuracy;
	            this.name = name;
	            this.phone_number = phone_number;
	            this.address = address;
	            this.types = types;
	            this.website = website;
	            this.language = language;
	        }

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
	        
	        public String getPlaceId() {
	        	return place_id;
	        }
	        public void setPlaceId(String place_id) {
	        	this.place_id=place_id;
	        	
	        }
	    }

	    // Java class for location object
	 public static class Location {
	        private double lat;
	        private double lng;

	        public Location(double lat, double lng) {
	            this.lat = lat;
	            this.lng = lng;
	        }

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
	 
}

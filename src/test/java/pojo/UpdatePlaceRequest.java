package pojo;

public class UpdatePlaceRequest {
    private String place_id;
    private String address;
    private String key;
    private String msg;
   
	public String getPlace_id() {
        return place_id;
    }

    public void setPlace_id(String place_id) {
        this.place_id = place_id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
    
    public String getMsg()
    {
    	return msg;
    }
    public void setMsg(String msg) {
    	this.msg=msg;
    	
    }
}
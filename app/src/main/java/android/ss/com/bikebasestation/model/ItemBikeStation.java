package android.ss.com.bikebasestation.model;

public class ItemBikeStation {

    //Getter setters for the field in the JSON file.
    //These are the 5 fields that I got from the API Link.
    private int number;
    private String name;
    private String address;
    private double latitude;
    private double longitude;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}

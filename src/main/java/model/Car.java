package model;

public class Car {

    private String make;
    private String model;
    private int year;
    private String license;

    // constructor
    public Car(String make, String model, int year, String license){
        this.make = make;
        this.model = model;
        this.year = year;
        this.license = license;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return year + " " + make + " " + model + " " + license;
    }
}

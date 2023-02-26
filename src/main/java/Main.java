import model.Car;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    public static void main(String[] args){

        System.out.print("From which file do you want to load this information? ");

        Scanner scanner = new Scanner(System.in);

        String fileName = scanner.nextLine();

        List<Car> cars = new ArrayList<>();

        try {
            File myObj = new File(fileName);
            Scanner myReader = new Scanner(myObj);

            System.out.println("Data loaded.");

            String make = "";
            String model = "";
            int year = 0;
            String license = "";

            while (myReader.hasNextLine()) {

                String data = myReader.nextLine();

                if(data.startsWith("Car")) continue;

                String[] values = data.trim().split(":");

                if(values.length == 2) {
                    String key = values[0];
                    String value = values[1];

                    if(key == null || value == null) continue;

                    value = value.trim();

                    switch (key.trim()) {
                        case "Make":
                            make = value;
                            break;
                        case "Model":
                            model = value;
                            break;
                        case "Year":
                            year = Integer.parseInt(value);
                            break;
                        case "License":
                            license = value;
                            break;
                    }
                }

                if(data.equals("")){
                    cars.add(new Car(make, model, year, license));
                }

            }

            cars.sort(Comparator.comparingInt(Car::getYear));
            System.out.println("Data sorted.");

            System.out.println(cars);
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}

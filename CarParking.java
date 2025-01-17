import java.util.ArrayList;
import java.util.Scanner;

public class car {
    private static ArrayList<String> authorizedVehicles = new ArrayList<String>();
    private static ArrayList<String> parkedVehicles = new ArrayList<String>();

    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);

        // Add some authorized vehicles to the list
        authorizedVehicles.add("Kf1273, krish ");
        authorizedVehicles.add("HR26HD126, shushant ");
        authorizedVehicles.add("PB10GX9223, Aryaman");
        authorizedVehicles.add("PB10GW4130, monu");
        authorizedVehicles.add("QWERT1234,goli");
        authorizedVehicles.add("FEMALE123,james");
        authorizedVehicles.add("HP23ASDFG,ram");


        while (true) {
            // Display menu options
            System.out.println("1. Park a vehicle");
            System.out.println("2. Remove a vehicle from the car park which is already parked ");
            System.out.println("3. View parked vehicles with valid plate number");
            System.out.println("4. View authorised vehicles");
            System.out.println("5. Exit");

            // Get user input
            System.out.print("Enter your choice from 1, 2, 3, 4 and 5: ");
            int choice = scanner.nextInt();

            // Process user choice
            switch (choice) {
                case 1:
                    parkVehicle();
                    break;
                case 2:
                    removeVehicle();
                    break;
                case 3:
                    viewParkedVehicles();
                    break;
                case 4:
                    viewAuthorizedVehicles();
                    break;
                case 5:
                    System.out.println("Thanks for using! ");
                    System.out.println("If any feedback give it to owner. ");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void parkVehicle() {
        Scanner scanner = new Scanner(System.in);

        // Get the license plate number of the vehicle to be parked
        System.out.println("Enter the license plate number of the vehicle: ");
        System.out.println("These are the authorised vehicles. "+authorizedVehicles);
        String licensePlateNumber = scanner.nextLine();

        // Check if the vehicle is authorized to park in the car park
        boolean isAuthorized = false;
        String ownerName = "";
        for (String authorizedVehicle : authorizedVehicles) {
            if (authorizedVehicle.startsWith(licensePlateNumber + ",")) {
                isAuthorized = true;
                ownerName = authorizedVehicle.substring(licensePlateNumber.length() + 2);
                break;
            }
        }

        if (!isAuthorized) {
            System.out.println("Vehicle not authorized to park in the car park.");
        } else if (parkedVehicles.contains(licensePlateNumber)) {
            System.out.println("Vehicle already parked in the car park.");
        } else {
            parkedVehicles.add(licensePlateNumber);
            System.out.println("Vehicle parked successfully.");
            System.out.println("Owner name: " + ownerName);
        }
    }

    private static void removeVehicle() {
        Scanner scanner = new Scanner(System.in);

        // Get the license plate number of the vehicle to be removed
        System.out.print("Enter the license plate number of the vehicle: " );
        String licensePlateNumber = scanner.nextLine();

        if (!parkedVehicles.contains(licensePlateNumber)) {
            System.out.println("Vehicle not parked in the car park.");
            System.out.println("Try giving authorised license plate number.");
        } else {
            parkedVehicles.remove(licensePlateNumber);
            System.out.println("Vehicle removed successfully.");
        }
    }

    // yaha tk upload krdia hai iske agge krna hai aj ek aurr functinality 

    private static void viewParkedVehicles() {
        if (parkedVehicles.size() == 0) {
            System.out.println("No vehicles parked in the car park.");
            System.out.println("Number of vehicles in tha car park = 0");
        } else {
            System.out.println("Parked vehicles:");
            for (String parkedVehicle : parkedVehicles) {
                System.out.println(parkedVehicle );
            }
        }
    }

    private static void viewAuthorizedVehicles() {
        if (authorizedVehicles.size() == 0) {
            System.out.println("No authorized vehicles. ");
            System.out.println("Add vehicles to the list. ");
        } else {
            System.out.println("These are the vehicles authorized to park." + authorizedVehicles);
        }
    }
};
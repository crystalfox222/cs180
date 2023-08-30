import java.util.Scanner;
        import java.text.DecimalFormat;
public class CarRentalAgency {
    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat(".00");
        int check = 0;
        int print = 0;
        int forever = 0;
        String input;
        Scanner scan = new Scanner(System.in);
        System.out.println("Hello! What would you like to do?");
        System.out.println("1. Rent a Car");
        System.out.println("2. Buy a Car");
        System.out.println("3. Calculate Salary");
        System.out.println("4. Quit");
        input = scan.nextLine();
        while (forever == 0) {
            while (check == 0) {
                while (print == 1) {
                    System.out.println("1. Rent a Car");
                    System.out.println("2. Buy a Car");
                    System.out.println("3. Calculate Salary");
                    System.out.println("4. Quit");
                    input = scan.nextLine();
                    print = 0;
                }
                if (input.equals("1")) {
                    break;
                } else if (input.equals("2")) {
                    break;
                } else if (input.equals("3")) {
                    break;
                } else if (input.equals("4")) {
                    System.out.println("Shutting down the program!");
                    return;
                } else {
                    System.out.println("Invalid input!");
                    System.out.println("Please enter a number between 1 and 4!");
                    print = 1;
                }
            }
            while (input.equals("1")) {
                System.out.println("Please enter the Customer's information:");
                System.out.println("Name:");
                String name = scan.nextLine();
                System.out.println("Address:");
                String address = scan.nextLine();
                System.out.println("Zip Code:");
                String zipCode = scan.nextLine();
                System.out.println("Number of Previous Rentals:");
                int rentals = scan.nextInt();
                scan.nextLine();
                while (rentals < 0) {
                    System.out.println("Invalid input!");
                    System.out.println("Please enter a number greater than or equal to 0.");
                    rentals = scan.nextInt();
                    scan.nextLine();
                }
                Customer customer = new Customer(name, address, zipCode, rentals);
                System.out.println("Please enter the Car's Information:");
                System.out.println("Classification Type:");
                String type = scan.nextLine();
                System.out.println("Max Seating:");
                int maxSeating = scan.nextInt();
                scan.nextLine();
                while (maxSeating < 0) {
                    System.out.println("Invalid input!");
                    System.out.println("Please enter a number greater than or equal to 0.");
                    maxSeating = scan.nextInt();
                    scan.nextLine();
                }
                System.out.println("Towing Capacity:");
                int towing = scan.nextInt();
                scan.nextLine();
                while (towing < 0) {
                    System.out.println("Invalid input!");
                    System.out.println("Please enter a number greater than or equal to 0.");
                    towing = scan.nextInt();
                    scan.nextLine();
                }
                System.out.println("Fuel Economy:");
                double fuel = scan.nextDouble();
                scan.nextLine();
                while (fuel < 0) {
                    System.out.println("Invalid input!");
                    System.out.println("Please enter a number greater than or equal to 0.");
                    fuel = scan.nextDouble();
                    scan.nextLine();
                }
                System.out.println("Make:");
                String make = scan.nextLine();
                System.out.println("Model:");
                String model = scan.nextLine();
                System.out.println("Vin:");
                String vin = scan.nextLine();
                System.out.println("Purchase Price:");
                double price = scan.nextDouble();
                scan.nextLine();
                while (price < 0||price == -0) {
                    System.out.println("Invalid input!");
                    System.out.println("Please enter a number greater than or equal to 0.");
                    price = scan.nextDouble();
                    scan.nextLine();
                }
                System.out.println("Mileage:");
                int mile = scan.nextInt();
                scan.nextLine();
                while (mile < 0) {
                    System.out.println("Invalid input!");
                    System.out.println("Please enter a number greater than or equal to 0.");
                    mile = scan.nextInt();
                    scan.nextLine();
                }
                Car car = new Car(Classification.valueOf(type), maxSeating, towing, fuel, make, model, vin, price, mile);
                System.out.println("Does " + name + " want insurance?");
                String answer = scan.nextLine();
                boolean insurance = true;
                int checking = 0;
                while (checking == 0) {
                    if (answer.equals("Yes") || answer.equals("yes") || answer.equals("y")) {
                        insurance = true;
                        checking = 1;
                    } else if (answer.equals("No") || answer.equals("no") || answer.equals("n")) {
                        insurance = false;
                        checking = 1;
                    }else {
                        System.out.println("Invaild input!");
                        System.out.println("Please enter either Yes/yes/y or No/no/n.");
                        answer = scan.nextLine();
                    }
                }
                System.out.println("How many days are in the rental period?");
                int days = scan.nextInt();
                scan.nextLine();
                while (days < 0) {
                    System.out.println("Invalid input!");
                    System.out.println("Please enter a number greater than or equal to 0.");
                    days = scan.nextInt();
                    scan.nextLine();
                }
                double rate = car.calculateRate(days, insurance);
                double discount = rate * customer.calculateDiscount();
                rate = rate - discount;
                System.out.printf("The total Price is: $%.2f.", +rate);
                System.out.println("");
                print = 1;
                input = "";
                break;
            }
            while (input.equals("2")) {
                System.out.println("Please enter the Customer's information:");
                System.out.println("Name:");
                String name = scan.nextLine();
                System.out.println("Address:");
                String address = scan.nextLine();
                System.out.println("Zip Code:");
                String zipCode = scan.nextLine();
                System.out.println("Number of Previous Rentals:");
                int rentals = scan.nextInt();
                scan.nextLine();
                while (rentals < 0) {
                    System.out.println("Invalid input!");
                    System.out.println("Please enter a number greater than or equal to 0.");
                    rentals = scan.nextInt();
                    scan.nextLine();
                }
                Customer customer = new Customer(name, address, zipCode, rentals);
                System.out.println("Please enter the Car's Information:");
                System.out.println("Classification Type:");
                String type = scan.nextLine();
                System.out.println("Max Seating:");
                int maxSeating = scan.nextInt();
                scan.nextLine();
                while (maxSeating < 0) {
                    System.out.println("Invalid input!");
                    System.out.println("Please enter a number greater than or equal to 0.");
                    maxSeating = scan.nextInt();
                    scan.nextLine();
                }
                System.out.println("Towing Capacity:");
                int towing = scan.nextInt();
                scan.nextLine();
                while (towing < 0) {
                    System.out.println("Invalid input!");
                    System.out.println("Please enter a number greater than or equal to 0.");
                    towing = scan.nextInt();
                    scan.nextLine();
                }
                System.out.println("Fuel Economy:");
                double fuel = scan.nextDouble();
                scan.nextLine();
                while (fuel < 0) {
                    System.out.println("Invalid input!");
                    System.out.println("Please enter a number greater than or equal to 0.");
                    fuel = scan.nextDouble();
                    scan.nextLine();
                }
                scan.nextLine();
                System.out.println("Make:");
                String make = scan.nextLine();
                System.out.println("Model:");
                String model = scan.nextLine();
                System.out.println("Vin:");
                String vin = scan.nextLine();
                System.out.println("Purchase Price:");
                double price = scan.nextDouble();
                scan.nextLine();
                while (price < 0) {
                    System.out.println("Invalid input!");
                    System.out.println("Please enter a number greater than or equal to 0.");
                    price = scan.nextDouble();
                    scan.nextLine();
                }
                System.out.println("Mileage:");
                int mile = scan.nextInt();
                scan.nextLine();
                while (mile < 0) {
                    System.out.println("Invalid input!");
                    System.out.println("Please enter a number greater than or equal to 0.");
                    mile = scan.nextInt();
                    scan.nextLine();
                }
                Car car = new Car(Classification.valueOf(type), maxSeating, towing, fuel, make, model, vin, price, mile);
                price = car.calculateSellPrice();
                System.out.printf("The total Price is: $%.2f.", +price);
                System.out.println("");
                print = 1;
                input = "";
                break;
            }
            while (input.equals("3")) {
                System.out.println("Please enter the Employee's information:");
                System.out.println("Name:");
                String name = scan.nextLine();
                System.out.println("Years worked:");
                int years = scan.nextInt();
                scan.nextLine();
                while (years < 0) {
                    System.out.println("Invalid input!");
                    System.out.println("Please enter a number greater than or equal to 0.");
                    years = scan.nextInt();
                    scan.nextLine();
                }
                System.out.println("Total Rentals:");
                int rentals = scan.nextInt();
                scan.nextLine();
                while (rentals < 0) {
                    System.out.println("Invalid input!");
                    System.out.println("Please enter a number greater than or equal to 0.");
                    rentals = scan.nextInt();
                    scan.nextLine();
                }
                System.out.println("Base Salary:");
                double salary = scan.nextDouble();
                scan.nextLine();
                while (salary < 0) {
                    System.out.println("Invalid input!");
                    System.out.println("Please enter a number greater than or equal to 0.");
                    salary = scan.nextDouble();
                    scan.nextLine();
                }
                System.out.println("ID:");
                int id = scan.nextInt();
                scan.nextLine();
                while (id < 0) {
                    System.out.println("Invalid input!");
                    System.out.println("Please enter a number greater than or equal to 0.");
                    id = scan.nextInt();
                    scan.nextLine();
                }
                Employee employee = new Employee(name, years, rentals, salary, id);
                double rate = employee.calculateSalary();
                System.out.printf(name+"'s salary is: $%.2f.", +rate);
                System.out.println("");
                print = 1;
                input = "";
                break;
            }
        }

    }
}

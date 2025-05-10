import java.util.Scanner;

class Customer {
    String name;
    String address;
    int meterNumber;

    Customer(String name, String address, int meterNumber) {
        this.name = name;
        this.address = address;
        this.meterNumber = meterNumber;
    }
}

class Bill {
    Customer customer;
    int units;
    double totalBill;

    Bill(Customer customer, int units) {
        this.customer = customer;
        this.units = units;
        this.totalBill = calculateBill();
    }

    private double calculateBill() {
        double bill = 0;
        if (units <= 100) {
            bill = units * 1.5;
        } else if (units <= 300) {
            bill = 100 * 1.5 + (units - 100) * 2.5;
        } else {
            bill = 100 * 1.5 + 200 * 2.5 + (units - 300) * 4.0;
        }
        bill += 50; // fixed charge
        return bill;
    }

    void displayBill() {
        System.out.println("\n------ Electricity Bill ------");
        System.out.println("Customer Name: " + customer.name);
        System.out.println("Address      : " + customer.address);
        System.out.println("Meter Number : " + customer.meterNumber);
        System.out.println("Units Used   : " + units);
        System.out.println("Total Bill   : ₹" + totalBill);
    }
}

public class ElectricityBillingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter customer name:");
        String name = sc.nextLine();

        System.out.println("Enter address:");
        String address = sc.nextLine();

        System.out.println("Enter meter number:");
        int meterNumber = sc.nextInt();

        System.out.println("Enter units consumed:");
        int units = sc.nextInt();

        Customer customer = new Customer(name, address, meterNumber);
        Bill bill = new Bill(customer, units);

        bill.displayBill();
        sc.close();
    }
}

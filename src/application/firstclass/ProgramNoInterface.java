package application.firstclass;

import model.entities.firstclass.CarRental;
import model.entities.firstclass.Vehicle;
import services.firstclass.BrazilTaxService;
import services.firstclass.RentalService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ProgramNoInterface {

    public static void main(String[] args) throws ParseException {

        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:ss");


        System.out.println("Car model: ");
        String car = sc.nextLine();
        System.out.println("Pickup (dd/MM/yyyy hh:ss): ");
        Date start = sdf.parse(sc.nextLine());
        System.out.println("Return (dd/MM/yyyy hh:ss): ");
        Date finish = sdf.parse(sc.nextLine());

        CarRental cr = new CarRental(start, finish, new Vehicle(car));

        System.out.println("Enter price per hour: ");
        double pricePerHour = sc.nextDouble();
        System.out.println("Enter price per day: ");
        double pricePerDay = sc.nextDouble();

        RentalService rentalService = new RentalService(pricePerDay, pricePerHour, new BrazilTaxService());

        rentalService.processInvoice(cr);

        System.out.println("INVOICE: ");
        System.out.println("Basic payment: "+ String.format("%.2f", cr.getInvoice().getBasicPayment()));
        System.out.println("Taxt: "+ String.format("%.2f", cr.getInvoice().getTax()));
        System.out.println("Total payment: "+ String.format("%.2f", cr.getInvoice().getTotalPayment()));

        sc.close();


    }

}

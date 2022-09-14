package application.secondclass;



import model.entities.secondclass.Contract;
import model.entities.secondclass.Installment;
import services.secondclass.ContractService;
import services.secondclass.PaypalService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) throws ParseException {

        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Enter contract data ");
        System.out.println("Number: ");
        int number = sc.nextInt();
        System.out.println("Date(dd/MM/yyyy hh:ss): ");
        Date date = sdf.parse(sc.next());
        System.out.println("Contract value: ");
        double price = sc.nextDouble();

        Contract contract = new Contract(number, date, price);

        System.out.println("Enter number of installments: ");
        int numberInst = sc.nextInt();

        ContractService cs = new ContractService(new PaypalService());

        cs.processContract(contract, numberInst);

        System.out.println("Installments: ");
        for (Installment x : contract.getInstallments()){
            System.out.println(x);
        }


        sc.close();


    }

}
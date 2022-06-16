package com.example.solidbankapp;

import com.example.solidbankapp.ACCOUNT.AccountType;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class MyCLI implements CLIUI{
    Scanner scanner;

    public MyCLI(Scanner scanner) {
        this.scanner = scanner;
    }
    MyCLI() {
        this.scanner = new Scanner(System.in);
    }

    public Scanner getScanner() {
        return scanner;
    }

    public double requestClientAmount(){
        System.out.println("Type amount of money");
//        System.out.print(scanner.nextLine());
        String amount = scanner.nextLine();
        return Double.parseDouble(amount);
    }
    public String requestClientAccountNumber(){
        return scanner.nextLine();
    }
    @Override
    public AccountType requestAccountType(){
        switch(scanner.nextLine()){
            case "FIXED": return AccountType.FIXED;
            case "CHECKING":  return AccountType.CHECKING;
            case "SAVING":  return AccountType.SAVING;
        }
        return null;
    }

}

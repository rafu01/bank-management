
package javafxapplication13;

import java.io.*;
import java.util.Scanner;

public class SavingsAccount extends User{
    
    public double calculateInterest(int year) throws FileNotFoundException{
        FileReader fr =  new FileReader(accountNumber+"balance.txt"); 
        Scanner sc = new Scanner(fr);
        double s=0;
        while(sc.hasNextLine()){
        s = Double.parseDouble(sc.nextLine());
        }
        double i = s*checkInterest()*year;
        return i;
    }
    public double checkBalance() throws FileNotFoundException{
        FileReader fr =  new FileReader(accountNumber+"balance.txt"); 
        Scanner sc = new Scanner(fr);
        double s=0;
        while(sc.hasNextLine()){
        s = Double.parseDouble(sc.next());
        }
        return s;
    }
    public double withdrawBalance(double amount) throws IOException{
            FileReader fr =  new FileReader(accountNumber+"balance.txt"); 
            Scanner sc = new Scanner(fr);
            double s=0;
            while(sc.hasNextLine()){
                s = Double.parseDouble(sc.nextLine());
                }
            if(amount>s){
                balance = s;
            }
            else {
                balance = s-amount;
                FileWriter fw = new FileWriter(accountNumber+"balance.txt", false); 
                fw.write(balance+"");
                fw.close();
            }
            return balance;
    }
    public double addBalance(double amount) throws IOException{
            FileReader fr =  new FileReader(accountNumber+"balance.txt"); 
            Scanner sc = new Scanner(fr);
            double s=0;
            while(sc.hasNextLine()){
            s = Double.parseDouble(sc.nextLine());
            }
            balance = s+amount;
            FileWriter fw = new FileWriter(accountNumber+"balance.txt", false); 
            fw.write(balance+"");
            fw.close();
            return balance;
    }
}

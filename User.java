
package javafxapplication13;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class User{
    Scanner sc = new Scanner(System.in);
    String name, email, password, phone, address;
    int accountNumber;
    double balance, interestRate = 0.03;
    public String encrypt(String pass){
        char[] c = pass.toCharArray();
        for(int i=0; i<c.length;i++){
            if(i%2==0){
                c[i]=(char)(c[i]+3);
            }
            else {
            c[i]=(char)(c[i]-2);
            }
        }
        String newPass = new String(c);
        return newPass;
    }
    public void show(){
        System.out.println(name);
        System.out.println(email);
        System.out.println(password);
        System.out.println(accountNumber);
    }
    public void takeNameInput(String _name){
        name = _name;
    }
    public void takeEmailInput(String _email){
        email = _email;
    }
    public void takePasswordInput(String _password){
        password = _password;
    }
    public void takePhoneInput(String _phone){
        phone = _phone;
    }
      public void takeAddressInput(String _address){
        address = _address;
    }
    public void generateId() throws FileNotFoundException, IOException{
        try{
            FileReader fr =  new FileReader("AccountNumber.txt"); 
        }
        catch(Exception e){
            PrintWriter wr = new PrintWriter("AccountNumber.txt");
            wr.print("1000");
            wr.close();
        }
        FileReader fr =  new FileReader("AccountNumber.txt"); 
        Scanner sc = new Scanner(fr);
        while(sc.hasNextLine()){
                accountNumber = Integer.parseInt(sc.nextLine());
        }
        accountNumber++;
        FileWriter fw = new FileWriter("AccountNumber.txt", false);
        fw.write(accountNumber+"");
        fw.close();
    }
    public int getId(){
        return accountNumber;
    }

   public void save() throws IOException{
           File file = new File(accountNumber+"login.txt");
           FileWriter fr = new FileWriter(file, true); 
           File fileBalance = new File(accountNumber+"balance.txt");
           FileWriter frBalance = new FileWriter(fileBalance, true); 
           fr.write(name+"\n");
           fr.write(email+"\n");
           fr.write(accountNumber+" "+encrypt(password)+"\n");
           fr.write(phone+"\n");
           fr.write(address+"\n");
           frBalance.write(balance+"");
           fr.close();
           frBalance.close();
        }
    public boolean access(int accNo,String pass) throws FileNotFoundException{
        boolean flag = false;
        try{
            FileReader fr =  new FileReader(accNo+"login.txt");
            Scanner sc = new Scanner(fr);
            String accpass = accNo+" "+(encrypt(pass));
            flag = false;
            while(sc.hasNextLine()){
                if(sc.nextLine().equals(accpass)){
                    flag = true;
                    break;
                }
            }
        }
        catch(Exception e){
            return flag;
        }
        return flag;
    } 
    public void setId(int acc){
        accountNumber = acc;
    }
    public void setPass(String pass){
        password = pass;
    }
    public void changeInterest(double newinterest) throws FileNotFoundException, IOException{
        try{
            FileReader fr =  new FileReader("InterestRate.txt"); 
        }
        catch(Exception e){
            PrintWriter wr = new PrintWriter("InterestRate.txt");
            wr.print("0.03");
            wr.close();
        }
        FileWriter fw = new FileWriter("InterestRate.txt", false);
        fw.write(newinterest+"");
        fw.close();
    }
    public double checkInterest() throws FileNotFoundException{
        try{
            FileReader fr =  new FileReader("InterestRate.txt"); 
        }
        catch(Exception e){
            PrintWriter wr = new PrintWriter("InterestRate.txt");
            wr.print("0.03");
            wr.close();
        }
        FileReader fr =  new FileReader("InterestRate.txt"); 
        Scanner sc = new Scanner(fr);
        while(sc.hasNextLine()){
            interestRate = Double.parseDouble(sc.nextLine());
        }
        return interestRate;
    }
}



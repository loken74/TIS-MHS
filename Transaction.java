import java.util.Scanner;



public class Transaction{



  static MHS_Main bank = new MHS_Main();



  String transaction = "-1";

  double cashAmount = 0;



  Tickets ticket = new Tickets();

  Scanner scan = new Scanner(System.in);

  TIS_Main main = new TIS_Main();





public static Payment createPayment(String bankaccount, double cashAmount){



  bankaccount = bankaccount.replace("-", "");



  Payment currentPayment = (Payment) bank.checkPayment(bankaccount, cashAmount);



  return currentPayment;



}





}






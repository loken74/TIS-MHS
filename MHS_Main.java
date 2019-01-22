public class MHS_Main{

    public MHS_Bank nordea;

    public MHS_Bank handelsbanken;

    public MHS_Bank seb;

    public MHS_Bank swedbank;

    private String clearingNordea        = "1234";

    private String clearingHandelsbanken = "1423";

    private String clearingSEB           = "5531";

    private String clearingSwedbank      = "9951";



  public MHS_Main(){

    //Create banks

    nordea        = new MHS_Bank("Nordea");

    handelsbanken = new MHS_Bank("Handelsbanken");

    seb           = new MHS_Bank("SEB");

    swedbank      = new MHS_Bank("Swedbank");

    //Create bank accounts

    createAccounts();

  }

  private void createAccounts(){

    //Nordea

    nordea.addAccount("1234000001", 10);

    nordea.addAccount("1234000002", 30);

    //Handelsbanken

    handelsbanken.addAccount("1423000001", 30);

    handelsbanken.addAccount("1423000002", 70);

    //SEB

    seb.addAccount("5531000001", 100);

    seb.addAccount("5531000002",  35);

    //Swedbank

    swedbank.addAccount("9951000001",  5);

    swedbank.addAccount("9951000002", 95);

  }

  public String tryTransaction(double price, String accountNumber){

    String returnStatement = "Invalid clearing-number specified";

    //If account number has valid amount of numbers in it

    if(accountNumber.length() == 10){

      //Extract clearing number

      String clearingNumber = accountNumber.substring(0,4);

      //Identify bank

      if(clearingNumber.equals(clearingNordea)){

        returnStatement = nordea.tryPayment(accountNumber, price);

      } else if(clearingNumber.equals(clearingHandelsbanken)){

        returnStatement = handelsbanken.tryPayment(accountNumber, price);

      } else if(clearingNumber.equals(clearingSEB)){

        returnStatement = seb.tryPayment(accountNumber, price);

      } else if(clearingNumber.equals(clearingSwedbank)){

        returnStatement = swedbank.tryPayment(accountNumber, price);

      }

    }

    return returnStatement;

  }

public Payment checkPayment(String bankaccount, double cashAmount) {
	
	return null;
}

}

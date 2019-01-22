import java.util.Scanner;

import java.util.InputMismatchException;

import java.util.concurrent.TimeUnit;



public class TIS_Main {



  private static String kontoNr = "-1";

  private static double price = 0;

  private static int operation = -1;



  public static final String ANSI_RESET = "\u001B[0m";

  public static final String ANSI_RED = "\u001B[31m";

  public static final String ANSI_GREEN = "\u001B[32m";

  public static final String ANSI_WHITE = "\u001B[37m";

private Scanner op;

private Scanner scanString;

private static Scanner scan;



  // Gör raka kolumner

  private void addSpacing(final String temp, final int kolumnBredd) {

    final int namnBredd = temp.length();

    final int spaces = kolumnBredd - namnBredd;



    for (int k = 0; k <= spaces; k++) {

      System.out.print(" ");

    }

  }



  // Skriver ut kvittot

  public void printReceipt(final String bankName) {

    System.out.println(ANSI_WHITE + '\n' + "------------------------------" + '\n');

    System.out.println('\t' + "Kvitto" + '\n');

    System.out.println(('\t'+"Biljett: " + Tickets.ticketName.get(operation-1)));

    System.out.println('\t'+"Pris:    " + price);

    System.out.println('\t'+"Bank:    " + bankName + '\n');

    System.out.println('\t' + "Tack för ert köp!");

    System.out.println('\n' + "------------------------------" + ANSI_RESET);

  }



  // Tillgängliga biljettyper

  private void printTickets() {

    int kolumnBredd;

    String temp;



    System.out.println('\n' + "Tillgängliga biljetter:" + '\n');

    for (int i = 0; i < Tickets.ticketName.size(); i++) {
    	
    	 System.out.print((i+1) + ". " + Tickets.age.get(i));



         kolumnBredd = 12;

         temp = Tickets.age.get(i);

         addSpacing(temp, kolumnBredd);



         System.out.print(Tickets.ticketDescription.get(i));

      System.out.print((i+1) + ". " + Tickets.ticketName.get(i));



      kolumnBredd = 12;

      temp = Tickets.ticketName.get(i);

      addSpacing(temp, kolumnBredd);



      System.out.print(Tickets.ticketDescription.get(i));



      kolumnBredd = 50;

      temp = Tickets.ticketDescription.get(i);

      addSpacing(temp, kolumnBredd);



      System.out.println("Pris: " + Tickets.ticketPrice.get(i) + " kr / st");

    }

    System.out.println();

  }



  // Biljettval och kontonummer

  private  void userInputs() {



    op = new Scanner(System.in);

    boolean looping = true;

    scanString = new Scanner(System.in);



      while (looping) {



        try {



          System.out.print("Välj typ av biljett (1-5): ");

          operation = op.nextInt();



          if (operation >= 1 && operation <= 5) {

            price = Tickets.ticketPrice.get(operation-1);

            looping = false;

          } else {

            System.out.println("Välj biljett med siffrorna 1-5.");

          }



        } catch (final InputMismatchException e) {

          System.out.println("Fel datatyp, försök igen.");

          op.next();

        } catch (final Exception e) {

            System.out.println("Ett fel har inträffat.");

        }

      }



    System.out.print("Ange ditt kontonummer: ");

    setKontoNr(scanString.next());

  }



  private void fakeDelay() {

    for (int i = 0; i < 12; i++) {

      try {

        TimeUnit.MILLISECONDS.sleep(90);

      } catch (final InterruptedException e) {

        e.printStackTrace();

      }

      System.out.print(".");

    }

  }



  private void callBank(final TIS_Main tis_main) {

    System.out.print('\n' + "Kontaktar banken ");



    fakeDelay();



    if (Payment.isValid) {

      System.out.println(ANSI_GREEN + " Betalningen godkändes." + ANSI_RESET);

      tis_main.printReceipt(Payment.nameOfBank);

    } else {

      System.out.println(ANSI_RED + " Betalningen nekades" + ANSI_RESET);

    }

  }



// ---------------------------------------------------------------------------



  public static void main(final String[] args){

    final TIS_Main tis_main = new TIS_Main();

    setScan(new Scanner(System.in));

    final boolean looping = true;



    while (looping) {

      tis_main.printTickets();

      tis_main.userInputs();

      tis_main.callBank(tis_main);

    }

  }



public static String getKontoNr() {
	return kontoNr;
}



public static void setKontoNr(String kontoNr) {
	TIS_Main.kontoNr = kontoNr;
}



public static Scanner getScan() {
	return scan;
}



public static void setScan(Scanner scan) {
	TIS_Main.scan = scan;
}



}
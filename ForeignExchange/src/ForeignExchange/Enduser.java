package ForeignExchange;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Enduser {
	
	private static double usdTOInrRate = 66.00;
    private static  List<Trade> trades = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) {
            
            while (true) {
                System.out.println("1. Book Trade");
                System.out.println("2. Print Trades");
                System.out.println("3. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine();  // Consume the newline left by nextInt()

                switch (choice) {
                    case 1:
            
                        bookTrade();
                        break;

                    case 2:
                        printTrades();
                        break;

                    case 3:
                        exit();
                        break;

                    default:
                        System.out.println("Invalid choice. Please choose a valid option.");
                        break;
                }
            }
        }
        
        
    
        private static void bookTrade() {
        	System.out.print("Enter customer Name: ");
        	String customerName = scanner.nextLine();
        	if (!isValidName(customerName)) {
                System.out.println("Invalid name format. Please use only alphabetic characters and spaces.");
               
            }        	
            
            System.out.print("Enter Currency Pair (USDINR): ");
            String currencyPair = scanner.nextLine();
            
            if (!currencyPair.equalsIgnoreCase("USDINR")) {
                System.out.println("Invalid currency pair. Only USDINR is supported.");
            }
            
            System.out.print("Enter amount to transfer: ");
            double amount = scanner.nextDouble();
            scanner.nextLine();  

            System.out.print("Do you want to get Rate (Yes/No): ");
            String getRate = scanner.nextLine();

            if (getRate.equalsIgnoreCase("yes")) {
                System.out.println("You are transferring INR "  + amount*usdTOInrRate + " to " + customerName +"( Assuming that rate was" + usdTOInrRate + ")");
            }
            else {
            	System.out.println("You are transferring INR "  + amount*usdTOInrRate + " to " + customerName +"( Assuming that rate was" + usdTOInrRate + ")");
            }

            System.out.print("Book/Cancel this trade? (Book/Cancel): ");
            String bookCancel = scanner.nextLine();

            if (bookCancel.equalsIgnoreCase("book")) {
            	trades.add(new Trade(customerName,currencyPair, usdTOInrRate, amount));
                System.out.println("Trade for " + currencyPair + " has been booked with Rate " + usdTOInrRate + "  ,The amount of Rs " + amount*usdTOInrRate + "will be transferred in 2 working days to " + customerName +".");
            } 
            else if(bookCancel.equalsIgnoreCase("cancle")){
                System.out.println("Trade is Canceled.");
            }
            else {
            	System.out.println("invalid choice");
            }
        }
        
        
        
            private static void printTrades(){
            	System.out.println("tradeNumber currencyPair  customerName   amount       rate");
            	for (Trade Trade : trades)
            	{
            		System.out.println(Trade);
            	}
            }
            
            private static void exit() {
            System.out.print("Do you really want to exit (yes/no): ");
            String confirmation = scanner.nextLine();
            if (confirmation.equalsIgnoreCase("y")) {
                System.out.println("Bye - have a good day");
                scanner.close();
                System.exit(0);
            }
         }
            
            public static boolean isValidName(String name) {
            	for(char c:name.toCharArray()) {
            		if(!Character.isLetter(c) && c!=1) {
            			return false;
            			
            		}
            		 return name.matches("^[A-Za-z ]+$");
            	}
				return false;
				
            }
          
            
            
   }


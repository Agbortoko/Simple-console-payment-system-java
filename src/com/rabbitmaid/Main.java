package com.rabbitmaid;
import com.rabbitmaid.Authentication.Authentication;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Authentication auth = new Authentication();
        System.out.println("Account Login");
        System.out.println("****************");

        System.out.print("Enter username: ");
        Scanner usernameInput = new Scanner(System.in);

        String username = usernameInput.next();

        System.out.print("Enter password: ");
        Scanner passwordInput = new Scanner(System.in);

        String password = passwordInput.nextLine();

        // auth.username = "rabbitmaid";
        // auth.password = "lolita";

        auth.username = username;
        auth.password = password;
        auth.login();

        if(auth.getLoggedState()){

            for (int i = 0; i < auth.accountInformation().length; ++i) {

                for(int j = 0; j < auth.accountInformation()[i].length; ++j) {

                    String theAccountInfo = auth.accountInformation()[i][j];

                    if(theAccountInfo.equals(auth.username)){

                            System.out.println("\nAccount Info");
                            System.out.println("****************");
                            System.out.println("Full Names: " +  auth.accountInformation()[i][1]);
                            System.out.println("Balance:" + auth.accountInformation()[i][2] + "XAF");
                            System.out.println("Account Number:"  + auth.accountInformation()[i][3]);


                            // Account Options
                            System.out.println("\nSelect Options");
                            System.out.println("****************");
                            System.out.println("(1) Transfer Money");
                            System.out.println("(0) Exit");

                        System.out.print("Option: ");
                        Scanner optionInput = new Scanner(System.in);
                            int option = optionInput.nextInt();

                            if(option == 1){

                                System.out.print("\nHow much money do you want to transfer: ");
                                Scanner amountToTransferInput = new Scanner(System.in);
                                int amountTransfer = optionInput.nextInt();

                                System.out.print("Account number of receiver: ");
                                Scanner receiverInput = new Scanner(System.in);
                                String receiverAccount = receiverInput.next();

                                //  Get receiver information
                                for (int x = 0; x < auth.accountInformation().length; ++x) {

                                    for (int y = 0; y < auth.accountInformation()[x].length; ++y) {

                                        String receiverInfo = auth.accountInformation()[x][y];

                                                // Check if account number is correct
                                                if(receiverInfo.equals(receiverAccount)){

                                                    // Current Account Balance
                                                    int accountBalance  = Integer.parseInt(auth.accountInformation()[i][2]);

                                                    // Check if you have enough money in your account
                                                    if(amountTransfer > accountBalance){
                                                        System.out.println("\nYou don't have enough money in your account");
                                                        System.exit(-1);
                                                    }

                                                    // Notification incase of successful transfer
                                                    System.out.println("\nNotification!");
                                                    System.out.println("****************");
                                                    System.out.println("Money sent to " +  auth.accountInformation()[x][1]);
                                                    System.out.println("Receiver Account Number:"  + auth.accountInformation()[x][3]);


                                                    int balanceLeft = accountBalance - amountTransfer;

                                                    System.out.println(amountTransfer + "XAF has been sent successfully.");

                                                    auth.accountInformation()[i][2] = Integer.toString(balanceLeft);

                                                    System.out.println("\nAccount Info");
                                                    System.out.println("****************");
                                                    System.out.println("Full Names: " +  auth.accountInformation()[i][1]);
                                                    System.out.println("Balance:" + balanceLeft + "XAF");
                                                    System.out.println("Account Number:"  + auth.accountInformation()[i][3]);

                                                    // Stop loop if everything is good
                                                    System.exit(1);
                                                }
                                    }
                                }



                            }else if(option == 0){
                                System.out.println("\nBoom!");
                                System.exit(1);
                            }

                    }

                }
            }


        }else{
            System.out.println("You can't do anything if you are not logged in");
        }

    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
/* Reference
GeeksforGeeks. 2026. Arrays in Java. [Online]. Available at: https://www.geeksforgeeks.org/java/arrays-in-java/ [Accessed 24 May 2026].
W3Schools. n.d. Java String substring() Method. [Online]. Available at: https://www.w3schools.com/java/ref_string_substring.asp [Accessed 1 May 2026].
GeeksforGeeks. 2024. Java String length() Method with Examples. [Online]. Available at: https://www.geeksforgeeks.org/java/java-string-length-method-with-examples/ [Accessed 1 June 2026].
Farrell, J. 2018. Programming logic and design. 10th ed. Boston: Cengage Learning
Google. 2026. Gemini response to prompt about Java programming. Generated using Google Gemini on 5 June 2026.
*/

package act.quickchat;
import java.util.Scanner;
/**
 *
 * @author mnisi
 */
public class QuickChat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        //Declarations
        String username;
        String password;
        String[] messages = new String[100];
        String[] storedMessages = new String[100];
        String[] sentMessages = new String[100]; 
        String[] disregardedMessages = new String[100];
        String[] storedMessageHashes = new String[100];
        String [] messageIDs = new String[100];
        String cellnum;
        int i;
        String recipientNum = null;
        String x = null;
        
        // Track the current exact index counts for arrays
        int sentCount = 0;
        int storedCount = 0;
        int disregardedCount = 0;
        int hashCount = 0;
        
        // REGISTRATION
        while (true) {
            System.out.println("Enter your username: e.g Ka_li");
            username = sc.nextLine();
            if (login.checkUserName(username)) {
                System.out.println("Username successfully captured.");
                break;
            } else {
                System.out.println("Username is not correctly formatted, please ensure that your username contains an underscore and is no more than five characters in length");
            }
        }

        // CAPTURING PASSWORD
        while (true) {
            System.out.println("Set up a unique password: (e.g ZphisherPreInstalled101!)");
            password = sc.nextLine();
            if (login.checkPasswordComplexity(password)) {
                System.out.println("Password successfully captured.");
                break;
            } else {
                System.out.println("Password is not correctly formatted, please ensure that the password contains at least eight characters, a capital letter, a number, and a special symbol");
            }
        }

        // CAPTURING CELLPHONE NUMBER
        while (true) {
            System.out.println("Enter your cellphone number (e.g +2761345600)");
            cellnum = sc.nextLine();
            if (login.checkCellPhoneNumber(cellnum)) {
                System.out.println("Cell phone number successfully added.");
                System.out.println(login.registerUser(username, password));
                break;
            } else {
                System.out.println("Cell phone number incorrectly formatted or does not contain international code.");
            }
        }
        
        // LOGIN LOOP
        System.out.println("Login with your username and password");
        String loginUsername = sc.nextLine();
        System.out.println("Password:");
        String loginPassword = sc.nextLine();
        
        if (login.loginUser(loginUsername, loginPassword)) {
            System.out.println("Welcome " + username + ", to QuickChat");
            System.out.println(login.returnLoginStatus(loginUsername, loginPassword));
        }
        
        // MAIN MENU LOOP
        while (true) {
            int userOption;
            System.out.println("--- Menu ---");
            System.out.println("Option 1) Send Message");
            System.out.println("Option 2) Show recently sent messages");
            System.out.println("Option 3) Quit");
            System.out.println("Option 4) Show stored messages");
            userOption = sc.nextInt();
            sc.nextLine(); //ensure no buffer and takes the enter (key) as input when pressed

            if (userOption == 1) {
                System.out.println("Enter recipient number along with country code (e.g. +27831234567):");
                recipientNum = sc.nextLine();

                if (!message.checkRecipientCell(recipientNum).equals("+27")) {
                    System.out.println("Invalid number. Must start with +27");
                }
                
                System.out.println("How many messages would you like to send?");
                int userMessageCounter = sc.nextInt();
                sc.nextLine();

                for (i = 0; i < userMessageCounter; i++) {
                    System.out.println("Type message: ");
                    String userMessage = sc.nextLine();
                    
                    //VALIDATES USERS INPUT IS NO MORE THAN 250 CHAR LONG
                    while (userMessage.length() > 250) {
                    System.out.println("Message exceeds 250 characters, please reduce the size");
                    System.out.println("Type message again: ");
                    userMessage = sc.nextLine(); // Overwrite with new input
                    }
                       messages[i] = userMessage;// populates userInput in an array
                    
                    //MESSAGE HASH
                    String messageID = message.checkMessageID();
                    System.out.println("Message ID: " + messageID);
                    // Grab only the first word using index 
                    String firstWord = userMessage.split(" ")[0];
                    System.out.println("Message hash: " + messageID.substring(0, 2) + ":"+ (i+1) +" "+ firstWord);//(Google Gemini, 2026)
                    
                    System.out.println("Do you want to Send, Store or Disregard?");
                    x = sc.nextLine();
                    
                    System.out.println(message.sentMessage(x));
                    System.out.println(message.printMessage(userMessage));
                    
                    if (x.equals("Send")) {
                        sentMessages[sentCount] = userMessage;
                        sentCount++;
                    } else if (x.equals("Store")) {
                        messageIDs[storedCount] = messageID;
                        storedMessageHashes[storedCount] = messageID.substring(0, 2); 
                        storedMessages[storedCount] = userMessage;
                        storedCount++;
                    } else if (x.equals("Disregard")){
                        disregardedMessages[disregardedCount] = userMessage;
                        disregardedCount++;
                    }
                }
                
                //Save to JSON file 
                if (storedCount > 0) {
                    message.storeMessage(storedMessages, storedCount);
                }
                
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("Total sent messages: " + sentCount);

            } else if (userOption == 2) {
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("SENT MESSAGES");
                System.out.println("Sender: " + cellnum);
                System.out.println("Recipient: " + recipientNum);
                System.out.println("------------------------");
                
                if (sentCount == 0) {
                    System.out.println("No messages have been sent yet.");
                } else {
                    for (int k = 0; k < sentCount; k++) {
                        System.out.println((k + 1) + ") " + sentMessages[k]);
                    }
                }
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~");
            } else if (userOption == 3) {
                break;
                
            } else if (userOption == 4) {
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("STORED MESSAGES");
                
                if (storedCount == 0) {
                    System.out.println("No messages stored yet.");
                } else {
                    for (int k = 0; k < storedCount; k++) {
                // Print the hash prefix alongside the message so the user knows what to type to delete it
                System.out.println((k + 1) + ") [Hash: " + storedMessageHashes[k] + "] " + storedMessages[k]);
                    }
                }
                
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("DISREGARDED MESSAGES");
                for (int d = 0; d < disregardedCount; d++){
                    System.out.println((d + 1) +") " + disregardedMessages[d]);
                }
                
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println("Delete a message using the hash");
                String deleteHash = sc.nextLine();
                
               for (int hashIndex = 0; hashIndex < storedCount; hashIndex++) {
            if (storedMessageHashes[hashIndex].equals(deleteHash)) {
                System.out.println("Message with hash " + deleteHash + " has been deleted");
                }}
            }}}}

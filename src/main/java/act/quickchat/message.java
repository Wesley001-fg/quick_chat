/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package act.quickchat;
import java.util.Random;
import java.util.HashMap;
import java.io.FileWriter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
/**
 *
 * @author mnisi
 */
public class message {
  
    public static void storeMessage(String[] storedMessages, int count) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        
        // Clean out nulls so your JSON file doesn't look empty or broken
        String[] cleanArray = new String[count];
        System.arraycopy(storedMessages, 0, cleanArray, 0, count);

        try (FileWriter writer = new FileWriter("StoredMessages.json")) {
            gson.toJson(cleanArray, writer);
            System.out.println("Messages stored successfully in JSON.");
        } catch (IOException e) {
            System.out.println("Error storing messages: " + e.getMessage());
        }
    }
    
    public static String sentMessage(String x) {
        if (x.equals("Send")){
            return "Sent";
        } else if (x.equals("Store")){
            return "Stored";
        } else if (x.equals("Disregard")){
            return "Deleted";
        }
        return "Invalid option";
    }
    
    public static String checkMessageID() {
        Random randomlyGeneratedNum = new Random();
        StringBuilder randomNumber = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            randomNumber.append(randomlyGeneratedNum.nextInt(10));
        }
        return randomNumber.toString();
    }
    
    public static String checkRecipientCell(String recipientNum) {
        if (recipientNum.startsWith("+27") && recipientNum.substring(3).length() == 9) {
            return "+27";
        } else {
            return "Not valid";
        }
    }
    
    public static String printMessage(String message) {
        return "Element: " + message;
    }

    public int returnTotalMessages(int userMessageCounter) {
        return userMessageCounter;
    }
    
}
    








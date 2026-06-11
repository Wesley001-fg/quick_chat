/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import act.quickchat.message;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author mnisi
 */
public class method_testing {
    
    public method_testing() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }
    public void checkUserName_True() {
    String username = "Kyl_1";
    boolean actual = username.length() <= 5 && username.contains("_");
    assertEquals(true, actual);
    }
    
    @Test
    public void checkUserName_False(){
    String username = "kyle!!!!!!!";
    boolean actual = username.length() <= 5 && username.contains("_");
    assertEquals(false, actual);
    }

    @Test
    public void checkPasswordComplexity_True(){
    String password = "Ch&&sec@ke99!";
    boolean actual = password.length()  >=8 && password.matches(".*[A-Z].*") && password.matches(".*\\d+.*")  && password.matches(".*[^a-zA-Z0-9].*");
    assertEquals(true, actual);
    }
    
    @Test
    public static void checkPasswordComplexity_False(){
    String password = "password";
    boolean actual = password.length()  >=8 && password.matches(".*[A-Z].*") && password.matches(".*\\d+.*")  && password.matches(".*[^a-zA-Z0-9].*");
    assertEquals(false, actual);
    }

    @Test
    public void checkCellPhoneNumber_True(){
        String cellnum = "+27838968976";
        boolean actual = cellnum.substring(3).length() == 9 && cellnum.startsWith("+27");
        assertEquals(true, actual);
    }

    public void checkCellPhoneNumber_False(){
        String cellnum = "08966663";
        boolean actual = cellnum.substring(3).length() == 9 && cellnum.startsWith("+27");
        assertEquals(false, actual);
    }

    @Test
    public void sentMessage_Send() {
        assertEquals("Sent", message.sentMessage("Send"));
    }
    
    @Test
    public void sentMessage_Store() {
        assertEquals("Stored", message.sentMessage("Store"));
    }
    
    @Test
    public void sentMessage_Disregard() {
        assertEquals("Deleted", message.sentMessage("Disregard"));
    }
      
    @Test
    public void checkRecipientCell_True(){
       String recipientNum = "+27838968976";
       String result = "Message successfully sent";
       boolean isValid = recipientNum.startsWith("+27") && recipientNum.substring(3).length() == 9;
       boolean actual = recipientNum.substring(3).length() == 9 && recipientNum.startsWith("+27");
       assertEquals("sent.", result);
    }

   
    @Test
    public void checkMessageID() {
        String messageID = "2783896897"; // Example 10-digit ID
        boolean actual = messageID.length() == 10;
        assertTrue(actual);
    }
    
    @Test
    public void returnTotalMessages() {
        message obj = new message();
        assertEquals(5, obj.returnTotalMessages(5));
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    }}

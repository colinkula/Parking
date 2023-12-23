import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class creates User objects that are primarily used to login and use 
 * the features on the home screen of the GUI.
 * 
 * @author ColinKula
 */
public class User implements Manageable {
        
    /**
     * The username variable holds the username of the user.
     */
    public String username;
    
    /**
     * The password variable holds the password of the user.
     */
    public String password;
    
    /**
     * The currentUserIndex variable holds the current index of where the user 
     *     is in the list of all users.
     */
    public int currentUserIndex;
    
    /**
     * The parkingLots variable holds a list of all the ParkingLot objects 
     *     that have been instantiated.
     */
    public ArrayList<ParkingLot> parkingLots = new ArrayList<ParkingLot>();

    /**
     * This constructor creates an instance of the User class and initializes
     * the username and password instance variables.
     * 
     * @param username a String to update the username variable of the User class
     * @param passworda String to update the password variable of the User class
     */
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    /**
     * This constructor creates an instcnace of the User class based 
     * off of another User's attributes.
     * 
     * @param user a User that is used to copy its instance variables
     */
    public User(User user) {
        this.username = user.getUsername();
        this.password = user.getPassword();
    }

    /**
     * This method gets the username of the current user and returns its value.
     * 
     * @return a String containing the username of the user
     */
    public String getUsername() {
        return this.username;
    }

    /**
     * This method gets the password of the current user and returns its value.
     * 
     * @return a String containing the password of the user
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * This method generates a new password for the current user.
     * 
     * @return a String containing a new random password
     */
    public String generateNewPassword() {
        String letters = "abcdefghijklmnopqrstuvxyz";
        String numbers = "0123456789";
        String str = "";
        for (int i = 0; i <= 5; i++) {
            str += letters.charAt((int)(Math.random() * (letters.length())));
            str += numbers.charAt((int)(Math.random() * (numbers.length())));            
        }
        return str;
    }

    /**
     * This method calls the generateNewPassword() method and sets the given password 
     * as the users new password. This makes the old password ineffective.
     * 
     * @return a String containing the new password of the user
     */
    public String resetPassword() {
        this.password = generateNewPassword();
        return this.password;
    }
    
    /**
     * This method checks if the given username and password is related to a user in the 
     * arraylist of users. If so, the method returns true and updates the currentUserIndex 
     * to the index found in the array list.
     * 
     * @param username a String containing a posible username for the user
     * @param password a String containing a posible password for the user
     * @param users an ArrayList of all the users with access to managaement system
     * @return a boolean that is true when the username and password match for a 
     *     certain user and false if not
     */
    public boolean checkUserAndPass(String username, String password, ArrayList<User> users) {
        for(int i = 0; i < users.size(); i++) {
            if (username.equals(users.get(i).getUsername()) 
                && password.equals(users.get(i).getPassword())) {
                currentUserIndex = i;
                return true;
            } 
        }
        return false;
    }        
    
    /**
     * This method scans through a text file of users that are capable of logging in, 
     * and stores them into an array list of user objects.
     * 
     * @param users an ArrayList of users to be added to
     */
    @Override
    public void storeAllUsers(ArrayList<User> users) throws FileNotFoundException {
        try {
            Scanner in = new Scanner(new File("UserPass.txt"));
            while(in.hasNextLine() && in.hasNext()) {
                users.add(new User(in.next(), in.next()));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method changes looks at the given username and password, and if 
     * the information pertains to one of the users in the arraylist of users, 
     * the current index of the user is updated.
     * 
     * @param username a String containing a posible username for the user
     * @param password a String containing a posible password for the user
     * @param users an ArrayList of all the users with access to managaement system
     * @return a User that is being changed to
     */
    @Override
    public User changeUser(String username, String password, ArrayList<User> users) {
            if (checkUserAndPass(username, password, users)) { 
                return users.get(currentUserIndex);
            }
        return null;
    }
    
    /**
     * This method generates a parking report and updates the ParkingReport.txt file 
     * with all the information pertaining to the parking manaegment system.
     */
    @Override
    public void generateParkingReport() {
        try {
            FileWriter writer = new FileWriter(new File("ParkingReport.txt"));
            BufferedWriter buffer = new BufferedWriter(writer);
            buffer.write("The user who requested this file is: " 
                + this.getUsername() + "\n\n");
            for (int i = 0; i <= parkingLots.size() - 1; i++) {
                String parkingInfo = parkingLots.get(i).toString();
                buffer.write(parkingInfo);
            }
            buffer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * This method creates a clone of a User object and returns its value.
     * 
     * @return a User with the same attributes of the current User object
     */
    @Override
    public User clone() {
        return new User(this.getUsername(), this.getPassword());
    }
    
    /**
     * This method creates a string representation of a User object.
     * 
     * @return a String containing the attributes of a user object
     */
    @Override
    public String toString() {
        return "User {username: " + this.getUsername() + " password: " 
            + this.getPassword() + "}";
    }
    
    


}

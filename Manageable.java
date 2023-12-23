import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * This interface creates abstract methods that can be implemented in the 
 * User class.
 * 
 * @author ColinKula
 */
public interface Manageable {
                       
    /**
     * This method scans through a text file of users that are capable of logging in, 
     * and stores them into an array list of user objects.
     * 
     * @throws FileNotFoundException if a file is not found
     * @param users an ArrayList of users to be added to
     */
    public void storeAllUsers(ArrayList<User> users) throws FileNotFoundException;
    
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
    public User changeUser(String username, String password, ArrayList<User> users);
    
    /**
     * This method generates a parking report and updates the ParkingReport.txt
     * file with all the information pertaining to the parking manaegment system.
     */
    public void generateParkingReport();

    /**
     * This method creates a string representation of some object.
     * 
     * @return a Srinng represntation of some object
     */
    public String toString();
    
    /**
     * This method creates a clone of some object.
     * 
     * @return a clone of some object
     */
    public Object clone();
    
}

import java.util.ArrayList;

/**
 * This class creates parking lot objects which are used to hold parking spaces 
 * and perform actions related to the parking lot. 
 * 
 * @author ColinKula
 */
public class ParkingLot extends User {
        
    /**
     * The capacity variable holds the capcity of the parking lot.
     */
    public int capacity;
    
    /**
     * The spaces variable holds a list of all the parkingSpace objects that 
     *     are in the parkinglot.
     */
    public ArrayList<ParkingSpace> spaces;
    
    /**
     * This constructor creates an instance of the ParkingLot class and
     * initializes the capacity and spaces instance variables.
     * 
     * @param capacity an int used to initialize the capcity instance variable
     */
    public ParkingLot(int capacity) {
        super("Admin", "Password");
        this.capacity = capacity;
        spaces = new ArrayList<>(capacity);
        
        for (int i = 0; i < capacity - 5; i++) {
            spaces.add(new ParkingSpace(i + 1, false, false, 's'));
        }
        
        for (int i = 0; i < 5; i++) {
            spaces.add(new ParkingSpace(i + 1, false, false, 'l'));
        }
    }

    /**
     * This constructor creates an instance of the ParkingLot class based 
     * off of another ParkingLot's attributes.

     * @param ParkingLot a ParkingLot that is used to copy its instance variables
     */
    public ParkingLot(ParkingLot ParkingLot) {
        super(ParkingLot.getUsername(), ParkingLot.getPassword());
        this.capacity = ParkingLot.getCapacity();
        spaces = new ArrayList<>(ParkingLot.spaces.size());
        
        for (ParkingSpace space : ParkingLot.spaces) {
            spaces.add(new ParkingSpace(space));
        }
    }

    /**
     * This method gets the capacity of the current parking lot and returns 
     * its value.
     * 
     * @return an int that represents the capacity of the parking lot
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * This method finds the number of parking spaces in the parking lot that 
     * are not occupied and not on hold.
     * 
     * @return an in that represents the number of available spaces in the parking lot
     */
    public int getNumberOfAvailableSpaces() {
        int count = 0;
        for (ParkingSpace space : spaces) {
            if (!space.isOccupied() && !space.isHeld()) {
                count++;
            }
        }
        return count;
    }
    
    /**
     * This method creates a string representation of all the parking spaces 
     * in the parking lot.
     * 
     * @return a String that shows all of the available spaces in the parking lot
     */
    public String getAllSpecificAvailableSpaces() {
        String allSpaces = "";
        
        for (int i = 0; i < this.getCapacity(); i++) {
            if (i % 5 == 0) {
                allSpaces += "\n";
            }
            
            if (this.spaces.get(i).isOccupied()) {
                allSpaces += (i + 1) + " (" + this.spaces.get(i).getSize() + ") - occupied | ";
            } else if (this.spaces.get(i).isHeld()) {
                allSpaces += (i + 1) + " (" + this.spaces.get(i).getSize() + ") - on hold |";
            } else {
                allSpaces += (i + 1) + " (" + this.spaces.get(i).getSize() + ") - not occupied |";
            }
        }
       
        if (this.getNumberOfAvailableSpaces() == 0) {
            return "Try a new parking lot, this one is full.\n\n" + allSpaces;
        }
        return allSpaces;
    }

    /**
     * This method finds the next parking spot in the parking lot that is not occupuied 
     *     and not on hold.
     * 
     * @param size a char used to determine if a vehicle can fit in the next available 
     *     space
     * @return an int representing the next available space, and if there isnt an 
     *     available space -1 is returned 
     */
    public int getNextAvailableSpace(char size) {
        for (int i = 0; i < spaces.size(); i++) {
            if (!this.spaces.get(i).isOccupied() && !this.spaces.get(i).isHeld() 
                && this.spaces.get(i).ensureVehicleFits(size)) {
                return i;
            }
        }
        return -1;
    }
    
    /**
     * This method calculates the fees that need to be collected in the parking lot.
     * 
     * @return an int representing the fees due for the current parking lot
     */
    public int calculateFees() {
        return 5 * (this.getCapacity() - this.getNumberOfAvailableSpaces());        
    }
    
    /**
     * This method creates a clone of a ParkingLot object and returns its value.
     * 
     * @return a ParkingLot with the same attributes of the current ParkingLot object
     */
    public ParkingLot clone() {
        return new ParkingLot(this.getCapacity());
    }

    /**
     * This method creates a string representation of a ParkingLot object.
     * 
     * @return a String representation of a parking lot object 
     */
    public String toString() {
        return (this.getAllSpecificAvailableSpaces() + "\nThe capacity for this parking lot is: " 
            + this.getCapacity() + "\nThe total fees to collect from this parking lot is: " 
            + this.calculateFees() + "\n\n");
    }
    
}

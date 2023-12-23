/**
 * This class creates parking space objects which are used to hold vehicles and perform
 * actions related to the space. 
 * 
 * @author ColinKula
 */
public class ParkingSpace {
        
    /**
     * The spaceNumber variable holds the space number of the parking space.
     */
    public int spaceNumber;
    
    /**
     * The isOccupied variable determines if the parking space is occupied or not.
     */
    public boolean isOccupied;
    
    /**
     * The isHeld variable determines if the parking space is on hold or not.
     */
    public boolean isHeld;
    
    /**
     * The size variable holds the size of the parking space.
     */
    public char size = 's';

    /**
     * This constructor creates an instance of the ParkingSpace class and initializes
     * the spaceNumber, isOccupied, isHeld and size instance variables.
     * 
     * @param spaceNumber an int used to initialize the spaceNumber instance variable
     * @param isOccupied a boolean used to initialize the isOccupied instance variable
     * @param isHeld a boolean used to initialize the isHeld instance variable
     * @param size a char used to initialize the size instance variable
     */
    public ParkingSpace(int spaceNumber, boolean isOccupied, boolean isHeld, char size) {
        this.spaceNumber = spaceNumber;
        this.isOccupied = isOccupied;
        this.isHeld = isOccupied;
        this.size = size;
    }
   
    /**
     * This constructor creates an instance of the ParkingSpace class based 
     * off of another ParkingSpace's attributes.
     * 
     * @param space a ParkingSpace that is used to copy its instance variables
     */
    public ParkingSpace(ParkingSpace space) {
        this.spaceNumber = space.getSpaceNumber();
        this.isOccupied = space.isOccupied();
        this.isHeld = space.isHeld();
        this.size = space.getSize();
    }
    
    /**
     * This method gets the size of the current parking space and returns its value.
     * 
     * @return a char containing the size of the parking space
     */
    public char getSize() {
        return size;
    }
    
    /**
     * This method gets the size of the current parking space and returns its value.
     * 
     * @param size a char to set the size instacnce variable
     */
    public void setSize(char size) {
        this.size = size;
    }

    /**
     * This method gets the space number of the current parking space and returns 
     * its value.
     * 
     * @return an int representing the space number of the current parking space
     */
    public int getSpaceNumber() {
        return spaceNumber;
    }

    /**
     * This method gets the status of occupancy of the current parking space and 
     * returns its value.
     * 
     * @return a boolean that represents if the parking space is occupied 
     */
    public boolean isOccupied() {
        return isOccupied;
    }
    
    /**
     * This method sets the isOccupied instance variable to true.
     */
    public void occupy() {
        isOccupied = true;
    }

    /**
     * This method sets the isOccupied instance variable to false.
     */
    public void free() {
        isOccupied = false;
    }

    /**
     * This method gets the status of being held of the current parking space and 
     * returns its value.
     * 
     * @return a boolean that represents if the parking space is on hold
     */
    public boolean isHeld() {
        return isHeld;
    }

    /**
     * This method puts the current parking space on hold depending on occupancy
     * and available spaces left in the parking lot.
     * 
     * @param parkingLot a ParkingLot used to see if there are available spaces 
     *     and to access the spaces instance variable
     * @param spaceNumber an int used to determine which parking space is being held
     */
    public void holdSpace(ParkingLot parkingLot, int spaceNumber) {
        if (parkingLot.getNumberOfAvailableSpaces() == 0) {
            isHeld = false; 
        } else if (parkingLot.spaces.get(spaceNumber).isOccupied()) {
            parkingLot.spaces.get(spaceNumber).free();
            isHeld = true; 
        } else if (!parkingLot.spaces.get(spaceNumber).isOccupied()) {
            isHeld = true;
        }
    }
    
    /**
     * This method ensures the vehicle will fit in the parking space depending 
     * on the size of the vehicle.
     * 
     * @param size a char to be used to check if the vehicle fits in the parking space
     * @return a boolean that is true when the size of the vehicle matches or is smaller 
     *     than the size, and false in every other case
     */
    public boolean ensureVehicleFits(char size) {
        if (this.size == size || (this.size == 'm' && size == 's') 
            || (this.size == 'l' && size == 's') 
            || (this.size == 'l' && size == 'm')) {
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * This method parks a vehicle in an open parking space if it isnt on hold 
     * or already occupied.
     * 
     * @param size a char used to see if the vehicle will fit in the parking space
     * @param parkingLot a ParkingLot used to search for the next available space 
     *     and access the spaces variable
     * @return a boolean that is true when the vehivle cannot be parked and false 
     *     in all other cases
     */
    public boolean parkVehicle(char size, ParkingLot parkingLot) {
        int nextOpenSpot = parkingLot.getNextAvailableSpace(size);
        if (nextOpenSpot != -1) {
            parkingLot.spaces.get(nextOpenSpot).occupy();
            return false;
        } else {
            return true;
        }
    }

    /**
     * This method remove a vehicle from a specified space number. 
     * 
     * @param spaceNumber an int used to access the parking space a parking lot 
     * @param parkingLot a ParkingLot used to access the spaces variable
     */
    public void removeVehicle(int spaceNumber, ParkingLot parkingLot) {
        if (parkingLot.spaces.get(spaceNumber).isOccupied()) {
            parkingLot.spaces.get(spaceNumber).free();
        }
    }
    
    /**
     * This method creates a clone of a ParkingSpace object and returns its value.
     * 
     * @return a ParkingSpace with the same attributes of the current ParkingSpace object
     */
    public ParkingSpace clone() {
        return new ParkingSpace(this.getSpaceNumber(), this.isOccupied(), 
            this.isHeld(), this.getSize());
    }

    /**
     * This method creates a string representation of a ParkingSpace object.
     * 
     * @return a String representaion of a ParkingSpace object
     */
    public String toString() {
        return "ParkingSpace {space number: " + this.getSpaceNumber() 
            + " is occupied: " + this.isOccupied()+ " is held: " 
            + this.isHeld()+ " size: " + this.getSize() + "}";
    }
}

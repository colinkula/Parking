import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * This class creates the front end GUI for a parking lot management system. 
 * 
 * @author ColinKula
 */

public class FrontEnd {
        
    /**
     * The parkingReportButton creates a button that generates a parking report. 
     */
    public static JButton parkingReportButton 
        = new JButton("Generate Parking Report");
    
    /**
     * The parkVehicleButton creates a button that parks a vehicle. 
     */
    public static JButton parkVehicleButton 
        = new JButton("Park Vehicle: Specify the size of vehivle (s, m, l) ->");
    
    /**
     * The removeVehicleButton creates a button that removes a vehicle. 
     */
    public static JButton removeVehicleButton 
        = new JButton("Remove vehicle from parking space: Specify which parking space number ->");
    
    /**
     * The trackCapacityButton creates a button that finds the current capacity. 
     */
    public static JButton trackCapacityButton 
        = new JButton("Find Current Capacity");
    
    /**
     * The availableSpacesButton creates a button that lets the user view the current parking lot. 
     */
    public static JButton availableSpacesButton 
        = new JButton("View Parking Status");
    
    /**
     * The calculateFeesButton creates a button that finds the total fees due. 
     */
    public static JButton calculateFeesButton 
        = new JButton("Calculate Total Fees to Collect");
    
    /**
     * The resetPasswordButton creates a button that resets the users password. 
     */
    public static JButton resetPasswordButton 
        = new JButton("Reset password");
    
    /**
     * The changeUserButton creates a button that changes the current user. 
     */
    public static JButton changeUserButton 
        = new JButton("Change User");
    
    /**
     * The holdSpaceButton creates a button that holds a parking space. 
     */
    public static JButton holdSpaceButton 
        = new JButton("Hold parking space until parking lot is full: Specify which parking space number ->");
    
    /**
     * The loginButton creates a button that lets the user login. 
     */
    public static JButton loginButton 
        = new JButton("Login");
    
    /**
     * The changeParkingLotButton creates a button that creates a new parking lot. 
     */
    public static JButton changeParkingLotButton 
        = new JButton("Change Parking Lot");
    
    /**
     * The answerField creates a text field that holds input from the user.
     */
    public static JTextField answerField = new JTextField(5);
    
    /**
     * The answerField2 creates a text field that holds input from the user.
     */
    public static JTextField answerField2 = new JTextField(5);
    
    /**
     * The answerField3 creates a text field that holds input from the user.
     */
    public static JTextField answerField3 = new JTextField(5);
    
    /**
     * The usernameField creates a text field that holds input from the user.
     */
    public static JTextField usernameField = new JTextField(20);
    
    /**
     * The passwordField creates a text field that holds input from the user.
     */
    public static JTextField passwordField = new JPasswordField(20);

    /**
     * The usernameLabel creates a label that displays "Username: ".
     */
    public static JLabel usernameLabel = new JLabel("Username:");
    
    /**
     * The passwordLabel creates a label that displays "Password: ".
     */
    public static JLabel passwordLabel = new JLabel("Password:");
    
    /**
     * The resultLabel creates a label to be updated.
     */
    public static JLabel resultLabel = new JLabel();
    
    /**
     * The resultLabel creates a label to be updated.
     */
    public static JLabel outputLabel = new JLabel();
        
    /**
     * The currentParkingLot variable stores a specific instance of the PrkingLot class.
     */
    public static ParkingLot currentParkingLot;
    
    /**
     * The currentUser variable stores a specific instance of the User class.
     */
    public static User currentUser;
    
    /**
     * The users variable stores a list of all the users that are able to login to the program.
     */
    public static ArrayList<User> users;
    
    /**
     * This main method creates an instance of a FrontEnd object and calls the
     * startApplication method which launches the creates.
     * 
     * @param args an array of command-line arguments for the application
     */
    public static void main(String[] args) {
        FrontEnd frontEnd = new FrontEnd();
        frontEnd.startApplication();
    }

    /**
     * This constructor creates an instance of the FrontEnd class and initializes 
     * the currentUser, currentParkingLot and users variables.
     */
    public FrontEnd() {
        currentUser = new User("Admin","Password");
        currentParkingLot = new ParkingLot(25);
        users = new ArrayList<User>();
    }
    
    /**
     * This method creates the login screen and allows the user to login with their credentials.
     */
    public static void startApplication() {
        JFrame loginFrame = new JFrame("Welcome to our Parking System");
        JPanel loginPanel = new JPanel();
        setScreen(350, 200, loginFrame, loginPanel, true);
        constructLoginFeatures(loginPanel);           
        implementLoginButton(loginPanel);
        implementResetPasswordButton(loginPanel);
        loginFrame.setVisible(true);        
    }
    
    
    
    /**
     * This method displays the home screen after the user successfully logs in. 
     */
    public static void dislpayHome() {
        JFrame homeFrame = new JFrame("Home");
        JPanel mainPanel = new JPanel();
                
        setScreen(800, 700, homeFrame, mainPanel, true);
        constructHomeScreenFeatures(mainPanel);
        implementAllHomeFeatures(mainPanel, homeFrame);
    }
        
    /**
     * This method sets the attributes of a specific JFrame and JPanel.
     * 
     * @param width an int holding the width of the screen
     * @param height an int holding the height of the screen 
     * @param frame a JFrame to be adjusted
     * @param panel a JPanel to be adjusted
     * @param visible a boolean specify the visibility
     */
    public static void setScreen(int width, int height, JFrame frame, JPanel panel, boolean visible) {
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(visible);
        frame.setResizable(false);
        frame.add(panel);
        panel.setLayout(null);
    }
    
    /**
     * This method sets the boundaries and adds specific login 
     * JComponent objects to the login panel.
     * 
     * @param panel a JPanel to be adjusted
     */
    public static void constructLoginFeatures(JPanel panel) {
        usernameLabel.setBounds(10, 20, 80, 25);
        panel.add(usernameLabel);
        
        usernameField.setBounds(100, 20, 165, 25);
        panel.add(usernameField);
        
        passwordLabel.setBounds(10, 50, 80, 25);
        panel.add(passwordLabel);
        
        passwordField.setBounds(100, 50, 165, 25);
        panel.add(passwordField);

        resultLabel.setBounds(10, 125, 340, 25);
        panel.add(resultLabel);
    }
    
    /**
     * This method sets the boundaries and adds specific home screen 
     * JComponent objects to the home screen panel.
     * 
     * @param panel a JPanel to be adjusted
     */
    public static void constructHomeScreenFeatures(JPanel panel) {
        outputLabel.setBounds(200, 50, 400, 25);
        panel.add(outputLabel);
        
        answerField.setBounds(675, 200, 50, 50);
        panel.add(answerField);
        
        answerField2.setBounds(675, 275, 50, 50);
        panel.add(answerField2);
        
        answerField3.setBounds(675, 350, 50, 50);
        panel.add(answerField3);
                
    }
    
    /**
     * This method implements the parkingReportButton and implements its corresponding
     * actionPerformed method so that it can generate a parking report.
     * 
     * @param panel a JPanel to be adjusted
     */
    public static void implementParkingReportButton(JPanel panel) {
        parkingReportButton.setBounds(50, 425, 600, 50);
        panel.add(parkingReportButton);
        
        parkingReportButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                currentUser.parkingLots.add(currentParkingLot);
                currentUser.generateParkingReport();
                
            }
        });
    }
    
    /**
     * This method implements the trackCurrentCapacity button and implements its corresponding 
     * actionPerformed method so that it can set the outputLabel with information regarding 
     * the current capacity.
     * 
     * @param panel a JPanel to be adjusted
     */
    public static void implementCurentCapacityButton(JPanel panel) {
        trackCapacityButton.setBounds(50, 500, 175, 50);
        panel.add(trackCapacityButton);
        
        trackCapacityButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                outputLabel.setText("The current capacity of this parking lot is: "
                    + currentParkingLot.getCapacity());
            }
        }); 
    }
    
    /**
     * This method implements the calculateFeesButton and implements its corresponding
     * actionPerformed method so that it can set the outputLabel with the information
     * regarding the total fees needed to be collected.
     * 
     * @param panel a JPanel to be adjusted
     */
    public static void implementTotalFeesButton(JPanel panel) {
        calculateFeesButton.setBounds(250, 500, 250, 50);
        panel.add(calculateFeesButton);
        
        calculateFeesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                outputLabel.setText("The total fees needed to be collected adds up to: $"
                    + currentParkingLot.calculateFees());
            }
        });

    }
    
    /**
     * This method implements the parkVehicleButton and implements its corresponding
     * actionPerformed method so that a vehicle can be added to a parking space.
     * 
     * @param panel a JPanel to be adjusted
     * @param frame a JFrame to be adjusted
     */
    public static void implementParkVehicleButton(JPanel panel, JFrame frame) {
        parkVehicleButton.setBounds(50, 350, 600, 50);
        panel.add(parkVehicleButton);
        
        parkVehicleButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                char size;
                if (!answerField3.getText().equals("")) {
                    size = answerField3.getText().charAt(0);
                    if (currentParkingLot.spaces.get(currentParkingLot.getNextAvailableSpace(size)).parkVehicle(size, currentParkingLot)) {
                        outputLabel.setText("There are no available spaces left for this vehicle, try another parking lot.");
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "Type the size of the vehivle in the textbox (s - small, m - medium, l - large) and try again.");     
                }
            }
        });
    }
    
    /**
     * This method implements the availableSpacesButton and implements its corresponding
     * actionPerformed method so that it can set the output label and open a JOptionPane 
     * containing the status of the parking lot. 
     * 
     * @param panel a JPanel to be adjusted
     * @param frame a JFrame to be adjusted
     */
    public static void implementParkingStatusButton(JPanel panel, JFrame frame) {
        availableSpacesButton.setBounds(250, 125, 175, 50);
        panel.add(availableSpacesButton);
        
        availableSpacesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {               
                outputLabel.setText("The number of available parking spaces is: "
                    + currentParkingLot.getNumberOfAvailableSpaces());
                
                JOptionPane.showMessageDialog(frame, currentParkingLot.getAllSpecificAvailableSpaces());     
            }
        });
    }
    
    /**
     * This method implements the changeUserButton and implements its corresponding
     * actionPerformed method so that the start application method can be called.
     * 
     * @param panel a JPanel to be adjusted
     * @param frame a JFrame to be adjusted
     */
    public static void implementChangeUserButton(JPanel panel, JFrame frame) {
        changeUserButton.setBounds(450, 125, 175, 50);
        panel.add(changeUserButton);

        changeUserButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                
                startApplication();
            }
        });
    }
    
    /**
     * This method implements the removeVehicleButton and implements its corresponding
     * actionPerformed method so that a vehicle can be removed from a parking space;
     * 
     * @param panel a JPanel to be adjusted
     * @param frame a JFrame to be adjusted
     */
    public static void implementRemoveVehicleButton(JPanel panel, JFrame frame) {
        removeVehicleButton.setBounds(50, 200, 600, 50);
        panel.add(removeVehicleButton);
        
        removeVehicleButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!answerField.getText().equals("")) {
                    currentParkingLot.spaces.get(Integer.parseInt(answerField.getText()) - 1).removeVehicle(Integer.parseInt(answerField.getText()) - 1, currentParkingLot);
                } else {
                    JOptionPane.showMessageDialog(frame, "Type which parking space number you would like to remove in the textbox and try again.");     
                }
            }
        });
    }
    
    /**
     * This method implements the loginButton and implements its corresponding
     * actionPerformed method so that it can verify the login information 
     * put in by the user.
     * 
     * @param panel a JPanel to be adjusted
     */
    public static void implementLoginButton(JPanel panel) {
        loginButton.setBounds(75, 90, 80, 25);
        panel.add(loginButton);

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (users.isEmpty()) {
                    try {
                        currentUser.storeAllUsers(users);
                    } catch (Exception f) {
                        f.printStackTrace();
                    }
                }
                String user = usernameField.getText();
                String pass = passwordField.getText();
                if (currentUser.checkUserAndPass(user, pass, users)) {
                    currentUser = currentUser.changeUser(user, pass, users);
                    dislpayHome();
                } 
            }
        });
    }
    
    /**
     * This method implements the resetPasswordButton and implements its corresponding
     * actionPerformed method that changes the current users password and sets the 
     * outputLabel with the information regarding the new password.
     * 
     * @param panel a JPanel to be adjusted
     */
    public static void implementResetPasswordButton(JPanel panel) {
        resetPasswordButton.setBounds(150, 90, 150, 25);
        panel.add(resetPasswordButton);
        
        resetPasswordButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resultLabel.setText("New password: \"" + currentUser.resetPassword() 
                    + "\" for user " + currentUser.getUsername());
            }
        });
    }
    
    /**
     * This method implements the holdSpaceButton and implements its corresponding
     * actionPerformed method so that it can put a specific parking space on hold.
     * 
     * @param panel a JPanel to be adjusted
     * @param frame a JFrame to be adjusted
     */
    public static void implementHoldSpaceButton(JPanel panel, JFrame frame) {
        holdSpaceButton.setBounds(50, 275, 600, 50);
        panel.add(holdSpaceButton);

        holdSpaceButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (answerField2.getText().equals("")) {
                    JOptionPane.showMessageDialog(frame, "Type which parking space number you would like to reserve in the textbox and try again.");     
                } else {
                    int currentSpace = Integer.parseInt(answerField2.getText());
                    currentParkingLot.spaces.get(currentSpace - 1).holdSpace(currentParkingLot, currentSpace);
                }

            }
        });
    }
    
    /**
     * This method implements the changeParkingLotButton and implements its corresponding
     * actionPerformed method so that it can add the current parking lot to an array list  
     * of parking lots and create a new parking lot to be used.
     *  
     * @param panel a JPanel to be adjusted
     */
    public static void implementChangeParkingLotButton(JPanel panel) {
        changeParkingLotButton.setBounds(50, 125, 175, 50);
        panel.add(changeParkingLotButton);
        
        changeParkingLotButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!(currentUser.parkingLots == null)) {
                    currentUser.parkingLots.add(currentParkingLot);
                }
                currentParkingLot = new ParkingLot(25);
            }
        });
    }

    /**
     * This method implements all of the buttons to the home screen panel.
     * 
     * @param panel a JPanel to be adjusted
     * @param frame a JFrame to be adjusted
     */
    public static void implementAllHomeFeatures(JPanel panel, JFrame frame) {
       implementParkingReportButton(panel);    
       implementParkVehicleButton(panel, frame);
       implementRemoveVehicleButton(panel, frame);
       implementCurentCapacityButton(panel);
       implementParkingStatusButton(panel, frame);
       implementTotalFeesButton(panel);
       implementChangeUserButton(panel, frame);    
       implementHoldSpaceButton(panel, frame);
       implementChangeParkingLotButton(panel);
   }       
}


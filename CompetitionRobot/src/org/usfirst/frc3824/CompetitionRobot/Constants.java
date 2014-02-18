package org.usfirst.frc3824.CompetitionRobot;

/**
 * Put any important constants here.
 */
public class Constants {
    /* Contants which might require tuning */

    public final static double DrivetrainAngleGyroControllerP = 0.04;
    public final static double DrivetrainAngleGyroControllerI = 0.004;
    public final static double DrivetrainAngleGyroControllerD = 0.04;

    // Cypress IO defines
    public final static int ANALOG_AUXILIARY_ANGLE = 1; // Pot input channel
    public final static int ANALOG_SHOOTER_ADJUST_PID = 2; // Pot input channel
    public final static int INPUT_PICKUP_IN = 10; // Double toggle
    public final static int INPUT_PICKUP_OUT = 1; // Double toggle
    public final static int INPUT_VACUUM_TOGGLE = 4; // Toggle switch
    public final static int INPUT_CANNON_SHOOT = 11; // Button
    public final static int INPUT_SHOOTER_ANGLE_ADJUSTMENT_MANUAL = 7; // Toggle switch
    public final static int SHOOTER_ANGLE_SHOOT = 16; // Button
    public final static int SHOOTER_ANGLE_PASS = 3; // Button
    public final static int SHOOTER_ANGLE_PICKUP = 8; // Button
    public final static int SHOOTER_ANGLE_CORNER = 14; // Button
    public final static int SHOOTER_ANGLE_ANGLED_CORNER = 12; // Button
    public final static int SHOOTER_ANGLE_START = 13; // Button
    public final static int AUXILIARY_ANGLE_CONTROL = 5; // Toggle switch
    public final static int INPUT_BALL_TRANSFER = 6;  // Button
    public final static int INPUT_HOME_POSITION = 15; // Button
    
    //------------------------------
    // Camera related values
    public final static double CAMERA_STARTUP_TIMEOUT = 5.0;
    
    //------------------------------
    // Autonomous configurations
    public final static double AUTONOMOUS_TIME_TO_HOT_GOAL_SWITCH = 5.0;    // Hot goal switches at 5.0 seconds into the game
    
    // Drive straight and shoot configuration values
    public final static double AUTONOMOUS_STRAIGHT_DRIVE_TIME = 1.6; 
    public final static double AUTONOMOUS_STRAIGHT_DRIVER_POWER = 0.5;
    public final static double AUTONOMOUS_STRAIGHT_DRIVE_ANGLE = 0.0;
    /**
     * **** SHOOTER POSITION *****
     */
    // Note: The shooter angle is greater than possible to ensure the new shooter 
    //       can move the full range (after the slope and y-intercept have been 
    //       recalibrated)
    public final static double SHOOTER_ANGLE_MAX_VALUE = 50.0;    // 850.0  - 45.848
    public final static double SHOOTER_ANGLE_MIN_VALUE = 10.0;    //   0.0  - 17.203
    
    public final static double SHOOTER_PICKUP_POSITION = 10.2;
    public final static double SHOOTER_PASS_POSITION = 18.379;
    public final static double SHOOTER_LONG_SHOT_POSITION = 36.1;
    public final static double SHOOTER_CORNER_POSITION = 37.071;
    public final static double SHOOTER_ANGLED_CORNER_POSITION = 38.232;
    public final static double SHOOTER_START_POSITION = 45;
    
    public final static double TURN_THRESHOLD = 1.5; //works with 1 but is a bit slow
    
    //------------------------------
    // Auxiliary Shooter
    
    // Motor angle constants
    public final static double AUX_MIN_ANGLE = -90.0;   // 90 degrees below horizontal
    public final static double AUX_MAX_ANGLE = 90.0;    // 90 degrees above horizontal
    public final static double AUX_MIN_ANGLE_ADCVAL = 100;  // value read from the ADC of the POT
    public final static double AUX_MAX_ANGLE_ADCVAL = 800;  // value read from the ADC of the POT
    public final static double AUX_TRANSFER_ANGLE = 90.0;   // value for ball transfer
    
    // Home position constants
    public final static double SHOOTER_HOME_POSITION = 50.0; // degree
    public final static double AUX_HOME_POSITION = 180.0; // degree
    
}

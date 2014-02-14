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

    /**
     * **** SHOOTER POSITION *****
     */
    // Note: The shooter angle is greater than possible to ensure the new shooter 
    //       can move the full range (after the slope and y-intercept have been 
    //       recalibrated)
    public final static double SHOOTER_ANGLE_MAX_VALUE = 50.0;    // 850.0  - 45.848
    public final static double SHOOTER_ANGLE_MIN_VALUE = 10.0;    //   0.0  - 17.203
    
    public final static double SHOOTER_PICKUP_POSITION = 13.5;
    public final static double SHOOTER_PASS_POSITION = 18.379;
    public final static double SHOOTER_LONG_SHOT_POSITION = 36.1;
    public final static double SHOOTER_CORNER_POSITION = 37.071;
    public final static double SHOOTER_ANGLED_CORNER_POSITION = 38.232;
    public final static double SHOOTER_START_POSITION = 45;
}

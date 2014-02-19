package org.usfirst.frc3824.CompetitionRobot;

/**
 * Put any important constants here.
 */
public class Constants {
    /* Contants which might require tuning */

    public final static double DrivetrainAngleGyroControllerP = 0.04;
    public final static double DrivetrainAngleGyroControllerI = 0.004;
    public final static double DrivetrainAngleGyroControllerD = 0.04;

    // ===================================================
    // Cypress IO defines
    // ===================================================
    /** Cypress IO Define.
     *  <br> Analog 1
     *  <br> Potentiometer. Used to change the auxiliary arm motor angle.
     */
    public final static int ANALOG_AUXILIARY_ANGLE = 1;
    /** Cypress IO Define.
     *  <br> Analog 2
     *  <br> Potentiometer. Used to change the shooter angle.
     */
    public final static int ANALOG_SHOOTER_ADJUST_PID = 2; 
    /** Cypress IO Define.
     *  <br> Digital 10
     *  <br> Double Toggle. 
     *  <p> This is used to define the pickup in command.
     */
    public final static int INPUT_PICKUP_IN = 10; // Double toggle
    /** Cypress IO Define.
     *  <br> Digital 1
     *  <br> Double Toggle.
     *  <p> This is used to define the pickup out command.
     */
    public final static int INPUT_PICKUP_OUT = 1; // Double toggle
    /** Cypress IO Define.
     *  <br> Digital 4
     *  <br> Toggle Switch.
     */
    public final static int INPUT_VACUUM_TOGGLE = 4; // Toggle switch
    /** Cypress IO Define.
     *  <br> Digital 11
     *  <br> Button.
     */
    public final static int INPUT_CANNON_SHOOT = 11; // Button
    /** Cypress IO Define.
     *  <br> Digital 7
     *  <br> Toggle Switch.
     */
    public final static int INPUT_SHOOTER_ANGLE_ADJUSTMENT_MANUAL = 7; // Toggle switch
    /** Cypress IO Define.
     *  <br> Digital 16
     *  <br> Button.
     */
    public final static int SHOOTER_ANGLE_SHOOT = 16; // Button
    /** Cypress IO Define.
     *  <br> Digital 3
     *  <br> Button.
     */
    public final static int SHOOTER_ANGLE_PASS = 3; // Button
    /** Cypress IO Define.
     *  <br> Digital 8
     *  <br> Button
     */
    public final static int SHOOTER_ANGLE_PICKUP = 8; // Button
    /** Cypress IO Define.
     *  <br> Digital 14
     *  <br> Button.
     */
    public final static int SHOOTER_ANGLE_CORNER = 14; // Button
    /** Cypress IO Define.
     *  <br> Digital 12
     *  <br> Button.
     */
    public final static int SHOOTER_ANGLE_ANGLED_CORNER = 12; // Button
    /** Cypress IO Define.
     *  <br> Digital 13
     *  <br> Button.
     */
    public final static int SHOOTER_ANGLE_START = 13; // Button
    /** Cypress IO Define.
     *  <br> Digital 5
     *  <br> Toggle Switch.
     */
    public final static int AUXILIARY_ANGLE_CONTROL = 5; // Toggle switch
    /** Cypress IO Define.
     *  <br> Digital 6
     *  <br> Button.
     */
    public final static int INPUT_BALL_TRANSFER = 6;  // Button
    /** Cypress IO Define.
     *  <br> Digital 15
     *  <br> Button.
     */
    public final static int INPUT_HOME_POSITION = 15; // Button
    
   
    /** Camera related value.
     *  <p> Start up timeout.
     */
    public final static double CAMERA_STARTUP_TIMEOUT = 5.0;
    
    //------------------------------
    // Autonomous configurations
    public final static double AUTONOMOUS_TIME_TO_HOT_GOAL_SWITCH = 5.0;    // Hot goal switches at 5.0 seconds into the game
    
    // Drive straight and shoot configuration values
    /** Autonomous Straight Drive
     * <p> Straight Drive Time</p>
     */
    public final static double AUTONOMOUS_STRAIGHT_DRIVE_TIME = 1.6; 
    /** Autonomous Straight Drive
     * <p> Straight Drive Power </p>
     */
    public final static double AUTONOMOUS_STRAIGHT_DRIVER_POWER = 0.5;
    /** Autonomous Straight Drive
     * <p> Straight Drive Angle </p>
     */
    public final static double AUTONOMOUS_STRAIGHT_DRIVE_ANGLE = 0.0;
    
    /*
     * **** SHOOTER POSITION *****
     */
    // Note: The shooter angle is greater than possible to ensure the new shooter 
    //       can move the full range (after the slope and y-intercept have been 
    //       recalibrated)
    
    /** Shooter Angle Value.
     * <p> Maximum Value
     */
    public final static double SHOOTER_ANGLE_MAX_VALUE = 100.0;    // 850.0  - 45.848   50
    /** Shooter Angle Value.
     * <p> Minimum Value </p>
     */
    public final static double SHOOTER_ANGLE_MIN_VALUE = -25.0;    //   0.0  - 17.203   10
    
    /** Shooter Position.
     * <p> Max Value </p>
     */
    public final static double SHOOTER_PICKUP_POSITION = -13.6;     // 13.85
    public final static double SHOOTER_PASS_POSITION = 23;
    public final static double SHOOTER_REGULAR_SHOT_POSITION = 66;
    public final static double SHOOTER_CORNER_POSITION = 40;
    public final static double SHOOTER_ANGLED_CORNER_POSITION = 40;
    public final static double SHOOTER_START_POSITION = 96;
    public final static double SHOOTER_TRANSFER_POSITION = 96;
    
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
    public final static double SHOOTER_HOME_POSITION = 45.0; // degree
    public final static double AUX_HOME_POSITION = 180.0; // degree
    
}

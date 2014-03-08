package org.usfirst.frc3824.CompetitionRobot;

/**
 * Put any important constants here.
 */
public class Constants
{
    /* Contants which might require tuning */
    public final static double DrivetrainAngleGyroControllerP = 0.04;
    public final static double DrivetrainAngleGyroControllerI = 0.004;
    public final static double DrivetrainAngleGyroControllerD = 0.04;

    public final static double DrivetrainAngleGyroControllerTurnP = 0.005;
    public final static double DrivetrainAngleGyroControllerTurnI = 0.00005;
    public final static double DrivetrainAngleGyroControllerTurnD = 0.0004;

    public final static double TURN_THRESHOLD = 1.5; //works with 1 but is a bit slow    

    public final static double CANNON_SHOOT_TIME = 0.75;
    public final static double WAIT_FOR_VACUUM_AUTONOMOUS_TIME = 1.0;
    
    // ===================================================
    // Cypress IO defines - Analog Inputs
    // ===================================================
    /**
     * <b><u>Cypress IO Define</u></b>
     * <p>
     * Analog 1
     * <br> Potentiometer.
     * <p>
     * Used to change the auxiliary arm motor angle.
     */
    public final static int ANALOG_AUXILIARY_ANGLE = 1;
    /**
     * <b><u>Cypress IO Define</u></b>
     * <p>
     * Analog 2
     * <br> Potentiometer.
     * <p>
     * Used to change the shooter angle.
     */
    public final static int ANALOG_SHOOTER_ADJUST_PID = 2;

    // ===================================================
    // Cypress IO defines - Digital Inputs
    // ===================================================  
    /**
     * <b><u>Cypress IO Define</u></b>
     * <p>
     * Digital 1
     * <br> Double Toggle.
     * <p>
     * This is used to define the pickup out command.
     */
    public final static int INPUT_PICKUP_OUT = 1; // Double toggle
    /**
     * <b><u>Cypress IO Define</u></b>
     * <p>
     * Digital 3
     * <br> Button.
     */
    public final static int SHOOTER_ANGLE_PASS = 3; // Button    
    /**
     * <b><u>Cypress IO Define</u></b>
     * <p>
     * Digital 4
     * <br> Toggle Switch.
     */
    public final static int INPUT_VACUUM_TOGGLE = 4; // Toggle switch
    /**
     * <b><u>Cypress IO Define</u></b>
     * <p>
     * Digital 5
     * <br> Toggle Switch.
     */
    public final static int AUXILIARY_ANGLE_CONTROL = 5; // Toggle switch  
    /**
     * <b><u>Cypress IO Define</u></b>
     * <p>
     * Digital 6
     * <br> Button.
     */
    public final static int INPUT_BALL_TRANSFER = 6;  // Button    
    /**
     * <b><u>Cypress IO Define</u></b>
     * <p>
     * Digital 7
     * <br> Toggle Switch.
     */
    public final static int INPUT_SHOOTER_ANGLE_ADJUSTMENT_MANUAL = 7; // Toggle switch 
    /**
     * <b><u>Cypress IO Define</u></b>
     * <p>
     * Digital 8
     * <br> Button
     */
    public final static int SHOOTER_ANGLE_PICKUP = 8; // Button    
    /**
     * <b><u>Cypress IO Define</u></b>
     * <p>
     * Digital 10
     * <br> Double Toggle.
     * <p>
     * This is used to define the pickup in command.
     */
    public final static int INPUT_PICKUP_IN = 10; // Double toggle    
    /**
     * <b><u>Cypress IO Define</u></b>
     * <p>
     * Digital 11
     * <br> Button.
     */
    public final static int SHOOTER_ANGLE_LOW_GOAL = 11; // Button
    /**
     * <b><u>Cypress IO Define</u></b>
     * <p>
     * Digital 12
     * <br> Button.
     */
    public final static int SHOOTER_ANGLE_ANGLED_CORNER = 12; // Button
    /**
     * <b><u>Cypress IO Define</u></b>
     * <p>
     * Digital 13
     * <br> Button.
     */
    public final static int SHOOTER_ANGLE_START = 13; // Button    
    /**
     * <b><u>Cypress IO Define</u></b>
     * <p>
     * Digital 14
     * <br> Button.
     */
    public final static int SHOOTER_ANGLE_CORNER = 14; // Button
    /**
     * <b><u>Cypress IO Define</u></b>
     * <p>
     * Digital 15
     * <br> Button.
     */
    public final static int INPUT_HOME_POSITION = 15; // Button    
    /**
     * <b><u>Cypress IO Define</u></b>
     * <p>
     * Digital 16
     * <br> Button.
     */
    public final static int SHOOTER_ANGLE_SHOOT = 16; // Button

    // ===================================================
    // Auxiliary Shooter
    // Motor angle constants
    // ===================================================
    /**
     * <b><u>Auxiliary Arm Angle</u></b>
     * <p>
     * Minimum Angle</p>
     */
    public final static double AUX_MIN_ANGLE = -90.0;   // 90 degrees below horizontal
    /**
     * <b><u>Auxiliary Arm Angle</u></b>
     * <p>
     * Maximum Angle</p>
     */
    public final static double AUX_MAX_ANGLE = 90.0;    // 90 degrees above horizontal
    /**
     * <b><u>Home Position</u></b>
     * <p>
     * Auxiliary Home Position</p>
     */
    public final static double AUX_HOME_POSITION = 180.0; // degree

    // ADC Auxiliary constants
    public final static double AUX_ADC_PICKUP_POSITION = 600.0;
    public final static double AUX_ADC_PLACE_POSITION = 350.0;    
    /**
     * <b><u>Auxiliary Arm Angle</u></b>
     * <p>
     * Minimum ADC Value</p>
     */
    public final static double AUX_MIN_ANGLE_ADCVAL = 100;  // value read from the ADC of the POT
    /**
     * <b><u>Auxiliary Arm Angle</u></b>
     * <p>
     * Maximum ADC Value</p>
     */
    public final static double AUX_MAX_ANGLE_ADCVAL = 800;  // value read from the ADC of the POT
    /**
     * <b><u>Auxiliary Arm Angle</u></b>
     * <p>
     * Transfer Angle</p>
     */
    public final static double AUX_TRANSFER_ANGLE = 90.0;   // value for ball transfer
    /**
     * <b><u>Shooter Position</u></b>
     * <p>
     * Ball Transfer Position. This is used with the BallTransferAuxtoMain
     * command. </p>
     */
    public final static double SHOOTER_TRANSFER_POSITION = 96;

    // ===================================================
    // Camera Related
    // ===================================================      
    /**
     * <b><u>Camera Related Value</u></b>
     * <p>
     * Startup timeout.
     */
    public final static double CAMERA_STARTUP_TIMEOUT = 180.0;
    
    public final static int HUE_MIN = 60;
    public final static int HUE_MAX = 128;
    public final static int SATURATION_MIN = 100;
    public final static int SATURATION_MAX = 255;
    public final static int VALUE_MIN = 90;
    public final static int VALUE_MAX = 200;

    // ===================================================
    // Autonomous configurations
    // ===================================================
    public final static double AUTONOMOUS_TIME_TO_HOT_GOAL_SWITCH = 5.0;    // Hot goal switches at 5.0 seconds into the game

    // Drive straight and shoot configuration values
    /**
     * <b><u>Autonomous Straight Drive</u></b>
     * <p>
     * Straight Drive Time</p>
     */
    public final static double AUTONOMOUS_STRAIGHT_DRIVE_TIME = 1.8;
    /**
     * <b><u>Autonomous Straight Drive</u></b>
     * <p>
     * Straight Drive Power </p>
     */
    public final static double AUTONOMOUS_STRAIGHT_DRIVER_POWER = 0.5;
    /**
     * <b><u>Autonomous Straight Drive</u></b>
     * <p>
     * Straight Drive Angle </p>
     */
    public final static double AUTONOMOUS_STRAIGHT_DRIVE_ANGLE = 0.0;

    // ===================================================
    // Shooter Positions
    // ===================================================    
    // Note: The shooter angle is greater than possible to ensure the new shooter 
    //       can move the full range (after the slope and y-intercept have been 
    //       recalibrated)
    /**
     * <b><u>Shooter Angle Value</b></u>
     * <p>
     * Maximum Value
     */
    public final static double SHOOTER_ANGLE_MAX_VALUE = 100.0;    // 850.0  - 45.848   50
    /**
     * <b><u>Shooter Angle Value</b></u>
     * <p>
     * Minimum Value </p>
     */
    public final static double SHOOTER_ANGLE_MIN_VALUE = -25.0;    //   0.0  - 17.203   10
    /**
     * <b><u>Shooter Position</u></b>
     * <p>
     * Pickup </p>
     */
    public final static double SHOOTER_PICKUP_POSITION = -13.6;
    /**
     * <b><u>Shooter Position</u></b>
     * <p>
     * Passing </p>
     */
    public final static double SHOOTER_PASS_POSITION = 23;
    /**
     * <b><u>Shooter Position</u></b>
     * <p>
     * Regular Shot </p>
     */
    public final static double SHOOTER_REGULAR_SHOT_POSITION = 63;
    /**
     * <b><u>Shooter Position</u></b>
     * <p>
     * Corner Shot </p>
     */
    public final static double SHOOTER_CORNER_POSITION = 76;
    /**
     * <b><u>Shooter Position</u></b>
     * <p>
     * Angled Corner Shot </p>
     */
    public final static double SHOOTER_ANGLED_CORNER_POSITION = 40;
    /**
     * <b><u>Shooter Position</u></b>
     * <p>
     * Start Position </p>
     */
    public final static double SHOOTER_VERTICAL_POSITION = 96.5;

    
    public final static double SHOOTER_LOW_GOAL_POSITION = 0.0;
}

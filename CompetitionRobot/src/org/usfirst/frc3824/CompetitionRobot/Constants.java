package org.usfirst.frc3824.CompetitionRobot;

/**
 * Put any important constants here.
 */
public class Constants
{
    /* Contants which might require tuning */
    public final static double DrivetrainAngleGyroControllerP     = 0.04;
    public final static double DrivetrainAngleGyroControllerI     = 0.004;
    public final static double DrivetrainAngleGyroControllerD     = 0.04;

    public final static double DrivetrainAngleGyroControllerTurnP = 0.005;
    public final static double DrivetrainAngleGyroControllerTurnI = 0.00005;
    public final static double DrivetrainAngleGyroControllerTurnD = 0.0004;

    public final static double TURN_THRESHOLD    = 1.5; //works with 1 but is a bit slow    

    public final static double CANNON_SHOOT_TIME = 0.75;
    
    public final static double WAIT_FOR_VACUUM_AUTONOMOUS_TIME = 1.0;
    
    // ===================================================
    // Cypress IO defines - Analog Inputs
    // ===================================================
    public final static int ANALOG_SHOOTER_ADJUST_PID = 2;

    // ===================================================
    // Cypress IO defines - Digital Inputs
    // =================================================== 
    public final static int INPUT_PICKUP_OUT                      =  1; // Double toggle
    public final static int SHOOTER_ANGLE_PASS                    =  3; // Button    
    public final static int INPUT_VACUUM_TOGGLE                   =  4; // Toggle switch
    public final static int INPUT_BALL_TRANSFER                   =  6;  // Button    
    public final static int INPUT_SHOOTER_ANGLE_ADJUSTMENT_MANUAL =  7; // Toggle switch 
    public final static int SHOOTER_ANGLE_PICKUP                  =  8; // Button    
    public final static int INPUT_PICKUP_IN                       = 10; // Double toggle    
    public final static int SHOOTER_ANGLE_LOW_GOAL                = 11; // Button
    public final static int SHOOTER_ANGLE_ANGLED_CORNER           = 12; // Button
    public final static int SHOOTER_ANGLE_START                   = 13; // Button    
    public final static int SHOOTER_ANGLE_CORNER                  = 14; // Button
    public final static int INPUT_HOME_POSITION                   = 15; // Button    
    public final static int SHOOTER_ANGLE_SHOOT                   = 16; // Button

    // ===================================================
    // Camera Related
    // ===================================================      
    public final static double CAMERA_STARTUP_TIMEOUT = 180.0;
    
    public final static int HUE_MIN        = 60;
    public final static int HUE_MAX        = 128;
    
    public final static int SATURATION_MIN = 100;
    public final static int SATURATION_MAX = 255;
    
    public final static int VALUE_MIN      = 90;
    public final static int VALUE_MAX      = 200;

    // ===================================================
    // Autonomous configurations
    // ===================================================
    // Hot goal switches at 5.0 seconds into the game
    public final static double AUTONOMOUS_TIME_TO_HOT_GOAL_SWITCH            = 5.0;   
 
    // Defines for autonomous single ball
    public final static double AUTONOMOUS_STRAIGHT_DRIVE_TIME                = 1.8;
    public final static double AUTONOMOUS_STRAIGHT_DRIVER_POWER              = 0.5;
    public final static double AUTONOMOUS_STRAIGHT_DRIVE_ANGLE               = 0.0;

    // ===================================================
    // Defines for autonomous double ball
    public final static double AUTONOMOUS_TWO_BALL_START_DRIVE_TIME          =  2.2;  // 2.2
    public final static double AUTONOMOUS_TWO_BALL_START_DRIVER_POWER        =  0.5;  // 0.5
    public final static double AUTONOMOUS_TWO_BALL_START_DRIVE_ANGLE         =  0.0;
    
    public final static double AUTONOMOUS_TWO_BALL_PICKUP_DRIVE_TIME         =  0.8;
    public final static double AUTONOMOUS_TWO_BALL_PICKUP_DRIVE_POWER        =  0.5;
    public final static double AUTONOMOUS_TWO_BALL_PICKUP_DRIVE_ANGLE        =  0.0;
            
    public final static double AUTONOMOUS_TWO_BALL_BACKUP_SHOOT_DRIVE_TIME   =  1.2;
    public final static double AUTONOMOUS_TWO_BALL_BACKUP_SHOOT_DRIVE_POWER  = -0.5;
    public final static double AUTONOMOUS_TWO_BALL_BACKUP_SHOOT_DRIVE_ANGLE  =  0.0;
     
    public final static double AUTONOMOUS_TWO_BALL_FORWARD_SHOOT_DRIVE_TIME  =  0.6;
    public final static double AUTONOMOUS_TWO_BALL_FORWARD_SHOOT_DRIVE_POWER =  0.75;
    public final static double AUTONOMOUS_TWO_BALL_FORWARD_SHOOT_DRIVE_ANGLE = 15.0;

    // ===================================================
    // Shooter Positions
    // ===================================================    
    // Note: The shooter angle is greater than possible to ensure the new shooter 
    //       can move the full range (after the slope and y-intercept have been 
    //       recalibrated)
    public final static double SHOOTER_ANGLE_MAX_VALUE        = 100.0;    // 850.0  - 45.848   50
    public final static double SHOOTER_ANGLE_MIN_VALUE        = -25.0;    //   0.0  - 17.203   10
    
    // Practice robot: Min -23.9 (0.08V)   Max: 89.1 (4.5V)
    public final static double SHOOTER_PICKUP_POSITION        = -13.6;
    public final static double SHOOTER_LOW_GOAL_POSITION      =  -1.0;   // 0.0
    public final static double SHOOTER_PASS_POSITION          =  23.0;
    public final static double SHOOTER_ANGLED_CORNER_POSITION =  40.0;
    public final static double SHOOTER_REGULAR_SHOT_POSITION  =  55.0;    // 63.0
    public final static double SHOOTER_CORNER_POSITION        =  76.0;
    public final static double SHOOTER_VERTICAL_POSITION      =  85.0;    // 96.5

    public final static double PICKUP_WHEEL_POWER             = 0.6;
}

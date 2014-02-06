package org.usfirst.frc3824.CompetitionRobot;

/**
 * Put any important constants here.
 */
public class Constants
{
    /* Contants which might require tuning */
    public final static double DrivetrainAngleGyroControllerP = .1;
    public final static double DrivetrainAngleGyroControllerI = .01;
    public final static double DrivetrainAngleGyroControllerD = .001;
    
    // Cypress IO defines
    public final static int ANALOG_SHOOTER_ADJUST_PID = 2; // pot input channel
    public final static int INPUT_SHOOTER_UP = 10; // double toggle
    public final static int INPUT_SHOOTER_DOWN = 1; // double toggle
    
    /****** SHOOTER POSITION ******/
    // Note: The shooter angle is greater than possible to ensure the new shooter 
    //       can move the full range (after the slope and y-intercept have been 
    //       recalibrated)
    public final static double SHOOTER_ANGLE_MAX_VALUE = 50.0;    // 850.0  - 45.848
    public final static double SHOOTER_ANGLE_MIN_VALUE = 10.0;    //   0.0  - 17.203
    public final static double SHOOTER_ANGLE_THRESHOLD = 2.0;    // Note: in ADC values
    public final static double SHOOTER_ANGLE_MAX_PICKUP_VALUE = 23.943;  //  200.0
    public final static double SHOOTER_ANGLE_PICKUP_VALUE = 21.584;  //  130.0

    /* Constants copied from last years robot */
    /****** Shooter angle conversion (ADC to angle) ******/
    /* angle = (SLOPE * ADC) + Y_INTERCEPT   */
    /* ADC   = (angle - Y_INTERCEPT) / SLOPE */
    public final static double SHOOTER_ANGLE_SLOPE = 0.0337;
    public final static double SHOOTER_ANGLE_Y_INTERCEPT = 17.203;
    /****** BACK/UNDER TOWER ******/
    public final static double SHOOTER_ANGLE_BACK_OF_TOWER = 29.5 ;
    public final static double SHOOTER_ANGLE_UNDER_TOWER = 30.25 ;
    public final static double SHOOTER_ANGLE_FOR_PICKUP = 21.584;
    public final static double SHOOTER_SPEED_BACK_OF_TOWER = 3200.0;
    /****** SHOOTER WAIT TIMES ******/
    public final static double AUTONOMOUS_SHOOT_WAIT1 = 0.0;
    public final static double AUTONOMOUS_SHOOT_WAIT2 = 0.0;
    // Loadind define
    public final static double POSITION_LOADING = 36.0;
    public final static double POSITION_INITIALIZE = 34.3; //28.0
    /****** SHOOTER SPEED ******/
    public final static double SHOOTER_SPEED_THRESHOLD = 50.0;
    public final static double SHOOTER_SPEED_MAX_VALUE = 4000.0;
    public final static double SHOOTER_SPEED_MIN_VALUE = 1000.0;
    /****** PICKUP VOLTAGE ******/
    public final static double PICKUP_OUT_VOLTAGE = -0.5;
    public final static double PICKUP_IN_VOLTAGE = 0.4;
    /****** CYPRESS POSITION DEFINES ******/
    // front of pyramid
    public final static double POSITION_1_ANGLE = 40.793;  // 700.0
    public final static double POSITION_1_VELOCITY = 2500.0;
    public final static double POSITION_1_VOLTAGE = 0.6;
    public final static boolean POSITION_1_IS_RPM = true;
    // back of pyramid
    public final static double POSITION_2_ANGLE = 28.0;  // 230.0 
    public final static double POSITION_2_VELOCITY = 3200.0;
    public final static double POSITION_2_VOLTAGE = 0.62;
    public final static boolean POSITION_2_IS_RPM = true;
    // under the tower and loading
    public final static double POSITION_3_ANGLE = SHOOTER_ANGLE_BACK_OF_TOWER ;
    public final static double POSITION_3_VELOCITY = SHOOTER_SPEED_BACK_OF_TOWER;
    public final static double POSITION_3_VOLTAGE = 0.6;
    public final static boolean POSITION_3_IS_RPM = true;
    // Long Shoot
    public final static double POSITION_4_ANGLE = 10.0; // 854.0 
    public final static double POSITION_4_VELOCITY = 3000.0;
    public final static double POSITION_4_VOLTAGE = 0.6;
    public final static boolean POSITION_4_IS_RPM = true;
    // loading position
    public final static double POSITION_5_ANGLE = POSITION_LOADING ;
    public final static double POSITION_5_VELOCITY = SHOOTER_SPEED_BACK_OF_TOWER;
    public final static double POSITION_5_VOLTAGE = 0.6;
    public final static boolean POSITION_5_IS_RPM = true;
    // shooting when handing on the tower
    public final static double HANGING_ON_TOWER_ANGLE = 28.5;
    public final static double HANGING_ON_TOWER_VELOCITY = 3600.0;
    public final static boolean HANGING_ON_TOWER_IS_RPM = true;
}

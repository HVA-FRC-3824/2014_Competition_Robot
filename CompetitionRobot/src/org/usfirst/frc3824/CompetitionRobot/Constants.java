package org.usfirst.frc3824.CompetitionRobot;

/**
 * Put any important constants here.
 */
public class Constants {
    /* Contants which might require tuning */

    public final static double DrivetrainAngleGyroControllerP = 0.1;
    public final static double DrivetrainAngleGyroControllerI = 0.01;
    public final static double DrivetrainAngleGyroControllerD = 0.001;

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

    /**
     * **** SHOOTER POSITION *****
     */
    // Note: The shooter angle is greater than possible to ensure the new shooter 
    //       can move the full range (after the slope and y-intercept have been 
    //       recalibrated)
    public final static double SHOOTER_ANGLE_MAX_VALUE = 100.0;    // 850.0  - 45.848
    public final static double SHOOTER_ANGLE_MIN_VALUE = -20.0;    //   0.0  - 17.203
    
    // law of cosines:
    //  a = sqrt(b^2 + h^2 - 2bhCos(theta))
    //  a -- 35.6cm - 55.9cm    actuation length
    //  b -- 11.4cm             length from pivot to actuator connection point
    //  h -- 47.6cm             height from pivot to base
    //  psi is our requested angle
    //  phi is offset angle (constant)
    //  theta is the acutal calculated angle
    // Angle from shooter head to shooter pivot to shooter/linear actuator mount
    private final static double b = 11.4;
    private final static double h = 47.6;
    private final static double a_min = 35.6;
    private final static double a_max = 55.9;
    
    public final static double SHOOTER_MOUNTING_OFFSET_ANGLE = 25.0;    
    public final static double SHOOTER_B_SQUARE_PLUS_H_SQUARE = ((b*b) + (h*h));
    public final static double SHOOTER_TWO_B_H = (2*b*h);
    public final static double SHOOTER_ACTUATOR_MIN_LENGTH = a_min;
    public final static double SHOOTER_ACTUATOR_MAX_LENGTH = a_max;
}

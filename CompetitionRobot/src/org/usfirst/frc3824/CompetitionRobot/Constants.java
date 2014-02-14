package org.usfirst.frc3824.CompetitionRobot;

/*
 * Put any important constants here.
 */
public class Constants
{
    // Contants which might require tuning
    public final static double DrivetrainAngleGyroControllerP = 0.000;
    public final static double DrivetrainAngleGyroControllerI = 0.010;
    public final static double DrivetrainAngleGyroControllerD = 0.001;

    // Cypress IO defines
    public final static int INPUT_PICKUP_IN = 10; // Double toggle
    public final static int INPUT_PICKUP_OUT = 1; // Double toggle
    public final static int INPUT_VACUUM_TOGGLE = 4; // Toggle switch
    public final static int INPUT_CANNON_SHOOT = 11; // Button
    public final static int INPUT_SHOOTER_ANGLE_ADJUSTMENT_MANUAL = 7; // Toggle 
    public final static int ANALOG_SHOOTER_ADJUST_PID = 2; // Pot input channel
    public final static int SHOOTER_ANGLE_SHOOT = 16; // Button
    public final static int SHOOTER_ANGLE_PASS = 3; // Button
    public final static int SHOOTER_ANGLE_PICKUP = 8; // Button
    public final static int SHOOTER_ANGLE_CORNER = 14; // Button
    public final static int SHOOTER_ANGLE_ANGLED_CORNER = 12; // Button

    // SHOOTER POSITION
    public final static double SHOOTER_ANGLE_MAX_VALUE = 50.0;    // 850.0  - 45.848
    public final static double SHOOTER_ANGLE_MIN_VALUE = 10.0;    //   0.0  - 17.203

    public final static double SHOOTER_ANGLE_SHOOT_HIGH = 35.0;
    public final static double SHOOTER_ANGLE_PICKUP_ANGLE = 10.2;
    public final static double SHOOTER_ANGLE_PASS_ANGLE = 19;
}

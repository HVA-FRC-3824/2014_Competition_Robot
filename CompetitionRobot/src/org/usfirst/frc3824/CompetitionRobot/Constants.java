package org.usfirst.frc3824.CompetitionRobot;

/**
 * Put any important constants here.
 */
public class Constants
{
    /* Contants which might require tuning */
    public final static double DrivetrainAngleGyroControllerP = .1;
    public final static double DrivetrainAngleGyroControllerI = .01;
    public final static double DrivetrainAngleGyroControllerD = .01;
    
    public final static int ANALOG_SHOOTER_ADJUST_PID = 3; // pot input channel
    
    public final static double SHOOTER_ANGLE_MAX_VALUE =  850;
    public final static double SHOOTER_ANGLE_MIN_VALUE =  0;
}

// RobotBuilder Version: 0.0.2
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in th future.
package org.usfirst.frc3824.CompetitionRobot;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap
{
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static SpeedController drivetrainFrontRight;
    public static SpeedController drivetrainFrontLeft;
    public static SpeedController drivetrainRearRight;
    public static SpeedController drivetrainRearLeft;
    public static RobotDrive drivetrainHolonomicDrive;
    public static Gyro drivetrainGyro;
    public static AnalogChannel drivetrainUltrasonicFront;
    public static Solenoid shooterShootSolenoid1;
    public static Solenoid shooterShootSolenoid2;
    public static Solenoid shooterShootSolenoid3;
    public static Solenoid shooterShootSolenoid4;
    public static Compressor pumpCompressor;
    public static Relay pickupWheelPickup;
    public static AnalogChannel shooterAngleAdjustPIDShooterAnglePID;
    public static SpeedController shooterAngleAdjustPIDAngleMotorPID;
    public static SpeedController vacuumVacuum;
    public static SpeedController auxiliaryLeftShooterMotor;
    public static AnalogChannel auxiliaryLeftShooterAngle;
    public static PIDController auxiliaryLeftShooterAnglePID;
    public static DoubleSolenoid auxiliaryLeftVerticalAdjust;
    public static SpeedController auxiliaryLeftVacuum;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static void init()
    {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        drivetrainFrontRight = new Talon(1, 1);
	LiveWindow.addActuator("Drivetrain", "Front Right", (Talon) drivetrainFrontRight);
        
        drivetrainFrontLeft = new Talon(1, 2);
	LiveWindow.addActuator("Drivetrain", "Front Left", (Talon) drivetrainFrontLeft);
        
        drivetrainRearRight = new Talon(1, 3);
	LiveWindow.addActuator("Drivetrain", "Rear Right", (Talon) drivetrainRearRight);
        
        drivetrainRearLeft = new Talon(1, 4);
	LiveWindow.addActuator("Drivetrain", "Rear Left", (Talon) drivetrainRearLeft);
        
        drivetrainHolonomicDrive = new RobotDrive(drivetrainFrontLeft, drivetrainRearLeft,
              drivetrainFrontRight, drivetrainRearRight);
	
        drivetrainHolonomicDrive.setSafetyEnabled(false);
        drivetrainHolonomicDrive.setExpiration(0.1);
        drivetrainHolonomicDrive.setSensitivity(0.5);
        drivetrainHolonomicDrive.setMaxOutput(1.0);
        drivetrainHolonomicDrive.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true);
        drivetrainHolonomicDrive.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);
        drivetrainGyro = new Gyro(1, 1);
	LiveWindow.addSensor("Drivetrain", "Gyro", drivetrainGyro);
        drivetrainGyro.setSensitivity(0.007);
        drivetrainUltrasonicFront = new AnalogChannel(1, 4);
	LiveWindow.addSensor("Drivetrain", "Ultrasonic Front", drivetrainUltrasonicFront);
        
        shooterShootSolenoid1 = new Solenoid(1, 1);
	LiveWindow.addActuator("Shooter", "Shoot Solenoid 1", shooterShootSolenoid1);
        
        shooterShootSolenoid2 = new Solenoid(1, 2);
	LiveWindow.addActuator("Shooter", "Shoot Solenoid 2", shooterShootSolenoid2);
        
        shooterShootSolenoid3 = new Solenoid(1, 3);
	LiveWindow.addActuator("Shooter", "Shoot Solenoid 3", shooterShootSolenoid3);
        
        shooterShootSolenoid4 = new Solenoid(1, 4);
	LiveWindow.addActuator("Shooter", "Shoot Solenoid 4", shooterShootSolenoid4);
        
        pumpCompressor = new Compressor(1, 1, 1, 1);
	
        
        pickupWheelPickup = new Relay(1, 5);
	LiveWindow.addActuator("Pickup", "Wheel Pickup", pickupWheelPickup);
        
        shooterAngleAdjustPIDShooterAnglePID = new AnalogChannel(1, 5);
	LiveWindow.addSensor("Shooter Angle Adjust PID", "Shooter Angle PID", shooterAngleAdjustPIDShooterAnglePID);
        
        shooterAngleAdjustPIDAngleMotorPID = new Talon(1, 7);
	LiveWindow.addActuator("Shooter Angle Adjust PID", "Angle Motor PID", (Talon) shooterAngleAdjustPIDAngleMotorPID);
        
        vacuumVacuum = new Talon(1, 5);
	LiveWindow.addActuator("Vacuum", "Vacuum", (Talon) vacuumVacuum);
        
        auxiliaryLeftShooterMotor = new Talon(1, 6);
	LiveWindow.addActuator("Auxiliary Left", "Shooter Motor", (Talon) auxiliaryLeftShooterMotor);
        
        auxiliaryLeftShooterAngle = new AnalogChannel(1, 2);
	LiveWindow.addSensor("Auxiliary Left", "Shooter Angle", auxiliaryLeftShooterAngle);
        
        auxiliaryLeftShooterAnglePID = new PIDController(0.01, 0.0, 0.0, 0.0, auxiliaryLeftShooterAngle, auxiliaryLeftShooterMotor, 0.02);
	LiveWindow.addActuator("Auxiliary Left", "ShooterAnglePID", auxiliaryLeftShooterAnglePID);
        auxiliaryLeftShooterAnglePID.setContinuous(false); auxiliaryLeftShooterAnglePID.setAbsoluteTolerance(5.0); 
        auxiliaryLeftShooterAnglePID.setOutputRange(-0.5, 0.5);        
        auxiliaryLeftVerticalAdjust = new DoubleSolenoid(1, 7, 8);      
	
        
        auxiliaryLeftVacuum = new Talon(1, 8);
	LiveWindow.addActuator("Auxiliary Left", "Vacuum", (Talon) auxiliaryLeftVacuum);
        
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }
}

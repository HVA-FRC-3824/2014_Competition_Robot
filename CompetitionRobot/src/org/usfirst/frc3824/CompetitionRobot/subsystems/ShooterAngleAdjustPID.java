// RobotBuilder Version: 1.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.
package org.usfirst.frc3824.CompetitionRobot.subsystems;
import org.usfirst.frc3824.CompetitionRobot.RobotMap;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc3824.CompetitionRobot.Constants;
/**
 *
 */
public class ShooterAngleAdjustPID extends PIDSubsystem
{
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    AnalogChannel shooterAnglePID = RobotMap.shooterAngleAdjustPIDShooterAnglePID;
    SpeedController angleMotorPID = RobotMap.shooterAngleAdjustPIDAngleMotorPID;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    // Initialize your subsystem here
    public ShooterAngleAdjustPID()
    {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=PID
        super("ShooterAngleAdjustPID", 8.0, 0.0, 0.0);
        setAbsoluteTolerance(0.01);
        getPIDController().setContinuous(false);
        LiveWindow.addActuator("Shooter Angle Adjust PID", "PIDSubsystem Controller", getPIDController());
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=PID
        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
    }
    public void initDefaultCommand()
    {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    protected double returnPIDInput()
    {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
        //SmartDashboard.putNumber("ShooterPosition", Robot.shooterAngleAdjustPID.getPosition());
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SOURCE
        return shooterAnglePID.getAverageVoltage();
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SOURCE
    }
    protected void usePIDOutput(double output)
    {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=OUTPUT
        angleMotorPID.pidWrite(output);
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=OUTPUT
        SmartDashboard.putNumber("ShooterDrive", output);
    }
    /**
     * Get method to return the potentiometer.
     * <br> Returns an AnalogChannel. </br>
     *
     * @return shooterAnglePID - Cypress Board Potentiometer
     */
    public AnalogChannel getPotentiometer()
    {
        return shooterAnglePID;
    }
    /**
     * Set method to set the target angle.
     *
     * @param <inputAngle> angle to set as the target.
     */
    public void setTargetAngle(double inputAngle)
    {
        setSetpoint(convertAngleToVolts(limitAngle(inputAngle)));
    }
    /**
     * Get method to return the target angle.
     * <br>Returns a double value.</br>
     *
     * @return target angle
     */
    public double getTargetAngle()
    {
        return convertVoltsToAngle(this.getSetpoint());
    }
    /**
     * Get method to return the current angle.
     * <br>Returns a double value.</br>
     *
     * @return current angle
     */
    public double getCurrentAngle()
    {
        return convertVoltsToAngle(this.getPosition());
    }
    /**
     * This private method sets a limit to the PID to keep it from breaking
     * mechanically.
     * <br>Returns a double value.</br>
     *
     * @param <inputAngle> angle to limit
     * @return outputAngle - the limited angle
     */
    private double limitAngle(double inputAngle)
    {
        double outputAngle = inputAngle;
        if (inputAngle > Constants.SHOOTER_ANGLE_MAX_VALUE)
        {
            outputAngle = Constants.SHOOTER_ANGLE_MAX_VALUE;
        }
        if (inputAngle < Constants.SHOOTER_ANGLE_MIN_VALUE)
        {
            outputAngle = Constants.SHOOTER_ANGLE_MIN_VALUE;
        }
        return outputAngle;
    }
    /**
     * This private method converts an angle to volts.
     * <br>Returns a double value.</br>
     *
     * @param <inputAngle> angle in degrees to convert to volts
     * @return volts
     */
    private double convertAngleToVolts(double inputAngle)
    {
        double volts;
        // Convert the requested angle into a voltage in the range 0-5V
        //  The voltage is what the PID requires.
        volts = ((inputAngle - Constants.SHOOTER_ANGLE_MIN_VALUE) / (Constants.SHOOTER_ANGLE_MAX_VALUE - Constants.SHOOTER_ANGLE_MIN_VALUE)) * 5.0;
        return volts;
    }
    /**
     * This private method converts volts to an angle value.
     * <br>Returns a double value.</br>
     *
     * @param <inputVolts> volts to convert to degrees
     * @return angle - in degrees
     */
    private double convertVoltsToAngle(double inputVolts)
    {
        double angle;
        angle = (inputVolts * (Constants.SHOOTER_ANGLE_MAX_VALUE - Constants.SHOOTER_ANGLE_MIN_VALUE)) / 5.0 + Constants.SHOOTER_ANGLE_MIN_VALUE;
        return angle;
    }
}

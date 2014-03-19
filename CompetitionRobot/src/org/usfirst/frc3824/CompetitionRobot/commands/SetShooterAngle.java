// RobotBuilder Version: 0.0.2
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in th future.
package org.usfirst.frc3824.CompetitionRobot.commands;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DriverStationEnhancedIO;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc3824.CompetitionRobot.Constants;
import org.usfirst.frc3824.CompetitionRobot.Robot;
/**
 *
 */
public class SetShooterAngle extends Command
{
    private double m_Angle, angle;
    private boolean angleSpecifiedInConstructor;
    public SetShooterAngle(double angleParam)
    {
        m_Angle = angleParam;
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.shooterAngleAdjustPID);
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        // set the boolean to indicate that the constructor with angle was called
        angleSpecifiedInConstructor = true;
    }
    public SetShooterAngle()
    {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.shooterAngleAdjustPID);
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        // set the boolean to indicate that the constructor with angle was called
        angleSpecifiedInConstructor = false;
    }
    // Called just before this Command runs the first time
    protected void initialize()
    {
        // determine if the shooter angle should be pulled from the SmartDashboard
        if (angleSpecifiedInConstructor == false)
        {
            try
            {
                // Angle is currently in 0V to 3.3V
                //angle = DriverStation::GetInstance()->GetEnhancedIO().GetAnalogIn(ANALOG_SHOOTER_ADJUST);
                angle = DriverStation.getInstance().getEnhancedIO().getAnalogIn(Constants.ANALOG_SHOOTER_ADJUST_PID);
            } 
            catch (DriverStationEnhancedIO.EnhancedIOException ex)
            {
                ex.printStackTrace();
            }
            // Convert the Voltage to Degrees
            angle = angle * (Constants.SHOOTER_ANGLE_MAX_VALUE - Constants.SHOOTER_ANGLE_MIN_VALUE) / 
                    3.3 + Constants.SHOOTER_ANGLE_MIN_VALUE;
        } else
        {
            angle = m_Angle;
        }
        Robot.shooterAngleAdjustPID.setTargetAngle(angle);
        Robot.shooterAngleAdjustPID.enable();
    }
    // Called repeatedly when this Command is scheduled to run
    protected void execute()
    {
        if (angleSpecifiedInConstructor == false)
        {
            try
            {
                // Angle is currently in 0V to 3.3V
                angle = DriverStation.getInstance().getEnhancedIO().getAnalogIn(Constants.ANALOG_SHOOTER_ADJUST_PID);
            } catch (DriverStationEnhancedIO.EnhancedIOException ex)
            {
                ex.printStackTrace();
            }
            // Convert the Voltage to Degrees
            angle = angle * (Constants.SHOOTER_ANGLE_MAX_VALUE - Constants.SHOOTER_ANGLE_MIN_VALUE) / 
                    3.3 + Constants.SHOOTER_ANGLE_MIN_VALUE;
            
            // Set the setpoint in ADC
            Robot.shooterAngleAdjustPID.setTargetAngle(angle);
        }
        SmartDashboard.putNumber("ShooterTarget", Robot.shooterAngleAdjustPID.getTargetAngle());
        SmartDashboard.putNumber("ShooterPosition", Robot.shooterAngleAdjustPID.getCurrentAngle());
        try
        {
            SmartDashboard.putNumber("Pot Value", DriverStation.getInstance().getEnhancedIO().getAnalogIn(Constants.ANALOG_SHOOTER_ADJUST_PID));
        } 
        catch (DriverStationEnhancedIO.EnhancedIOException ex)
        {
        }
    }
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished()
    {
        // determine if the shooter angle is within the desired range
        // TODO - set threshold to accurate value!!
        return Robot.shooterAngleAdjustPID.onTarget();
    }
    // Called once after isFinished returns true
    protected void end()
    {
        Robot.shooterAngleAdjustPID.disable();
    }
    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted()
    {
        end();
    }
}

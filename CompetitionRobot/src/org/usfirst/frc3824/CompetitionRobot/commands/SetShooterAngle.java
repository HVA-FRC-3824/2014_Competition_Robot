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
        if (angleSpecifiedInConstructor == false) {
            try {
                // Angle is currently in 0V to 3.3V
                //angle = DriverStation::GetInstance()->GetEnhancedIO().GetAnalogIn(ANALOG_SHOOTER_ADJUST);
                angle = DriverStation.getInstance().getEnhancedIO().getAnalogIn(Constants.ANALOG_SHOOTER_ADJUST_PID);
            } catch (DriverStationEnhancedIO.EnhancedIOException ex) {
                ex.printStackTrace();
            }
            // Convert the Voltage to Degrees
            angle = angle * (Constants.SHOOTER_ANGLE_MAX_VALUE - Constants.SHOOTER_ANGLE_MIN_VALUE) / 3.3 + Constants.SHOOTER_ANGLE_MIN_VALUE;
        } else {
            angle = m_Angle;
        }
        // ensure the range of the shooter angle
        if (angle > Constants.SHOOTER_ANGLE_MAX_VALUE) {
            angle = Constants.SHOOTER_ANGLE_MAX_VALUE;
        }
        if (angle < Constants.SHOOTER_ANGLE_MIN_VALUE) {
            angle = Constants.SHOOTER_ANGLE_MIN_VALUE;
        }
        // Convert the requested angle into a voltage in the range 0-5V
        //  The voltage is what the PID requires.
        angle = ((angle - 10.0) / 40.0) * 5.0;
        
        Robot.shooterAngleAdjustPID.setSetpoint(angle);
        Robot.shooterAngleAdjustPID.enable();
    }
    // Called repeatedly when this Command is scheduled to run
    protected void execute()
    {
        if(angleSpecifiedInConstructor == false)
	{
            try {
                // Angle is currently in 0V to 3.3V
                angle = DriverStation.getInstance().getEnhancedIO().getAnalogIn(Constants.ANALOG_SHOOTER_ADJUST_PID);
            } catch (DriverStationEnhancedIO.EnhancedIOException ex) {
                ex.printStackTrace();
            }
		// Convert the Voltage to Degrees
		angle = angle * (Constants.SHOOTER_ANGLE_MAX_VALUE - Constants.SHOOTER_ANGLE_MIN_VALUE)/3.3 + Constants.SHOOTER_ANGLE_MIN_VALUE;
		
		if (angle > Constants.SHOOTER_ANGLE_MAX_VALUE)
			angle = Constants.SHOOTER_ANGLE_MAX_VALUE;
		if (angle < Constants.SHOOTER_ANGLE_MIN_VALUE)
			angle = Constants.SHOOTER_ANGLE_MIN_VALUE;
		
        // Convert the requested angle into a voltage in the range 0-5V
        //  The voltage is what the PID requires.
               angle = ((angle - 10.0) / 40.0) * 5.0;
		   
		// Set the setpoint in ADC
                Robot.shooterAngleAdjustPID.setSetpoint(angle);
	}
        SmartDashboard.putNumber("ShooterTarget", Robot.shooterAngleAdjustPID.getSetpoint());
        SmartDashboard.putNumber("ShooterPosition", Robot.shooterAngleAdjustPID.getPosition());
    }
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished()
    {
        // determine if the shooter angle is within the desired range
        return Math.abs(Robot.shooterAngleAdjustPID.getSetpoint() - Robot.shooterAngleAdjustPID.getPosition()) < 0.1;
    }
    // Called once after isFinished returns true
    protected void end()
    {
        System.out.println("SetShooterAngle - end");
    }
    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted()
    {
        System.out.println("SetShooterAngle - Interrupted");
        end();
    }
}

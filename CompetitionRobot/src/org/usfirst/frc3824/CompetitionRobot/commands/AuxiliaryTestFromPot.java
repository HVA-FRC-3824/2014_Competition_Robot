// RobotBuilder Version: 1.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.
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
public class  AuxiliaryTestFromPot extends Command {
    private double voltsIn;
    private double pidValue;
    private boolean takeControl;
    public AuxiliaryTestFromPot() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
	
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.auxiliaryLeft);
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }
    // Called just before this Command runs the first time
    protected void initialize() {
        System.out.println("Aux Test From Pot - Initialize");
        takeControl = false;
    }
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        
        SmartDashboard.putNumber("Auxiliary Rotation Angle:", Robot.auxiliaryLeft.getAuxiliaryAngle());
        SmartDashboard.putNumber("Auxiliary Rotation PID Val: ", Robot.auxiliaryLeft.getAuxiliaryPIDValue());
        try 
        {
            // Angle is currently in 0V to 3.3V
            voltsIn = DriverStation.getInstance().getEnhancedIO().getAnalogIn(Constants.ANALOG_AUXILIARY_ANGLE) / 3.3;
        } 
        catch (DriverStationEnhancedIO.EnhancedIOException ex)
        {
            ex.printStackTrace();
        }
        SmartDashboard.putNumber("Auxiliary Rotation Input Value (0-1024): ", voltsIn * 1024);
        if(takeControl == false)
        {
            pidValue = Robot.auxiliaryLeft.getAuxiliaryPIDValue() / 1024;
            if(Math.abs(voltsIn - pidValue) < .05)
            {
                System.out.println("TAKE CONTROL");
                Robot.auxiliaryLeft.setShooterTestPID(voltsIn * 1024);
                Robot.auxiliaryLeft.setShooterTestStartPID();
                takeControl = true;
            }
        }
        else
        {
            Robot.auxiliaryLeft.setShooterTestPID(voltsIn * 1024);
        }
    }
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }
    // Called once after isFinished returns true
    protected void end() {
        takeControl = false;
        Robot.auxiliaryLeft.setShooterStop();
        System.out.println("Aux Test From Pot - end()");
    }
    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}

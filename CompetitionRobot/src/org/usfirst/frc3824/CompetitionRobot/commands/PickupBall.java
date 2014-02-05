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
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc3824.CompetitionRobot.Robot;
/**
 *
 */
public class  PickupBall extends Command {
    
    private static Timer timer;
    public PickupBall() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
	requires(Robot.vacuum);
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.pickup);
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        
        timer = new Timer();
    }
    // Called just before this Command runs the first time
    protected void initialize() {
        timer.reset();
        timer.start();
        
        Robot.pickup.setWheelSpeed(0.5);
        Robot.vacuum.getVacuum().set(Relay.Value.kOn);
    }
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return timer.get() >= 2.0;
    }
    // Called once after isFinished returns true
    protected void end() {
        Robot.pickup.setWheelSpeed(0);
        Robot.vacuum.getVacuum().set(Relay.Value.kOff);
    }
    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
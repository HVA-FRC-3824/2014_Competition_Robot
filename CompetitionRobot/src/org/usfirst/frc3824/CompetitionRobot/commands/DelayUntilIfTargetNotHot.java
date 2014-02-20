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
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.WaitUntilCommand;
import org.usfirst.frc3824.CompetitionRobot.Robot;
/**
 *
 */
public class  DelayUntilIfTargetNotHot extends Command {
    protected int m_whichTarget;
    protected double m_delayUntil;
    protected Command driver;
    private int executeCount = 0;
    
    public DelayUntilIfTargetNotHot() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
	
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }
    
    // --- IMPORTANT: the delayUntil is from the START OF THE GAME
    //  this means this function is generally NOT something that would be used
    //  as a dealy in teleOp mode, it should only be used in Autonomous.
    public DelayUntilIfTargetNotHot(int whichTarget, double delayUntil)
    {
        m_whichTarget = whichTarget;
        m_delayUntil = delayUntil;
    }
    // Called just before this Command runs the first time
    protected void initialize() {
        if(m_whichTarget != Robot.hotGoalInfo.hotTarget)
        {
            // wait until 'delayUntil' time after the Autonomous starts.
            driver = new WaitUntilCommand(m_delayUntil);  // delay
        }
        else
        {
            // to keep symmetry so additional tests for null are not needed later,
            // create a delay command object, but set the start time to a value already
            // in the past, so there will effectively be no delay
            driver = new WaitUntilCommand(0.0);          
       }
       driver.start();
    }
    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        // This counter is used to make sure the delay actually works.  When the isFinished is
        // called the first time, in most cases, driver.isRunning() will return FALSE because
        // it has NOT YET STARTED, NOT because it is finished running. By requiring the 
        // execute to run at lease 3 times, we guarantee that the timer will start and
        // run for the specified delay.
        executeCount++;
    }
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (!driver.isRunning() && (executeCount > 2));
    }
    // Called once after isFinished returns true
    protected void end() {
        driver.cancel();
    }
    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
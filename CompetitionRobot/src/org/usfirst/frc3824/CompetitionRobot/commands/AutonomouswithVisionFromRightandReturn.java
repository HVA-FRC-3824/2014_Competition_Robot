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

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import edu.wpi.first.wpilibj.command.WaitUntilCommand;
import org.usfirst.frc3824.CompetitionRobot.Constants;

/**
 *
 */
public class AutonomouswithVisionFromRightandReturn extends CommandGroup
{
    public AutonomouswithVisionFromRightandReturn()
    {       
        // set the global inital Gyro angle to be used by the ChassisDriveStraight command
        addSequential(new SetGlobalGyroSetting());
                
        // enable the vacuum and allow time for ball to attach to shooter        
        addSequential(new VacuumOn());
        addParallel(new WaitUntilCommand(Constants.WAIT_FOR_VACUUM_AUTONOMOUS_TIME));
        
        // locate the hot goal and decide if to wait or drive immediately
        addSequential(new LocateHotGoal());
        addSequential(new DelayUntilIfTargetNotHot(LocateHotGoal.TargetSide.RIGHT, Constants.AUTONOMOUS_TIME_TO_HOT_GOAL_SWITCH));
       
        // set the shooter angle
        addParallel(new SetShooterAngle(Constants.SHOOTER_REGULAR_SHOT_POSITION));
        
        // drive to the goal
        addSequential(new ChassisDriveStraight(Constants.AUTONOMOUS_STRAIGHT_DRIVE_TIME,
                                               Constants.AUTONOMOUS_STRAIGHT_DRIVER_POWER,
                                               Constants.AUTONOMOUS_STRAIGHT_DRIVE_ANGLE, true));
        
        // shoot and then disable the vacuum
        addSequential(new CannonShoot());
        addSequential(new VacuumOff());  
        
        addParallel(new SetShooterAngle(Constants.SHOOTER_PICKUP_POSITION));
        
        // Turn around
        addSequential(new ChassisTurnAngle(160.0));

        // wait for shooter to lower
        addSequential(new WaitCommand(1.0));
        

        // Drive forward in opposite direction
        addSequential(new SetGlobalGryoValueReverse());        
        addSequential(new ChassisDriveStraight(Constants.AUTONOMOUS_STRAIGHT_DRIVE_TIME,
                                               Constants.AUTONOMOUS_STRAIGHT_DRIVER_POWER,
                                               Constants.AUTONOMOUS_STRAIGHT_DRIVE_ANGLE, true));         
    }
}

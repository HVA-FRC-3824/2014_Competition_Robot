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
public class AutonomousTwoBallPreCommon extends CommandGroup
{

    public AutonomousTwoBallPreCommon()
    {
        // set the global inital Gyro angle to be used by the ChassisDriveStraight command
        addSequential(new SetGlobalGyroSetting());
              
        // extend the ball guide
        addSequential(new BallGuideOut());
                
        // ensure the ball is captured with the vacuum
        addSequential(new VacuumOn());
        addSequential(new PickupBallIn());
        
//        addSequential(new WaitUntilCommand(Constants.WAIT_FOR_VACUUM_AUTONOMOUS_TIME));
        addSequential(new WaitUntilCommand(0.5));
        
        // turn off the pickup wheels
        addSequential(new PickupBallStop());

        // set the shooter angle
        addParallel(new SetShooterAngle(Constants.SHOOTER_REGULAR_SHOT_POSITION));

        // drive to the goal
        addSequential(new ChassisDriveStraight(Constants.AUTONOMOUS_TWO_BALL_START_DRIVE_TIME,
                                               Constants.AUTONOMOUS_TWO_BALL_START_DRIVER_POWER,
                                               Constants.AUTONOMOUS_TWO_BALL_START_DRIVE_ANGLE, true));

        // shoot and then disable the vacuum
        addParallel(new CannonShoot());
    
        // retract the ball guide
        addSequential(new BallGuideIn());
                
        // set shooter to pickup angle
        addParallel(new SetShooterAngle(Constants.SHOOTER_PICKUP_POSITION));
        
        // wait to for shooter angle to lower and ball to reach lower goal
        addSequential(new WaitCommand(0.8));
                 
        // turn on pickup wheels
        addSequential(new PickupBallIn());
                
        // drive forward to pickup the ball  
        addSequential(new ChassisDriveStraight(Constants.AUTONOMOUS_TWO_BALL_PICKUP_DRIVE_TIME,
                                               Constants.AUTONOMOUS_TWO_BALL_PICKUP_DRIVE_POWER,
                                               Constants.AUTONOMOUS_TWO_BALL_PICKUP_DRIVE_ANGLE, true));  
        
        // wait to capture ball in shooter
        addSequential(new WaitCommand(1.2));
       
        // have ball so backup to shoot
        addParallel(new ChassisDriveStraight(Constants.AUTONOMOUS_TWO_BALL_BACKUP_SHOOT_DRIVE_TIME,
                                             Constants.AUTONOMOUS_TWO_BALL_BACKUP_SHOOT_DRIVE_POWER,
                                             Constants.AUTONOMOUS_TWO_BALL_BACKUP_SHOOT_DRIVE_ANGLE, true));   
        
        // get ready to shoot
        addSequential(new SetShooterAngle(Constants.SHOOTER_REGULAR_SHOT_POSITION));
        addSequential(new PickupBallStop());


    }
}
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
import edu.wpi.first.wpilibj.command.WaitUntilCommand;
import org.usfirst.frc3824.CompetitionRobot.Constants;

/**
 *
 */
public class AutonomouswithVisionFromRight extends CommandGroup
{
    public AutonomouswithVisionFromRight()
    {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.
        addSequential(new VacuumOn());
        addSequential(new LocateHotGoal());
        addParallel(new WaitUntilCommand(1.0));
        addSequential(new DelayUntilIfTargetNotHot(LocateHotGoal.TargetSide.RIGHT, Constants.AUTONOMOUS_TIME_TO_HOT_GOAL_SWITCH));
        addParallel(new SetShooterAngle(Constants.SHOOTER_REGULAR_SHOT_POSITION));
        addSequential(new ChassisDriveStraight(Constants.AUTONOMOUS_STRAIGHT_DRIVE_TIME,
                                               Constants.AUTONOMOUS_STRAIGHT_DRIVER_POWER,
                                               Constants.AUTONOMOUS_STRAIGHT_DRIVE_ANGLE));
        addSequential(new CannonShoot());
        addSequential(new VacuumOff());

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.
        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}

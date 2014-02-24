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

/**
 *
 */
public class ChassisDriveAndTurnTest extends CommandGroup
{
    public ChassisDriveAndTurnTest()
    {
        ChassisTurnAngle chassisTurn = new ChassisTurnAngle(180.0);

        // Drive forward
        addSequential(new ChassisDriveStraight(2.0, 0.5, 0.0));
        addSequential(new WaitCommand(1.0));

        // Turn around
        addSequential(chassisTurn);
        addSequential(new WaitCommand(1.0));

        // Drive forward in opposite direction
        addSequential(new ChassisDriveStraight(2.0, 0.5, 0.0, true));
    }
}

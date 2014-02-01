// RobotBuilder Version: 0.0.2
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in th future.
package org.usfirst.frc3824.CompetitionRobot.subsystems;
import org.usfirst.frc3824.CompetitionRobot.RobotMap;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;
/**
 *
 */
public class Shooter extends Subsystem
{
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    Solenoid shootSolenoid1 = RobotMap.shooterShootSolenoid1;
    Solenoid shootSolenoid2 = RobotMap.shooterShootSolenoid2;
    Solenoid shootSolenoid3 = RobotMap.shooterShootSolenoid3;
    Solenoid shootSolenoid4 = RobotMap.shooterShootSolenoid4;
    Solenoid vacuum = RobotMap.shooterVacuum;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void initDefaultCommand()
    {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public Solenoid getSolenoid1()
    {
        return shootSolenoid1;
    }
    public Solenoid getSolenoid2()
    {
        return shootSolenoid2;
    }
    public Solenoid getSolenoid3()
    {
        return shootSolenoid3;
    }
    public Solenoid getSolenoid4()
    {
        return shootSolenoid4;
    }
}

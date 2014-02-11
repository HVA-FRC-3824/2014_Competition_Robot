// RobotBuilder Version: 1.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.
package org.usfirst.frc3824.CompetitionRobot.subsystems;
import org.usfirst.frc3824.CompetitionRobot.RobotMap;
import org.usfirst.frc3824.CompetitionRobot.commands.*;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;
/**
 *
 */
public class AuxiliaryLeft extends Subsystem {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    Solenoid leftShootSolenoid1 = RobotMap.auxiliaryLeftLeftShootSolenoid1;
    Solenoid leftShootSolenoid2 = RobotMap.auxiliaryLeftLeftShootSolenoid2;
    Solenoid leftVerticalAdjust = RobotMap.auxiliaryLeftLeftVerticalAdjust;
    Relay leftVacuum = RobotMap.auxiliaryLeftLeftVacuum;
    SpeedController leftAuxilaryMotor = RobotMap.auxiliaryLeftLeftAuxilaryMotor;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public Solenoid getShootSolenoid1()
    {
        return leftShootSolenoid1;
    }
    
    public Solenoid getShootSolenoid2()
    {
        return leftShootSolenoid2;
    }
    
    public Solenoid getVerticalAdjustSolenoid()
    {
        return leftVerticalAdjust;
    }
    
    public Relay getVacuum()
    {
        return leftVacuum;
    }
    
    public void setShootSolenoids(boolean on)
    {
        leftShootSolenoid1.set(on);
        leftShootSolenoid2.set(on);
    }
    
    public void setVerticalAdjustSolenoid(boolean up)
    {
        leftVerticalAdjust.set(up);
    }
    
}

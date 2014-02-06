// RobotBuilder Version: 0.0.2
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in th future.
package org.usfirst.frc3824.CompetitionRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.buttons.*;
import org.usfirst.frc3824.CompetitionRobot.commands.*;
/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI
{
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    // Another type of button you can create is a DigitalIOButton, which is
    // a button or switch hooked up to the cypress module. These are useful if
    // you want to build a customized operator interface.
    // Button button = new DigitalIOButton(1);
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public JoystickButton joystickShoot;
    public JoystickButton joystickShooterUp;
    public JoystickButton joystickShooterDown;
    public JoystickButton joystickToggleVacuum;
    public JoystickButton vacuumOn;
    public JoystickButton vacuumOff;
    public Joystick driveJoystick;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public OI()
    {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        driveJoystick = new Joystick(1);
        
        vacuumOff = new JoystickButton(driveJoystick, 11);
        vacuumOff.whenPressed(new VacuumOff());
        vacuumOn = new JoystickButton(driveJoystick, 9);
        vacuumOn.whenPressed(new VacuumOn());
        joystickToggleVacuum = new JoystickButton(driveJoystick, 8);
        joystickToggleVacuum.whenPressed(new VacuumToggle());
        joystickShooterDown = new JoystickButton(driveJoystick, 6);
        joystickShooterDown.whileHeld(new ShooterAngleDown());
        joystickShooterUp = new JoystickButton(driveJoystick, 5);
        joystickShooterUp.whileHeld(new ShooterAngleUp());
        joystickShoot = new JoystickButton(driveJoystick, 1);
        joystickShoot.whenPressed(new CannonShoot());
	    
        // SmartDashboard Buttons
        SmartDashboard.putData("Autonomous Command", new AutonomousCommand());
        SmartDashboard.putData("Autonomous Drive to Right Box from Center", new AutonomousDrivetoRightBoxfromCenter());
        SmartDashboard.putData("Autonomous Drive to Left Box from Center", new AutonomousDrivetoLeftBoxfromCenter());
        SmartDashboard.putData("Cannon Shoot", new CannonShoot());
        SmartDashboard.putData("Shooter Angle Up", new ShooterAngleUp());
        SmartDashboard.putData("Shooter Angle Down", new ShooterAngleDown());
        SmartDashboard.putData("Set Shooter Angle", new SetShooterAngle());
        SmartDashboard.putData("Teleoperated", new Teleoperated());
        SmartDashboard.putData("ChassisTurnAngle", new ChassisTurnAngle());
        SmartDashboard.putData("DriveStraight", new DriveStraight());
        SmartDashboard.putData("DriveAtASmallAngleVisionWaitForHotGoal", new DriveAtASmallAngleVisionWaitForHotGoal());
        SmartDashboard.putData("DriveAtASmallAngleTimeAndPowerDriveAtHotGoal", new DriveAtASmallAngleTimeAndPowerDriveAtHotGoal());
        SmartDashboard.putData("DriveAtASmallAngleTimeAndPowerWaitForHot", new DriveAtASmallAngleTimeAndPowerWaitForHot());
        SmartDashboard.putData("DriveAtASmallAngleUltraSonicDriveAtHotGoal", new DriveAtASmallAngleUltraSonicDriveAtHotGoal());
        SmartDashboard.putData("DriveAtASmallAngleUltraSonicWaitForHot", new DriveAtASmallAngleUltraSonicWaitForHot());
        SmartDashboard.putData("DriveAtASmallAngleVisionDriveAtHotGoal", new DriveAtASmallAngleVisionDriveAtHotGoal());
        SmartDashboard.putData("DriveInFrontOfBoxTimeAndPowerWaitForHot", new DriveInFrontOfBoxTimeAndPowerWaitForHot());
        SmartDashboard.putData("DriveInFrontOfBoxUltraSonicWaitForHot", new DriveInFrontOfBoxUltraSonicWaitForHot());
        SmartDashboard.putData("Autonomous Command Group", new AutonomousCommandGroup());
        SmartDashboard.putData("Update PID", new UpdatePID());
        SmartDashboard.putData("Pickup Ball", new PickupBall());
        SmartDashboard.putData("VacuumOn", new VacuumOn());
        SmartDashboard.putData("VacuumToggle", new VacuumToggle());
        SmartDashboard.putData("VacuumOff", new VacuumOff());
        SmartDashboard.putData("PickupToggleBallIn", new PickupToggleBallIn());
        SmartDashboard.putData("PickupToggleBallOut", new PickupToggleBallOut());
        SmartDashboard.putData("PickupWheelControl", new PickupWheelControl());
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
    public Joystick getDriveJoystick() {
        return driveJoystick;
    }
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
}

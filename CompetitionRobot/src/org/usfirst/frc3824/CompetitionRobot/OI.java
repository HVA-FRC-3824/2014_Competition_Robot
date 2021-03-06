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
    public JoystickButton joystickShootTwoPistons;
    public JoystickButton joystickShootThreePistons;
    public JoystickButton joystickToggleMainVacuum;
    public JoystickButton goToHome;
    public JoystickButton mainVacuumOn;
    public JoystickButton mainVacuumOff;
    public JoystickButton ballGuideOutButton;
    public JoystickButton ballGuideInButton;
    public Joystick driveJoystick;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public OI()
    {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        driveJoystick = new Joystick(1);
        
        ballGuideInButton = new JoystickButton(driveJoystick, 12);
        ballGuideInButton.whenPressed(new BallGuideIn());
        ballGuideOutButton = new JoystickButton(driveJoystick, 10);
        ballGuideOutButton.whenPressed(new BallGuideOut());
        mainVacuumOff = new JoystickButton(driveJoystick, 11);
        mainVacuumOff.whenPressed(new VacuumOff());
        mainVacuumOn = new JoystickButton(driveJoystick, 9);
        mainVacuumOn.whenPressed(new VacuumOn());
        goToHome = new JoystickButton(driveJoystick, 7);
        goToHome.whenPressed(new GoHome());
        joystickToggleMainVacuum = new JoystickButton(driveJoystick, 8);
        joystickToggleMainVacuum.whenPressed(new VacuumToggle());
        joystickShootThreePistons = new JoystickButton(driveJoystick, 3);
        joystickShootThreePistons.whenPressed(new CannonShootThreePistons());
        joystickShootTwoPistons = new JoystickButton(driveJoystick, 4);
        joystickShootTwoPistons.whenPressed(new CannonShootTwoPiston());
        joystickShoot = new JoystickButton(driveJoystick, 1);
        joystickShoot.whenPressed(new CannonShoot());
	    
        // SmartDashboard Buttons
        SmartDashboard.putData("Autonomous Test Vision", new AutonomousTestVision());
        SmartDashboard.putData("Go Home", new GoHome());
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        
        DigitalIOButton m_shooterAngleAdjustmentManual = new DigitalIOButton(Constants.INPUT_SHOOTER_ANGLE_ADJUSTMENT_MANUAL);
        m_shooterAngleAdjustmentManual.whileHeld(new SetShooterAngle());
        
        DigitalIOButton m_shooterAnglePickup = new DigitalIOButton(Constants.SHOOTER_ANGLE_PICKUP);
        m_shooterAnglePickup.whenPressed(new SetShooterAngle(Constants.SHOOTER_PICKUP_POSITION));
        
        DigitalIOButton m_shooterAngleLowGoal = new DigitalIOButton(Constants.SHOOTER_ANGLE_LOW_GOAL);
        m_shooterAngleLowGoal.whenPressed(new SetShooterAngle(Constants.SHOOTER_LOW_GOAL_POSITION));
                
        DigitalIOButton m_shooterAnglePass = new DigitalIOButton(Constants.SHOOTER_ANGLE_PASS);
        m_shooterAnglePass.whenPressed(new SetShooterAngle(Constants.SHOOTER_PASS_POSITION));
        
        DigitalIOButton m_shooterAngleShot = new DigitalIOButton(Constants.SHOOTER_ANGLE_REGULAR);
        m_shooterAngleShot.whenPressed(new SetShooterAngle(Constants.SHOOTER_REGULAR_SHOT_POSITION));
        
        DigitalIOButton m_shooterAngleTruss = new DigitalIOButton(Constants.SHOOTER_ANGLE_TRUSS);
        m_shooterAngleTruss.whenPressed(new SetShooterAngle(Constants.SHOOTER_TRUSS_POSITION));
                
        DigitalIOButton m_shooterAngleCorner = new DigitalIOButton(Constants.SHOOTER_ANGLE_CORNER);
        m_shooterAngleCorner.whenPressed(new SetShooterAngle(Constants.SHOOTER_CORNER_POSITION));
          
        DigitalIOButton m_shooterAngleTrussCatch = new DigitalIOButton(Constants.SHOOTER_ANGLE_TRUSS_CATCH);
        m_shooterAngleTrussCatch.whenPressed(new SetShooterAngle(Constants.SHOOTER_TRUSS_CATCH_POSITION));
        
        DigitalIOButton m_shooterAngleVertical = new DigitalIOButton(Constants.SHOOTER_ANGLE_VERTICAL);
        m_shooterAngleVertical.whenPressed(new SetShooterAngle(Constants.SHOOTER_VERTICAL_POSITION));
        
        DigitalIOButton m_pickupIn = new DigitalIOButton(Constants.INPUT_PICKUP_IN);
        m_pickupIn.whileHeld(new PickupBallIn());
        m_pickupIn.whenReleased(new PickupBallStop());
        
        DigitalIOButton m_pickupOut = new DigitalIOButton(Constants.INPUT_PICKUP_OUT);
        m_pickupOut.whileHeld(new PickupBallOut());
        m_pickupOut.whenReleased(new PickupBallStop());
        
        DigitalIOButton m_vacuum = new DigitalIOButton(Constants.INPUT_VACUUM_TOGGLE);
        m_vacuum.whenPressed(new VacuumOn());
        m_vacuum.whenReleased(new VacuumOff());
        
        SmartDashboard.putData("LocateHotGoal", new LocateHotGoal());
        
        DigitalIOButton m_homePosition = new DigitalIOButton(Constants.INPUT_HOME_POSITION);
        m_homePosition.whenPressed(new GoHome());
    }
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
    public Joystick getDriveJoystick() {
        return driveJoystick;
    }
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
}

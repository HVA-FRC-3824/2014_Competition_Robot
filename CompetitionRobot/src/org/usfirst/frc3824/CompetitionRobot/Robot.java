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
import org.usfirst.frc3824.CompetitionRobot.subsystems.Shooter;
import org.usfirst.frc3824.CompetitionRobot.subsystems.Drivetrain;
import org.usfirst.frc3824.CompetitionRobot.subsystems.Pump;
import org.usfirst.frc3824.CompetitionRobot.subsystems.Pickup;
import org.usfirst.frc3824.CompetitionRobot.subsystems.Vacuum;
import org.usfirst.frc3824.CompetitionRobot.commands.AutonomousCommand;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.camera.AxisCamera;
import edu.wpi.first.wpilibj.camera.AxisCameraException;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.image.ColorImage;
import edu.wpi.first.wpilibj.image.NIVisionException;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc3824.CompetitionRobot.commands.AutonomousDriveStraight;
import org.usfirst.frc3824.CompetitionRobot.commands.AutonomousDrivetoLeftBoxfromCenter;
import org.usfirst.frc3824.CompetitionRobot.commands.AutonomousDrivetoNotHotGoal;
import org.usfirst.frc3824.CompetitionRobot.commands.AutonomousDrivetoRightBoxfromCenter;
import org.usfirst.frc3824.CompetitionRobot.commands.LocateHotGoal;
import org.usfirst.frc3824.CompetitionRobot.subsystems.AuxiliaryLeft;
import org.usfirst.frc3824.CompetitionRobot.subsystems.ShooterAngleAdjustPID;
/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot
{
    Command autonomousCommand;
    public static OI oi;
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static Drivetrain drivetrain;
    public static Shooter shooter;
    public static Pump pump;
    public static Pickup pickup;
    public static ShooterAngleAdjustPID shooterAngleAdjustPID;;
    public static Vacuum vacuum;
    public static AuxiliaryLeft auxiliaryLeft;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    
    public static LocateHotGoal.TargetInfo hotGoalInfo;
    public static boolean cameraAvailable;
    public static SendableChooser chooser;
    public static Command selectedCommand;
    
    private static Timer timer = new Timer();
    
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit()
    {

            
        RobotMap.init();
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        drivetrain = new Drivetrain();
        shooter = new Shooter();
        pump = new Pump();
        pickup = new Pickup();
        shooterAngleAdjustPID = new ShooterAngleAdjustPID();
        vacuum = new Vacuum();
        auxiliaryLeft = new AuxiliaryLeft();
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        // This MUST be here. If the OI creates Commands (which it very likely
        // will), constructing it during the construction of CommandBase (from
        // which commands extend), subsystems are not guaranteed to be
        // yet. Thus, their requires() statements may grab null pointers. Bad
        // news. Don't move it.
        oi = new OI();
        // instantiate the command used for the autonomous period
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS
        autonomousCommand = new AutonomousCommand();
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS
        
        selectedCommand = null;
        chooser = new SendableChooser();
        chooser.addDefault("1) Do Nothing", new AutonomousCommand());
        chooser.addObject("2) Drive to NON-HOT goal", new AutonomousDrivetoNotHotGoal());
        chooser.addObject("3) Drive to right box", new AutonomousDrivetoRightBoxfromCenter());
        chooser.addObject("4) Drive to left box", new AutonomousDrivetoLeftBoxfromCenter());
        chooser.addObject("4) Drive straight", new AutonomousDriveStraight());
      // show the autonomous modes
        SmartDashboard.putData("AutonomousModes", chooser); 
        
        Timer startupTimeout = new Timer();
        startupTimeout.reset();
        startupTimeout.start();
        AxisCamera primeImageStream = AxisCamera.getInstance();
        ColorImage image;
        do{
            image = null;
            try
            {
                image = primeImageStream.getImage();
                System.out.println("ROBOT - prime: Image Found - primed");
            }
            catch(AxisCameraException ex)
            {
                System.out.println("ROBOT - prime: No Image Available -- " + ex.getMessage());
            }
            catch(NIVisionException ex)
            {
                
            }
            Timer.delay(0.25);
        } while ((image == null) && (startupTimeout.get() < Constants.CAMERA_STARTUP_TIMEOUT));
        startupTimeout.stop();
        
        // if the image is null, set cameraAvailable to FALSE;
        cameraAvailable = !(null == image);
    }
    public void autonomousInit()
    {
        // schedule the autonomous command (example)
        selectedCommand = (Command) chooser.getSelected();
        if(selectedCommand != null)
        {
            selectedCommand.start();
        }
    }
    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic()
    {
        Scheduler.getInstance().run();
    }
    public void teleopInit()
    {
        // This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (selectedCommand != null)
        {
            selectedCommand.cancel();
        }
    }
    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic()
    {
        // Print out sensor information
        SmartDashboard.putNumber("Shooter Angle (ADC)", Robot.shooterAngleAdjustPID.getPotentiometer().pidGet());
        SmartDashboard.putNumber("Shooter Angle (Degrees)", (0.0387*Robot.shooterAngleAdjustPID.getPotentiometer().pidGet()) + 11.916);
        SmartDashboard.putNumber("Gyro", Robot.drivetrain.getGyroValue());
        Scheduler.getInstance().run();
    }
    /**
     * This function called periodically during test mode
     */
    public void testPeriodic()
    {
        LiveWindow.run();
    }
}

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
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc3824.CompetitionRobot.Constants;
import org.usfirst.frc3824.CompetitionRobot.Robot;
/**
 *
 */
public class AuxiliaryLeft extends Subsystem
{
    private boolean m_vacuumActive = false;
    
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    SpeedController shooterMotor = RobotMap.auxiliaryLeftShooterMotor;
    AnalogChannel shooterAngle = RobotMap.auxiliaryLeftShooterAngle;
    PIDController shooterAnglePID = RobotMap.auxiliaryLeftShooterAnglePID;
    DoubleSolenoid verticalAdjust = RobotMap.auxiliaryLeftVerticalAdjust;
    SpeedController vacuum = RobotMap.auxiliaryLeftVacuum;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void initDefaultCommand()
    {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        // Vacuum is on/off only, set the direction to forward only, so ON is 
        //  equivalent to kForward
        vacuum.set(0.0);
        verticalAdjust.set(DoubleSolenoid.Value.kOff);
    }
    
    //------------------------------------------------------------------------------------
    // Deployment piston control methods
    //------------------------------------------------------------------------------------
    public void setVerticalDeploy()
    {
        verticalAdjust.set(DoubleSolenoid.Value.kForward);
    }
    
    public void setVerticalRetract()
    {
        verticalAdjust.set(DoubleSolenoid.Value.kReverse);
    }
    
    public void setVerticalStop()
    {
        verticalAdjust.set(DoubleSolenoid.Value.kOff);
    }
        
    //------------------------------------------------------------------------------------
    // Vacuum Control methods
    //------------------------------------------------------------------------------------
    public void setVacuumOff()
    {
        vacuum.set(0.0);
        m_vacuumActive = false;
    }
    
    public void setVacuumOn()
    {
        vacuum.set(1.0);
        m_vacuumActive = true;
    }
    
    public void vacuumToggle()
    {
       if(m_vacuumActive == true)
        {
            // if vacuum is on, turn it off!
            vacuum.set(0.0); 
            m_vacuumActive = false;
        }
        else if(m_vacuumActive == false)
        {
            // if vacuum is off, turn it on!
            vacuum.set(1.0);
            m_vacuumActive = true;
        }
    }
    
    //------------------------------------------------------------------------------------
    // Shooter Angle Control methods
    //------------------------------------------------------------------------------------
    public void setShooterAngle(double adcVal)
    { 
        // Convert angle into 0-5V for the PID
        //shooterAnglePID.reset();
        shooterAnglePID.setSetpoint(adcVal);
        shooterAnglePID.enable();
    }
    
    public double getShooterSetpoint()
    {
        return shooterAnglePID.getSetpoint();
    }
    
    public void setShooterTestPID(double pid)
    { 
        shooterAnglePID.setSetpoint(pid);
    }
    
    public void setShooterTestStartPID()
    {
        shooterAnglePID.enable();
    }
    
    public void setShooterStop()
    {
        // Disables the PID
        shooterAnglePID.disable();
    }
    
    public boolean getAtAngle()
    {
        return shooterAnglePID.onTarget();
    }
    
    public double getMotorPower()
    {
        return shooterMotor.get();
    }
    
    //------------------------------------------------------------------------------------
    // Conversion methods
    //------------------------------------------------------------------------------------
    /*
    private double convertAngleToADC(double angle)
    {
       double angleRatio;
       
       angleRatio = ((angle - Constants.AUX_MIN_ANGLE) / (Constants.AUX_MAX_ANGLE - Constants.AUX_MIN_ANGLE));
       return (Constants.AUX_MAX_ANGLE_ADCVAL - Constants.AUX_MIN_ANGLE_ADCVAL) * angleRatio + Constants.AUX_MIN_ANGLE_ADCVAL;
    }
    
    private double convertADCtoAngle(double ADC)
    {
       double adcRatio;
       
       adcRatio = (ADC - Constants.AUX_MIN_ANGLE_ADCVAL) / (Constants.AUX_MAX_ANGLE_ADCVAL - Constants.AUX_MIN_ANGLE_ADCVAL);
       return (Constants.AUX_MAX_ANGLE - Constants.AUX_MIN_ANGLE) * (adcRatio) + Constants.AUX_MIN_ANGLE;
    }
    
    
    public double getAuxiliaryAngle()
    {
        return convertADCtoAngle(shooterAngle.pidGet());
    }
    */
    
    public double getAuxiliaryPIDValue()
    {
        return shooterAngle.pidGet();
    }
}

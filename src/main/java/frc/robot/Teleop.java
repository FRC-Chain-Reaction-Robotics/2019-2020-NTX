package frc.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import com.ctre.phoenix.motorcontrol.ControlMode;

public class Teleop {
	private DriveTrain drivetrain;
	private OI oi;
	private boolean boost,turning,speedToggle,modeToggle,arcade,rumble1,rumble2;
	private double sensitivity,preSensitivity;
	                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 
	public Teleop(DriveTrain dt, OI O) {
		drivetrain = dt;
		oi = O;
		boost = false;
		speedToggle=false;
		turning = false;
		modeToggle=false;
		arcade=true;
		sensitivity=.3;
		preSensitivity = sensitivity;
		rumble1=false;
		rumble2=false;
	}
	public void init() {}
    // public void demo()
    // {
	// 	boost=oi.drive.getRawButton(5)&&oi.drive.getRawButton(6);
		
	// 	if(powerFast)sensitivity=.5;
	// 	if(boost)sensitivity=.3;
    //     drivetrain.getRightMaster().set(ControlMode.PercentOutput, (oi.getDriveLeftY()+oi.getDriveRightX())* -1 * sensitivity);
    //     drivetrain.getLeftMaster().set(ControlMode.PercentOutput, (oi.getDriveLeftY()-oi.getDriveRightX()) *-1* sensitivity);

	// }
	public void DemoPlusMK2()
	{
		speedToggle=oi.drive.getRawButtonPressed(2);
		modeToggle=oi.drive.getRawButtonPressed(8);
		turning = oi.getDriveRightX()!=0;
		rumble1 = oi.drive.getRawButton(1);
		rumble2 = oi.drive.getRawButton(4);
		
		if(speedToggle)
		{
			if(boost)boost=false;
			else boost = true;
		}
		if(modeToggle)
		{
			if(arcade)arcade=false;
			else arcade = true;
		}
		if(rumble1){ oi.drive.setRumble(RumbleType.kRightRumble,1);oi.drive.setRumble(RumbleType.kLeftRumble, 1);}
		else if(rumble2){oi.drive.setRumble(RumbleType.kLeftRumble, 2);oi.drive.setRumble(RumbleType.kRightRumble, 2);}
		else{ oi.drive.setRumble(RumbleType.kLeftRumble, 0);oi.drive.setRumble(RumbleType.kRightRumble, 0);}
			if(boost)
			{
				if(turning)sensitivity=.40;
		else sensitivity=.5;
				if(arcade)
				{
					drivetrain.getRightMaster().set(ControlMode.PercentOutput, (oi.getDriveLeftY()+oi.getDriveRightX())* -1 * sensitivity);
        drivetrain.getLeftMaster().set(ControlMode.PercentOutput, (oi.getDriveLeftY()-oi.getDriveRightX()) *-1* sensitivity);
		SmartDashboard.putBoolean("arcade", true);
		SmartDashboard.putNumber("sensitivity", sensitivity);
				}
				else
				{
					drivetrain.getRightMaster().set(ControlMode.PercentOutput, (oi.getDriveLeftY()+oi.getDriveLeftX())* -1 * sensitivity);
        drivetrain.getLeftMaster().set(ControlMode.PercentOutput, (oi.getDriveLeftY()-oi.getDriveLeftX()) *-1* sensitivity);
		SmartDashboard.putBoolean("arcade", false);
		SmartDashboard.putNumber("sensitivity", sensitivity);
				}
        
			}
			else
			{
				if(turning)sensitivity=.25;
				else sensitivity=.3;
				
				if(arcade)
				{
				drivetrain.getRightMaster().set(ControlMode.PercentOutput, (oi.getDriveLeftY()+oi.getDriveRightX())* -1 * sensitivity);
        drivetrain.getLeftMaster().set(ControlMode.PercentOutput, (oi.getDriveLeftY()-oi.getDriveRightX()) *-1* sensitivity);
		SmartDashboard.putBoolean("arcade", true);
		SmartDashboard.putNumber("sensitivity", sensitivity);
				}
				else
				{
					drivetrain.getRightMaster().set(ControlMode.PercentOutput, (oi.getDriveLeftY()+oi.getDriveLeftX())* -1 * sensitivity);
        drivetrain.getLeftMaster().set(ControlMode.PercentOutput, (oi.getDriveLeftY()-oi.getDriveLeftX()) *-1* sensitivity);
		SmartDashboard.putBoolean("arcade", false);
		SmartDashboard.putNumber("sensitivity", sensitivity);
				}
			}
		

	}


public void DemoPlusMK1()
	{
		boost=oi.drive.getRawButton(5)&&oi.drive.getRawButton(6)&&!turning;
		turning = oi.getDriveRightX()!=0;
		
		//System.out.println(oi.getDriveRightX());
		if(turning)sensitivity=.25;
		else sensitivity=preSensitivity;
		if(boost)sensitivity=.5;
		
        drivetrain.getRightMaster().set(ControlMode.PercentOutput, (oi.getDriveLeftY()+oi.getDriveRightX())* -1 * sensitivity);
        drivetrain.getLeftMaster().set(ControlMode.PercentOutput, (oi.getDriveLeftY()-oi.getDriveRightX()) *-1* sensitivity);
		System.out.println(sensitivity);

	}
	public void DemoPlusMK3()
	{
		speedToggle=oi.drive.getRawButtonPressed(8);
		//modeToggle=oi.drive.getRawButtonPressed(8);
		turning = oi.getDriveRightX()!=0;
		if(speedToggle)
		{
			if(boost)boost=false;
			else boost = true;
		}
		// if(modeToggle)
		// {
		// 	if(arcade)arcade=false;
		// 	else arcade = true;
		// }
			if(boost)
			{
				if(turning)sensitivity=.80;
		else sensitivity=.9;
				if(arcade)
				{
					drivetrain.getRightMaster().set(ControlMode.PercentOutput, (oi.getDriveLeftY()+oi.getDriveRightX())* -1 * sensitivity);
        drivetrain.getLeftMaster().set(ControlMode.PercentOutput, (oi.getDriveLeftY()-oi.getDriveRightX()) *-1* sensitivity);
		SmartDashboard.putBoolean("arcade", true);
		SmartDashboard.putNumber("sensitivity", sensitivity);
				}
				else
				{
					drivetrain.getRightMaster().set(ControlMode.PercentOutput, (oi.getDriveLeftY()+oi.getDriveLeftX())* -1 * sensitivity);
        drivetrain.getLeftMaster().set(ControlMode.PercentOutput, (oi.getDriveLeftY()-oi.getDriveLeftX()) *-1* sensitivity);
		SmartDashboard.putBoolean("arcade", false);
		SmartDashboard.putNumber("sensitivity", sensitivity);
				}
        
			}
			else
			{
				if(turning)sensitivity=.25;
				else sensitivity=.3;
				
				if(arcade)
				{
				drivetrain.getRightMaster().set(ControlMode.PercentOutput, (oi.getDriveLeftY()+oi.getDriveRightX())* -1 * sensitivity);
        drivetrain.getLeftMaster().set(ControlMode.PercentOutput, (oi.getDriveLeftY()-oi.getDriveRightX()) *-1* sensitivity);
		SmartDashboard.putBoolean("arcade", true);
		SmartDashboard.putNumber("sensitivity", sensitivity);
				}
				else
				{
					drivetrain.getRightMaster().set(ControlMode.PercentOutput, (oi.getDriveLeftY()+oi.getDriveLeftX())* -1 * sensitivity);
        drivetrain.getLeftMaster().set(ControlMode.PercentOutput, (oi.getDriveLeftY()-oi.getDriveLeftX()) *-1* sensitivity);
		SmartDashboard.putBoolean("arcade", false);
		SmartDashboard.putNumber("sensitivity", sensitivity);
				}
			}
		

	}	
}



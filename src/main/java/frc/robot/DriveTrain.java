package frc.robot;

import edu.wpi.first.wpilibj.IterativeRobot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;


import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.Timer;

public class DriveTrain {
	/*changes from old DriveTrain class:
	 * CANTalon = TalonSRX
	 * set(value) + changeControlMode(mode) = set(mode, value)
	 * configNominalOutputVoltage / configPeakOutputVoltage / configMaxOutputVoltage = configPeakOutputForward / configPeakOutputReverse / configNominalOutputForward / configNominalOutputReverse
	 * enableBrakeMode = setNeutralMode
	 * SetFeedbackDevice = ConfigSelectedFeedbackSensor
	 */
	 
	private TalonSRX rightMaster, rightSlave, leftMaster, leftSlave;
	private Timer timer;
	
	private boolean on, off;
	private OI oi;
	
	public DriveTrain(OI o) {
		
		rightMaster = new TalonSRX(14);//4
		rightSlave = new TalonSRX(17);//2
		leftMaster = new TalonSRX(20);//1
		leftSlave = new TalonSRX(18);//3

		oi = o;
		on = false;
		off = false;
		
		rightSlave.set(ControlMode.Follower, rightMaster.getDeviceID());
		leftSlave.set(ControlMode.Follower, leftMaster.getDeviceID());
		
		leftMaster.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute, 0, 0);
		rightMaster.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute, 0, 0);
		
		rightMaster.configNominalOutputForward(0.0, 0);
        rightMaster.configNominalOutputReverse(0.0, 0);
		leftMaster.configNominalOutputForward(0.0, 0);
        leftMaster.configNominalOutputReverse(0.0, 0);
        
        rightMaster.configPeakOutputForward(1, 0);
        rightMaster.configPeakOutputReverse(-1, 0);
        leftMaster.configPeakOutputForward(1, 0);
        leftMaster.configPeakOutputReverse(-1, 0);
        
		rightSlave.configNominalOutputForward(0.0, 0);
        rightSlave.configNominalOutputReverse(0.0, 0);
		leftMaster.configNominalOutputForward(0.0, 0);
        leftSlave.configNominalOutputReverse(0.0, 0);
        
        rightSlave.configPeakOutputForward(1, 0);
        rightSlave.configPeakOutputReverse(-1, 0);
        leftSlave.configPeakOutputForward(1, 0);
        leftSlave.configPeakOutputReverse(-1, 0);
        
        rightMaster.setNeutralMode(NeutralMode.Brake);
        rightSlave.setNeutralMode(NeutralMode.Brake);
        leftMaster.setNeutralMode(NeutralMode.Brake);
        leftSlave.setNeutralMode(NeutralMode.Brake);
        
        leftMaster.setSensorPhase(true);
        leftSlave.setSensorPhase(true);
        rightMaster.setSensorPhase(true);
        rightSlave.setSensorPhase(true);
        
        rightMaster.setInverted(true);
        rightSlave.setInverted(false);
        
        leftMaster.setInverted(true);
        leftSlave.setInverted(false);
        
        //ahrs = new AHRS(SPI.Port.kMXP, (byte) 200);
        
	}
	
	public TalonSRX getRightMaster() {
		return rightMaster;
	}
	
	public TalonSRX getRightSlave() {
		return rightSlave;
	}
	
	public TalonSRX getLeftMaster() {
		return leftMaster;
	}
	
	public TalonSRX getLeftSlave() {
		return leftSlave;
	}
	

	
	
}

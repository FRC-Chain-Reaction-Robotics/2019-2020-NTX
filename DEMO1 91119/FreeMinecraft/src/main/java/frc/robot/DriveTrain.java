package frc.robot;

import edu.wpi.first.wpilibj.IterativeRobot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;


import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.Timer;

public class DriveTrain{
    private OI consolePleb;
    private TalonSRX LMotor1, LMotor2, RMotor1, RMotor2;
    public DriveTrain(){
        consolePleb = new OI();
        LMotor1 = new TalonSRX(0);
        LMotor2 = new TalonSRX(1);
        RMotor1 = new TalonSRX(2);
        RMotor2 = new TalonSRX(3);

        LMotor2.set(ControlMode.Follower, LMotor1.getDeviceID());
        RMotor2.set(ControlMode.Follower, RMotor1.getDeviceID());

        LMotor1.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute, 0, 0);
    }
}
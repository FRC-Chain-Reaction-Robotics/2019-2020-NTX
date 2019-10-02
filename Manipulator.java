package frc.robot;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;

import javax.lang.model.util.ElementScanner6;

import com.ctre.phoenix.motorcontrol.*;
import com.ctre.phoenix.motorcontrol.can.*;
//import com.revrobotics.*;
//import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.DigitalInput;
public class Manipulator
{
    private TalonSRX inOut;
    private OI oi;
    private boolean xIsPressed;
    private DigitalInput limitMax, limitMin;
    public Manipulator(OI other)
    {
        inOut = new TalonSRX(1);
        oi = other;
        xIsPressed = false;

    }
    public void intakeOuttake()
    {
        if(oi.getX())
        {
            inOut.set(ControlMode.PercentOutput,-0.5);
        } else if(oi.getB())
        {
            inOut.set(ControlMode.PercentOutput,0.5);
        } else {
            inOut.set(ControlMode.PercentOutput,0);
        }
    }
}


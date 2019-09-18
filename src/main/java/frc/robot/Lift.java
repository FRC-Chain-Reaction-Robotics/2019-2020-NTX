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

public class Lift
{
    private OI oi;
    private Teleop teleop;
    private boolean button1Pressed, hatch;
    private int countOfLifts;
    private boolean yIsPressed;
    private boolean bIsPressed;
    private boolean xIsPressed;
    private boolean aIsPressed;
    private boolean up;
    private TalonSRX lift;
    private AnalogInput potent;
    private boolean forward,reverse;
    private boolean speedChange;
    private double speed;
    
    public Lift(OI o)
    {
        oi = o;
        lift = new TalonSRX(2);
        potent = new AnalogInput(0);
        yIsPressed = false;
        xIsPressed = false;
        aIsPressed = false;
        bIsPressed = false;
        hatch = false;
        up = true;
        countOfLifts =0;
        forward = reverse = false;
        speed = 0.0;
        speedChange = false;
    }



    //default is cargo
    //if press it goes to hatch mode if press again back to cargo mode
    public void cargoOrHatch()
    {
        if(oi.getBoxA())
        {
            yIsPressed = true;
        }
        if(yIsPressed && !(oi.getBoxA()))
        {
            yIsPressed = false;
            hatch = !hatch;
        } 
    }

    public void withPot()
    {
        if(hatch)
        {
            if(oi.getBoxB())
            {
                if(getPotent() < 500)
                    while(getPotent() < 500)
                        lift.set(ControlMode.PercentOutput, 0.5);
                else if(getPotent() > 500)
                    while(getPotent() > 500)
                        lift.set(ControlMode.PercentOutput, -0.5);
                else
                    lift.set(ControlMode.PercentOutput,0);
            }
            if(oi.getBoxC())
            {
                if(getPotent() < 1000)
                    while(getPotent() < 1000)
                        lift.set(ControlMode.PercentOutput, 0.5);
                else if(getPotent() > 1000)
                    while(getPotent() > 1000)
                        lift.set(ControlMode.PercentOutput, -0.5);
                else
                    lift.set(ControlMode.PercentOutput,0);
            }
            if(oi.getBoxD())
            {
                if(getPotent() < 1500)
                    while(getPotent() < 1500)
                        lift.set(ControlMode.PercentOutput,0.5);
                else if(getPotent() > 1500)
                    while(getPotent() > 1500)
                        lift.set(ControlMode.PercentOutput, -0.5);
                else
                    lift.set(ControlMode.PercentOutput,0);        
            }
        }
        else
        {
            if(oi.getBoxB())
            {
                if(getPotent() < 750)
                    while(getPotent() < 750)
                        lift.set(ControlMode.PercentOutput,0.5);
                else if(getPotent() > 750)
                    while(getPotent() > 750)
                        lift.set(ControlMode.PercentOutput,-0.5);
                else
                    lift.set(ControlMode.PercentOutput,0);
            }
            if(oi.getBoxC())
            {
                if(getPotent() < 1250)
                    while(getPotent() < 1250)
                        lift.set(ControlMode.PercentOutput,0.5);
                else if(getPotent() > 1250)
                    while(getPotent() > 1250)
                        lift.set(ControlMode.PercentOutput,-0.5);
                else
                    lift.set(ControlMode.PercentOutput,0);
            }
            if(oi.getBoxD())
            {
                if(getPotent() < 1750)
                    while(getPotent() < 1750)
                        lift.set(ControlMode.PercentOutput,0.5);
                else if(getPotent() > 1750)
                    while(getPotent() > 1750)
                        lift.set(ControlMode.PercentOutput,-0.5);
                else
                    lift.set(ControlMode.PercentOutput,0);
            }
        }
    }

    public void withoutPot()
    {
        if(hatch)
        {

        }
        else
        {
            
        }
    }

    public int getPotent()
    {
        return potent.getValue();
    }
    public void noLimit()
    {
            forward = oi.getDriveLeftTrigger()==1;
            reverse = oi.getDriveRightTrigger()==1;
            speedChange = oi.drive.getRawButtonPressed(7);
            if(speedChange)
            {
                if(speed==0)speed=.2;
                else if(speed==.2)speed=.25;
                else if(speed==.25)speed=.3;
                else if(speed==.3)speed=.35;
                else if(speed==.35)speed=.4;
                else if(speed==.4)speed=.45;
                else if(speed==.45)speed=.5;
                else if(speed==.5)speed=.55;
                else if(speed==.55)speed=.60;
                else if(speed==.6)speed=.65;
                else if(speed==.65)speed=.70;
                else if(speed==.7)speed=.75;
                else if(speed==.75)speed=.8;
                else if(speed==.8)speed=.85;
                else if(speed==.85)speed=.9;
                else if(speed==.9)speed=.95;
                else if(speed==.95)speed=1;
                else if(speed==1)speed=.0;
            }
            SmartDashboard.putNumber("4barspeed", speed);
            

            if(forward)
            {
                lift.set(ControlMode.PercentOutput, speed);
                System.out.println("for");
            }
            else if(reverse)
            {
                lift.set(ControlMode.PercentOutput, -1*speed);
                System.out.println("rev");
            }
            else
            {
                lift.set(ControlMode.PercentOutput, 0);
            }
            SmartDashboard.putNumber("4barspeed", speed);
            System.out.println("no");
    }
}
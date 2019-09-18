package frc.robot;

import javax.lang.model.util.ElementScanner6;

import com.ctre.phoenix.motorcontrol.*;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Servo;
//import edu.wpi.fir  
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
public class Climb
{
    private TalonSRX talon1,talon2;
    private DigitalInput top;
    private DigitalInput bottom;
    private OI oi;
    private boolean boxAIsPressed;
    private boolean boxBIsPressed;
    private boolean xIsPressed, bIsPressed;
    private Intake intake;
    private boolean forward,reverse;
    private Servo servo;
    private double value;

    public Climb(OI o, Intake i)
    {
        oi = o;
        intake = i;
        value = 0;
        talon1 = new TalonSRX(12);
        talon2 = new TalonSRX(13);
        servo = new Servo(9);
        top = new DigitalInput(0);
        bottom = new DigitalInput(1);
        boxAIsPressed = false;
        boxBIsPressed = false;
        xIsPressed = false;
        bIsPressed = false;
        forward=reverse=false;
    }
    public Climb(OI o)
    {
        oi = o;
        value= 0.0;
        talon1 = new TalonSRX(12);
        talon2 = new TalonSRX(13);
        top = new DigitalInput(0);
        servo = new Servo(4);
        bottom = new DigitalInput(1);
        boxAIsPressed = false;
        boxBIsPressed = false;
        xIsPressed = false;
        bIsPressed = false;
        forward=reverse=false;
    }

    public void climb()
    {

        //up
            //servo.set(Engaged)
            //m1.set(PO, 0.5)
            //m2.set(PO, -0.5)
        //down
            //m1.set(PO, -0.1)
            //m2.set(PO, 0.1)
            //servo.set(DisEngaged)

        
        if(oi.getX())
            boxAIsPressed = true;
        if(boxAIsPressed && (oi.getBoxA()))
            boxAIsPressed = false;
        if(oi.getY())
            boxBIsPressed = true;
        if(boxBIsPressed && (oi.getBoxB()))
            boxBIsPressed = false;
        if(boxAIsPressed)
        {
            while(!top.get())
            {
                talon1.set(ControlMode.PercentOutput, 0.2);
                talon2.set(ControlMode.PercentOutput, -0.2);
                intake.pivot();
            }
        }
        else if(boxBIsPressed)
        {
            while(!bottom.get())
            {
                talon1.set(ControlMode.PercentOutput, -0.2);
                talon2.set(ControlMode.PercentOutput, 0.2);
            }
        }
        else
        {
            talon1.set(ControlMode.PercentOutput, 0);
            talon2.set(ControlMode.PercentOutput, 0);
        }
    }
    public void noLimit()
    {
        forward=oi.drive.getRawButton(1);
        reverse=oi.drive.getRawButton(2);
        boolean engage = oi.drive.getRawButton(3);
        boolean disengage = oi.drive.getRawButton(4);
        boolean start = oi.drive.getRawButton(7);
        boolean stop = oi.drive.getRawButton(8);
        // 0 to 45
        if(engage)  servo.setAngle(0);

        if(disengage)  servo.setAngle(45);


        SmartDashboard.putNumber("val",value);

        if(forward)
        {
            talon1.set(ControlMode.PercentOutput,.5);
            talon2.set(ControlMode.PercentOutput, -.5);
        }
        else if(reverse)
        {
            
        }
        else if(start)
        {
            talon1.set(ControlMode.PercentOutput,1);
            talon2.set(ControlMode.PercentOutput, -1);
        }
        else if(stop)
        {
            talon1.set(ControlMode.PercentOutput,-1);
            talon2.set(ControlMode.PercentOutput, 1);
        }
        else
        {
            talon1.set(ControlMode.PercentOutput,0);
            talon2.set(ControlMode.PercentOutput, 0);
        }
    }
    public double getTheAngle()
    {
        return servo.getAngle();
    }   
}

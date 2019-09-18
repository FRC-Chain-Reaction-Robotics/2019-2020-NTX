package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
//import com.revrobotics.CANSparkMax;
//import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Intake
{
    private PWMVictorSPX intake; 
    private PWMVictorSPX box;
    private OI oi;
    private TalonSRX pivot;
    private Boolean speedChange;
    private double speed;
    public Intake(OI o)
    {
        oi = o;
        intake = new PWMVictorSPX(1);
        pivot = new TalonSRX(19);
        box = new PWMVictorSPX(2);
        speed = 0.0;
        speedChange =false;
    }

    public void takeIn()
    {
        speedChange = oi.drive.getRawButtonPressed(6);
            if(speedChange)
            {
                if(speed==0)speed=.2;
                else if(speed==.2)speed=.30;
                else if(speed==.30)speed=.4;
                else if(speed==.4)speed=.5;
                else if(speed==.5)speed=.6;
                else if(speed==.6)speed=.7;
                else if(speed==.7)speed=.8;
                else if(speed==.8)speed=.9;
                else if(speed==.9)speed=1;
                else if(speed==1)speed=0;
            }
            SmartDashboard.putNumber("victorSpeed", speed);
        if(oi.getBoxF())
        {
            intake.set(-1*speed);
            box.set(-1*speed);
        }
        else if(oi.getBoxG())
        {
            intake.set(speed);
            box.set(speed);
        }else{
            intake.set(0);
            box.set(0);
        }
    }

    public void pivot()
    {
        if(oi.getBoxD())
        {
            pivot.set(ControlMode.PercentOutput,0.5);
        }
        else if(oi.getBoxH())
        {
            pivot.set(ControlMode.PercentOutput,-0.5);
        } else 
        {
            pivot.set(ControlMode.PercentOutput,0);
        }
    }

    public void boxMove()
    {
        // speedChange = oi.drive.getRawButtonPressed(6);
        //     if(speedChange)
        //     {
        //         if(speed==0)speed=.2;
        //         else if(speed==.2)speed=.30;
        //         else if(speed==.30)speed=.4;
        //         else if(speed==.4)speed=.5;
        //         else if(speed==.5)speed=.6;
        //         else if(speed==.6)speed=.7;
        //         else if(speed==.7)speed=.8;
        //         else if(speed==.8)speed=.9;
        //         else if(speed==.9)speed=1;
        //         else if(speed==1)speed=0;
        //     }
            //SmartDashboard.putNumber("victorSpeed", speed);
        if(oi.getBoxG())
            box.set(speed);
        else if(oi.getBoxH())
            box.set(-1*speed);
        else
            box.set(0);
    }
}
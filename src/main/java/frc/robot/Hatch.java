package frc.robot;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;

import javax.lang.model.util.ElementScanner6;

import com.ctre.phoenix.motorcontrol.*;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Hatch
{
    private PWMVictorSPX hatch;
    private OI oi;
    private Teleop teleop;
    private boolean speedChange;
    private double speed;
    public Hatch(OI o)
    {
        oi=o;
        hatch = new PWMVictorSPX(3);
        speed = 0.0;
        speedChange = false;
    }

    public void grabHatch()
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
        //     SmartDashboard.putNumber("victorSpeed", speed);
        if(oi.getBoxB())
            hatch.set(0.5);
        else if(oi.getBoxC())
            hatch.set(-0.5);
        else
            hatch.set(0);
    }
}
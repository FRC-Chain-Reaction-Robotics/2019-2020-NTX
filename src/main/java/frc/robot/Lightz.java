package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
//import com.revrobotics.CANSparkMax;
//import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Lightz
{
    private Spark led;
    private OI oi;
    private Boolean valChangeUp,valChangeDown,ledChange;
    private double val;
    public Lightz(OI o)
    {
        oi = o;
        led = new Spark(4);
        val=0.0;        
        valChangeUp =valChangeDown=false;
        ledChange= false;
    }

    

    public void LightSwitch()
    {
         ledChange = oi.drive.getRawButtonPressed(1);
         valChangeUp = oi.drive.getRawButtonPressed(2);
         valChangeDown = oi.drive.getRawButtonPressed(3);
         if(valChangeUp)val+=.01;
         if(valChangeDown)val-=.01;
         if(ledChange)led.set(val);
         SmartDashboard.putNumber("ledval", val);
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
        
}
}
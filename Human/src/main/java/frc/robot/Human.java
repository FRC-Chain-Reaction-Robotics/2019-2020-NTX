package frc.robot;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import javax.lang.model.util.ElementScanner6;
import com.ctre.phoenix.motorcontrol.*;
import com.ctre.phoenix.motorcontrol.can.*;
import com.revrobotics.*;

public class Human{
    private OI oi;
    private Teleop teleop;
    private boolean yIsPressed;
    private boolean up;
    private TalonSRX shakira;
    private boolean speedChange;
    private double speed;

    public Human (OI jeff)
    {
        oi = jeff; //yes
        shakira = new TalonSRX(2);
        yIsPressed = false;
        speed = 0.0;
        speedChange = false;
    }
    public void movement ()
    {
            if(oi.getY())
            {
                shakira.set(ControlMode.PercentOutput, -0.7);
            }
            else{
                shakira.set(ControlMode.PercentOutput, 0.0);
            }

    }

}


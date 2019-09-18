package frc.robot;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class Driver{
    private TalonSRX one;
    private OI oi;
    public Driver(OI other){
        one = new TalonSRX(4);
        oi = other;
    }
    public void move(){
        if(oi.getA()){
            one.set(ControlMode.PercentOutput, 0.5);
        }else{
            one.set(ControlMode.PercentOutput, 0);
        }
    }
}
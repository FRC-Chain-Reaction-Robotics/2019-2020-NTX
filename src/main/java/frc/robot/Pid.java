package frc.robot;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
public class Pid
{

    private double p;
    private double i;
    private double d;
    private double f;
    private int error;
    boolean Apushed = false;


    private TalonSRX motor;
    private OI o;
    public Pid()
    {
        motor = new TalonSRX(6);
        motor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative);
        o = new OI();
        ///p= 128*2*1.35*2*8*8*2;
        //i= 0;
        //d= p;
        //f= 0.010180266 ; good values
        p= 128*128*128*128/2;
        i= 0;//(128*128 *.54)/(1/16)/10;
        d= p *1.05;
        f=  0.010180266 ; 
    }
    //0.010180266 for f
    public void init(OI oi){
        turnWheel(o);
        
        //SmartDashboard.putNumber("Position", motor.getSensorCollection().getPulseWidthPosition());
        //SmartDashboard.putNumber("Width US", motor.getSensorCollection().getPulseWidthRiseToFallUs());
        //SmartDashboard.putNumber("Period US", motor.getSe0nsorCollection().getPulseWidthRiseToRiseUs());
        //SmartDashboard.putNumber("Pulse Width Velocity", motor.getSensorCollection().getPulseWidthVelocity());
        motor.config_kP(0, p);
        motor.config_kI(0, i);
        motor.config_kD(0, d);
        motor.config_kF(0, f);
        
    }
    public void turnWheel(OI oi){
        if(oi.drive.getRawButtonPressed(3)){
            motor.set(ControlMode.Position, 500);
            
            
        } else if(oi.getY()){zeroSensor();}
        
        /*if(oi.getA())
        {
            motor.set(ControlMode.PercentOutput,1);
        }
        if(oi.getB()){
            motor.set(ControlMode.PercentOutput,0);
        }
        */
    
        else if(oi.getA() || motor.getSelectedSensorPosition()>=500)
        {
            motor.set(ControlMode.PercentOutput, 0);
        }
        

    }

    public int getError()
    {
        
        error = Math.abs(motor.getSelectedSensorPosition(0) - 500);
        return error;
    }

    public void setP(int value){
        p=value;
    }
    public void setI(int value){
        i=value;
    }
    public void setD(int value){
        d=value;
    }
    public void setF(int value){
        f=value;
    }
    public void zeroSensor()
    {
        motor.setSelectedSensorPosition(0);
    }
    public TalonSRX getMotor(){return motor;}
    public double getP(){return p;}
    public double getF(){return f;}
    public double getI(){return i;}
    public double getD(){return d;}
}
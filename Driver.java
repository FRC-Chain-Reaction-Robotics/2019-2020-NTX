package frc.robot;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class Driver{
    double Ly;
    double Lx;
    double Ry;
    double Rx;
    private double ina = 0.1;
    private double speed;

    private TalonSRX one,two,three,four;
    private OI oi;

    
    public Driver(OI other){
        one = new TalonSRX(1);		//Left front  4
        two = new TalonSRX(3);		//left back  3
        three = new TalonSRX(4);	//right front 14
        four = new TalonSRX(2);		//right back 20
        speed = .4;
        oi = other;
    }
    public double inaJoyMap (double joyVal) {
    
            joyVal *= (1-ina);
        return joyVal;
    }
    public void move(){
           
           /* Ly = oi.getDriveLeftY();
            Lx = oi.getDriveLeftX();
            Ry = oi.getDriveRightY();
            Rx = oi.getDriveRightX();
                        
            Ly = inaJoyMap(Ly);
            Lx = inaJoyMap(Lx);
            Ry = inaJoyMap(Ry);
            Rx = inaJoyMap(Rx);

            if (Ly != 0){
                one.set(ControlMode.PercentOutput, Ly);
                two.set(ControlMode.PercentOutput, Ly);
                three.set(ControlMode.PercentOutput, Ly);
                four.set(ControlMode.PercentOutput, Ly);
            } else if (Rx != 0){
                one.set(ControlMode.PercentOutput, Rx);
                two.set(ControlMode.PercentOutput, -Rx);
                three.set(ControlMode.PercentOutput, Rx);
                four.set(ControlMode.PercentOutput, -Rx);
            } else { 
                one.set(ControlMode.PercentOutput, 0);
                two.set(ControlMode.PercentOutput, 0);
                three.set(ControlMode.PercentOutput, 0);
                four.set(ControlMode.PercentOutput, 0);            
            }
            */
            







        if(oi.getDriveRightX()>0){
            one.set(ControlMode.PercentOutput, -0.3);
            two.set(ControlMode.PercentOutput, -.3);
            three.set(ControlMode.PercentOutput,0.3);
            four.set(ControlMode.PercentOutput,.3);
        }
        else if(oi.getDriveRightX()<0){
            one.set(ControlMode.PercentOutput, .3);
            two.set(ControlMode.PercentOutput, .3);
            three.set(ControlMode.PercentOutput,-.3);
            four.set(ControlMode.PercentOutput, -.3);
        }
        else if(oi.getDriveLeftY()>0){
            one.set(ControlMode.PercentOutput, .3);
            two.set(ControlMode.PercentOutput, .3);
            three.set(ControlMode.PercentOutput, .3);
            four.set(ControlMode.PercentOutput, .3);
        }
        else if(oi.getDriveLeftY()<0)
        {
            one.set(ControlMode.PercentOutput, -0.3);
            two.set(ControlMode.PercentOutput, -.3);
            three.set(ControlMode.PercentOutput, -0.3);
            four.set(ControlMode.PercentOutput, -.3);
        }
       
            
        else{
            one.set(ControlMode.PercentOutput, 0);
            two.set(ControlMode.PercentOutput, 0);
            three.set(ControlMode.PercentOutput, 0);
            four.set(ControlMode.PercentOutput, 0);
        }
    } 
    public void carDrive(){
    	if(oi.getDriveRightX()>0){
        	if (oi.getDriveLeftY()>0){
            	one.set(ControlMode.PercentOutput, Math.pow(oi.getDriveLeftY(),2));
				two.set(ControlMode.PercentOutput, Math.pow(oi.getDriveLeftY(),2));
				if (Math.abs(oi.getDriveLeftY())>Math.abs(oi.getDriveRightX())){
					three.set(ControlMode.PercentOutput,-Math.pow(oi.getDriveLeftY(),2)+Math.pow(oi.getDriveRightX(),2));
            		four.set(ControlMode.PercentOutput,-Math.pow(oi.getDriveLeftY(),2)+Math.pow(oi.getDriveRightX(),2));
				}
			}
        	else if (oi.getDriveLeftY()<0){
            	one.set(ControlMode.PercentOutput, -Math.pow(oi.getDriveLeftY(),2));
            	two.set(ControlMode.PercentOutput, -Math.pow(oi.getDriveLeftY(),2));
				if (Math.abs(oi.getDriveLeftY())>Math.abs(oi.getDriveRightX())){
					three.set(ControlMode.PercentOutput,Math.pow(oi.getDriveLeftY(),2)-Math.pow(oi.getDriveRightX(),2));
            		four.set(ControlMode.PercentOutput,Math.pow(oi.getDriveLeftY(),2)-Math.pow(oi.getDriveRightX(),2));
				}
			}
        	else {
            	one.set(ControlMode.PercentOutput,-Math.pow(oi.getDriveRightX(),2));
            	two.set(ControlMode.PercentOutput,-Math.pow(oi.getDriveRightX(),2));
            	three.set(ControlMode.PercentOutput,Math.pow(oi.getDriveRightX(),2));
            	four.set(ControlMode.PercentOutput, Math.pow(oi.getDriveRightX(),2));
        	}
    	}
    	else if(oi.getDriveRightX()<0){
        	if (oi.getDriveLeftY()>0){
				if (Math.abs(oi.getDriveLeftY())>Math.abs(oi.getDriveRightX())){
					one.set(ControlMode.PercentOutput,-Math.pow(oi.getDriveLeftY(),2)+Math.pow(oi.getDriveRightX(),2));
            		two.set(ControlMode.PercentOutput,-Math.pow(oi.getDriveLeftY(),2)+Math.pow(oi.getDriveRightX(),2));
				}
				three.set(ControlMode.PercentOutput,Math.pow(oi.getDriveLeftY(),2));
            	four.set(ControlMode.PercentOutput, Math.pow(oi.getDriveLeftY(),2));
        	}
        	else if (oi.getDriveLeftY()<0){
				if (Math.abs(oi.getDriveLeftY())>Math.abs(oi.getDriveRightX())){
					one.set(ControlMode.PercentOutput,-Math.pow(oi.getDriveLeftY(),2)+Math.pow(oi.getDriveRightX(),2));
					two.set(ControlMode.PercentOutput,-Math.pow(oi.getDriveLeftY(),2)+Math.pow(oi.getDriveRightX(),2));
				}
				three.set(ControlMode.PercentOutput,-Math.pow(oi.getDriveLeftY(),2));
            	four.set(ControlMode.PercentOutput, -Math.pow(oi.getDriveLeftY(),2));
        	}
        	else {
            	one.set(ControlMode.PercentOutput,Math.pow(oi.getDriveRightX(),2));
            	two.set(ControlMode.PercentOutput,Math.pow(oi.getDriveRightX(),2));
            	three.set(ControlMode.PercentOutput,-Math.pow(oi.getDriveRightX(),2));
            	four.set(ControlMode.PercentOutput, -Math.pow(oi.getDriveRightX(),2));
        	}
    	}
    	else if(Math.abs(oi.getDriveLeftY())>0){
        	one.set(ControlMode.PercentOutput, oi.getDriveLeftY()*.7);
        	two.set(ControlMode.PercentOutput, oi.getDriveLeftY()*.7);
        	three.set(ControlMode.PercentOutput, oi.getDriveLeftY()*.7);
        	four.set(ControlMode.PercentOutput, oi.getDriveLeftY()*.7);
    	}  
    	else{
        	one.set(ControlMode.PercentOutput, 0);
        	two.set(ControlMode.PercentOutput, 0);
        	three.set(ControlMode.PercentOutput, 0);
        	four.set(ControlMode.PercentOutput, 0);
    	}
	}

    public void haloDrive(){
    	if(oi.getDriveRightX()>0){
        	if (oi.getDriveLeftY()>0){
            	three.set(ControlMode.PercentOutput, Math.pow(oi.getDriveLeftY(),2));
				four.set(ControlMode.PercentOutput, Math.pow(oi.getDriveLeftY(),2));
				if (Math.abs(oi.getDriveLeftY())>Math.abs(oi.getDriveRightX())){
					one.set(ControlMode.PercentOutput,-Math.pow(oi.getDriveLeftY(),2)+Math.pow(oi.getDriveRightX(),2));
            		two.set(ControlMode.PercentOutput,-Math.pow(oi.getDriveLeftY(),2)+Math.pow(oi.getDriveRightX(),2));
				}
			}
        	else if (oi.getDriveLeftY()<0){
            	one.set(ControlMode.PercentOutput, -Math.pow(oi.getDriveLeftY(),2));
            	two.set(ControlMode.PercentOutput, -Math.pow(oi.getDriveLeftY(),2));
				if (Math.abs(oi.getDriveLeftY())>Math.abs(oi.getDriveRightX())){
					three.set(ControlMode.PercentOutput,Math.pow(oi.getDriveLeftY(),2)-Math.pow(oi.getDriveRightX(),2));
            		four.set(ControlMode.PercentOutput,Math.pow(oi.getDriveLeftY(),2)-Math.pow(oi.getDriveRightX(),2));
				}
			}
        	else {
            	one.set(ControlMode.PercentOutput,-Math.pow(oi.getDriveRightX(),2));
            	two.set(ControlMode.PercentOutput,-Math.pow(oi.getDriveRightX(),2));
            	three.set(ControlMode.PercentOutput,Math.pow(oi.getDriveRightX(),2));
            	four.set(ControlMode.PercentOutput, Math.pow(oi.getDriveRightX(),2));
        	}
    	}
    	else if(oi.getDriveRightX()<0){
        	if (oi.getDriveLeftY()>0){
				if (Math.abs(oi.getDriveLeftY())>Math.abs(oi.getDriveRightX())){
					three.set(ControlMode.PercentOutput,-Math.pow(oi.getDriveLeftY(),2)+Math.pow(oi.getDriveRightX(),2));
            		four.set(ControlMode.PercentOutput,-Math.pow(oi.getDriveLeftY(),2)+Math.pow(oi.getDriveRightX(),2));
				}
				one.set(ControlMode.PercentOutput,Math.pow(oi.getDriveLeftY(),2));
            	two.set(ControlMode.PercentOutput, Math.pow(oi.getDriveLeftY(),2));
        	}
        	else if (oi.getDriveLeftY()<0){
				if (Math.abs(oi.getDriveLeftY())>Math.abs(oi.getDriveRightX())){
					one.set(ControlMode.PercentOutput,-Math.pow(oi.getDriveLeftY(),2)+Math.pow(oi.getDriveRightX(),2));
					two.set(ControlMode.PercentOutput,-Math.pow(oi.getDriveLeftY(),2)+Math.pow(oi.getDriveRightX(),2));
				}
				three.set(ControlMode.PercentOutput,-Math.pow(oi.getDriveLeftY(),2));
            	four.set(ControlMode.PercentOutput, -Math.pow(oi.getDriveLeftY(),2));
        	}
        	else {
            	one.set(ControlMode.PercentOutput,Math.pow(oi.getDriveRightX(),2));
            	two.set(ControlMode.PercentOutput,Math.pow(oi.getDriveRightX(),2));
            	three.set(ControlMode.PercentOutput,-Math.pow(oi.getDriveRightX(),2));
            	four.set(ControlMode.PercentOutput, -Math.pow(oi.getDriveRightX(),2));
        	}
    	}
    	else if(Math.abs(oi.getDriveLeftY())>0){
        	one.set(ControlMode.PercentOutput, oi.getDriveLeftY()*.7);
        	two.set(ControlMode.PercentOutput, oi.getDriveLeftY()*.7);
        	three.set(ControlMode.PercentOutput, oi.getDriveLeftY()*.7);
        	four.set(ControlMode.PercentOutput, oi.getDriveLeftY()*.7);
    	}  
    	else{
        	one.set(ControlMode.PercentOutput, 0);
        	two.set(ControlMode.PercentOutput, 0);
        	three.set(ControlMode.PercentOutput, 0);
        	four.set(ControlMode.PercentOutput, 0);
    	}
	}

    public void tankDrive() {
    	if (oi.getDriveLeftY()>0){
        	one.set(ControlMode.PercentOutput, .5);
        	two.set(ControlMode.PercentOutput, .5);
    	}
    	else if (oi.getDriveLeftY()<0){
        	one.set(ControlMode.PercentOutput, -.5);
        	two.set(ControlMode.PercentOutput, -.5);
    	}
    	if (oi.getDriveRightY()>0){
        	three.set(ControlMode.PercentOutput, .5);
        	four.set(ControlMode.PercentOutput, .5);
    	}
    	else if (oi.getDriveRightY()<0){
        	three.set(ControlMode.PercentOutput, -.5);
        	four.set(ControlMode.PercentOutput, -.5);
    	}
    	if (oi.getDriveLeftY()>0 && oi.getDriveRightY()>0){
        	one.set(ControlMode.PercentOutput, .5);
        	two.set(ControlMode.PercentOutput, .5);
        	three.set(ControlMode.PercentOutput, .5);
        	four.set(ControlMode.PercentOutput, .5);
    	}
    	else if (oi.getDriveLeftY()<0 && oi.getDriveRightY()<0){
        	one.set(ControlMode.PercentOutput, -.5);
        	two.set(ControlMode.PercentOutput, -.5);
        	three.set(ControlMode.PercentOutput, -.5);
        	four.set(ControlMode.PercentOutput, -.5);
    	}
    	if(oi.getDriveLeftY()==0 && oi.getDriveRightY()==0){
        	one.set(ControlMode.PercentOutput, 0);
        	two.set(ControlMode.PercentOutput, 0);
        	three.set(ControlMode.PercentOutput, 0);
        	four.set(ControlMode.PercentOutput, 0);
		}
	}

	public void arcade (){
		if (oi.getDriveLeftY()>0) {
			one.set(ControlMode.PercentOutput, .5);
			two.set(ControlMode.PercentOutput, .5);
			three.set(ControlMode.PercentOutput, .5);
			four.set(ControlMode.PercentOutput, .5);
		}
		if (oi.getDriveLeftY()<0) {
			one.set(ControlMode.PercentOutput, -.5);
			two.set(ControlMode.PercentOutput, -.5);
			three.set(ControlMode.PercentOutput, -.5);
			four.set(ControlMode.PercentOutput, -.5);
		}
		if (oi.getDriveLeftX()>0) {
			one.set(ControlMode.PercentOutput, .5);
			two.set(ControlMode.PercentOutput, .5);
			three.set(ControlMode.PercentOutput, -.5);
			four.set(ControlMode.PercentOutput, -.5);
		}
		if (oi.getDriveLeftX()<0) {
			one.set(ControlMode.PercentOutput, -.5);
			two.set(ControlMode.PercentOutput, -.5);
			three.set(ControlMode.PercentOutput, .5);
			four.set(ControlMode.PercentOutput, .5);
		}
		if (oi.getDriveLeftY()>0 && oi.getDriveLeftX()>0) {
			one.set(ControlMode.PercentOutput, .5);
			two.set(ControlMode.PercentOutput, .5);
			three.set(ControlMode.PercentOutput, .25);
			four.set(ControlMode.PercentOutput, .25);
		}
		if (oi.getDriveLeftY()>0 && oi.getDriveLeftX()<0) {
			one.set(ControlMode.PercentOutput, .25);
			two.set(ControlMode.PercentOutput, .25);
			three.set(ControlMode.PercentOutput, .5);
			four.set(ControlMode.PercentOutput, .5);
		}
		if (oi.getDriveLeftY()<0 && oi.getDriveLeftX()<0) {
			one.set(ControlMode.PercentOutput, -.3);
			two.set(ControlMode.PercentOutput, -.3);
			three.set(ControlMode.PercentOutput, -.5);
			four.set(ControlMode.PercentOutput, -.5);
		}
		if (oi.getDriveLeftY()<0 && oi.getDriveLeftX()>0) {
			one.set(ControlMode.PercentOutput, -.5);
			two.set(ControlMode.PercentOutput, -.5);
			three.set(ControlMode.PercentOutput, -.3);
			four.set(ControlMode.PercentOutput, -.3);
		}
		if(oi.getDriveLeftY()==0 && oi.getDriveRightY()==0){
            one.set(ControlMode.PercentOutput, 0);
            two.set(ControlMode.PercentOutput, 0);
            three.set(ControlMode.PercentOutput, 0);
            four.set(ControlMode.PercentOutput, 0);
        }
	}
	
	
	
}



    




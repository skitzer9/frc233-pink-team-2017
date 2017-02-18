package org.usfirst.frc.team233.robot;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;

public class AutoPID extends PIDController {
	
	public AutoPID(double Kp, double Ki, double Kd, double Kf,
			PIDSource source) {
		super(Kp, Ki, Kd, Kf, source, null);
	}

	public AutoPID(double Kp, double Ki, double Kd, PIDSource source){
		super(Kp, Ki, Kd, source, null, 20.0);
	}
	
	public double getFeedForward(){
		return calculateFeedForward();
	}

}

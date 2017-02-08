package org.usfirst.frc.team233.robot.subsystems;

import org.usfirst.frc.team233.robot.RobotMap;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Flywheel extends Subsystem {
	public SpeedController flywheelMotor = new Talon(RobotMap.flywheelMotorPort);
	
	public double flywheelSpeed = RobotMap.flywheelMotorSpeed;
	private double tolerance = 0.1;
	private final double flywheelKp = 0.1;
	private Encoder encoder = new Encoder(RobotMap.flywheelEncoderPortA, RobotMap.flywheelEncoderPortB);
	private final double flywheelDistancePerPulse = 0.123;
	
	/* Calculate the distance each pulse in the encoder equals to.
	 * Equation: (Wheel Diameter x Pi) / Number of pulses per encoder revolution */
	private final double gearDiameter = 4.0;
	private final int pulsePerRevolution = 40;
	private final double distancePerPulse = (Math.PI * gearDiameter) / pulsePerRevolution;
	
	public Flywheel() {
		super();
		SmartDashboard.putNumber("Flywheel Motor Speed", flywheelMotor.get());
		encoder.reset();
		encoder.setDistancePerPulse(flywheelDistancePerPulse);
	}
	

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}

	public void startFlywheel() {
		//System.out.println("Running Flywheel");
		//flywheelMotor.set(flywheelSpeed);
		flywheelMotor.set(getPDSpeed(flywheelMotor.get(), flywheelSpeed, flywheelKp));
	}

	public void stopFlywheel() {
		flywheelMotor.stopMotor();
	}

	
	/** Reset all encoders. */
	public void resetEncoder() {
		encoder.reset();
	}
	
	/** Setup encoders before use. */
	public void setupEncoder() {
		encoder.setDistancePerPulse(distancePerPulse);
		//leftEncoder.setPIDSourceType(PIDSourceType.kDisplacement);
		SmartDashboard.putData("Flywheel Encoder", encoder);
	}
	
	/** Get the current value of the flywheel motor.
	 * Ranges from -1.0 to 1.0 */
	public double getFlywheelMotorSpeed(){
		return flywheelMotor.get();
	}
	
	/** Get the speed of the flywheel, which is determined
	 * by the encoder. */
	public double getFlywheelEncoderSpeed(){
		return encoder.getRate();
	}
	
	/** Adjust the speed of the */
	public void adjustFlywheelSpeed(int adjustment){
		//System.out.println("Button pressed = " + adjustment);
		if(adjustment == 0){
			System.out.println("Add speed to flywheel");
			
			flywheelSpeed = rangeValue(flywheelSpeed + 0.01);
		} else if (adjustment == 180){
			System.out.println("Slow down flywheel");
			flywheelSpeed = rangeValue(flywheelSpeed - 0.01);
		}
	}
	
	private double rangeValue(double value) {
		if (value > 1.0) {
			return 1.0;
		} 
		else if (value < -1.0) {
			return -1.0;
		}
		else {
			return value;
		}
	}
	
	/** Calculate a P and D values and apply it to the speed that 
	 * is going to be applied to the flywheel motor. */
	public double getPDSpeed(double currentSpeed, double targetSpeed, double Kp) {
		currentSpeed = Math.abs(currentSpeed);
		double error = (targetSpeed - currentSpeed);
        double speedCmd;
        //System.out.println("inside getSpeedCmd, currentSpeed: " + currentSpeed);
        speedCmd = ((Kp * error) + targetSpeed);
        //System.out.println("Speed CMD = " + speedCmd);
        return speedCmd;
	}
	
	public boolean motorSpeedEqualsSetSpeed(){
		if (Math.abs(Math.abs(flywheelMotor.get()) - flywheelSpeed) < tolerance) {
			//System.out.println("Motor up to speed!");
			return true;
		}
		return false;
	}

}

package org.usfirst.frc.team233.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	
	//============================================
	// 		DRIVE TRAIN VARIABLES
	//============================================
	// Motors
	public static int leftFrontMotorPort = 2;
	public static int leftBackMotorPort = 3;
	public static int rightFrontMotorPort = 0;
	public static int rightBackMotorPort = 1;
	
	// Encoders
	public static int leftEncoderAPort = 0;
	public static int leftEncoderBPort = 1;
	public static int rightEncoderAPort = 3;
	public static int rightEncoderBPort = 4;
	
	
	//============================================
	// 		SHOOTER VARIABLES
	//============================================
	// Motors
	public static int flywheelMotorPort = 4;
	public static int indexerMotorPort = 5;
	
	// Motor Speeds
	public static double flywheelMotorSpeed = 1.0;
	public static double indexerMotorSpeed = 0.5;
	
	// Encoder
	public static int flywheelEncoderPortA = 5;
	public static int flywheelEncoderPortB = 6;
	
	
	//============================================
	// 		COLLECTOR VARIABLES
	//============================================
	// Motor
	public static int collectorMotorPort = 6;
	
	// Motor Speed
	public static double collectorMotorSpeed = 1.0;
	

	//============================================
	// 		ROPE CLIMBER VARIABLES
	//============================================
	// Motors
	public static int ropeClimberMotorPort = 7;
	
	// Motor Speeds
	public static double ropeClimberSpeed = 0.75;
	public static double ropeHoldSpeed = 0.25;
	
	
	//============================================
	// 		HOPPER VARIABLES
	//============================================
	// Motors
	public static int agitatorMotorPort = 8;
	
	// Motor Speeds
	public static double agitatorMotorSpeed = 1;
	
	
	//============================================
	// 		JOYSTICK VARIABLES
	//============================================
	public static int baseJoystickPort = 0;
	public static int shooterJoystickPort = 1;
	
	
	
	
	
}
package org.usfirst.frc.team233.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;
	
	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
	public static int leftFrontMotorPort = 0;
	public static int leftBackMotorPort = 1;
	public static int rightFrontMotorPort = 2;
	public static int rightBackMotorPort = 3;
	
	public static int baseJoystickPort = 0;
	public static int shooterJoystickPort = 1;
	
	
	public static enum Encoders {
		FrontLeft(0,1),
		BackLeft(2,3),
		FrontRight(4,5),
		BackRight(6,7);
		
		private final int channelA;
		private final int channelB;
		
		Encoders(int channelA, int channelB) {
			this.channelA = channelA;
			this.channelB = channelB;
		}
		
		public int channelA() {
			return this.channelA;
		}
		
		public int channelB() {
			return this.channelB;
		}
	}
}
package org.usfirst.frc.team233.robot.autonomous;

import org.usfirst.frc.team233.robot.PinkPD;
import org.usfirst.frc.team233.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class PinkNavigate extends Command {
	static final double POSITION_THRESHOLD = 1.0; // Distance (Inches)
	static final double ANGLE_THRESHOLD = 5.0; // Degrees

	private double targetPos;
	private double targetAngle;
	private double maxPower;

	/** Constructor - Define the distance and angle for the robot to */
	public PinkNavigate(double targetPos, double targetAngle, double maxPower) {
		this.targetPos = targetPos;
		this.targetAngle = targetAngle;
		this.maxPower = maxPower;
		requires(Robot.drivetrain);
		Robot.drivetrain.resetEncoders();
	}

	// Tank drive two wheels to target positions in inches.
	// Returns true when both arrive at the target.
	public boolean driveToPos() {
		double angularVelocity = Robot.drivetrain.getGyroRate();
		double linearVelocity = Robot.drivetrain.getDriveTrainRate();
		double linearError = targetPos - Robot.drivetrain.getDistanceTraveled();
		double angularError = targetAngle - Robot.drivetrain.getGyroRotation();
		double motorCmd = PinkPD.getMotorCmd(0.1, 0.01, linearError,
				linearVelocity);
		SmartDashboard.putNumber("MotorCMD", motorCmd);
		motorCmd = clip(motorCmd, 0.5, -0.5);

		// Determine and add the angle offset
		double angleOffset = PinkPD.getMotorCmd(0.02, 0.02, angularError,
				angularVelocity);
		SmartDashboard.putNumber("Angle Offset", angleOffset);
		double leftMotorCmd = motorCmd + angleOffset;
		double rightMotorCmd = motorCmd - angleOffset;
		leftMotorCmd = clip(leftMotorCmd, -maxPower, maxPower);
		rightMotorCmd = clip(rightMotorCmd, -maxPower, maxPower);
		SmartDashboard.putNumber("leftMotorCmd", leftMotorCmd);
		SmartDashboard.putNumber("rightMotorCmd", rightMotorCmd);

		// Scale the motor commands back to account for the MC windup problem
		// (if the motor can't keep up with the command, error builds up)
		// leftMotorCmd *= maxPower;
		// rightMotorCmd *= maxPower;

		Robot.drivetrain.drive(leftMotorCmd, rightMotorCmd);
		if ((Math.abs(linearError) < POSITION_THRESHOLD)
				&& (Math.abs(angularError) < ANGLE_THRESHOLD)) {
			return true;
		} else {
			return false;
		}
	}

	// migrated over from Range class
	public static double clip(double cmd, double max, double min) {
		if (cmd > max) {
			return max;
		} else if (cmd < min) {
			return min;
		}
		return cmd;
	}
	
	@Override
	protected boolean isFinished() {
		return driveToPos();
	}

	@Override
	protected void end() {
		Robot.drivetrain.drive(0, 0);
	}
}
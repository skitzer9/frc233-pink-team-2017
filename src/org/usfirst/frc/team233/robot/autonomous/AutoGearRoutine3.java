package org.usfirst.frc.team233.robot.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

/**
 * Autonomous gear routine starting @ farthest position from boiler
 * @author Meriel
 *
 */
public class AutoGearRoutine3 extends CommandGroup {

	public AutoGearRoutine3(){
		addSequential(new PinkNavigate(-109,0,1));
		addSequential(new PinkNavigate(-109,-60,1));
		addSequential(new PinkNavigate(-141,-60,1));
		//addSequential (new StopBase());
		//addSequential();
		
	}
}
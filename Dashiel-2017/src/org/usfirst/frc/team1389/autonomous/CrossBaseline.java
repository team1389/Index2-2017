package org.usfirst.frc.team1389.autonomous;

import org.usfirst.frc.team1389.autonomous.command.RobotCommands;
import org.usfirst.frc.team1389.robot.RobotSoftware;

import com.team1389.auto.AutoModeEndedException;
import com.team1389.util.list.AddList;
import com.team1389.watch.Watchable;

public class CrossBaseline extends AutoModeConstants {
	RobotSoftware robot;
	RobotCommands commands;

	public CrossBaseline(RobotSoftware robot) {
		this.robot = robot;
		commands = new RobotCommands(robot);
	}

	@Override
	public AddList<Watchable> getSubWatchables(AddList<Watchable> stem) {
		return stem.put(robot.voltageDrive);
	}

	@Override
	protected void routine() throws AutoModeEndedException {
		runCommand(commands.new DriveStraight(getRotations(SIDE_GEAR_STRAIGHT), 5));
		runCommand(commands.new TurnAngle(SIDE_GEAR_TURN, true));
		runCommand(commands.new DriveStraight(getRotations(SIDE_GEAR_APPROACH), 5));
	}

	@Override
	public String getIdentifier() {
		return "Cross Baseline";
	}

}

/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

/**
 * This is an auto command to make the robot move during autonomous.
 * NOTE: This command is designed to be chained together into a sequential set of movements,
 * this means the robot will not stop at the end of the chain. We must explicitly put a
 * AutoMove(...,..., 0, 0, 0); as the last entry in the chain.
 * 
 * The drive subsystem default Command must be disabled while this command is running.
 * 
 * To make the robot move we call drive.arcadeDrive(move, turn) with the ranges -1 to 1.
 * When the time has finished we exit.
 */

public class AutoMoveCommand extends CommandBase {
	private DriveSubsystem driveSubsystem;
	private double endTime;
	private double runTime;
	private double turnPower;
	private double forwardPower;
	
	/**
	 * AutoMove: move the robot during autonomous period
	 * @param driveSubsystem The drive subsystem for controlling the motors
	 * @param forwardPower How much to move forward or back (-1 full back to +1 full forward)
	 * @param turnPower How much to turn left or right (-1 full left to +1 full right)
	 * @param runTime How long to perform this action in seconds.
	 */
    public AutoMoveCommand(DriveSubsystem driveSubsystem, double forwardPower, double turnPower, double runTime) {
    	this.driveSubsystem = driveSubsystem;
    	this.turnPower = turnPower;
    	this.forwardPower = forwardPower;
    	this.runTime = runTime;
    	addRequirements(driveSubsystem);
    }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    endTime = Timer.getFPGATimestamp() + this.runTime;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    driveSubsystem.autoDrive(forwardPower, turnPower);		// Ask the drivebase to move.
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return (Timer.getFPGATimestamp() > endTime);
  }
}

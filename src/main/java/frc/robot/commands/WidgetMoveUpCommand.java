/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.WidgetSubsystem;

public class WidgetMoveUpCommand extends CommandBase {
	WidgetSubsystem widgetSubsystem;
	private double startTime;
  private double runTime;
  /**
   * Creates a new WidgetMoveUpCommand.
   */
  public WidgetMoveUpCommand(WidgetSubsystem widgetSubsystem, double runTime) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.widgetSubsystem = widgetSubsystem;
    this.runTime = runTime;
    addRequirements(widgetSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    startTime = Timer.getFPGATimestamp();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    widgetSubsystem.setMoveUp();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    double now = Timer.getFPGATimestamp();
      if (now > (startTime + runTime)) {
        return true;
      }
      return false;					// not finished yetdx
  }
}

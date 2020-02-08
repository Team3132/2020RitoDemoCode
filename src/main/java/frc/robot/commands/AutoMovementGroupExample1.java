/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.DriveSubsystem;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class AutoMovementGroupExample1 extends SequentialCommandGroup {
  /**
   * Creates a new AutoMovementGroupExample1.
   */
  public AutoMovementGroupExample1(DriveSubsystem driveSubsystem) {
    // Add your commands in the super() call, e.g.
    // super(new FooCommand(), new BarCommand());
    super(
      new AutoMoveCommand(driveSubsystem, 0.8, 0.0, 4.0),	// move straight forward at 80% power for 4 seconds
      new AutoMoveCommand(driveSubsystem, 0.0, 0.0, 0.0)	// and stop
    );
  }
}

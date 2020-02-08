/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.WidgetSubsystem;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/latest/docs/software/commandbased/convenience-features.html
public class AutoMovementGroupExample3 extends SequentialCommandGroup {
  /**
   * Creates a new AutoMovementGroupExample3.
   */
  public AutoMovementGroupExample3(DriveSubsystem driveSubsystem, WidgetSubsystem widgetSubsystem) {
    // Add your commands in the super() call, e.g.
    // super(new FooCommand(), new BarCommand());
    super(
      new AutoMoveCommand(driveSubsystem, 0.8, 0.0, 1.0),	// move straight forward at 80% power for 1 second
      new AutoMoveCommand(driveSubsystem, 0.0, -0.3, 1.0),	// turn left at 30% power for 1 second
      new AutoMoveCommand(driveSubsystem, 1.0, 0.0, 0.5),	// move straight forward at 100% power for 0.5 seconds
      new AutoMoveCommand(driveSubsystem, 0.0, 0.3, 1.0),	// turn right at 30% power for 1 second (inverse of above turn)
      new AutoMoveCommand(driveSubsystem, 1.0, 0.0, 1.3),	// move straight forward at 100% power for 1.3 seconds
      new WidgetMoveUpCommand(widgetSubsystem, 2.0),	// move the widget up for 2 seconds
      new AutoMoveCommand(driveSubsystem, 0.0, 0.0, 0.0)	// and stop
    );
  }
}

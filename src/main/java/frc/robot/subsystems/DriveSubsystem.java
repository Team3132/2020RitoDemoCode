/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Constants.DriveStyle;

public class DriveSubsystem extends SubsystemBase {
  private DifferentialDrive drive;
  private DoubleSupplier left, right;
  private Constants.DriveStyle driveType = Constants.DriveStyle.DRIVE_STYLE_ARCADE;
  private boolean enabled;

  /**
   * Creates a new DriveSubsystem.
   */
  public DriveSubsystem(DoubleSupplier left, DoubleSupplier right, DifferentialDrive drive, DriveStyle driveType) {
    this.left = left;
    this.right = right;
    this.drive = drive;
    this.driveType = driveType;
    enabled = false;
  }

  public void autoDrive(double forwardPower, double turnPower) {
    drive.arcadeDrive(forwardPower, turnPower);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    if (!enabled) {
      return;
    }
    /*
     *  Note: The joysticks return -1 as forward, but drive wants 1 as forward, so we need to reverse the sign of the forward component.
     *  
     *  If you are using a gamepad as the driver's controller then you will want to use one joystick, and read the two thumb sticks from it instead.
     */
    switch (driveType) {
    case DRIVE_STYLE_ARCADE:
    default:
      //drive.arcadeDrive(-leftJoystick.getY(), rightJoystick.getX(), true);
      drive.arcadeDrive(left.getAsDouble(), right.getAsDouble(), true);
      break;
    case DRIVE_STYLE_TANK:
      drive.tankDrive(-1 * left.getAsDouble(), -1 * right.getAsDouble(), true);
      break;
    case DRIVE_STYLE_CURVE:
      drive.curvatureDrive(left.getAsDouble(), right.getAsDouble(), false);
      break;
    }
  }

  public DriveSubsystem setEnabled(boolean enabled) {
    this.enabled = enabled;
    return this;
  }
}

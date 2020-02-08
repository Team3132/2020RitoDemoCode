/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.WidgetSubsystem;

/**
 * This is a demo program showing the use of the DifferentialDrive class. Runs
 * the motors with arcade steering.
 */
public class Robot extends TimedRobot {
  private SpeedController leftController;
  private SpeedController rightController;
  private DifferentialDrive drive;
  private DriveSubsystem driveSubsystem;

  private Joystick driverGamePad;
  private Joystick operatorGamePad;
  private WidgetSubsystem widgetSubsystem;

  @SuppressWarnings("unused")
  private OI oi;

  public void robotInit() {
    driverGamePad = new Joystick(Constants.DRIVER_GAMEPAD);
    operatorGamePad = new Joystick(Constants.OPERATOR_GAMEPAD);

    /*
     * These two lines are for CTRE Talon SRX CAN Bus style drive controllers.
     * Uncomment the lines and add (or remove) WPI_TalonSRX definitions as necessary
     * Note: you will also need to add the CTRE phoenix libraries (see above)
     */
    leftController = new SpeedControllerGroup(new PWMVictorSPX(Constants.DRIVE_LEFT1_PWM_ID),
        new PWMVictorSPX(Constants.DRIVE_LEFT2_PWM_ID));
    rightController = new SpeedControllerGroup(new PWMVictorSPX(Constants.DRIVE_RIGHT1_PWM_ID),
        new PWMVictorSPX(Constants.DRIVE_RIGHT2_PWM_ID));

    drive = new DifferentialDrive(leftController, rightController);
    /*
     * These drive subsystem definitions are defining how the driver's controlls
     * affect the motor. You need ONE of these uncommented, so depending on which
     * style you want chose the appropriate line.
     */
    driveSubsystem = new DriveSubsystem(driverGamePad::getY, driverGamePad::getTwist, drive, Constants.DriveStyle.DRIVE_STYLE_ARCADE); // single flight stick with twist for turning
    // driveSubsystem = new DriveSubsystem(() -> driverInput.getRawAxis(1), () ->
    // driverInput.getRawAxis(5), drive, RobotMap.DriveStyle.DRIVE_STYLE_TANK); //
    // single gamepad using thumb sticks as tank control

    widgetSubsystem = new WidgetSubsystem(new PWMVictorSPX(9));
    oi = new OI(driverGamePad, operatorGamePad, widgetSubsystem);
    /*
     * Start a camera server - this allows you to have a camera mounted on your
     * robot and the image being shown on the drivers startion.
     * https://wpilib.screenstepslive.com/s/currentCS/m/vision/l/669166-using-the-
     * cameraserver-on-the-roborio for details.
     * 
     * if you don't want a camera server comment out this line.
     */
    CameraServer.getInstance().startAutomaticCapture();
  }

  @Override
  public void teleopPeriodic() {
    driveSubsystem.setEnabled(true);
  }
}

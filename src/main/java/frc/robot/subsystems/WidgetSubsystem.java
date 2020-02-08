/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class WidgetSubsystem extends SubsystemBase {
  SpeedController controller;
  /**
   * Creates a new WidgetSubsystem.
   */
  public WidgetSubsystem(SpeedController controller) {
    this.controller = controller;
    this.controller.set(0);		// and start with the motor stopped
  }

  /**
   * setMoveUp - Cause the widget to start moving upwards.
   * When the appropriate movement has been completed setMoveStop must be called
   */
  public void setMoveUp() {
    controller.set(Constants.WIDGET_SPEED_UP);
  }

  /**
   * setMoveDown - Cause the widget to start moving downwards.
   * When the appropriate movement has been completed setMoveStop must be called
   */
  public void setMoveDown() {
    controller.set(Constants.WIDGET_SPEED_DOWN);
  }

  /**
   * setMoveStop - Causes the widget to stop moving
   */
  public void setMoveStop() {
    controller.set(0);
  }
    
  // Put methods for talking about this subsystem here
  // call these when other things need to know about this subsystem

  /**
   * isInPosition identifies whether the widget is in position. In the demo case this
   * is a dummy method that always returns true. On a real robot this method would check a sensor
   * to determine if the widget was in the correct position
   * 
   * @return true if the widget is in the correct position
   */
  public boolean isInPosition() {
    return true;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}

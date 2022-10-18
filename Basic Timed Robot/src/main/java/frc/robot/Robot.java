// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj.Timer;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  private Spark leftMotor1 = new Spark(0); //initialize leftMotor1 as a Spark Max motor controller (controller #0)
  private Spark leftMotor2 = new Spark(1); //initialize leftMotor2 as a Spark Max motor controller (controller #1)
  private Spark rightMotor1 = new Spark(2); //initialize rightMotor1 as a Spark Max motor controller (controller #2)
  private Spark rightMotor2 = new Spark(3); //initialize rightMotor2 as a Spark Max motor controller (controller #3)

  private Joystick joy1 = new Joystick(0);

  private double startTime;

  @Override
  public void robotInit() {} //initialize function

  @Override
  public void robotPeriodic() {}

  @Override
  public void autonomousInit() {
  startTime = Timer.getFPGATimestamp();
  }

  @Override
  public void autonomousPeriodic() {
    double time = Timer.getFPGATimestamp();
    System.out.println(time - startTime);
    double autonSpeed = 0.2; //speed of motors -1 through 1 (min - max) during autonomous peroid

    if (time - startTime < 3) {
      leftMotor1.set(autonSpeed); //set motors to spin at autonSpeed during autonoums peroid
      leftMotor2.set(autonSpeed);
      rightMotor1.set(-autonSpeed);
      rightMotor2.set(-autonSpeed);
    } else {
      leftMotor1.set(0);
      leftMotor2.set(0);
      rightMotor1.set(0);
      rightMotor2.set(0);
    }
  }

  @Override
  public void teleopInit() {}

  @Override
  public void teleopPeriodic() {
    double speed = -joy1.getRawAxis(1) * 0.6;
    double turn = joy1.getRawAxis(4) * 0.3;

    double left = speed + turn;
    double right = speed - turn;

    leftMotor1.set(left);
    leftMotor2.set(left);
    rightMotor1.set(-right);
    rightMotor2.set(-right);

  }

  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  @Override
  public void testInit() {}

  @Override
  public void testPeriodic() {}

  @Override
  public void simulationInit() {}

  @Override
  public void simulationPeriodic() {}
}

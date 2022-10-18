// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
//import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

//import edu.wpi.first.wpilibj.Joystick; //generic joystick library
import edu.wpi.first.wpilibj.TimedRobot;
//import edu.wpi.first.wpilibj.motorcontrol.Spark; //spark controller
//import edu.wpi.first.wpilibj.Timer; //autonomous timer
import edu.wpi.first.wpilibj.XboxController;

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

  private VictorSPX leftMotor1 = new VictorSPX(1); //initialize leftMotor1 as a TalonSRX motor controller (controller #0)
  private VictorSPX leftMotor2 = new VictorSPX(2); //initialize leftMotor2 as a TalonSRX motor controller (controller #1)
  private VictorSPX rightMotor1 = new VictorSPX(3); //initialize rightMotor1 as a TalonSRX motor controller (controller #2)
  private VictorSPX rightMotor2 = new VictorSPX(4); //initialize rightMotor2 as a TalonSRX motor controller (controller #3)

  //private Joystick joy1 = new Joystick(0); //generic joystick controller
  private XboxController joy1 = new XboxController(0);

//  private double startTime; // used in autonomous timing

  @Override
  public void robotInit() {} //initialize function

  @Override
  public void robotPeriodic() {}

  @Override
  public void autonomousInit() {
//startTime = Timer.getFPGATimestamp();
  }

  @Override
  public void autonomousPeriodic() {
    /*
    double time = Timer.getFPGATimestamp();
    System.out.println(time - startTime);
    double autonSpeed = 0.2; //speed of motors -1 through 1 (min - max) during autonomous peroid

    if (time - startTime < 3) {
      leftMotor1.set(autonSpeed); //set motors to spin at autonSpeed during autonoums peroid
      leftMotor2.set(autonSpeed);
      rightMotor1.set(-autonSpeed);
      rightMotor2.set(-autonSpeed);
      leftMotor1.set(Mode, demand);
    } else {
      leftMotor1.set(0);
      leftMotor2.set(0);
      rightMotor1.set(0);
      rightMotor2.set(0);
    }
    */
  }

  @Override
  public void teleopInit() {}

  @Override
  public void teleopPeriodic() {
    double speed = joy1.getLeftX() * 0.6;
    double turn = joy1.getRightY() * 0.3;

    double left = speed + turn;
    double right = speed - turn;

    leftMotor1.set(ControlMode.PercentOutput, 1);
    leftMotor2.set(ControlMode.PercentOutput, 1);
    rightMotor1.set(ControlMode.PercentOutput, -1);
    rightMotor2.set(ControlMode.PercentOutput, -1);

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

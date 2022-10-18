// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import java.util.Set;

import com.ctre.phoenix.motorcontrol.ControlMode;

import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Timer; //autonomous timer
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;

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

  private WPI_VictorSPX leftMotor1 = new WPI_VictorSPX(1); //initialize leftMotor1 as a TalonSRX motor controller (controller #0)
  private WPI_VictorSPX leftMotor2 = new WPI_VictorSPX(2); //initialize leftMotor2 as a TalonSRX motor controller (controller #1)
  private WPI_VictorSPX rightMotor1 = new WPI_VictorSPX(3); //initialize rightMotor1 as a TalonSRX motor controller (controller #2)
  private WPI_VictorSPX rightMotor2 = new WPI_VictorSPX(4); //initialize rightMotor2 as a TalonSRX motor controller (controller #3)

  private MotorControllerGroup right = new MotorControllerGroup(rightMotor1, rightMotor2);
  private MotorControllerGroup left = new MotorControllerGroup(leftMotor1, leftMotor2);


  private DifferentialDrive drivetrain = new DifferentialDrive(left, right);
  //private Joystick joy1 = new Joystick(0); //generic joystick controller
  private XboxController joy1 = new XboxController(1);

  public double startTime; // used in autonomous timing

  @Override
  public void robotInit() {
    rightMotor1.setInverted(true); 
    rightMotor2.setInverted(true);
  } //initialize function

  @Override
  public void robotPeriodic() {}

  @Override
  public void autonomousInit() {
    startTime = Timer.getFPGATimestamp();
  }

  @Override
  public void autonomousPeriodic() {
    
    System.out.println(Timer.getFPGATimestamp());

    double time = Timer.getFPGATimestamp();

    if ((startTime - time) < 3) {
      drivetrain.arcadeDrive(-0.5, 0);
    } 
    else {
      drivetrain.arcadeDrive(0,0);
    }
  }

  @Override
  public void teleopInit() {}

  @Override
  public void teleopPeriodic() {
    drivetrain.arcadeDrive(joy1.getLeftY() * 0.8, joy1.getRightX() * 0.6); //controller axis mapped to drive motors, with sensitivity values
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

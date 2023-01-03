// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.RelativeEncoder;

import frc.robot.RobotMap.Climber;
import frc.robot.util.GroundedDigitalInput;

public class ClimberSubsystem extends SubsystemBase 
{
	private CANSparkMax climbMotor;
	private RelativeEncoder climbEncoder;
	private GroundedDigitalInput topLeftLimitSwitch, topRightLimitSwitch, bottomLeftLimitSwitch, bottomRightLimitSwitch;



	public ClimberSubsystem()
	{
		climbMotor = new CANSparkMax(Climber.CLIMB_PORT_ID, MotorType.kBrushless);
		climbEncoder = climbMotor.getEncoder();
		climbMotor.setInverted(Climber.CLIMB_MOTOR_INVERTED); //:)
        climbMotor.setIdleMode(Climber.BRAKE);
		bottomLeftLimitSwitch = new GroundedDigitalInput(Climber.BOTTOM_LEFT_LIMIT_SWITCH);
		topLeftLimitSwitch = new GroundedDigitalInput(Climber.TOP_LEFT_LIMIT_SWITCH);
		bottomRightLimitSwitch = new GroundedDigitalInput(Climber.BOTTOM_RIGHT_LIMIT_SWITCH);
		topRightLimitSwitch = new GroundedDigitalInput(Climber.TOP_RIGHT_LIMIT_SWITCH);
	}
	public void setClimb(CANSparkMax climbMotor)
	{
		this.climbMotor = climbMotor;
	}

	public CANSparkMax getClimb()
	{
		return climbMotor;
	}

	public RelativeEncoder getEncoder()
	{
		return climbMotor.getEncoder();
	}

	public boolean bottomLimitReached()
	{
		return bottomLeftLimitSwitch.get() && bottomRightLimitSwitch.get();
	}

	public boolean topLimitReached()
	{
		return topLeftLimitSwitch.get() && topRightLimitSwitch.get();
	}

	public void setSpeed(double speed)
	{
		climbMotor.set(speed);
	}

	public CANSparkMax getClimbMotor() {
		return climbMotor;
	}

	public void setClimbMotor(CANSparkMax climbMotor) {
		this.climbMotor = climbMotor;
	}

	public RelativeEncoder getClimbEncoder() {
		return climbEncoder;
	}

	public void setClimbEncoder(RelativeEncoder climbEncoder) {
		this.climbEncoder = climbEncoder;
	}

	public GroundedDigitalInput getTopLeftLimitSwitch() {
		return topLeftLimitSwitch;
	}

	public void setTopLeftLimitSwitch(GroundedDigitalInput topLeftLimitSwitch) {
		this.topLeftLimitSwitch = topLeftLimitSwitch;
	}

	public GroundedDigitalInput getTopRightLimitSwitch() {
		return topRightLimitSwitch;
	}

	public void setTopRightLimitSwitch(GroundedDigitalInput topRightLimitSwitch) {
		this.topRightLimitSwitch = topRightLimitSwitch;
	}

	public GroundedDigitalInput getBottomLeftLimitSwitch() {
		return bottomLeftLimitSwitch;
	}

	public void setBottomLeftLimitSwitch(GroundedDigitalInput bottomLeftLimitSwitch) {
		this.bottomLeftLimitSwitch = bottomLeftLimitSwitch;
	}

	public GroundedDigitalInput getBottomRightLimitSwitch() {
		return bottomRightLimitSwitch;
	}

	public void setBottomRightLimitSwitch(GroundedDigitalInput bottomRightLimitSwitch) {
		this.bottomRightLimitSwitch = bottomRightLimitSwitch;
	}

	public void resetEncoders() {
		climbEncoder.setPosition(0);
	}

	public void setNeutralMode(IdleMode idlemode){
		climbMotor.setIdleMode(idlemode);
	}





}
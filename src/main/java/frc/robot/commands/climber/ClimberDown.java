package frc.robot.commands.climber;

// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.


import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.RobotMap.Climber;

/**
 * Forces the climber to come to the down position
 */
public class ClimberDown extends CommandBase {
    private final double speed;
    public ClimberDown(double speed)
    {
        this.speed = speed;
        addRequirements(Robot.getClimb());
    }

    @Override
    public void execute()
    {
        Robot.getClimb().setSpeed(-speed);
    }
    @Override
    public void end(boolean interrupted)
    {
        Robot.getClimb().setSpeed(0);
    }
    @Override
    public boolean isFinished()
    {
        return Robot.getClimb().bottomLimitReached();
    }
    @Override
    public void initialize()
    {
        
    }
}

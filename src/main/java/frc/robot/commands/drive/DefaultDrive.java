package frc.robot.commands.drive;
import frc.robot.Robot;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class DefaultDrive extends CommandBase{
    
    DefaultDrive()
    {
        addRequirements(Robot.getDrivebase());
    }

    @Override
    public void execute()
    {
        Robot.getDrivebase().tankDrive(-Robot.rightJoystick.getY(), -Robot.leftJoystick.getY());
    }

}

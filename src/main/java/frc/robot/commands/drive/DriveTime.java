package frc.robot.commands.drive;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class DriveTime extends CommandBase{
    Timer timer;
    double time;
    double speed;

    DriveTime(double time, double speed)
    {
        this.time = time;
        this.speed = speed;
        addRequirements(Robot.getDrivebase());
    }

    @Override
    public void execute()
    {
        Robot.getDrivebase().tankDrive(speed, speed);
    }

    @Override
    public void initialize()
    {
        timer.start();
    }

    @Override
    public void end(boolean interrupted)
    {
        timer.stop();
        timer.reset();   
    }

    @Override
    public boolean isFinished()
    {
       return timer.hasElapsed(time);
    }



}

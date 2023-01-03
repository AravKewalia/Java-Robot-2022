package frc.robot.commands.drive;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class DriveWait extends CommandBase{

    private final double time;
    private Timer timer;

    public DriveWait(double time)
    {
        this.time = time;
        addRequirements(Robot.getDrivebase());
    }

    @Override
    public void execute()
    {
        Robot.getDrivebase().tankDrive(0, 0);
    }

    @Override
    public void initialize()
    {
        timer.reset();
        timer.start();
    }

    @Override
    public void end(boolean interrupted)
    {
        timer.stop();
    }

    @Override
    public boolean isFinished()
    {
       return timer.hasElapsed(time);
    }
}

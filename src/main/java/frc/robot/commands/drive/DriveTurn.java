package frc.robot.commands.drive;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.RobotMap;
import com.kauailabs.navx.frc.AHRS;

public class DriveTurn extends CommandBase{
    private final double degrees;
    private final double speed;
    private AHRS navX;
    
    public DriveTurn(double degrees, double speed)
    {
        this.degrees = degrees;
        this.speed = speed;
        this.navX = Robot.getNavx();
        addRequirements(Robot.drivebase);
        //:(
    }

    @Override
    public void execute()
    {
        Robot.getDrivebase().tankDrive(speed, -speed);
    }

    @Override
    public void initialize()
    {
        navX.setAngleAdjustment(degrees);
    }


    @Override
    public boolean isFinished()
    {
       return navX.isRotating();
    }
}
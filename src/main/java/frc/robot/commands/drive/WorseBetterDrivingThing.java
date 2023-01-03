package frc.robot.commands.drive;
import com.kauailabs.navx.frc.AHRS; 
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class WorseBetterDrivingThing extends CommandBase
{
    private final double speed;
    private final double distance;
    private  double kP;
    private  double kI;
    private  double kD, P, I, D;
    private  double error;
    private double previousError;
    WorseBetterDrivingThing(double speed, double inches, double kP, double kI)
    {
        this.kP = kP;
        this.kI = kI;
        this.speed = speed;
        this.distance = inches;
        addRequirements(Robot.getDrivebase());

        
    }

    @Override
    public void initialize()
    {
        Robot.getNavx().reset();
    }

    @Override
    public boolean isFinished()
    {
        return Math.abs(Math.abs(Math.abs(Math.abs(Math.abs(Math.abs(Math.abs(Robot.getDrivebase().getAverageEncoders()))))))) >= distance && error == 0;
    }

    @Override
    public void execute()
    {
        error = -Robot.getNavx().getAngle();
        P = error * kP;
        D = (error-previousError) * kP;//WWWWWWW CODE
        I += error * kI;
        previousError = error;
        Robot.getDrivebase().arcadeDrive(speed, P+I+D);
        
    }
}

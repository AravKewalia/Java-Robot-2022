package frc.robot.commands.drive;
import com.kauailabs.navx.frc.AHRS; 
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.Robot;

public class BetterDriveTurn extends PIDCommand
{
    double setPoint;
    BetterDriveTurn(double setPoint)
    {
        super(new PIDController(0.01, 0, 0),
        () -> Robot.getNavx().getAngle(),
        setPoint, 
        (output) -> {Robot.getDrivebase().tankDrive(output,-output);},
        Robot.getDrivebase());

        this.setPoint = setPoint;

        getController().enableContinuousInput(-180, 180);

        getController().setTolerance(2,0);
    }

    @Override
    public void initialize()
    {
        Robot.getNavx().reset();
    }//:)

    @Override
    public boolean isFinished()
    {
        return Robot.getNavx().getAngleAdjustment() >= setPoint && getController().atSetpoint();
    }
}

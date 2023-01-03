package frc.robot.commands.drive;
import com.kauailabs.navx.frc.AHRS; 
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.Robot;
import com.revrobotics.RelativeEncoder;

public class BetterDrivingThing extends PIDCommand
{

    double distance;
    BetterDrivingThing(double speed, double inches)
    {
        super(new PIDController(0.01, 0, 0),
        () -> Robot.getDrivebase().getLeftEncoder() - Robot.getDrivebase().getRightEncoder(), //AYYYYY
        0, 
        (output) -> {Robot.getDrivebase().arcadeDrive(speed, output);},
        Robot.getDrivebase());


        getController().enableContinuousInput(-180, 180);
        getController().setTolerance(2,0);

        this.distance = inches;
    }

    @Override
    public void initialize()
    {
        Robot.getDrivebase().resetEncoders();
        Robot.getNavx().reset();
    }//:)

    @Override
    public boolean isFinished()
    {
        return getController().atSetpoint() && Math.abs(Robot.getDrivebase().getAverageEncoders()) > distance;
        
    }
}

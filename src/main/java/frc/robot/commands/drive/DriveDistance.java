package frc.robot.commands.drive;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.RobotMap; 

import com.revrobotics.RelativeEncoder;

import edu.wpi.first.wpilibj.Encoder; 

public class DriveDistance extends CommandBase{


    private final double distance;
    private final double speed;



    RelativeEncoder leftFrontEncoder = Robot.getDrivebase().getfrontleftEncoder();
    RelativeEncoder rightFrontEncoder = Robot.getDrivebase().getfrontrightEncoder();
    RelativeEncoder leftBackEncoder = Robot.getDrivebase().getbackleftEncoder();
    RelativeEncoder rightBackEncoder = Robot.getDrivebase().getbackrightEncoder();

    public DriveDistance(double inches, double speed)
    {
        this.distance = inches;
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
        Robot.getDrivebase().resetEncoders();
    }

    @Override
    public boolean isFinished()
    {
        return Math.abs(Robot.getDrivebase().getAverageEncoders()) > distance;
    }


}

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.MotorController;

import javax.xml.namespace.QName;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;
import frc.robot.RobotMap.DrivebaseConstants;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.RelativeEncoder;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;

public class DrivebaseSubsystem extends SubsystemBase{
    private final CANSparkMax leftFrontMotor;
    private final CANSparkMax leftBackMotor;
    private final CANSparkMax rightFrontMotor;
    private final CANSparkMax rightBackMotor;
    private final MotorController leftSideGroup;
    private final MotorController rightSideGroup;
    private final DifferentialDrive drive;
    private final RelativeEncoder leftFrontEncoder;
    private final RelativeEncoder leftBackEncoder;
    private final RelativeEncoder rightFrontEncoder;
    private final RelativeEncoder rightBackEncoder;


     public DifferentialDrive getDrive() {
        return drive;
    }
    public static final ShuffleboardTab DRIVEBASE_TAB = Shuffleboard.getTab("Drivebase");
    public static final NetworkTableEntry LEFT_ENCODER_ENTRY = DRIVEBASE_TAB.add("Left Encoder", 0).getEntry();
    public static final NetworkTableEntry RIGHT_ENCODER_ENTRY = DRIVEBASE_TAB.add("Right Encoder", 0).getEntry();
    public static final NetworkTableEntry ENCODER_DISTANCE_ENTRY = DRIVEBASE_TAB.add("Encoder Distance", 0).getEntry();
    public static final NetworkTableEntry NAVX_ANGLE_ENTRY = DRIVEBASE_TAB.add("NavX Angle", 0).getEntry();
    public static final NetworkTableEntry NAVX_RATE_ENTRY = DRIVEBASE_TAB.add("NavX Rate", 0).getEntry();

    public DrivebaseSubsystem()
     {
        
        leftFrontMotor = new CANSparkMax(DrivebaseConstants.LEFT_FRONT_SPARK_ID, MotorType.kBrushless);
        leftBackMotor = new CANSparkMax(DrivebaseConstants.LEFT_BACK_SPARK_ID, MotorType.kBrushless);
        rightFrontMotor = new CANSparkMax(DrivebaseConstants.RIGHT_FRONT_SPARK_ID, MotorType.kBrushless);
        rightBackMotor = new CANSparkMax(DrivebaseConstants.RIGHT_BACK_SPARK_ID, MotorType.kBrushless);
        leftSideGroup = new MotorControllerGroup(leftFrontMotor, leftBackMotor);
        rightSideGroup = new MotorControllerGroup(rightFrontMotor, rightBackMotor); //:)
        
        leftFrontEncoder = leftFrontMotor.getEncoder();
        leftBackEncoder = leftBackMotor.getEncoder();
        rightFrontEncoder = rightFrontMotor.getEncoder();
        rightBackEncoder = rightBackMotor.getEncoder();



        leftFrontMotor.setInverted(DrivebaseConstants.LEFT_FRONT_SPARK_INVERTED);
        leftBackMotor.setInverted(DrivebaseConstants.LEFT_BACK_SPARK_INVERTED);
        rightFrontMotor.setInverted(DrivebaseConstants.RIGHT_FRONT_SPARK_INVERTED);
        rightBackMotor.setInverted(DrivebaseConstants.RIGHT_BACK_SPARK_INVERTED); //:)

        leftFrontMotor.setIdleMode(DrivebaseConstants.BRAKE);
        leftBackMotor.setIdleMode(DrivebaseConstants.BRAKE);
        leftFrontMotor.setIdleMode(DrivebaseConstants.BRAKE);
        rightBackMotor.setIdleMode(DrivebaseConstants.BRAKE); // :)

        drive = new DifferentialDrive(leftSideGroup, rightSideGroup);
     }

    public RelativeEncoder getfrontleftEncoder()
    {
        return leftFrontEncoder;
    }
    public RelativeEncoder getbackleftEncoder()
    {
        return leftBackEncoder;
    }
    public RelativeEncoder getfrontrightEncoder()
    {
        return rightFrontEncoder;
    }
    public RelativeEncoder getbackrightEncoder()
    {
        return rightBackEncoder;
    }

    public double getLeftEncoder() {
        return Math.abs(leftFrontEncoder.getPosition() + leftBackEncoder.getPosition());
    }

    public double getRightEncoder() {
        return Math.abs(rightFrontEncoder.getPosition() + rightBackEncoder.getPosition());
    }

    public double getAverageEncoders()
    {
        return Math.abs((Math.abs(getLeftEncoder()) + Math.abs(getRightEncoder())) / 2);
    }

    public void resetEncoders()
    {
        leftBackEncoder.setPosition(0.0D);
        leftFrontEncoder.setPosition(0.0D);
        rightBackEncoder.setPosition(0.0D);
        rightFrontEncoder.setPosition(0.0D);

    }

    public void resetEncoders(double value)
    {
        leftBackEncoder.setPosition(value);
        leftFrontEncoder.setPosition(value);
        rightBackEncoder.setPosition(value);
        rightFrontEncoder.setPosition(value);
    }


    public void arcadeDrive(double arcadeDriveSpeed, double arcadeDriveRotations)
    {
        getDrive().arcadeDrive(arcadeDriveSpeed, arcadeDriveRotations);
    }


    public void tankDrive(double leftSpeed, double rightSpeed) 
    {
        getDrive().tankDrive(leftSpeed, rightSpeed);
    }

    public void curvatureDrive(double xSpeed, double zRotations, boolean allowTurnInPlace)
    {
        getDrive().curvatureDrive(xSpeed, zRotations, allowTurnInPlace);
    }

    @Override
    public void periodic()
    {
        
    }
}

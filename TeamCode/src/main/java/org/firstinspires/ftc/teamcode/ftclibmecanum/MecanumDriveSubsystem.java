package org.firstinspires.ftc.teamcode.ftclibmecanum;

import com.arcrobotics.ftclib.drivebase.MecanumDrive;
import com.arcrobotics.ftclib.hardware.RevIMU;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class MecanumDriveSubsystem {

    private final MecanumDrive drive;
    private final RevIMU imu;
    private double headingOffset;

    public MecanumDriveSubsystem(HardwareMap hardwareMap) {
        MotorEx frontLeft = new MotorEx(hardwareMap, "frontLeft");
        MotorEx frontRight = new MotorEx(hardwareMap, "frontRight");
        MotorEx backLeft = new MotorEx(hardwareMap, "backLeft");
        MotorEx backRight = new MotorEx(hardwareMap, "backRight");

        frontLeft.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
        frontRight.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
        backLeft.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
        backRight.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);

        drive = new MecanumDrive(frontLeft, frontRight, backLeft, backRight);

        imu = new RevIMU(hardwareMap, "IMU");
        imu.init();
        headingOffset = 0.0;
    }

    public void zeroHeading() {
        headingOffset = imu.getHeading();
    }

    public double getRobotHeading() {
        return imu.getHeading() + headingOffset;
    }

    public void driveFieldCentric(double strafe, double forward, double turn) {
        drive.driveFieldCentric(strafe, forward, turn, getRobotHeading());
    }

    public void stop() {
        drive.stop();
    }
}

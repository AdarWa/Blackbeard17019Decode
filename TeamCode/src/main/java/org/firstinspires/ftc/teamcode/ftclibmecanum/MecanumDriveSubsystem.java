package org.firstinspires.ftc.teamcode.ftclibmecanum;

import static com.sun.tools.doclint.Entity.and;
import static org.firstinspires.ftc.teamcode.ftclibmecanum.Time.waitTime;

import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class MecanumDriveSubsystem {

    private MotorEx frontLeft;
    private MotorEx backLeft;
    private MotorEx frontRight;
    private MotorEx backRight;

    public MecanumDriveSubsystem(HardwareMap hardwareMap) {
        frontLeft = new MotorEx(hardwareMap, "frontLeft");
        frontRight = new MotorEx(hardwareMap, "frontRight");
        backLeft = new MotorEx(hardwareMap, "backLeft");
        backRight = new MotorEx(hardwareMap, "backRight");
    }

    public void rotate(double V){
        if (V > 0.05){
            frontRight.set(-V);
            backRight.set(-V);
            frontLeft.set(V);
            backLeft.set(V);
        }
        if (V < 0.05) {
            frontRight.set(V);
            backRight.set(V);
            frontLeft.set(-V);
            backLeft.set(-V);
        }
    }

    public void move(double VX, double VY) {
        if ((VY > 0.05) && (VX >= 0.05)) {
            backRight.set(VY);
            frontLeft.set(VY);
            if (VX > 0.1) {
                backLeft.set(VX);
                frontRight.set(VX);
            }

            else {
                backLeft.set(VY);
                frontRight.set(VY);
            }
        }

        if ((VY < 0.05) && (VX >= 0.05)) {
            frontRight.set(VY);
            backLeft.set(VY);
            if (VX >= 0.1) {
                frontLeft.set(VX);
                backRight.set(VX);
            } else {
                frontLeft.set(VY);
                backRight.set(VY);
            }
        }

        if ((VY > 0.05) && (VX <= 0.05)) {
            frontRight.set(VY);
            backLeft.set(VY);
            if (VX < -0.1) {
                frontLeft.set(VX);
                backRight.set(VX);
            } else {
                frontLeft.set(VY);
                backRight.set(VY);
            }
        }

        if ((VY < 0.05) && (VX <= 0.05)) {
            frontLeft.set(VY);
            backRight.set(VY);
            if (VX < -0.1) {
                frontRight.set(VX);
                backLeft.set(VX);
            } else {
                frontRight.set(VY);
                backLeft.set(VY);
            }
        }
    }
}
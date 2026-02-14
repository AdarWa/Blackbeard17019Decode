package org.firstinspires.ftc.teamcode.ftclibmecanum;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;
import static org.firstinspires.ftc.teamcode.ftclibmecanum.Time.waitTime;

import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class MovementSubsystem {
    private MotorEx frontLeft;
    private MotorEx frontRight;
    private MotorEx backLeft;
    private MotorEx backRight;

    public void init() {
        frontLeft = new MotorEx(hardwareMap, "frontLeft");
        frontRight = new MotorEx(hardwareMap, "frontRight");
        backLeft = new MotorEx(hardwareMap, "backLeft");
        backRight = new MotorEx(hardwareMap, "backRight");
    }
    public void turn_left(int seconds, double V) {
        frontRight.setVelocity(V);
        backRight.setVelocity(V);
        frontLeft.setVelocity(-V);
        backLeft.setVelocity(-V);
        waitTime(seconds);
        frontRight.setVelocity(0);
        backRight.setVelocity(0);
        frontLeft.setVelocity(0);
        backLeft.setVelocity(0);
    }

    public void move_forward(int seconds, double V) {
        frontRight.setVelocity(V);
        backRight.setVelocity(V);
        frontLeft.setVelocity(V);
        backLeft.setVelocity(V);
        waitTime(seconds);
        frontRight.setVelocity(0);
        backRight.setVelocity(0);
        frontLeft.setVelocity(0);
        backLeft.setVelocity(0);
    }
    public void turn_right(int seconds, double V) {
        frontRight.setVelocity(-V);
        backRight.setVelocity(-V);
        frontLeft.setVelocity(V);
        backLeft.setVelocity(V);
        waitTime(seconds);
        frontRight.setVelocity(0);
        backRight.setVelocity(0);
        frontLeft.setVelocity(0);
        backLeft.setVelocity(0);
    }
    public void move_backwards(int seconds, double V) {
        frontRight.setVelocity(-V);
        backRight.setVelocity(-V);
        frontLeft.setVelocity(-V);
        backLeft.setVelocity(-V);
        waitTime(seconds);
        frontRight.setVelocity(0);
        backRight.setVelocity(0);
        frontLeft.setVelocity(0);
        backLeft.setVelocity(0);
    }
    public void strafe_left(int seconds, double V) {
        frontRight.setVelocity(V);
        frontLeft.setVelocity(-V);
        backLeft.setVelocity(V);
        backRight.setVelocity(-V);
        waitTime(seconds);
        frontRight.setVelocity(0);
        frontLeft.setVelocity(0);
        backLeft.setVelocity(0);
        backRight.setVelocity(0);
    }
    public void strafe_right(int seconds, double V) {
        frontRight.setVelocity(-V);
        frontLeft.setVelocity(V);
        backLeft.setVelocity(-V);
        backRight.setVelocity(V);
        waitTime(seconds);
        frontRight.setVelocity(0);
        frontLeft.setVelocity(0);
        backLeft.setVelocity(0);
        backRight.setVelocity(0);
    }
}
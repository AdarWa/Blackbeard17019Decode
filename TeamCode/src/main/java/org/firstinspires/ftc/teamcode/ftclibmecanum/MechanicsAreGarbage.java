package org.firstinspires.ftc.teamcode.ftclibmecanum;

import static org.firstinspires.ftc.teamcode.ftclibmecanum.Time.waitTime;

import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
@TeleOp(name = "Example Op Mode", group = "Examples")
public class MechanicsAreGarbage extends OpMode {

    private MotorEx frontLeft;

    private MotorEx frontRight;

    private MotorEx backLeft;

    private MotorEx backRight;
    private GamepadEx Driver;
    @Override
    public void init() {
        frontLeft = new MotorEx(hardwareMap,"frontLeft");
        frontRight = new MotorEx(hardwareMap,"frontRight");
        backLeft = new MotorEx(hardwareMap,"backLeft");
        backRight = new MotorEx(hardwareMap,"backRight");
        Driver = new GamepadEx(gamepad1);
    }

    @Override
    public void loop() {
        Driver.readButtons();
        if (Driver.wasJustPressed(GamepadKeys.Button.Y)) {
            frontLeft.set(1);
            waitTime(5);
            frontLeft.set(0);
            backLeft.set(1);
            waitTime(5);
            backLeft.set(0);
            frontRight.set(1);
            waitTime(5);
            frontRight.set(0);
            backRight.set(1);
            waitTime(5);
            backRight.set(0);
        }
    }

    @Override
    public void stop() {
    }

}
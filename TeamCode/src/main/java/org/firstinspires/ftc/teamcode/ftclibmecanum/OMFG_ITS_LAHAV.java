package org.firstinspires.ftc.teamcode.ftclibmecanum;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad1;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad2;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;
import static org.firstinspires.ftc.teamcode.ftclibmecanum.Time.waitTime;

import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion;

@TeleOp(name = "NERDDDDDDDDDDDDDDDDD", group = "NERDDDDDDDDDDDDDDDDD")
public class OMFG_ITS_LAHAV {
    private MotorEx frontLeft;
    private MotorEx frontRight;
    private MotorEx backLeft;
    private MotorEx backRight;
    private GamepadEx gamepad;

    private boolean IAmAVargion = false;

    public void init() {
         frontLeft = new MotorEx(hardwareMap, "frontLeft");
         frontRight = new MotorEx(hardwareMap,"frontRight");
         backLeft = new MotorEx(hardwareMap,"backLeft");
         backRight = new MotorEx(hardwareMap,"backRight");
         gamepad = new GamepadEx(gamepad2);
    }

    public void loop() {
        while (!IAmAVargion) {
            frontRight.set(-1);
            backRight.set(-1);
            frontLeft.set(1);
            backRight.set(1);
            waitTime(3);
            frontRight.set(0);
            backRight.set(0);
            frontLeft.set(0);
            backRight.set(0);
            break;
        }
    }
}


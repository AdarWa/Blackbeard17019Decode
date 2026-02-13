package org.firstinspires.ftc.teamcode.ftclibmecanum;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad2;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;
import static org.firstinspires.ftc.teamcode.ftclibmecanum.Time.waitTime;

import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@Autonomous(name=("IDC (Launch Zone Blue)"),group="Auto")
public class IM_GONNA_JUMP_YOUR_CABLE {
    private MotorEx frontLeft;
    private MotorEx frontRight;
    private MotorEx backLeft;
    private MotorEx backRight;


    private MotorEx shooter;

    private boolean IAmAVargion = false;

    public void init() {
        frontLeft = new MotorEx(hardwareMap, "frontLeft");
        frontRight = new MotorEx(hardwareMap, "frontRight");
        backLeft = new MotorEx(hardwareMap, "backLeft");
        backRight = new MotorEx(hardwareMap, "backRight");
        shooter = new MotorEx(hardwareMap, "shooter");
    }

    public void turn_left(int seconds) {
        frontRight.set(1);
        backRight.set(1);
        frontLeft.set(-1);
        backLeft.set(-1);
        waitTime(seconds);
        frontRight.set(0);
        backRight.set(0);
        frontLeft.set(0);
        backLeft.set(0);
    }

    public void forward(int seconds) {
        frontRight.set(1);
        backRight.set(1);
        frontLeft.set(1);
        backLeft.set(1);
        waitTime(seconds);
        frontRight.set(0);
        backRight.set(0);
        frontLeft.set(0);
        backLeft.set(0);
    }

    public void loop() {
        while (!IAmAVargion) {
            forward(2);
            turn_left(2);
            shooter.set(1);
            telemetry.addData("Huston we have liftoff", true);
            telemetry.update();
            break;

        }

    }
}
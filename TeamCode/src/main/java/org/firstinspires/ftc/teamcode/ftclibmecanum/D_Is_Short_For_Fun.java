package org.firstinspires.ftc.teamcode.ftclibmecanum;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad2;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;
import static org.firstinspires.ftc.teamcode.ftclibmecanum.Time.waitTime;

import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@Autonomous(name="WTF (Launch Zone Red)",group="Auto")
public class D_Is_Short_For_Fun
{
    private MotorEx frontLeft;
    private MotorEx frontRight;
    private MotorEx backLeft;
    private MotorEx backRight;


    private MotorEx shooter;

    private boolean IAmAVargion = false;

    public void init() {
        frontLeft = new MotorEx(hardwareMap, "frontLeft");
        frontRight = new MotorEx(hardwareMap,"frontRight");
        backLeft = new MotorEx(hardwareMap,"backLeft");
        backRight = new MotorEx(hardwareMap,"backRight");

        shooter = new MotorEx(hardwareMap,"shooter");
    }

    public void loop() {
        while (!IAmAVargion) {
            frontRight.set(1);
            backRight.set(1);
            frontLeft.set(1);
            backLeft.set(1);
            waitTime(3);
            frontRight.set(0);
            backRight.set(0);
            frontLeft.set(0);
            backLeft.set(0);
            waitTime(1);
            frontRight.set(-1);
            backRight.set(-1);
            frontLeft.set(1);
            backLeft.set(1);
            waitTime(1);
            frontRight.set(0);
            backRight.set(0);
            frontLeft.set(0);
            backLeft.set(0);
            shooter.set(1);
            telemetry.addData("Huston we have liftoff",true);
            telemetry.update();
            break;

        }
    }
}

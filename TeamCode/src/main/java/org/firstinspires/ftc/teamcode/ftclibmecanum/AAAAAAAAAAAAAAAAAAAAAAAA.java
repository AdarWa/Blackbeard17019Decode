package org.firstinspires.ftc.teamcode.ftclibmecanum;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad2;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;
import static org.firstinspires.ftc.teamcode.ftclibmecanum.Time.waitTime;

import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@Autonomous
public class AAAAAAAAAAAAAAAAAAAAAAAA extends OpMode {

    private MotorEx shooter;
    private MovementSubsystem WOOSH;


    private boolean IAmAVargion = false;

    public void init() {
        shooter = new MotorEx(hardwareMap, "shooter");
    }
    public void loop() {
        while (!IAmAVargion) {
            WOOSH.turn_right(2, 0.5);
            shooter.setVelocity(1);
            telemetry.addData("Huston we have liftoff", true);
            telemetry.update();
            break;
        }
    }
}
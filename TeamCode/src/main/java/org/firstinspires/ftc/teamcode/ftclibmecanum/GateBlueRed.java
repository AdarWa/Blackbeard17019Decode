package org.firstinspires.ftc.teamcode.ftclibmecanum;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad2;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;
import static org.firstinspires.ftc.teamcode.ftclibmecanum.Time.waitTime;

import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
@Autonomous
public class GateBlueRed extends LinearOpMode {

    private MotorEx shooter;
    private MovementSubsystem drive;

    @Override
    public void runOpMode() throws InterruptedException {
        drive = new MovementSubsystem(hardwareMap);
        shooter = new MotorEx(hardwareMap, "shooter");
        waitForStart();
        while(opModeIsActive() && !isStopRequested()){
            drive.move_forward(2,0.5);
            shooter.setVelocity(1);
        }
        drive.stop();
    }

}
package org.firstinspires.ftc.teamcode.ftclibmecanum;

import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "Op Mode", group = "Main")
public class ExampleOpMode extends OpMode {

    private MecanumDriveSubsystem drive;
    private GamepadEx driver;
    private GamepadEx operator;
    private shooterSubSystem shooter;
    private IntakeSubsystem intake;
    private final double CLOSE_TO_TARGET_VELOCITY = 0.1;
    private final double FAR_FROM_TARGET_VELOCITY = 1;

    @Override
    public void init() {
        driver = new GamepadEx(gamepad1);
        operator = new GamepadEx(gamepad2);
        shooter = new shooterSubSystem();
        intake = new IntakeSubsystem(hardwareMap);
        drive = new MecanumDriveSubsystem(hardwareMap);
    }

    @Override
    public void loop() {
        driver.readButtons();
        operator.readButtons();
        drive.driveRobotCentric(driver.getLeftY(), driver.getLeftX(), driver.getRightX());

        if (operator.isDown(GamepadKeys.Button.B)) {
            intake.setIntakeVelocity(1.0);
        } else {
            intake.off();
        }

        if (operator.isDown(GamepadKeys.Button.Y)) {
            intake.setIntakeVelocity(0.2);
        } else {
            intake.setIntakeVelocity(0);
        }

        if (operator.isDown(GamepadKeys.Button.A)) {
            shooter.setShooterVelocity(CLOSE_TO_TARGET_VELOCITY);
        } else {
            shooter.stop();
        }

        if (operator.isDown(GamepadKeys.Button.X)) {
            shooter.setShooterVelocity(FAR_FROM_TARGET_VELOCITY);
        } else {
            shooter.stop();
        }
    }


    @Override
    public void stop(){
        shooter.stop();
        intake.off();
        drive.stop();
    }
}
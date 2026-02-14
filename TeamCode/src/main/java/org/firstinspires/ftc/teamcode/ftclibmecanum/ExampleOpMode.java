package org.firstinspires.ftc.teamcode.ftclibmecanum;

import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "Op Mode", group = "MainS")
public class ExampleOpMode extends OpMode {

    private MecanumDriveSubsystem drive;
    private GamepadEx driver;
    private GamepadEx operator;
    private shooterSubSystem shooter;
    private IntakeSubsystem intake;
    private final double CLOSE_TO_TARGET_VELOCITY = 0.8;
    private final double FAR_FROM_TARGET_VELOCITY = 0.5;

    @Override
    public void init() {
        driver = new GamepadEx(gamepad1);
        operator = new GamepadEx(gamepad2);
        shooter = new shooterSubSystem();
        intake = new IntakeSubsystem(hardwareMap);
        drive = new MecanumDriveSubsystem(hardwareMap);


        drive.zeroHeading();
    }

    @Override
    public void loop() {
        driver.readButtons();
        operator.readButtons();
        drive.driveFieldCentric(
                -driver.getLeftX() / 2,
                -driver.getLeftY() / 2,
                driver.getRightX() / 2);

        if(driver.isDown(GamepadKeys.Button.Y)){
            drive.zeroHeading();
        }

        if (operator.getTrigger(GamepadKeys.Trigger.RIGHT_TRIGGER) > 0.7) {
            intake.setIntakeVelocity(1.0);
        } else {
            intake.off();
        }

        if(operator.isDown(GamepadKeys.Button.A)){
            shooter.setShooterVelocity(CLOSE_TO_TARGET_VELOCITY);
        }else if(operator.isDown(GamepadKeys.Button.B)){
            shooter.setShooterVelocity(FAR_FROM_TARGET_VELOCITY);
        }else{
            shooter.stop();
        }

        telemetry.addData("are mechanics are garbage?", true);
        telemetry.addData("Rotation", drive.getRobotHeading());
        telemetry.update();
    }
        public void stop() {
            shooter.stop();
            intake.off();
            drive.stop();
        }

    }


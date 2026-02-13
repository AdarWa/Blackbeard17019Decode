package org.firstinspires.ftc.teamcode.ftclibmecanum;

import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.arcrobotics.ftclib.gamepad.KeyReader;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.HardwareMap;

@TeleOp(name = "Op Mode", group = "MainS")
public class ExampleOpMode extends OpMode {

    private MecanumDriveSubsystem drive;
    private GamepadEx driver;
    private GamepadEx operator;
    private shooterSubSystem shooter;
    private IntakeSubsystem intake;
    private double manualIntakeV;
    double maxShooterVelocity;
    private boolean isShooterRunning = false;

    @Override
    public void init() {
        driver = new GamepadEx(gamepad1);
        operator = new GamepadEx(gamepad2);
        shooter = new shooterSubSystem();
        intake = new IntakeSubsystem(hardwareMap);
        drive = new MecanumDriveSubsystem(hardwareMap);

        maxShooterVelocity = 0.9;
        manualIntakeV = 0;

        drive.zeroHeading();
    }
    public double rpmToAngularVelocity (double rpm) { return 120*Math.PI*rpm ; }
    public double angularVelocityToRpm (double angularVelocity) { return angularVelocity/120/Math.PI; }

    @Override
    public void loop() {
        driver.readButtons();
        operator.readButtons();
        drive.driveFieldCentric(
                -driver.getLeftX() / 2,
                -driver.getLeftY() / 2,
                driver.getRightX() / 2);

        if (operator.isDown(GamepadKeys.Button.A)) {
            intake.setIntakeVelocity(manualIntakeV);
        } else {
            intake.off();
        }


        if (operator.wasJustPressed(GamepadKeys.Button.X)) {
            if (manualIntakeV < 5) {
                manualIntakeV++;
            }
        } else if (operator.wasJustPressed(GamepadKeys.Button.Y)) {
            if (manualIntakeV > 0) {
                manualIntakeV--;
            }
        } else {
            if (operator.wasJustPressed(GamepadKeys.Button.B)) {
                shooter.setShooterVelocity(0.8);
            }
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

        public void TERMINATE() {
        if(operator.wasJustPressed(GamepadKeys.Button.DPAD_LEFT)) {
            stop();
        }

    }
    }


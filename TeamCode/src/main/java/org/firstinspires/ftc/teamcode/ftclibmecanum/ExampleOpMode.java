package org.firstinspires.ftc.teamcode.ftclibmecanum;

import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.HardwareMap;

@TeleOp(name = "Example Op Mode", group = "Examples")
public class ExampleOpMode extends OpMode {

    private MecanumDriveSubsystem drive;
    private GamepadEx driver;
    private GamepadEx operator;
    private ShooterSubsystem shooter;
    private IntakeSubsystem intake;

    double maxShooterVelocity;
    @Override
    public void init() {
        driver = new GamepadEx(gamepad1);
        operator = new GamepadEx(gamepad2);
        shooter = new ShooterSubsystem(hardwareMap);
        intake = new IntakeSubsystem(hardwareMap);
        drive = new MecanumDriveSubsystem(hardwareMap);
        maxShooterVelocity = 62;

        drive.zeroHeading();
    }

    @Override
    public void loop() {
        driver.readButtons();
        operator.readButtons();
        drive.driveFieldCentric(
                -driver.getLeftX() / 4,
                -driver.getLeftY() / 4,
                driver.getRightX() / 4);

        if (operator.isDown(GamepadKeys.Button.A)) {
            intake.on();
        }
        else {
            intake.off();
        }

        double shooterPower = -operator.getLeftY() * maxShooterVelocity;
        shooter.setVelocity(shooterPower);

        shooter.periodic();

        telemetry.addData("Rotation",drive.getRobotHeading());
        telemetry.update();
    }

    @Override
    public void stop() {
        shooter.stop();
        intake.off();
        drive.stop();
    }

}

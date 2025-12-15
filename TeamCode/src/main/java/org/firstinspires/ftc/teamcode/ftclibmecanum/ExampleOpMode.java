package org.firstinspires.ftc.teamcode.ftclibmecanum;

import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name = "Example Op Mode", group = "Examples")
public class ExampleOpMode extends OpMode {

    private MecanumDriveSubsystem drive;
    private GamepadEx driver;
    private ShooterSubsystem shooter;
    private IntakeSubsystem intake;


    @Override
    public void init() {
        drive = new MecanumDriveSubsystem(hardwareMap);
        shooter = new ShooterSubsystem(hardwareMap);
        intake = new IntakeSubsystem(hardwareMap);
        driver = new GamepadEx(gamepad1);
        drive.zeroHeading();
    }

    @Override
    public void loop() {
        driver.readButtons();

        drive.driveFieldCentric(
                driver.getLeftX(),
                -driver.getLeftY(),
                driver.getRightX()
        );

        double shooterPower = driver.getTrigger(GamepadKeys.Trigger.RIGHT_TRIGGER);
        shooter.run(shooterPower);

        if(driver.isDown(GamepadKeys.Button.A)){
            intake.start();
        }else {
            intake.stop();
        }

    }

    @Override
    public void stop() {
        drive.stop();
        shooter.stop();
        intake.stop();
    }

}

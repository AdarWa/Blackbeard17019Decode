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
    private boolean isShooterRunning = false;

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
    public double rpmToAngularVelocity (double rpm) {
        return 120*Math.PI*rpm ;
    }
    public double angularVelocityToRpm (double angularVelocity){
        return angularVelocity/120/Math.PI;
    }

    @Override
    public void loop() {
        driver.readButtons();
        operator.readButtons();
        drive.driveFieldCentric(
                -driver.getLeftX() / 2,
                -driver.getLeftY() / 2,
                driver.getRightX() / 2);

        if (operator.isDown(GamepadKeys.Button.A)) {
            intake.on();
        }
        else {
            intake.off();
        }
        if (operator.wasJustPressed(GamepadKeys.Button.B)&&
                !isShooterRunning){
            //shooter.setVelocity(rpmToAngularVelocity(maxShooterVelocity));
            shooter.setShooterPower(1.0);
            isShooterRunning=true;
        } else if (operator.wasJustPressed(GamepadKeys.Button.B)&&
                   isShooterRunning){
            shooter.stop();
            isShooterRunning = false;
        }
        //double shooterPower = -operator.getLeftY() * maxShooterVelocity;
        //shooter.setShooterPower(shooterPower);

        shooter.periodic();

        telemetry.addData("Rotation",drive.getRobotHeading());
        telemetry.addData("VelocityRPM", angularVelocityToRpm(shooter.getVelocity()));
        telemetry.update();
    }

    @Override
    public void stop() {
        shooter.stop();
        intake.off();
        drive.stop();
    }

}

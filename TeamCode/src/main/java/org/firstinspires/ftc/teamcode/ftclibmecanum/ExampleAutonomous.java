package org.firstinspires.ftc.teamcode.ftclibmecanum;

import static org.firstinspires.ftc.teamcode.ftclibmecanum.Time.waitTime;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous
public class ExampleAutonomous extends LinearOpMode {
    private MecanumDriveSubsystem drive;


    @Override
    public void runOpMode() throws InterruptedException {
        drive = new MecanumDriveSubsystem(hardwareMap);

        waitForStart();


    }

    @Override
    public void init() {

    }

    @Override
    public void loop() {
        drive.driveFieldCentric(0, 0.5,0);
        waitTime(1);
        drive.stop();
        while ()

    }

    @Override
    public void stop() {
        drive.stop();
    }
}

package org.firstinspires.ftc.teamcode.ftclibmecanum;

import static org.firstinspires.ftc.teamcode.ftclibmecanum.Time.waitTime;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

@Autonomous
public class ExampleAutonomous extends OpMode{
    private MecanumDriveSubsystem drive;


    @Override
    public void init() {
        drive = new MecanumDriveSubsystem(hardwareMap);
    }

    @Override
    public void loop() {
        drive.driveFieldCentric(0, 0.5,0);
        waitTime(1);
        drive.stop();
    }

    @Override
    public void stop() {
        drive.stop();
    }
}

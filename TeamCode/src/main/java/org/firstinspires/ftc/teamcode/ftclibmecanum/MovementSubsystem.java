package org.firstinspires.ftc.teamcode.ftclibmecanum;

import com.qualcomm.robotcore.hardware.HardwareMap;

public class MovementSubsystem {

}
//    private LocationSubsystem LocatorThingy;
//    private HardwareMap hardwareMap;
//    private double X = 7;
//    private double Y = 7;
//    private double Rotation;
//    private MecanumDriveSubsystem drive;                        /*  VVVVV takes an existing location subsystem for performance improvements*/
//    public MovementSubsystem(HardwareMap hardwareMap, LocationSubsystem locationSubsystem) {
//        LocatorThingy = locationSubsystem;
//        drive = new MecanumDriveSubsystem(hardwareMap);
//    }
//    public void GoTo(double x,double y) {
//        LocatorThingy.run();
//        if (y != 5000) {
//            X = x;
//            Y = y;
//            drive.driveFieldCentric(X - LocatorThingy.x(), Y - LocatorThingy.y(), -LocatorThingy.rotation());
//        }
//        else {
//            X = 5000;
//        }
//    }
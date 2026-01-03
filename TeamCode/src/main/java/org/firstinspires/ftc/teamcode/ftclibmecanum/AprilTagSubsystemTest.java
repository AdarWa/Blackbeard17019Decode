package org.firstinspires.ftc.teamcode.ftclibmecanum;

import com.arcrobotics.ftclib.util.InterpLUT;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.vision.VisionPortal;
import org.firstinspires.ftc.vision.VisionProcessor;
import org.firstinspires.ftc.vision.apriltag.AprilTagDetection;
import org.firstinspires.ftc.vision.apriltag.AprilTagProcessor;

import java.util.List;

public class AprilTagSubsystemTest {
    private VisionPortal VisionPortal1;
    private AprilTagProcessor VisionProcessor1;
    private AprilTagDetection TagDetect;
    List<AprilTagDetection> TagDetectList;
    private int TargetID;
    private InterpLUT ShooterDisToVelLUT;

    public AprilTagSubsystemTest (HardwareMap hardwareMap,int GoalID) {
        VisionProcessor1 = AprilTagProcessor.easyCreateWithDefaults();
        VisionPortal1 = VisionPortal.easyCreateWithDefaults(hardwareMap.get(WebcamName.class,"Webcam"),VisionProcessor1);
        TargetID = GoalID;
        ShooterDisToVelLUT = new InterpLUT();
        ShooterDisToVelLUT.add(1,2);
        ShooterDisToVelLUT.add(2,3);
        ShooterDisToVelLUT.add(3,1);
        ShooterDisToVelLUT.createLUT();
    }
    public double GetDist () {
        TagDetectList = VisionProcessor1.getDetections();
        for (AprilTagDetection TagDetect : TagDetectList){
            if (TagDetect.id == TargetID) {
                return TagDetect.ftcPose.y;
            }
        }
        return -1;
    }
    public double GetAngle () {
        TagDetectList = VisionProcessor1.getDetections();
        for (AprilTagDetection TagDetect : TagDetectList){
            if (TagDetect.id == TargetID) {
                return Math.atan(TagDetect.ftcPose.x / TagDetect.ftcPose.y);
            }
        }
        return -1;
    }
    public double GetShooterVel() {
        return ShooterDisToVelLUT.get(GetDist());
    }
}

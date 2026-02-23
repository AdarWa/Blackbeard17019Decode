package org.firstinspires.ftc.teamcode.ftclibmecanum;

import android.nfc.Tag;

import com.arcrobotics.ftclib.util.InterpLUT;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.vision.VisionPortal;
import org.firstinspires.ftc.vision.VisionProcessor;
import org.firstinspires.ftc.vision.apriltag.AprilTagDetection;
import org.firstinspires.ftc.vision.apriltag.AprilTagProcessor;

import java.util.List;

public class AprilTagSubsystemTest {
    //Variable initialisation
    private VisionPortal VisionPortal1;
    private AprilTagProcessor VisionProcessor1;
    private AprilTagDetection TagDetect;
    List<AprilTagDetection> TagDetectList;
    private int TargetID;
    private InterpLUT ShooterDisToVelLUT;

    public AprilTagSubsystemTest (HardwareMap hardwareMap) {
        //setting the vision processor's settings
        VisionProcessor1 = new AprilTagProcessor.Builder()
                .setOutputUnits(DistanceUnit.CM, AngleUnit.DEGREES)
                .build();
        VisionPortal1 = VisionPortal.easyCreateWithDefaults(hardwareMap.get(WebcamName.class,"Webcam"),VisionProcessor1);
        ShooterDisToVelLUT = new InterpLUT();
        ShooterDisToVelLUT.add(1,2);
        ShooterDisToVelLUT.add(2,3);
        ShooterDisToVelLUT.add(3,1);
        ShooterDisToVelLUT.createLUT();
    }
    public double GetDist (int GoalID) {
        TagDetectList = VisionProcessor1.getDetections();
        TargetID = GoalID;
        for (AprilTagDetection TagDetect : TagDetectList){
            if (TagDetect.id == TargetID) {
                return TagDetect.ftcPose.range;
            }
        }
        return -1;
    }
    public double GetAngle (int GoalID) {
        TagDetectList = VisionProcessor1.getDetections();
        TargetID = GoalID;
        for (AprilTagDetection TagDetect : TagDetectList){
            if (TagDetect.id == TargetID) {
                return TagDetect.ftcPose.bearing; //*check documentation for + direction
            }
        }
        return -1;
    }
    public double GetShooterVel(int GoalID) {
        TargetID = GoalID;
        return ShooterDisToVelLUT.get(GetDist(TargetID));
    }
    public double TargetTagX (int GoalID) {
        TargetID = GoalID;
        TagDetectList = VisionProcessor1.getDetections();
        for (AprilTagDetection TagDetect : TagDetectList){
            if (TagDetect.id == TargetID) {
                return TagDetect.ftcPose.x;
            }
        }
        return 0; //DO NOT USE AS CHECK
    }
    public double TargetTagY (int GoalID) {
        TargetID = GoalID;
        TagDetectList = VisionProcessor1.getDetections();
        for (AprilTagDetection TagDetect : TagDetectList){
            if (TagDetect.id == TargetID) {
                return TagDetect.ftcPose.y;
            }
        }
        return -1;
    }
    public double TargetTagYaw (int GoalID) {
        TargetID = GoalID;
        TagDetectList = VisionProcessor1.getDetections();
        for (AprilTagDetection TagDetect : TagDetectList){
            if (TagDetect.id == TargetID) {
                return TagDetect.ftcPose.yaw;
            }
        }
        return 0; //DO NOT USE AS CHECK
    }
}

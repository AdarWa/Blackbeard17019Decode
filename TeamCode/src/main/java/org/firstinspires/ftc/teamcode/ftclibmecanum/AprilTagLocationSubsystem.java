package org.firstinspires.ftc.teamcode.ftclibmecanum;

public class AprilTagLocationSubsystem {
    private AprilTagSubsystemTest AprilTagDetector;
    private double DetectedY;
    private double DetectedX;
    private double yaw;
    private double TagAngleToWall;
    private double TagAngleFromVert;
    public AprilTagLocationSubsystem(AprilTagSubsystemTest AprilTagSubsystem) {
        AprilTagDetector = AprilTagSubsystem;
    }

    public double getHeading (int TargetID, double TagAngle) {
        TagAngleToWall = (-TagAngle) - 90;
        yaw = AprilTagDetector.TargetTagYaw(TargetID);
        return Math.toRadians(90 + yaw - TagAngleToWall);
    }

    public double getRobotX (double tagX, int TargetID, double TagAngle) {
        TagAngleFromVert = getHeading(TargetID, TagAngle ) - AprilTagDetector.GetAngle(TargetID);
            return tagX - (AprilTagDetector.GetDist(TargetID) * Math.sin(Math.toRadians(AprilTagDetector.GetAngle(TargetID))));
    }

    public double getRobotY (double tagY, int TargetID, double TagAngle) {
        TagAngleFromVert = getHeading(TargetID, TagAngle ) - AprilTagDetector.GetAngle(TargetID);
        return tagY - (AprilTagDetector.GetDist(TargetID) * Math.cos(Math.toRadians(AprilTagDetector.GetAngle(TargetID))));
    }
}

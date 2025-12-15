package org.firstinspires.ftc.teamcode.ftclibmecanum;

import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class ShooterSubsystem {

    private final Motor shooterMotor;

    public ShooterSubsystem(HardwareMap hardwareMap) {
        shooterMotor = new Motor(hardwareMap, "shooter");
    }

    public void run(double power) {
        shooterMotor.set(power);
    }

    public void stop() {
        shooterMotor.stopMotor();
    }
}

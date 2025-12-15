package org.firstinspires.ftc.teamcode.ftclibmecanum;

import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class IntakeSubsystem {

    private final Motor intakeMotor;
    public IntakeSubsystem(HardwareMap hardwareMap) {
        intakeMotor = new Motor(hardwareMap, "intake");
    }

    public void start() {
        intakeMotor.set(1.0);
    }

    public void stop() {
        intakeMotor.stopMotor();
    }
}

package org.firstinspires.ftc.teamcode.ftclibmecanum;

import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class IntakeSubsystem {

    private final Motor intakeMotor;
    public IntakeSubsystem(HardwareMap hardwareMap) {
        intakeMotor = new Motor(hardwareMap, "intake");
    }

    public void on() {
        intakeMotor.set(-1.0);
    }

    public void off() {
        intakeMotor.stopMotor();
    }
}

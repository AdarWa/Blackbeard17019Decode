package org.firstinspires.ftc.teamcode.ftclibmecanum;

import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class IntakeSubsystem {

    private final Motor intakeMotor;
    public IntakeSubsystem(HardwareMap hardwareMap) {
        intakeMotor = new Motor(hardwareMap, "intake");
    }

    public void setIntakeVelocity(double V) {
        intakeMotor.set(V);
    }

    public void off() {

        intakeMotor.set(0);
    }
}

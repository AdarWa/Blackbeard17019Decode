package org.firstinspires.ftc.teamcode.ftclibmecanum;

import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class IntakeSubsystem {

    private final MotorEx intakeMotor;
    public IntakeSubsystem(HardwareMap hardwareMap) {
        intakeMotor = new MotorEx(hardwareMap, "intake");
    }

    public void setIntakeVelocity(double V) {
        intakeMotor.setVelocity(V);
    }

    public void off() {

        intakeMotor.setVelocity(0);
    }
}

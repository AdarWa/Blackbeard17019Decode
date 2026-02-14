package org.firstinspires.ftc.teamcode.ftclibmecanum;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;

public class shooterSubSystem {
    private Motor shooter;

    public void init(){
        shooter = new Motor(hardwareMap,"shooter");
    }

    public void setShooterVelocity(double V){
            shooter.set(V);
    }

    public void stop() {
        setShooterVelocity(0);
    }

}

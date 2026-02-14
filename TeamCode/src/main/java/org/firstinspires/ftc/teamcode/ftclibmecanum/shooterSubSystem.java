package org.firstinspires.ftc.teamcode.ftclibmecanum;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

import com.arcrobotics.ftclib.hardware.motors.MotorEx;

public class shooterSubSystem {
    private MotorEx shooter;

    public void init(){
        shooter = new MotorEx(hardwareMap,"shooter");
    }

    public void setShooterVelocity(double V){
            shooter.setVelocity(V);
    }

    public void stop() {
        setShooterVelocity(0);
    }

}

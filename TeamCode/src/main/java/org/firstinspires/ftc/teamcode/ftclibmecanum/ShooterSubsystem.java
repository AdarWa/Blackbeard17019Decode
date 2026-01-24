package org.firstinspires.ftc.teamcode.ftclibmecanum;

import com.arcrobotics.ftclib.controller.PIDFController;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class ShooterSubsystem {
    double Kf = 0 , Kp = 0 , Ki = 0 , Kd = 0;
    private double tickPerCycle = 140; // motor is 28 ticks per cycle with a 5:1 gearbox
    private double tickToRad = 2 * Math.PI / tickPerCycle;
    boolean PIDActive = false;
    double velocityTarget = 0;


    PIDFController shooterPID = new PIDFController(Kp, Ki, Kd, Kf);
    MotorEx shooterMotor;

    public ShooterSubsystem(HardwareMap hardwareMap) {
        shooterMotor = new MotorEx(hardwareMap, "shooter");
        shooterMotor.setInverted(true);
    }

    public void setShooterPower(double power){
        shooterMotor.set(power);
    }

    public void setVelocity(double velocity){
        velocityTarget = velocity;
        PIDActive = true;
    }

    public double getVelocity() {
        return shooterMotor.getVelocity()*tickToRad;
    }

    public void periodic () {
        if (PIDActive){
            setShooterPower(
                    shooterPID.calculate(getVelocity(), velocityTarget)
            );
        }
    }


    public void stop() {
        PIDActive = false;
        shooterMotor.stopMotor();
    }
}
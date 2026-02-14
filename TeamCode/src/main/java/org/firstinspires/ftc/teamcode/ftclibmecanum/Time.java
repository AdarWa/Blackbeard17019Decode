package org.firstinspires.ftc.teamcode.ftclibmecanum;

public class Time {

    public static void waitTime(double seconds){
        try {
            Thread.sleep((long)(seconds*1000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

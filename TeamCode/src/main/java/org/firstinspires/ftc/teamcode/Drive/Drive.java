package org.firstinspires.ftc.teamcode.Drive;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.CommandScheduler;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;

public class Drive extends CommandOpMode {
    private GamepadEx p1;
    private GamepadEx p2;

    public void initialize(){
        CommandScheduler.getInstance().reset();

        p1=new GamepadEx(gamepad1);
        p2=new GamepadEx(gamepad2);

    }
    public void run(){

    }

}

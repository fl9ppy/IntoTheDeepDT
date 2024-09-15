package org.firstinspires.ftc.teamcode.Drive;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.CommandScheduler;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;

import org.firstinspires.ftc.teamcode.common.commandbase.grabPixels;
import org.firstinspires.ftc.teamcode.common.commandbase.scorePixels;
import org.firstinspires.ftc.teamcode.common.subsystems.FourbarSubsystem;
import org.firstinspires.ftc.teamcode.common.subsystems.OuttakeSubsystem;

public class Drive extends CommandOpMode {
    private GamepadEx gamepadEx1;
    private GamepadEx gamepadEx2;

    public void initialize(){
        CommandScheduler.getInstance().reset();

        gamepadEx1=new GamepadEx(gamepad1);
        gamepadEx2=new GamepadEx(gamepad2);
        FourbarSubsystem fourbarsubsystem = new FourbarSubsystem(hardwareMap);
        OuttakeSubsystem outtakesubsystem = new OuttakeSubsystem(hardwareMap);

        gamepadEx1.getGamepadButton(GamepadKeys.Button.X)
                .whenPressed(new grabPixels(fourbarsubsystem));
        gamepadEx2.getGamepadButton(GamepadKeys.Button.Y)
                .whenPressed(new scorePixels(outtakesubsystem));
    }
    public void run(){

    }

}

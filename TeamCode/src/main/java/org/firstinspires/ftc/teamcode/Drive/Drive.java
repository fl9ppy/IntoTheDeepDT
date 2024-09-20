package org.firstinspires.ftc.teamcode.Drive;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.PoseVelocity2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.CommandScheduler;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.MecanumDrive;
import org.firstinspires.ftc.teamcode.common.hardware.GlobalVars;

@TeleOp(name="Drive", group = "Main")

public class Drive extends CommandOpMode {
    private GamepadEx gamepadEx1;
    private GamepadEx gamepadEx2;

    MecanumDrive drive;
    GlobalVars.Modedrive currentMode;

    public void initialize(){
        CommandScheduler.getInstance().reset();

        drive = new MecanumDrive(hardwareMap, new Pose2d(0, 0, 0));
        currentMode = GlobalVars.Modedrive.DRIVER_CONTROL;

        gamepadEx1=new GamepadEx(gamepad1);
        gamepadEx2=new GamepadEx(gamepad2);
    }
    public void run(){
        if (gamepadEx1.getTrigger(GamepadKeys.Trigger.RIGHT_TRIGGER) >= 0.5) currentMode = GlobalVars.Modedrive.TURBO;
        else if (gamepadEx1.getTrigger(GamepadKeys.Trigger.LEFT_TRIGGER) >= 0.5) currentMode = GlobalVars.Modedrive.PRECISION;
        else currentMode = GlobalVars.Modedrive.DRIVER_CONTROL;

        double driveScale = (currentMode == GlobalVars.Modedrive.TURBO) ? GlobalVars.TURBO_SCALE
                : (currentMode == GlobalVars.Modedrive.PRECISION) ? GlobalVars.PRECISION_SCALE : GlobalVars.DRIVE_SCALE;

        drive.setDrivePowers(new PoseVelocity2d(
                new Vector2d(
                        gamepadEx1.getLeftY()/driveScale,
                        -gamepadEx1.getLeftX()/driveScale
                ),
                -gamepadEx1.getRightX()/driveScale
        ));
    }

}

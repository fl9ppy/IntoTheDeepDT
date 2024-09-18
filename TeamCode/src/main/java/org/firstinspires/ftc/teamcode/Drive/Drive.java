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
import org.firstinspires.ftc.teamcode.common.hardware.RobotParts;

@TeleOp(name="Drive", group = "Main")

public class Drive extends CommandOpMode {

    private final RobotParts robot = RobotParts.getInstance();

    MecanumDrive drive = new MecanumDrive(hardwareMap, new Pose2d(0, 0, 0));
    GlobalVars.Modedrive currentMode = GlobalVars.Modedrive.DRIVER_CONTROL;

    private GamepadEx p1;
    private GamepadEx p2;

    public void initialize(){
        CommandScheduler.getInstance().reset();

        p1=new GamepadEx(gamepad1);
        p2=new GamepadEx(gamepad2);

    }
    public void run(){
        CommandScheduler.getInstance().run();
        robot.clearBulkCache();
        if (p1.getTrigger(GamepadKeys.Trigger.RIGHT_TRIGGER) >= 0.5) currentMode = GlobalVars.Modedrive.TURBO;
        else if (p1.getTrigger(GamepadKeys.Trigger.LEFT_TRIGGER) >= 0.5) currentMode = GlobalVars.Modedrive.PRECISION;
        else currentMode = GlobalVars.Modedrive.DRIVER_CONTROL;

        double driveScale = (currentMode == GlobalVars.Modedrive.TURBO) ? GlobalVars.TURBO_SCALE
                : (currentMode == GlobalVars.Modedrive.PRECISION) ? GlobalVars.PRECISION_SCALE : GlobalVars.DRIVE_SCALE;

        drive.setDrivePowers(new PoseVelocity2d(
                new Vector2d(
                        -p1.getLeftX()/driveScale,
                        -p1.getLeftY()/driveScale
                ),
                -p1.getRightX()/driveScale
        ));
    }

}


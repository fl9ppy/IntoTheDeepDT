package org.firstinspires.ftc.teamcode.common.commandbase;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.common.subsystems.OuttakeSubsystem;

public class scorePixels extends CommandBase {

    private OuttakeSubsystem outtakeSubsystem;

    public scorePixels(OuttakeSubsystem subsystem ) {
        outtakeSubsystem = subsystem ;
        addRequirements(outtakeSubsystem);

    }

    @Override
    public void initialize(){
        outtakeSubsystem.ScorePos();
    }

    @Override
    public boolean isFinished ()
    {
        return true ;
    }

}

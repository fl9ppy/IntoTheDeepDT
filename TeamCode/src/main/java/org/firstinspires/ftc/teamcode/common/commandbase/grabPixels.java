package org.firstinspires.ftc.teamcode.common.commandbase;


import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.common.subsystems.FourbarSubsystem;

public class grabPixels extends CommandBase {
    private FourbarSubsystem fourbarSubsystem;

    public grabPixels(FourbarSubsystem subsystem){
        fourbarSubsystem = subsystem;
        addRequirements(fourbarSubsystem);
    }
    @Override
    public void initialize(){
        fourbarSubsystem.intake();
    }

    @Override
    public boolean isFinished()
    {
        return true;
    }

}

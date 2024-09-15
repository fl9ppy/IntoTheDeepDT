package org.firstinspires.ftc.teamcode.common.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.ServoImplEx;

public class OuttakeSubsystem extends SubsystemBase {

    private ServoImplEx bratLeft ;
    private ServoImplEx bratRight ;

    public OuttakeSubsystem(HardwareMap hardwareMap) {

         bratLeft = hardwareMap.get(ServoImplEx.class, "bratLeft");
         bratRight = hardwareMap.get(ServoImplEx.class, "bratRight");

    }

    public void InitPos (){
        bratRight.setPosition(0.6);
        bratLeft.setPosition(0.6);

    }

    public void ScorePos (){
        bratRight.setPosition(0.1);
        bratLeft.setPosition(0.1);

    }



}



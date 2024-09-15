package org.firstinspires.ftc.teamcode.common.subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.ServoImplEx;

public class FourbarSubsystem extends SubsystemBase {
    private ServoImplEx fourbarLeft;
    private ServoImplEx fourbarRight;

    public FourbarSubsystem(HardwareMap hardwareMap){
        fourbarLeft= hardwareMap.get(ServoImplEx.class, "fourbarLeft");
        fourbarRight=hardwareMap.get(ServoImplEx.class, "fourbarRight");
    }
    public void intake(){
        fourbarRight.setPosition(0.2);
        fourbarLeft.setPosition(0.2);
    }
    public void transferOutake(){
        fourbarRight.setPosition(0.7);
        fourbarLeft.setPosition(0.7);
    }

}

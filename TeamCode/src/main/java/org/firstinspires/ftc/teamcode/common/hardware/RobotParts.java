package org.firstinspires.ftc.teamcode.common.hardware;

import com.qualcomm.hardware.lynx.LynxModule;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.configuration.LynxConstants;

import java.util.List;


public class RobotParts {

    //Declarations

    public static RobotParts instance = null;
    private boolean enabled;

    public List<LynxModule> modules;
    public LynxModule CONTROL_HUB;

    public static RobotParts getInstance(){
        if (instance ==null) instance = new RobotParts();
        instance.enabled =true;
        return instance;
    }
    public void init(final HardwareMap hardwareMap){

        //HardwareMap

        for (LynxModule m : modules) {
            m.setBulkCachingMode(LynxModule.BulkCachingMode.MANUAL);
            if (m.isParent() && LynxConstants.isEmbeddedSerialNumber(m.getSerialNumber())) CONTROL_HUB = m;
        }
    }

    public void clearBulkCache() {CONTROL_HUB.clearBulkCache();}
    public void kill() {
        instance = null;
    }


}

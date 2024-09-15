package org.firstinspires.ftc.teamcode.common.hardware;

import com.arcrobotics.ftclib.hardware.ServoEx;
import com.qualcomm.hardware.lynx.LynxModule;
import com.qualcomm.hardware.rev.RevColorSensorV3;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.ServoImplEx;
import com.qualcomm.robotcore.hardware.configuration.LynxConstants;

import org.firstinspires.ftc.robotcontroller.external.samples.RobotHardware;
import org.firstinspires.ftc.teamcode.common.subsystems.FourbarSubsystem;
import org.firstinspires.ftc.teamcode.common.subsystems.OuttakeSubsystem;

import java.util.List;


public class RobotParts {
    public DcMotorEx sliderLeft;
    public DcMotorEx sliderRight;

    public ServoImplEx fourbarLeft;
    public ServoImplEx fourbarRight;
    public ServoImplEx bratLeft;
    public ServoImplEx bratRight;
    public ServoImplEx angular;

    public ServoEx droneAngle;
    public ServoEx droneLauncher;
    public ServoEx opritoareSus;
    public ServoEx opritoareJos;

    public RevColorSensorV3 sensor;

    public FourbarSubsystem fourbarSubsystem;
    public OuttakeSubsystem outtakeSubsystem;

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
        sliderLeft = hardwareMap.get(DcMotorEx.class, "sliderLeft");
        sliderRight = hardwareMap.get(DcMotorEx.class, "sliderRight");

        fourbarLeft = hardwareMap.get(ServoImplEx.class, "FourbarLeft");
        fourbarRight = hardwareMap.get(ServoImplEx.class, "FourbarRight");
        bratLeft = hardwareMap.get(ServoImplEx.class, "bratLeft");
        bratRight = hardwareMap.get(ServoImplEx.class, "bratRight");
        angular = hardwareMap.get(ServoImplEx.class, "angular");

        sensor = hardwareMap.get(RevColorSensorV3.class, "sensor");

        modules = hardwareMap.getAll(LynxModule.class);

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

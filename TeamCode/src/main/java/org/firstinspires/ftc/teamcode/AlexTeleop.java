package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name="AlexTeleop", group="Template")
//Disabled
public class AlexTeleop extends OpMode {

    private Anvil robot;

    @Override
    public void init() {
        robot = new Anvil(hardwareMap, Anvil.Drivetrain.MECHANUM, telemetry);
    }
    @Override
    public void loop() {

        if(gamepad2.left_trigger > 0.5){
            robot.servo1.setPosition(0.1);
        }
        if(gamepad2.right_trigger > 0.5){
            robot.servo1.setPosition(1);
        }


        if (gamepad2.atRest()) robot.rest();
    }
}
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
        robot = new Anvil(hardwareMap, Anvil.Drivetrain.TANK, telemetry);
    }
    @Override
    public void loop() {

        double pace = 0.5;

        if(gamepad2.left_trigger>0.5){
            robot.servo1.setPosition(1/25);
        }
        if(gamepad2.right_trigger>0.5){
            robot.servo1.setPosition(25/25);
        }


        if (gamepad1.atRest()) robot.rest();
    }
}
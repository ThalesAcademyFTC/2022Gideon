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


        if (gamepad1.right_trigger>pace){
            robot.moveForward(1);
        }
        if(gamepad1.left_trigger>pace){
            robot.moveBackward(1);
        }
        if(gamepad1.right_bumper){
            robot.turnRight(1);
        }
        if(gamepad1.left_bumper){
            robot.turnLeft(1);
        }



        if (gamepad1.atRest()) robot.rest();
    }
}
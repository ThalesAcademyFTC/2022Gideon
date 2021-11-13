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
            robot.moveForward(pace);
        }
        if(gamepad1.left_trigger>pace){
            robot.moveBackward(pace);
        }
        if(gamepad1.right_bumper){
            robot.turnRight(pace);
        }
        if(gamepad1.left_bumper){
            robot.turnLeft(pace);
        }



        if (gamepad1.atRest()) robot.rest();
        else { if (Math.abs(gamepad1.left_stick_x) > Math.abs(gamepad1.left_stick_y)) {
                robot.turnRight(gamepad1.left_stick_x);
            } else robot.moveBackward(gamepad1.left_stick_y);
        }
    }
}
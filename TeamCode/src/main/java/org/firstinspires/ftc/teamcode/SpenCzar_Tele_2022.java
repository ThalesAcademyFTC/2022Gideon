package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;


@TeleOp(name="SpenCzar", group="Template")
//@Disabled
public class SpenCzar_Tele extends OpMode {

    private Anvil robot;

    @Override
    public void init() {

        //This code initializes the drivetrain. Make sure that you have the right drivetrain selected!
        robot = new Anvil(hardwareMap, Anvil.Drivetrain.TANK, telemetry);
    }

        if (gamepad1.atRest()) robot.rest();

        //MOVEMENT
        if(gamepad1.left_stick_y > 0) {
            robot.moveForward(gamepad1.left_stick_y); }
        else if(gamepad1.left_stick_y < 0) {
            robot.moveBackward(gamepad1.left_stick_y); }
        else if(gamepad1.left_stick_x > 0) {
            robot.turnRight(gamepad1.left_stick_x); }
        else if(gamepad1.left_stick_x < 0) {
            robot.turnLeft(gamepad1.left_stick_x); }

            else {

                //If the gamepad is NOT at rest, then we want to see what we need to do.
//something


                //This is the code used to run the movement for Tank drivetrain.
                if (Math.abs(gamepad1.left_stick_x) > Math.abs(gamepad1.left_stick_y)) {
                    robot.turnRight(gamepad1.left_stick_x);
                } else robot.moveBackward(gamepad1.left_stick_y);
            }
        }
    }}
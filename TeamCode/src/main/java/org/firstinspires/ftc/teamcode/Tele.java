package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name="Tele", group="Template")
@Disabled
public class Tele extends OpMode {

    private Anvil robot;

    @Override
    public void init() {
        robot = new Anvil(hardwareMap, Anvil.Drivetrain.MECHANUM, telemetry);
    }

    @Override
    public void loop() {

        //This nested if statement is used to make the robot move using the left joytsick.
        // It works for every drive train, as long as it is set up in Anvil!


        //In the gap below would normally be where you would create if statements for buttons

        if (gamepad1.x){

        }

        //MOVEMENT
        //First, we want to make the robot rest if the gamepad is not being touched
        if (gamepad1.atRest()) robot.rest();

        else {

            //If the gamepad is NOT at rest, then we want to see what we need to do.


            //This is the code used to run a Mechanum robot.

            // The left stick is used for going any direction.
            //      Example: Pointing the left stick diagonally will make the robot go diagonally
            // The right stick is used for turning

            if (Math.abs(gamepad1.left_stick_x) + Math.abs(gamepad1.left_stick_y) > 1.3) {
                robot.moveDiagonal(gamepad1.left_stick_x, gamepad1.left_stick_y, 1);
            } else if (Math.abs(gamepad1.left_stick_x) > Math.abs(gamepad1.left_stick_y)) {
                robot.moveLeft(gamepad1.left_stick_x);
            } else if (Math.abs(gamepad1.right_stick_x) > Math.abs(gamepad1.right_stick_y)) {
                robot.turnLeft(gamepad1.right_stick_x);
            } else robot.moveForward(gamepad1.left_stick_y);
        }
    }
}
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name="NataliaCode", group="Template")
//@Disabled
public class NataliaCode extends OpMode {

    private Anvil robot;

    @Override
    public void init() {

        //This code initializes the drivetrain. Make sure that you have the right drivetrain selected!
        robot = new Anvil(hardwareMap, Anvil.Drivetrain.TANK, telemetry);
    }

    @Override
    public void loop() {

        //MOVEMENT
        //First, we want to make the robot rest of the gamepad is not being touched
        if (gamepad1.atRest()) robot.rest();

        //If the gamepad is NOT at rest, then we want to see what we need to do.

        //If the top button is being pressed, it moves forward.
        //If the bottom button is being presses, it moves backwards.
        //if the left button is being pressed, then it moves left without turning.
        //If the right button is being presses, then it moves right without turning.
        //If the top and left buttons are being pressed at the same time, then it turns left but counterclockwise still facing forwards.
        //If the top and right buttons are being pressed at the same time, then it turns right but clockwise, still facing forwards.


        double pace = 1;

        //Code for the buttons (idk if its right):
        //top
        if (gamepad1.dpad_up) {
            robot.moveForward(pace);
        }
        //bottom
        if (gamepad1.dpad_down) {
            robot.moveBackward(pace);
        }
        //left
        if (gamepad1.dpad_left) {
            robot.moveLeft(pace);
        }
        //right
        if (gamepad1.dpad_right) {
            robot.moveRight(pace);
        }
        //top and left
        if (gamepad1.dpad_up&&gamepad1.dpad_left) {
            robot.turnLeft(pace);
        }
        //top and right
        if (gamepad1.dpad_up&&gamepad1.dpad_right){
            robot.turnRight(pace);


            }
        }
    }

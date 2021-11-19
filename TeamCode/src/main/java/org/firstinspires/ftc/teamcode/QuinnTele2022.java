package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name="QuinnTele2022", group="Template")
//@Disabled
public class QuinnTele2022 extends OpMode {

    private Anvil robot;

    @Override
    public void init() {

        //This code initializes the drivetrain. Make sure that you have the right drivetrain selected!
        robot = new Anvil(hardwareMap, Anvil.Drivetrain.TANK, telemetry);
    }

    @Override
    public void loop() {

        if(gamepad1.left_stick_y > 0.5) {
            robot.moveForward(gamepad1.left_stick_y);
        }
        else if(gamepad1.left_stick_y < -0.5) {
            robot.moveBackward(gamepad1.left_stick_y);
        }
        else if(gamepad1.left_stick_x > 0.5) {
            robot.turnRight(gamepad1.left_stick_x);
        }
        else if(gamepad1.left_stick_x < -0.5) {
            robot.turnLeft(gamepad1.left_stick_x);
        }
        //This nested if statement is used to make the robot move using the left joystick.
        // It works for every drive train, as long as it is set up in Anvil!


        //MOVEMENT
        //First, we want to make the robot rest if the gamepad is not being touched
        if (gamepad1.atRest()) robot.rest();

        else {

            //If the gamepad is NOT at rest, then we want to see what we need to do.


            //This is the code used to run the movement for Tank drivetrain.
            if (Math.abs(gamepad1.left_stick_x) > Math.abs(gamepad1.left_stick_y)) {
                robot.turnRight(gamepad1.left_stick_x);
            } else robot.moveBackward(gamepad1.left_stick_y);
        }
    }
}
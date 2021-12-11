package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name="Tele", group="Template")
//@Disabled
public class Tele extends OpMode {

    private Anvil robot;

    @Override
    public void init() {

        //This code initializes the drivetrain. Make sure that you have the right drivetrain selected!
        robot = new Anvil(hardwareMap, Anvil.Drivetrain.MECHANUM, telemetry);
    }

    @Override
    public void loop() {
        telemetry.addData("motor1", robot.motor1.getCurrentPosition());
        telemetry.addData("motor2", robot.motor2.getCurrentPosition());
        telemetry.update();
        //This nested if statement is used to make the robot move using the left joystick.
        // It works for every drive train, as long as it is set up in Anvil!


        //In the gap below would normally be where you would create if statements for buttons
        if (gamepad1.x){

        }

        //MOVEMENT
        //First, we want to make the robot rest if the gamepad is not being touched


        //If the gamepad is NOT at rest, then we want to see what we need to do.
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
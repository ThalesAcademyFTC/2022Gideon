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

        //This nested if statement is used to make the robot move using the left joystick.
        // It works for every drive train, as long as it is set up in Anvil!


        //In the gap below would normally be where you would create if statements for buttons


        //MOVEMENT
        //First, we want to make the robot rest if the gamepad is not being touched


        //If the gamepad is NOT at rest, then we want to see what we need to do.
        if (gamepad1.atRest()) robot.rest();

        double pace = 0.5;

        robot.motor2.setPower(1);
        if (gamepad2.right_bumper) ;
        robot.moveForward(pace);
    }



    //This is the code used to run the movement for drivetrain
        }

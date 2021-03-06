package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name="RyanTeleop", group="Template")
@Disabled
public class RyanTeleop extends OpMode {

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

        if (gamepad2.left_bumper) {
            robot.carouselMotor.setPower(-1);
        }
        // when the left bumper is pressed the carousel motor has it's power set to negative 1 which makes it go counter clockwise, and when the left bumper is let go of then the motor stops moving the wheel or whatever we are using to spin the carousel.
        else {
            robot.carouselMotor.setPower(0);
        }


        //MOVEMENT
        //First, we want to make the robot rest if the gamepad is not being touched
        if (gamepad1.atRest()) robot.rest();

        else {

            //If the gamepad is NOT at rest, then we want to see what we need to do.


            //This is the code used to run the movement for Tank drivetrain.
            if (Math.abs(gamepad1.right_stick_x) > Math.abs(gamepad1.left_stick_y)) {

                if (gamepad1.right_stick_x > 0.5) {
                    robot.turnRight(0.5);
                }
                if (gamepad1.right_stick_x < -0.5) {
                    robot.turnLeft(0.5);
                }
                if (gamepad1.right_stick_y > 0.5) {
                    robot.moveForward(0.5);
                }
                if (gamepad1.right_stick_y < -0.5) {
                    robot.moveBackward(0.5);
                }
            }
        }
    }
}



package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.internal.camera.delegating.DelegatingCaptureSequence;

@TeleOp(name="Teleop2022", group="Template")
//@Disabled
public class Teleop2022 extends OpMode {

    private Anvil robot;

    public enum SpeedToggle {
        Normal_Forward,
        Slower_Forward
    }

    SpeedToggle mode = Teleop2022.SpeedToggle.Normal_Forward;

    @Override
    public void init() {

        //This code initializes the drivetrain. Make sure that you have the right drivetrain selected!
        robot = new Anvil(hardwareMap, Anvil.Drivetrain.MECHANUM, telemetry);
    }
    @Override
    public void loop() {

        //MOVEMENT
        //First, we want to make the robot rest if the gamepad is not being touched
        if (gamepad1.atRest() && gamepad2.atRest()) robot.rest();

        //In the gap below would normally be where you would create if statements for buttons
        //move the claw arm up and down
        if (gamepad2.dpad_down) {
            robot.armMotor.setPower(-1);
        } else if (gamepad2.dpad_up) {
            robot.armMotor.setPower(1);
        } else robot.armMotor.setPower(0);

        //spin the carousel
        if (gamepad2.right_bumper) {
            robot.carouselMotor.setPower(0.5);
        } else if (gamepad2.left_bumper) {
            robot.carouselMotor.setPower(-0.5);
        } else robot.carouselMotor.setPower(0);

        //Open and close claw
        if(gamepad2.left_trigger > 0.5){
            robot.servo1.setPosition(0.1);
        } else if(gamepad2.right_trigger > 0.5) {
            robot.servo1.setPosition(1);
        }

        //change from normal to slow speed and vice versa
        if (gamepad1.y) {
            if (mode == Teleop2022.SpeedToggle.Normal_Forward) {
                mode = SpeedToggle.Slower_Forward;
            } else {
                mode = Teleop2022.SpeedToggle.Normal_Forward;
            }
        }

        //rotate left and right

        //move forward, back, left, right
        switch (mode){
            case Normal_Forward:
                if (Math.abs(gamepad1.left_stick_x) + Math.abs(gamepad1.left_stick_y) > 1.5) {
                    robot.moveDiagonal(-gamepad1.left_stick_x, -gamepad1.left_stick_y, 1);
                } else if (Math.abs(gamepad1.left_stick_x) > Math.abs(gamepad1.left_stick_y)) {
                    robot.moveRight(gamepad1.left_stick_x);
                } else if (Math.abs(gamepad1.right_stick_x) > Math.abs(gamepad1.right_stick_y)) {
                    robot.turnRight(gamepad1.right_stick_x);
                } else robot.moveBackward(gamepad1.left_stick_y);

              /*    else if (gamepad1.left_stick_x >= 0.2){
                    robot.moveRight(gamepad1.left_stick_x);
                } else if (gamepad1.left_stick_x < -0.2) {
                    robot.moveLeft(-gamepad1.left_stick_x);
                } else if (gamepad1.left_stick_y >= 0.2){
                   robot.moveForward(gamepad1.left_stick_y);
                } else if (gamepad1.left_stick_y < -0.2) {
                    robot.moveBackward(-gamepad1.left_stick_y);
                } */

            /* case Slower_Forward:
               if (Math.abs(gamepad1.left_stick_x) + Math.abs(gamepad1.left_stick_y) > 1.3) {
                    robot.moveDiagonal(gamepad1.left_stick_x, gamepad1.left_stick_y, 0.5);
                } else if (Math.abs(gamepad1.left_stick_y) >= Math.abs(gamepad1.left_stick_x)) {
                    robot.moveForward(gamepad1.left_stick_y);
                } else  {
                    robot.moveRight(gamepad1.right_stick_x);
                } else  {
                robot.moveLeft(gamepad1.left_stick_y);
                } else if (Math.abs(gamepad1.left_stick_y) <= Math.abs(gamepad1.left_stick_x))) {
                    robot.moveBackward(gamepad1.left_stick_y);

            } */
                 /* else if (gamepad1.left_stick_x >= 0.2){
                    robot.moveRight(gamepad1.left_stick_x/2);
                } else if (gamepad1.left_stick_x < -0.2) {
                    robot.moveLeft(-gamepad1.left_stick_x/2);
                } else if (gamepad1.left_stick_y >= 0.2){
                    robot.moveForward(gamepad1.left_stick_y/2);
                } else if (gamepad1.left_stick_y < -0.2){
                    robot.moveBackward(-gamepad1.left_stick_y / 2);
                } */

                }
            }

        }


package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.robotcore.internal.camera.delegating.DelegatingCaptureSequence;

@TeleOp(name="Teleop2022", group="Template")
//@Disabled
public class Teleop2022 extends OpMode {

    private Anvil robot;
    int speed = 1;
    @Override
    public void init() {

        //This code initializes the drivetrain. Make sure that you have the right drivetrain selected!
        robot = new Anvil(hardwareMap, Anvil.Drivetrain.MECHANUM, telemetry);
    }
    @Override
    public void loop() {

        telemetry.addData("arm", robot.armMotor.getCurrentPosition());
        telemetry.addData("servo", robot.servo1.getPosition());
        telemetry.update();
        //MOVEMENT
        //First, we want to make the robot rest if the gamepad is not being touched
        if (gamepad1.atRest() && gamepad2.atRest()) robot.rest();

        //In the gap below would normally be where you would create if statements for buttons
        //move the claw arm up and down
        if (gamepad2.dpad_down) {
            robot.armMotor.setPower(0.5);
        } else if (gamepad2.dpad_up) {
            robot.armMotor.setPower(-0.6);
        } else robot.armMotor.setPower(0);

        //move arm to set positions
        if (gamepad2.x) {
            robot.servoPrepare();
        }

        //spin the carousel
        if (gamepad2.right_bumper) {
            robot.carouselMotor.setPower(0.2);
        } else if (gamepad2.left_bumper) {
            robot.carouselMotor.setPower(-0.2);
        } else robot.carouselMotor.setPower(0);

        //Open claw while holding right trigger on gamepad2
        if (gamepad2.right_trigger > 0.5) {
            robot.servoClose();
        } else robot.servoOpen();

        //change from normal to slow speed and vice versa
        if (gamepad1.x) {
            speed = 1;
        } else if (gamepad1.a) {
            speed = 2;
        }


        //move forward, back, left, right
                if (Math.abs(gamepad1.left_stick_x) + Math.abs(gamepad1.left_stick_y) > 1.5) {
                    robot.moveDiagonal(-gamepad1.left_stick_x, -gamepad1.left_stick_y, speed);
                } else if (Math.abs(gamepad1.left_stick_x) > Math.abs(gamepad1.left_stick_y)) {
                    robot.moveRight(gamepad1.left_stick_x/speed);
                } else if (Math.abs(gamepad1.right_stick_x) > Math.abs(gamepad1.right_stick_y)) {
                    robot.turnRight(gamepad1.right_stick_x/speed);
                } else robot.moveBackward(gamepad1.left_stick_y/speed);

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
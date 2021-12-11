package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name="Lakelan_Teleop", group="Template")
//@Disabled
public class Lakelan_Teleop extends OpMode {

    private Anvil robot;

    public enum SpeedToggle {
        Normal_Forward,
        Slower_Forward
    }

    SpeedToggle mode = Lakelan_Teleop.SpeedToggle.Normal_Forward;

    @Override
    public void init() {

        //This code initializes the drivetrain. Make sure that you have the right drivetrain selected!
        robot = new Anvil(hardwareMap, Anvil.Drivetrain.MECHANUM, telemetry);
    }
    @Override
    public void loop() {

        //MOVEMENT
        //First, we want to make the robot rest if the gamepad is not being touched
        if (gamepad1.atRest()) robot.rest();

        //In the gap below would normally be where you would create if statements for buttons

        if (gamepad1.y) {
            if (mode == Lakelan_Teleop.SpeedToggle.Normal_Forward) {
                mode = SpeedToggle.Slower_Forward;
            } else {
                mode = Lakelan_Teleop.SpeedToggle.Normal_Forward;
            }
        }

        if (gamepad1.right_stick_x >= 0.2){
            robot.turnRight(gamepad1.right_stick_x);
        } else if (gamepad1.right_stick_x < -0.2) {
            robot.turnLeft(-gamepad1.right_stick_x);
        }

        switch (mode){
            case Normal_Forward:
                if (gamepad1.left_stick_x >= 0.2){
                    robot.moveRight(gamepad1.left_stick_x);
                } else if (gamepad1.left_stick_x < -0.2) {
                    robot.moveLeft(-gamepad1.left_stick_x);
                } else if (gamepad1.left_stick_y >= 0.2){
                    robot.moveForward(gamepad1.left_stick_y);
                } else if (gamepad1.left_stick_y < -0.2){
                    robot.moveBackward(-gamepad1.left_stick_y);
                } else if (gamepad1.left_stick_x > 0.2 && gamepad1.left_stick_y > 0.2) {
                    robot.moveDiagonal(2, 2, 0.5);
                } else if (gamepad1.left_stick_x < - 0.2 && gamepad1.left_stick_y > 0.2) {
                    robot.moveDiagonal(2, 2, 0.5);
                } else if (gamepad1.left_stick_x < - 0.2 && gamepad1.left_stick_y < - 0.2) {
                    robot.moveDiagonal(2, 2, 0.5);
                } else if (gamepad1.left_stick_x > 0.2 && gamepad1.left_stick_y < - 0.2) {
                    robot.moveDiagonal(2, 2, 0.5);
                }
            case Slower_Forward:
                if (gamepad1.left_stick_x >= 0.2){
                    robot.moveRight(gamepad1.left_stick_x/2);
                } else if (gamepad1.left_stick_x < -0.2) {
                    robot.moveLeft(-gamepad1.left_stick_x/2);
                } else if (gamepad1.left_stick_y >= 0.2){
                    robot.moveForward(gamepad1.left_stick_y/2);
                } else if (gamepad1.left_stick_y < -0.2){
                    robot.moveBackward(-gamepad1.left_stick_y/2);
                } else if (gamepad1.left_stick_x > 0.2 && gamepad1.left_stick_y > 0.2) {
                    robot.moveDiagonal(2, 2, 0.5);
                } else if (gamepad1.left_stick_x < - 0.2 && gamepad1.left_stick_y > 0.2) {
                    robot.moveDiagonal(2, 2, 0.5);
                } else if (gamepad1.left_stick_x < - 0.2 && gamepad1.left_stick_y < - 0.2) {
                    robot.moveDiagonal(2, 2, 0.5);
                } else if (gamepad1.left_stick_x > 0.2 && gamepad1.left_stick_y < - 0.2) {
                    robot.moveDiagonal(2, 2, 0.5);
                }
        }

    }
}
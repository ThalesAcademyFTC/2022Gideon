package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name="Lakelan_Left_Stick_Movement", group="Template")
//@Disabled
public class Lakelan_Left_Stick_Movement extends OpMode {

    private Anvil_With_Back_Wheel_Speed robot;

    public enum SpeedToggle {
        Normal_Forward,
        Faster_Forward
    }

    SpeedToggle mode = Lakelan_Left_Stick_Movement.SpeedToggle.Normal_Forward;

    @Override
    public void init() {

        //This code initializes the drivetrain. Make sure that you have the right drivetrain selected!
        robot = new Anvil_With_Back_Wheel_Speed(hardwareMap, Anvil_With_Back_Wheel_Speed.Drivetrain.MECHANUM, telemetry);
    }
    @Override
    public void loop() {

        //MOVEMENT
        //First, we want to make the robot rest if the gamepad is not being touched
        if (gamepad1.atRest()) robot.rest();

        //In the gap below would normally be where you would create if statements for buttons

        if (gamepad1.y) {
            if (mode == Lakelan_Left_Stick_Movement.SpeedToggle.Normal_Forward) {
                mode = SpeedToggle.Faster_Forward;
            } else {
                mode = Lakelan_Left_Stick_Movement.SpeedToggle.Normal_Forward;
            }
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
                } else if (gamepad1.left_stick_x > 0.4 && gamepad1.left_stick_y > 0.4) {
                    robot.moveDiagonal(2, 2, 0.5);
                } else if (gamepad1.left_stick_x < - 0.4 && gamepad1.left_stick_y > 0.4) {
                    robot.moveDiagonal(2, 2, 0.5);
                } else if (gamepad1.left_stick_x < - 0.4 && gamepad1.left_stick_y < - 0.4) {
                    robot.moveDiagonal(2, 2, 0.5);
                } else if (gamepad1.left_stick_x > 0.4 && gamepad1.left_stick_y < - 0.4) {
                    robot.moveDiagonal(2, 2, 0.5);
                }
            case Faster_Forward:
                if (gamepad1.left_stick_x >= 0.2){
                    robot.moveRight(gamepad1.left_stick_x);
                } else if (gamepad1.left_stick_x < -0.2) {
                    robot.moveLeft(-gamepad1.left_stick_x);
                } else if (gamepad1.left_stick_y >= 0.2){
                    robot.moveForwardFaster(gamepad1.left_stick_y);
                } else if (gamepad1.left_stick_y < -0.2){
                    robot.moveBackward(-gamepad1.left_stick_y);
                } else if (gamepad1.left_stick_x > 0.4 && gamepad1.left_stick_y > 0.4) {
                    robot.moveDiagonal(2, 2, 1);
                } else if (gamepad1.left_stick_x < - 0.4 && gamepad1.left_stick_y > 0.4) {
                    robot.moveDiagonal(2, 2, 1);
                } else if (gamepad1.left_stick_x < - 0.4 && gamepad1.left_stick_y < - 0.4) {
                    robot.moveDiagonal(2, 2, 1);
                } else if (gamepad1.left_stick_x > 0.4 && gamepad1.left_stick_y < - 0.4) {
                    robot.moveDiagonal(2, 2, 1);
                }
        }

    }
}
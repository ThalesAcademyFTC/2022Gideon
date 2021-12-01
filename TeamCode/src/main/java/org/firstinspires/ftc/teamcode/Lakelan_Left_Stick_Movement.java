package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name="Lakelan_Tele2022", group="Template")
//@Disabled
public class Lakelan_Left_Stick_Movement extends OpMode {

    private Anvil_With_Back_Wheel_Speed robot;

    public enum SpeedToggle {
        Normal_Forward,
        Faster_Forward
    }

    @Override
    public void init() {

        //This code initializes the drivetrain. Make sure that you have the right drivetrain selected!
        robot = new Anvil(hardwareMap, Anvil.Drivetrain.TANK, telemetry);
    }
    int speed = 1;
    @Override
    public void loop(SpeedToggle) {


        DcMotor motor1, motor2, motor3, motor4;

        //MOVEMENT
        //First, we want to make the robot rest if the gamepad is not being touched
        if (gamepad1.atRest()) robot.rest();

        //In the gap below would normally be where you would create if statements for buttons

        if (gamepad1.y) {
            if (speed == 1) {
                speed = 2;
            } else {
                speed = 1;
            }
        }
        switch (SpeedToggle){
            case Normal_Forward:
                if (gamepad1.left_stick_x >= 0.2){
                    robot.moveRight(gamepad1.left_stick_x);
                } else if (gamepad1.left_stick_x < -0.2) {
                    robot.moveLeft(-gamepad1.left_stick_x);
                }

                if (gamepad1.left_stick_y >= 0.2){
                    robot.moveForward(gamepad1.left_trigger);
                } else if (gamepad1.left_stick_y < -0.2){
                    robot.moveBackward(-gamepad1.left_trigger);
                }
            case Faster_Forward:
                if (gamepad1.left_stick_x >= 0.2){
                    robot.moveRight(gamepad1.left_stick_x);
                } else if (gamepad1.left_stick_x < -0.2) {
                    robot.moveLeft(-gamepad1.left_stick_x);
                }

                if (gamepad1.left_stick_y >= 0.2){
                    robot.moveForwardFaster(gamepad1.left_trigger);
                } else if (gamepad1.left_stick_y < -0.2){
                    robot.moveBackward(-gamepad1.left_trigger);
                }
        }

    }
}
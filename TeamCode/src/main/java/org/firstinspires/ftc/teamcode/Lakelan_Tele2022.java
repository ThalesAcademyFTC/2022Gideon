package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;


@TeleOp(name="Lakelan_Tele2022", group="Template")
//@Disabled
public class Lakelan_Tele2022 extends OpMode {

    private Anvil robot;

    @Override
    public void init() {

        //This code initializes the drivetrain. Make sure that you have the right drivetrain selected!
        robot = new Anvil(hardwareMap, Anvil.Drivetrain.TANK, telemetry);
    }
    int speed = 1;
    @Override
    public void loop() {
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
        if (gamepad1.right_trigger >= 0.5){
            robot.moveForward(gamepad1.right_trigger);
        } else if (gamepad1.right_trigger < 0.5 * speed) {
            robot.moveBackward(gamepad1.right_trigger * 2 * speed);
        }

        if (gamepad1.left_trigger >= 0.5){
            robot.turnLeft(gamepad1.left_trigger * speed);
        } else if (gamepad1.left_trigger < 0.5){
            robot.turnRight(gamepad1.left_trigger * 2 * speed);
        }
    }
}
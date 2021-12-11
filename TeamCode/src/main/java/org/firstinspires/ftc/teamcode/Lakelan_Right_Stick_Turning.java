package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;


@TeleOp(name="Lakelan_Right_Stick_Turning", group="Template")
//@Disabled
public class Lakelan_Right_Stick_Turning extends OpMode {

    private Anvil_With_Back_Wheel_Speed robot;


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

                if (gamepad1.right_stick_x >= 0.2){
                    robot.turnRight(gamepad1.right_stick_x);
                } else if (gamepad1.right_stick_x < -0.2) {
                    robot.turnLeft(-gamepad1.right_stick_x);
                }

    }
}
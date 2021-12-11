package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name="Lakelan_Right_Stick_Turning", group="Template")
//@Disabled
public class Lakelan_Right_Stick_Turing extends OpMode {

    private Anvil_With_Back_Wheel_Speed robot;

    public enum SpeedToggle {
        Normal_Forward,
        Faster_Forward
    }

    @Override
    public void init() {

        //This code initializes the drivetrain. Make sure that you have the right drivetrain selected!
        robot = new Anvil_With_Back_Wheel_Speed(hardwareMap, Anvil_With_Back_Wheel_Speed.Drivetrain.MECHANUM, telemetry);
    }
    int speed = 1;
    @Override
    public void loop(SpeedToggle mode) {

        mode = Lakelan_Right_Stick_Turing.SpeedToggle.Normal_Forward;
        DcMotor motor1, motor2, motor3, motor4;

        //MOVEMENT
        //First, we want to make the robot rest if the gamepad is not being touched
        if (gamepad1.atRest()) robot.rest();

        //In the gap below would normally be where you would create if statements for buttons

                if (gamepad1.left_stick_x >= 0.2){
                    robot.turnRight(gamepad1.left_stick_x);
                } else if (gamepad1.left_stick_x < -0.2) {
                    robot.turnLeft(-gamepad1.left_stick_x);
                }

        }

    }
}
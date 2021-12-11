package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name="EthanClawDown", group="Template")
//Disabled
public class EthanClawDown extends OpMode {

    private Anvil robot;

    @Override
    public void init() {

        //This code initializes the drivetrain. Make sure that you have the right drivetrain selected!
        robot = new Anvil(hardwareMap, Anvil.Drivetrain.TANK, telemetry);
    }

    @Override
    public void loop() {

        //This nested if statement is used to make the robot move using the left joystick.
        // It works for every drive train, as long as it is set up in Anvil!


        //In the gap below would normally be where you would create if statements for buttons

        if (gamepad2.dpad_down) {
            robot.armMotor.setPower(-1);
        } else robot.armMotor.setPower(0);

        if (gamepad1.atRest()) robot.rest();

        else {

            double pace = -0.5;


        }
    }
}
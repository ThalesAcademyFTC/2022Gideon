package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name="EthanTeleop", group="Template")
//Disabled
public class EthanTeleop extends OpMode {

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

        double pace = 0.5;

        if (gamepad1.y>pace){
            robot.moveForward(pace);
        if (gamepad1.a>pace)
            robot.moveBackward(pace);
        if (gamepad1.x>pace)
            robot.moveLeft(pace);
        if (gamepad1.b>pace)
            robot.moveRight(pace);

        }
    }
}
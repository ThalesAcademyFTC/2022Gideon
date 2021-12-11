package org.firstinspires.ftc.teamcode;

import static org.firstinspires.ftc.teamcode.Anvil.Drivetrain.MECHANUM;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;


@Autonomous(name="Auton", group="Template")
@Disabled

public class AlexAuton extends LinearOpMode {
    private Anvil robot;
    private ElapsedTime runtime = new ElapsedTime();
    @Override
    public void runOpMode() {
        robot = new Anvil(hardwareMap, MECHANUM, telemetry);
        telemetry.addData("Status", "Initialized");
        runtime.reset();
        telemetry.update();
        //Code Above the waitForStart() is where you define variables or initialize any Vuforia
        //DO NOT PUT MOVEMENT CODE HERE - YOU WILL BE PENALIZED

        waitForStart(); //Below this point is where you place the linear code for your autonomous.
        //Any code that goes in this space is only run once, and after it is finished the program ends.

        //WITH TURNING

        robot.moveForwardFT(1000,0.5);
        robot.turnRight(0.5);
        robot.moveForwardFT(1000,0.5);
        robot.turnRight(0.5);
        robot.moveForwardFT(1000,0.5);
        robot.turnRight(0.5);

        //WITHOUT TURNING

//      robot.moveForwardFT(1000, 0.5);
//      robot.moveLeftFT(1000);
//      robot.moveBackwardFT(1000, 0.5);
//      robot.moveRightFT(1000);


        while (opModeIsActive() && runtime.milliseconds() < 30000) {


        }


    }
}

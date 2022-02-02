package org.firstinspires.ftc.teamcode;

import static org.firstinspires.ftc.teamcode.Anvil.Drivetrain.MECHANUM;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;


@Autonomous(name="QuinAuton2022", group="Template")
//@Disabled

public class QuinnAuton2022 extends LinearOpMode {
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

        int t = 20;
        int d = 650;
        //d*1 equals 45 degrees, d*2 equals 90 degrees

        robot.moveForwardFT(t*30,0.5);
        sleep(500);

        //the robot moves toward the shipping container
        robot.moveRightFT(t*60);
        sleep(500);
        robot.moveForwardFT(t*45,0.5);
        sleep(500);

        //claw movement and arm movement goes here
        sleep(500);

        //robot turns toward the bars ad moves over them
        robot.moveBackwardFT(t*20,0.5);
        sleep(500);
        robot.turnLeftFT(d*2, 0.5);
        sleep(500);
        robot.moveForwardFT(t*200,1.0);
        sleep(500);

        //arm and claw movement here

        //robot waits for other robot to maybe move out of the way
        sleep(1000);

        //robot turns around and moves over the bars
        robot.turnRightFT(d*4,0.6);
        sleep(500);
        robot.moveForwardFT(t*200,1.0);
        sleep(500);

        //robot turns to the shipping container and moves to the container
        robot.turnLeftFT(d*2,0.5);
        sleep(500);
        robot.moveForwardFT(t*20,0.5);
        sleep(500);

        //more claw and arm movement here
        sleep(500);

        //waits for other robot to move
        sleep(1000);

        //robot turns to the bars nd moves over them
        robot.moveBackwardFT(t*20,0.5);
        sleep(500);
        robot.turnLeftFT(d*2,0.5);
        sleep(500);
        robot.moveForwardFT(t*200,1.0);
        sleep(500);

        //robot stops moving and parks

        //Inside of the while statement below is any code that you want to run in loop during autonomous.
        while (opModeIsActive() && runtime.milliseconds() < 30000) {


        }


    }
}

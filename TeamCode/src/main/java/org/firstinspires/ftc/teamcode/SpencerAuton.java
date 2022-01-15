package org.firstinspires.ftc.teamcode;

import static org.firstinspires.ftc.teamcode.Anvil.Drivetrain.MECHANUM;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name="SpencerAuton", group="Template")

public class SpencerAuton extends LinearOpMode {

    private Anvil robot;
    private ElapsedTime runtime = new ElapsedTime();
    @Override
    public void runOpMode() {
        robot = new Anvil(hardwareMap, MECHANUM, telemetry);
        telemetry.addData("Status", "Initialized");
        runtime.reset();
        telemetry.update();

        int tcm = 20;
        int turn = 750;
        //turn*1 equals 45 degrees, turn*2 equals 90 degrees

        //Code Above the waitForStart() is where you define variables or initialize any Vuforia
        //DO NOT PUT MOVEMENT CODE HERE - YOU WILL BE PENALIZED
        waitForStart(); //Below this point is where you place the linear code for your autonomous.
        //Any code that goes in this space is only run once, and after it is finished the program ends.

        robot.moveForwardFT(tcm*28,0.5);
        //Pik up the rubber ducky here

        robot.moveForwardFT(tcm*48, 0.5);
        robot.turnRightFT(turn*2, 0.5);
        robot.moveForwardFT(tcm*47, 0.5);
        //Throw the rubber ducky onto the platform thingy(carousel)

        robot.moveBackwardFT(tcm*28, 0.5);






}}


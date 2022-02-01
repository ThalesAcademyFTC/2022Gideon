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
        int turn = 1024;
        //turn*1 equals 45 degrees, turn*2 equals 90 degrees

        //Code Above the waitForStart() is where you define variables or initialize any Vuforia
        //DO NOT PUT MOVEMENT CODE HERE - YOU WILL BE PENALIZED
        waitForStart(); //Below this point is where you place the linear code for your autonomous.
        //Any code that goes in this space is only run once, and after it is finished the program ends.

        robot.moveForwardFT(tcm*28,0.5);
        //Pik up the rubber ducky here
        sleep( 1000);
        robot.turnRightFT(turn*1, 1);
        sleep( 1000);
        robot.turnLeftFT(turn*1, 1);
        sleep( 1000);
        robot.turnRightFT(turn*1,1);
        robot.moveLeftFT( tcm*50);

        robot.moveForwardFT(tcm*67, 0.5);
        robot.turnRightFT(turn*2, 0.5);
        robot.moveForwardFT(tcm*60, 1);
        sleep( 1000);
        //Throw the rubber ducky onto the platform thingy(carousel)

        robot.moveBackwardFT(tcm*75, 0.5);
        sleep( 1000);
        robot.moveRightFT(tcm*79);
        sleep( 1000);
        robot.moveForwardFT(tcm*300, 1);
        //end code








}}


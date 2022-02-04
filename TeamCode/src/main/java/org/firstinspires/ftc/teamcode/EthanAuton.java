package org.firstinspires.ftc.teamcode;

import static org.firstinspires.ftc.teamcode.Anvil.Drivetrain.MECHANUM;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;


@Autonomous(name="EthanAuton", group="Template")
@Disabled

public class EthanAuton extends LinearOpMode {
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
        int ticksPerCm = 20;


        //This auton is for the blue corner.
        //The robot scans the duck.
        robot.moveForwardFT(ticksPerCm*28, 0.5);
        sleep(500);

        robot.moveBackwardFT(ticksPerCm*28, 0.5);
        sleep(500);
        robot.moveRightFT(ticksPerCm*49);
        sleep(500);
        robot.carouselMoveBlue(ticksPerCm*50);
        robot.moveForwardFT(ticksPerCm*118, 0.5);
        sleep(500);
        robot.turnLeftFT(1150,0.5);
        sleep(500);
        robot.moveForwardFT(ticksPerCm*46,0.5);
        sleep(500);
        robot.moveArmFT(500,0.5);
        sleep(500);
        robot.moveBackwardFT(ticksPerCm*98, 0.5);
        sleep(500);
        robot.moveLeftFT(ticksPerCm*120);
        sleep(500);

        //Inside of the while statement below is any code that you want to run in loop during autonomous.
        while (opModeIsActive() && runtime.milliseconds() < 30000) {


        }


    }
}

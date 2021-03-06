package org.firstinspires.ftc.teamcode;

import static org.firstinspires.ftc.teamcode.Anvil.Drivetrain.MECHANUM;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;




@Autonomous(name="AutonNatalia", group="Template")
@Disabled

public class AutonNatalia extends LinearOpMode {
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
            robot.moveForwardFT(15, 0.5);
            //scan for duck sensor?
            robot.clawMotor(0.5);
            sleep(500);
            robot.moveLeftFT(1500); //while scanning for duck, until duck is found
            sleep(500);
            robot.moveForwardFT(1600, 0.5);
            sleep(500);
            robot.moveRightFT (1400);
            sleep(500);
            robot.turnRightFT (1300, 0.5);
            sleep(500);
            robot.clawMotor(-0.5);
            sleep(500);
            robot.turnLeftFT (1200, 0.5);
            sleep(500);
            robot.moveLeftFT (1400);
            sleep(500);
            robot.moveBackwardFT(1550,0.5);
            sleep(500);
            robot.carouselMotor.setPower(0.5);
            sleep(500);
            robot.moveForwardFT(300,0.5);
            //robot.wait();

            //robot then has to determine which level to place block, and place it
            //depending on the duck place, that's the level of which to place the block it starts with
            //wait however long maybe til there 5 seconds left and then zoom to the corner hopefully it crosses the barrier
             /* approxamate measures, used for my guessing bc each mat is 2'x2'
            20tick=1cm
            2000 ticks=about 90 degrees maybe more */


        /*for the practice round, not important anymore
        robot.moveForwardFT(1000, 0.5);

        robot.moveRightFT(1000);

        robot.moveBackwardFT(1000, 0.5);

        robot.moveLeftFT(1000);


        Inside of the while statement below is any code that you want to run in loop during autonomous.
        while (opModeIsActive() && runtime.milliseconds() < 30000)*/
    }
}

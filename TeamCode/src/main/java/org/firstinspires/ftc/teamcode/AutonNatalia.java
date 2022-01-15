package org.firstinspires.ftc.teamcode;

import static org.firstinspires.ftc.teamcode.Anvil.Drivetrain.MECHANUM;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;




@Autonomous(name="AutonNatalia", group="Template")
//@Disabled

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


        class loop{};; {
            robot.moveForwardFT(900, 0.5);
            robot.moveRightFT(2280);
            //scan for duck sensor?
            robot.moveRightFT(1200); //while scanning for duck, until duck is found
            robot.moveLeftFT(2280);
            robot.moveForwardFT(2400, 0.5);
            //robot then has to determine which level to place block, and place it
            //depending on the duck place, that's the level of which to place the block it starts with
            robot.moveBackwardFT(2400, 0.5);
            robot.turnLeftFT(800, 0.5);
            robot.moveBackwardFT(2400, 0.5);
            robot.carouselMotor.setPower(1);
            //wait however long maybe til there 5 seconds left and then zoom to the corner hopefully it crosses the barrier
            robot.moveForwardFT(6000, 1);
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
}
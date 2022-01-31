package org.firstinspires.ftc.teamcode;

import static org.firstinspires.ftc.teamcode.Anvil.Drivetrain.MECHANUM;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;


@Autonomous(name="RedBar", group="Template")
//@Disabled

public class RedBar extends LinearOpMode {
    private Anvil robot;
    private ElapsedTime runtime = new ElapsedTime();
    @Override
    public void runOpMode() {
        robot = new Anvil(hardwareMap, MECHANUM, telemetry);
        telemetry.addData("Status", "Initialized");
        runtime.reset();
        telemetry.update();
        int ticksCm = 20;

        //Code Above the waitForStart() is where you define variables or initialize any Vuforia
        //DO NOT PUT MOVEMENT CODE HERE - YOU WILL BE PENALIZED

        waitForStart(); //Below this point is where you place the linear code for your autonomous.
        //Any code that goes in this space is only run once, and after it is finished the program ends.

        robot.moveForwardFT(ticksCm*28, 0.5);
        sleep(200);
        robot.moveLeftFT(ticksCm*53);
        sleep(200);
        robot.moveForwardFT(ticksCm*6, 0.5);

        /*sensor things to tell where to put freight on shipping containers
        if (robot.getRed() == 255 && robot.getGreen() == 255) {
            //duck-related code


            //arm things to put freight on shipping container
            robot.moveArmFT();
            robot.crservo1();
        }
        else //something related to re-scanning
        */


        sleep(200);
        //turn towards back area
        robot.turnRightFT(1280,0.5);
        sleep(200);
        //go over barrier
        robot.moveForwardFT(ticksCm*120, 1);
        sleep(200);
        //turn towards freight
        robot.turnRightFT(650, 0.5);
        sleep(200);

        /*more arm things to pick up freight
        robot.moveArmFT();
        robot.crservo1();
        robot.moveArmFT();
        */

        //turn towards shipping container
        robot.turnRightFT(1720, 0.5);
        sleep(200);
        //move out of back area
        robot.moveForwardFT(ticksCm*120, 1);
        sleep(200);
        //turn all the way toward shipping container
        robot.turnRightFT(1280, 1);
        sleep(200);
        //move toward shipping container to put in freight
        robot.moveForwardFT(ticksCm*28, 0.5);
        sleep(200);

        /*even more arm things to put more freight in the shipping container
        robot.moveArmFT();
        robot.crservo1();
        robot.moveArmFT();
        */

        robot.moveBackwardFT(ticksCm*28, 1);
        sleep(200);
        robot.turnRightFT(1280, 1);
        sleep(200);
        robot.moveForwardFT(ticksCm*130, 1);
        sleep(200);

        //Inside of the while statement below is any code that you want to run in loop during autonomous.
        while (opModeIsActive() && runtime.milliseconds() < 30000) {


        }

    }
}
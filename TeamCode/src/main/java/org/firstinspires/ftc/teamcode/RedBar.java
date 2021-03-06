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

        //grabs the block
        /*
        robot.armBottomRaise();
        robot.servoPrepare();
        robot.armReset();
        sleep(100);
        robot.servoClose();
        robot.moveLeftFT(ticksCm*60);

         */
        robot.moveForwardFT(ticksCm*55, 0.5);
        sleep(200);
        //arm raise to put freight on container
       //robot.armMiddleRaise();
       /* sleep(200);
        robot.moveForwardFT(ticksCm*5, 0.5);
        sleep(200);
        //servo things to let go of freight
        robot.servoPrepare();
        sleep(300);
        robot.moveBackwardFT(ticksCm*5, 0.5);
        sleep(200);
*/
        //turn towards back area
        robot.turnRightFT(1340,0.5);
        sleep(400);
        //go over barrier
        robot.moveForwardFT(ticksCm*160, 0.8);
        sleep(500);
        robot.turnRightFT(400,0.5);
        sleep(200);
        robot.moveForwardFT(3*ticksCm,0.5);




        //turn towards freight
        /*
        robot.turnRightFT(650, 0.5);
        sleep(200);

        //more arm things to pick up freight
        robot.armReset();
        sleep(200);
        robot.servoPrepare();
        sleep(200);
        robot.servoClose();
        sleep(200);
        robot.armMiddleRaise();
        sleep(200);

        //turn towards shipping container
        robot.turnRightFT(1970, 0.5);
        sleep(200);
        //move out of back area
        robot.moveForwardFT(ticksCm*180, 1);
        sleep(200);
        //turn all the way toward shipping container
        robot.turnRightFT(1300, 1);
        sleep(200);
        //move toward shipping container to put in freight
        robot.moveForwardFT(ticksCm*20, 0.5);
        sleep(200);
        
        //even more arm things to put more freight in the shipping container
        robot.servoOpen();
        sleep(200);
        robot.moveBackwardFT(ticksCm*20, 1);
        sleep(200);
        robot.servoClose();

        sleep(200);
        robot.turnRightFT(1300, 1);
        sleep(200);
        robot.moveForwardFT(ticksCm*200, 1);
        sleep(200);
        */
        //Inside of the while statement below is any code that you want to run in loop during autonomous.
        while (opModeIsActive() && runtime.milliseconds() < 30000) {

        }

    }

}
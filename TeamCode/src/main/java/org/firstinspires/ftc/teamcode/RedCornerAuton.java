package org.firstinspires.ftc.teamcode;

import static org.firstinspires.ftc.teamcode.Anvil.Drivetrain.MECHANUM;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;


@Autonomous(name="RedCornerAuton", group="Template")
//@Disabled

public class RedCornerAuton extends LinearOpMode {
    private Anvil robot;
    private ElapsedTime runtime = new ElapsedTime();
    @Override
    public void runOpMode() {
        robot = new Anvil(hardwareMap, MECHANUM, telemetry);
        telemetry.addData("Status", "Initialized");
        runtime.reset();
        telemetry.update();
        int ticksCm = 20;

        double s = 0.5;
        int t = 20;

        robot.moveForwardFT(t*8, 0.5);
        sleep(500);
        robot.moveLeftFT(t*25);
        sleep(500);
        robot.moveLeftFT(t*25);
        sleep(500);
        robot.moveLeftFT(t*25);
        sleep(500);
        robot.moveLeftFT(t*7);
        sleep(500);
        robot.turnLeftFT(650,0.5);
        sleep(500);
        robot.turnRightFT(650,0.5);
        sleep(500);
        robot.moveForwardFT(t*25, 0.5);
        sleep(500);
        robot.moveForwardFT(t*25, 0.5);
        sleep(500);
        robot.moveForwardFT(t*25, 0.5);
        sleep(500);
        robot.moveForwardFT(t*15, 0.5);
        sleep(500);
        robot.turnRightFT(1300,0.5);
        sleep(500);
        robot.moveForwardFT(t*25, 0.5);
        sleep(500);
        robot.moveForwardFT(t*25, 0.5);
        sleep(500);
        robot.moveForwardFT(t*25, 0.5);
        sleep(500);
        robot.moveForwardFT(t*25, 0.5);
        sleep(500);
        robot.moveBackwardFT(t*25,0.5);
        sleep(500);
        robot.moveBackwardFT(t*25,0.5);
        sleep(500);
        robot.moveBackwardFT(t*25,0.5);
        sleep(500);
        robot.moveBackwardFT(t*25,0.5);
        sleep(500);
        robot.moveBackwardFT(t*5,0.5);
        sleep(500);
        robot.moveRightFT(25);
        sleep(500);
        robot.moveRightFT(25);
        sleep(500);
        robot.moveRightFT(10);
        sleep(500);



        while (opModeIsActive() && runtime.milliseconds() < 30000) {
        }
    }
}
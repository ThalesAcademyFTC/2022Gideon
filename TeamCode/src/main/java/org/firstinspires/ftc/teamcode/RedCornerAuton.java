package org.firstinspires.ftc.teamcode;

import static org.firstinspires.ftc.teamcode.Anvil.Drivetrain.MECHANUM;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;


@Autonomous(name="RedCorner", group="Template")
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

        waitForStart();


        robot.armBottomRaise();
        sleep(200);
        robot.servoPrepare();
        sleep(200);
        robot.armReset();
        sleep(200);
        robot.servoClose();
        sleep(300);
        robot.armBottomRaise();

        robot.turnLeftFT(1345,0.5);

        robot.turnRightFT(1345, 0.5);

        robot.moveForwardFT(t*8, 0.5);
        sleep(500);
        robot.moveLeftFT(t*67);
        sleep(500);
        robot.moveBackwardFT(50,0.5);
        robot.carouselMoveRed();
        sleep(200);

        robot.moveForwardFT(t*78, 0.5);
        sleep(500);
        robot.moveForwardFT(t*35,0.5);
        sleep(500);
        robot.turnRightFT(1345,0.5);
        sleep(500);
        robot.moveForwardFT(t*100, 0.5);
        sleep(500);

        robot.armMiddleRaise();
        sleep(500);

        robot.servoPrepare();
        sleep(500);
        robot.moveBackwardFT(t*3,0.5);
        sleep(500);

        robot.armReset();

        robot.moveRightFT(t*25);
        sleep(500);
        robot.moveForwardFT(t*30,0.5);
        sleep(500);
        robot.moveForwardFT(t*170,1);
        sleep(500);


        while (opModeIsActive() && runtime.milliseconds() < 30000) {
        }
    }
}
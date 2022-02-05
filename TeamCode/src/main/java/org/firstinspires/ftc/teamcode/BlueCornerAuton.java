package org.firstinspires.ftc.teamcode;

import static org.firstinspires.ftc.teamcode.Anvil.Drivetrain.MECHANUM;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;


@Autonomous(name="BlueCornerAuton", group="Template")
//Disabled

public class BlueCornerAuton extends LinearOpMode {
    private Anvil robot;
    private ElapsedTime runtime = new ElapsedTime();
    @Override
    public void runOpMode() {
        robot = new Anvil(hardwareMap, MECHANUM, telemetry);
        telemetry.addData("Status", "Initialized");
        runtime.reset();
        telemetry.update();
        waitForStart();

        double s = 0.5;
        int t = 20;

        robot.moveForwardFT(t*8, 0.5);
        sleep(500);
        robot.moveRightFT(t*60);
        sleep(500);
        robot.turnLeftFT(1100,0.5);
        sleep(500);
        robot.moveBackwardFT(t*6,0.5);
        sleep(500);
        robot.moveLeftFT(t*30);
        sleep(200);
        robot.carouselMoveBlue();
        sleep(200);
        robot.moveRightFT(55*t);
        sleep(500);
        robot.moveBackwardFT(t*6,0.5);




        while (opModeIsActive() && runtime.milliseconds() < 30000) {
}
}
}

package org.firstinspires.ftc.teamcode;

import static org.firstinspires.ftc.teamcode.Anvil.Drivetrain.MECHANUM;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;


@Autonomous(name="BackupRedCorner", group="Template")
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

        double s = 0.5;
        int t = 20;

        waitForStart();

        robot.moveForwardFT(t*8, 0.5);
        sleep(500);
        robot.moveLeftFT(t*67);
        sleep(500);
        robot.moveBackwardFT(50,0.5);
        sleep(500);
        robot.carouselMoveRed();
        sleep(200);
        robot.moveForwardFT(t*32, 0.5);

        while (opModeIsActive() && runtime.milliseconds() < 30000) {
        }
    }
}
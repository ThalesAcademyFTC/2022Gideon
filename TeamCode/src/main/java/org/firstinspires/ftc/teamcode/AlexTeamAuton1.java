package org.firstinspires.ftc.teamcode;

import static org.firstinspires.ftc.teamcode.Anvil.Drivetrain.MECHANUM;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;


@Autonomous(name="AlexTeamAuton1", group="Template")
@Disabled

public class AlexTeamAuton1 extends LinearOpMode {
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

        robot.moveForwardFT(t*30, 0.5);
        sleep(500);
        robot.turnLeftFT(5000, 0.25);
        sleep(500);
        robot.moveForwardFT(t*55, 0.5);
        sleep(500);
        robot.turnRightFT(5000,0.25);
        sleep(500);
        robot.moveForwardFT(t*95, 0.5);
        sleep(500);
        robot.turnRightFT(5000, 0.25);
        sleep(500);
        robot.moveForwardFT(t*20, 0.5);
        sleep(500);
        //place
        sleep(500);
        robot.moveBackwardFT(t*20, 0.5);
        sleep(500);



        while (opModeIsActive() && runtime.milliseconds() < 30000) {
}
}
}

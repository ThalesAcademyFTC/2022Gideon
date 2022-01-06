package org.firstinspires.ftc.teamcode;

import static org.firstinspires.ftc.teamcode.Anvil.Drivetrain.MECHANUM;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;


@Autonomous(name="AlexAuton", group="Template")
//@Disabled

public class AlexAuton extends LinearOpMode {
    private Anvil robot;
    private ElapsedTime runtime = new ElapsedTime();
    @Override
    public void runOpMode() {
        robot = new Anvil(hardwareMap, MECHANUM, telemetry);
        telemetry.addData("Status", "Initialized");
        runtime.reset();
        telemetry.update();
        waitForStart();


        //WITH TURNING
//        robot.moveForwardFT(1000,0.5);
//        robot.turnRight(0.5);
//        robot.moveForwardFT(1000,0.5);
//        robot.turnRight(0.5);
//        robot.moveForwardFT(1000,0.5);
//        robot.turnRight(0.5);

//=========================================WITHOUT TURNING========================================\\
//      robot.moveForwardFT(1000, 0.5);
//      robot.moveLeftFT(1000);
//      robot.moveBackwardFT(1000, 0.5);
//      robot.moveRightFT(1000);

        //circle\\

//      robot.moveForwardFT(1000, 0.5);
//      robot.turnLeftFT(1000, 0.25);

robot.moveForwardFT(1000, 0.5);

while (opModeIsActive() && runtime.milliseconds() < 30000) {
}
}
}

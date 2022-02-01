package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name="AlexTeleop", group="Template")
//Disabled
public class AlexTeleop extends OpMode {

    private Anvil robot;

    @Override
    public void init() {
        robot = new Anvil(hardwareMap, Anvil.Drivetrain.MECHANUM, telemetry);
    }
    @Override
    public void loop() {


        if (gamepad2.right_trigger > 0.5) {
            for(int i=0; i<gamepad2.right_trigger; i++) {
                double servoControl[] = {0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.7, 0.8, 0.9, 1.0};
                double x = servoControl[i];
                robot.servo1.setPosition(servoControl[i]);

            }
        } else robot.servo1.setPosition(1);


        if(gamepad2.left_trigger > 0.5){
            while (gamepad2.left_trigger > 0.5) {
                double x = 0.1;
                robot.servo1.setPosition(0.1 + x);
                x += 0.1;
            }

        } else if(gamepad2.right_trigger > 0.5) {
            while (gamepad2.right_trigger > 0.5) {
                double x = 0.8;
                robot.servo1.setPosition(-0.1 + x);
                x += -0.1;
            }
        }


        if (gamepad2.atRest()) robot.rest();
    }
}
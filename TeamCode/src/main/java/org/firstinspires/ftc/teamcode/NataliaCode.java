package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name="NataliaCode", group="Template")
//@Disabled
public class NataliaCode extends OpMode {

    private Anvil robot;

    @Override
    public void init() {

        //This code initializes the drivetrain. Make sure that you have the right drivetrain selected!
                robot = new Anvil(hardwareMap, Anvil.Drivetrain.MECHANUM, telemetry);
    }

    @Override
    public void loop() {
            //this is for the right bumper and the carousel will move clockwise
            double pace = 1;

            if (gamepad2.right_bumper) {
                robot.carouselMotor.setPower(1);
            //if the button isn't being pressed,then the carousel doesn't need to move
            } else{
                robot.carouselMotor.setPower(0);
            }
    }

}
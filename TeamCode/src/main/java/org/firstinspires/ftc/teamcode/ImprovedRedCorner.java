/* Copyright (c) 2019 FIRST. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted (subject to the limitations in the disclaimer below) provided that
 * the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this list
 * of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice, this
 * list of conditions and the following disclaimer in the documentation and/or
 * other materials provided with the distribution.
 *
 * Neither the name of FIRST nor the names of its contributors may be used to endorse or
 * promote products derived from this software without specific prior written permission.
 *
 * NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
 * LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.ClassFactory;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaLocalizer;
import org.firstinspires.ftc.robotcore.external.tfod.Recognition;
import org.firstinspires.ftc.robotcore.external.tfod.TFObjectDetector;

import java.util.List;

import static org.firstinspires.ftc.teamcode.Anvil.Drivetrain.MECHANUM;

/**
 * This 2020-2021 OpMode illustrates the basics of using the TensorFlow Object Detection API to
 * determine the position of the Freight Frenzy game elements.
 *
 * Use Android Studio to Copy this Class, and Paste it into your team's code folder with a new name.
 * Remove or comment out the @Disabled line to add this opmode to the Driver Station OpMode list.
 *
 * IMPORTANT: In order to use this OpMode, you need to obtain your own Vuforia license key as
 * is explained below.
 */
@Autonomous(name = "ImprovedRedCorner", group = "Template")
//@Disabled
public class ImprovedRedCorner extends LinearOpMode {
  /* Note: This sample uses the all-objects Tensor Flow model (FreightFrenzy_BCDM.tflite), which contains
   * the following 4 detectable objects
   *  0: Ball,
   *  1: Cube,
   *  2: Duck,
   *  3: Marker (duck location tape marker)
   *
   *  Two additional model assets are available which only contain a subset of the objects:
   *  FreightFrenzy_BC.tflite  0: Ball,  1: Cube
   *  FreightFrenzy_DM.tflite  0: Duck,  1: Marker
   */
    private static final String TFOD_MODEL_ASSET = "FreightFrenzy_BCDM.tflite";
    private static final String[] LABELS = {
      "Ball",
      "Cube",
      "Duck",
      "Marker"
    };

    /*
     * IMPORTANT: You need to obtain your own license key to use Vuforia. The string below with which
     * 'parameters.vuforiaLicenseKey' is initialized is for illustration only, and will not function.
     * A Vuforia 'Development' license key, can be obtained free of charge from the Vuforia developer
     * web site at https://developer.vuforia.com/license-manager.
     *
     * Vuforia license keys are always 380 characters long, and look as if they contain mostly
     * random data. As an example, here is a example of a fragment of a valid key:
     *      ... yIgIzTqZ4mWjk9wd3cZO9T1axEqzuhxoGlfOOI2dRzKS4T0hQ8kT ...
     * Once you've obtained a license key, copy the string from the Vuforia web site
     * and paste it in to your code on the next line, between the double quotes.
     */
    private static final String VUFORIA_KEY =
            "AX3G6fv/////AAABmZBRkXN1c0tErKrNShdsK6sg6OR84mZ/jXTiTsmSViRiT11DOpbYuleK3MKGoFvmzMm4L65rUWpoz/OEB0TMjSG3OjZ6VzNljtmWWKeKCiXCudemY6bb7b+oiWh488JScjUKSud0XvcQXHD7RB5NOXLQyDYjrCxvreo6mrI+Rc77PLFMtv5QItyJRz57htJ8dnp2o4qNx9J8T4XzObgSmIxOESJ5+pZ/wEkytqXWZ2ZGDUIJ5WXBgAadjmz+ypSkF321D7GYjXu1R03n8hjuJEyuiDnnNaAtwMvlYGeqtjBpCmKRD2SYkLKzboD/KM0geHWj2SoL+NDuvLsw6TfISbcDXFR3qGf5d4Z4fBRhc8sm";

    /**
     * {@link #vuforia} is the variable we will use to store our instance of the Vuforia
     * localization engine.
     */
    private VuforiaLocalizer vuforia;

    /**
     * {@link #tfod} is the variable we will use to store our instance of the TensorFlow Object
     * Detection engine.
     */
    private TFObjectDetector tfod;

    private Anvil robot;
    private ElapsedTime runtime = new ElapsedTime();

    @Override
    public void runOpMode() {
        // The TFObjectDetector uses the camera frames from the VuforiaLocalizer, so we create that
        // first.


        /**
         * Activate TensorFlow Object Detection before we wait for the start command.
         * Do it here so that the Camera Stream window will have the TensorFlow annotations visible.
         **/

        /** Wait for the game to begin */
        robot = new Anvil(hardwareMap, MECHANUM, telemetry);
        runtime.reset();
        telemetry.addData(">", "Press Play to start op mode");
        telemetry.update();
        double markerLocation = 0;
        char level = 2;
        int t = 20;
        waitForStart();

        //Auton goes here
        robot.armBottomRaise();
        sleep(200);
        robot.servoPrepare();
        sleep(200);
        robot.moveRightFT(300);
        robot.moveBackwardFT(50,0.5);
        sleep(400);
        robot.armReset();
        sleep(200);
        robot.servoClose();
        sleep(500);
        robot.armBottomRaise();
        sleep(200);

        //Camera stuff goes here
        /*
        int y = 0;
        while(y<50) {
            if (tfod != null) {
                // getUpdatedRecognitions() will return null if no new information is available since
                // the last time that call was made.
                List<Recognition> updatedRecognitions = tfod.getUpdatedRecognitions();
                if (updatedRecognitions != null) {
                    telemetry.addData("# Object Detected", updatedRecognitions.size());
                    // step through the list of recognitions and display boundary info.
                    int i = 0;
                    for (Recognition recognition : updatedRecognitions) {
                        telemetry.addData(String.format("label (%d)", i), recognition.getLabel());
                        telemetry.addData(String.format("  left,top (%d)", i), "%.03f , %.03f",
                                recognition.getLeft(), recognition.getTop());
                        telemetry.addData(String.format("  right,bottom (%d)", i), "%.03f , %.03f",
                                recognition.getRight(), recognition.getBottom());
                        i++;
                        if (recognition.getLabel() == "Marker") {
                            markerLocation = recognition.getLeft();
                        }
                    }
                    telemetry.update();
                }
            }
            y++;
        }
        double marker3Threshold = 200;
        double marker1Max = 400;

        if (markerLocation >= marker3Threshold){
            level = 2; //May need to swap
        } else if (markerLocation <= marker1Max){ //Value may need to change
            level = 1; //May need to swap
        } else {
            level = 2;
        }
        telemetry.addData("MarkerLocation", markerLocation);
        telemetry.update();
         */

        robot.turnRightFT(1220, 0.5);
        sleep(500);
        robot.moveForwardFT(100, 0.5);
        robot.moveLeftFT(t*79);
        sleep(500);
        robot.moveBackwardFT(40,0.25);
        sleep(200);
        robot.carouselMoveRed();
        sleep(200);
        robot.moveRightFT(90);
        robot.turnRightFT(150, 0.5);
        robot.moveForwardFT(t*100, 0.5);

        robot.turnRightFT(1195,0.5);
        sleep(500);
        robot.moveForwardFT(t*56, 0.5);
        sleep(500);

        robot.armMiddleRaise();

        robot.moveForwardFT(t*10, 0.5);
        sleep(200);
        robot.servoPrepare();
        sleep(500);
        robot.moveBackwardFT(t*10,0.5);
        sleep(500);

        robot.armReset();

        robot.moveRightFT(t*85);
        robot.armBottomRaise();
        robot.moveForwardFT(t*220,1);
        sleep(500);


        if (opModeIsActive()) {
        }
    }

    /**
     * Initialize the Vuforia localization engine.
     */
}

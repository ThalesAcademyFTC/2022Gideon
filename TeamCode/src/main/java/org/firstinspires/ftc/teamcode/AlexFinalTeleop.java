package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name="AlexFinalTeleop", group="Template")
//Disabled
public class AlexFinalTeleop extends OpMode {

private Anvil robot;

@Override
public void init() {
robot = new Anvil(hardwareMap, Anvil.Drivetrain.TANK, telemetry);
}
@Override
public void loop() {

//==========================================================================================\\
//===========================================SPLIT==========================================\\
//==========================================================================================\\

//INTERGERS

double pace = 0.5;
int speed = 1;

//  MOVEMENT

                if (gamepad1.right_stick_y>pace){
                robot.moveForward(1);
}
                if(gamepad1.right_stick_y<-pace){
                robot.moveBackward(1);
}

                if(gamepad1.left_stick_x>pace){
                robot.moveRight(1);
}
                if(gamepad1.left_stick_x<-pace){
                robot.moveLeft(1);
}
//TURNING

                if(gamepad1.right_stick_x>pace){
                robot.turnRight(1);
}
                if(gamepad1.right_stick_x<-pace){
                robot.turnLeft(1);
}
//SPEED CHANGE

                if(gamepad1.y) {
                if (speed == 1) {
                speed = 2;
}
}
                if(gamepad1.y) {
                if (speed == 2) {
                speed = 2;
}
}
                if(gamepad1.a) {
                if (speed == 2) {
                speed = 1;
}
}
                if(gamepad1.a){
                if(speed == 1) {
                speed = 1;
}
}

// SERVO CONTROLLING

                if (gamepad2.left_trigger>0.5){
                robot.servo1.setPosition(1/25);
}
                if (gamepad2.right_trigger>0.5){
                robot.servo1.setPosition(25/25);
}
}
}



//               A
//              AAA
//             AAAAA
//            AAAAAAA
//           AAAA AAAA
//          AAAA   AAAA
//         AAAAAAAAAAAAA
//        AAAAAAAAAAAAAAA
//       AAAA         AAAA
//      AAAA           AAAA
//     AAAA             AAAA
//    AAAA               AAAA
//   AAAA                 AAAA
//  AAAA                   AAAA
// AAAA                     AAAA

// LLLL
// LLLL
// LLLL
// LLLL
// LLLL
// LLLL
// LLLL
// LLLL
// LLLL
// LLLL
// LLLL
// LLLL
// LLLL
// LLLLLLLLLLLLLLLLLLLLLLLLLLLLL
// LLLLLLLLLLLLLLLLLLLLLLLLLLLLL

// EEEEEEEEEEEEEEEEEEEEEEEEEEEEE
// EEEEEEEEEEEEEEEEEEEEEEEEEEEEE
// EEEE
// EEEE
// EEEE
// EEEEEEEEEEEEEE
// EEEEEEEEEEEEEE
// EEEE
// EEEE
// EEEE
// EEEE
// EEEE
// EEEEEEEEEEEEEEEEEEEEEEEEEEEE
// EEEEEEEEEEEEEEEEEEEEEEEEEEEE


// XXXX                            XXXX
//   XXXX                        XXXX
//     XXXX                    XXXX
//       XXXX                XXXX
//         XXXX            XXXX
//           XXXX        XXXX
//             XXXXX  XXXXX
//               XXXXXXXX
//             XXXXX  XXXXX
//           XXXX        XXXX
//         XXXX            XXXX
//       XXXX                XXXX
//     XXXX                    XXXX
//   XXXX                        XXXX
// XXXX                            XXXX


//               A
//              AAA
//             AAAAA
//            AAAAAAA
//           AAAA AAAA
//          AAAA   AAAA
//         AAAAAAAAAAAAA
//        AAAAAAAAAAAAAAA
//       AAAA         AAAA
//      AAAA           AAAA
//     AAAA             AAAA
//    AAAA               AAAA
//   AAAA                 AAAA
//  AAAA                   AAAA
// AAAA                     AAAA


// NNNNNNNNN                NNNN
// NNNN NNNNN               NNNN
// NNNN  NNNNN              NNNN
// NNNN   NNNNN             NNNN
// NNNN    NNNNN            NNNN
// NNNN     NNNNN           NNNN
// NNNN      NNNNN          NNNN
// NNNN       NNNNN         NNNN
// NNNN        NNNNN        NNNN
// NNNN         NNNNN       NNNN
// NNNN          NNNNN      NNNN
// NNNN           NNNNN     NNNN
// NNNN            NNNNN    NNNN
// NNNN             NNNNN   NNNN
// NNNN              NNNNN  NNNN
// NNNN               NNNNN NNNN
// NNNN                NNNNNNNNN
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.ColorSensor;


import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Anvil {
    //Define servo and motor variables
    public DcMotor motor1, motor2, motor3, motor4;
    public CRServo crservo1;
    public Servo servo1;
    public DcMotor carouselMotor, armMotor;
    public ColorSensor sensorColor;
    //Reference to mapped servo/motor controller
    private HardwareMap hwMap;

    public Telemetry telemetry;

    public DcMotor[] forward, front, right, left, special, unique;
    private int ticks;
    public int cm;


    public void clawMotor(double pace) {
    }

    public enum Drivetrain {
        HOLONOMIC,
        MECHANUM,
        TANK,
        WEST_COAST,
        OMNIDRIVE,
    }

    public Anvil(HardwareMap ahwMap, Drivetrain type, Telemetry telem) {
        hwMap = ahwMap;

        telemetry = telem;

        //Each of these cases are for different drive trains, the setup for each drive train is within.
        switch (type) {
            /*Example drive train:
            case TRAIN_NAME: //Make sure TRAIN_NAME is in the types enum!
                //Map all motors to proper variables.
                motor1 = hwMap.dcMotor.get("motor1");
                motor2 = hwMap.dcMotor.get("motor2");
                //Set motor directions. These should all be set so that power 1 for all
                //motors == robot moves forwards.
                motor1.setDirection(DcMotor.Direction.REVERSE);
                motor2.setDirection(DcMotor.Direction.FORWARD);
                //Set motor purposes for maneuvers. Motors in 'right' are the motors which must
                //move in reverse for the robot to turn right, and the same applies for left.
                //'forward' should contain all motors.
                forward = new DcMotor[]{motor1, motor2};
                right = new DcMotor[]{motor1};
                left = new DcMotor[]{motor2};
                //There is also a "special" motor array which is used for any additional
                //nonsense you want to do with the robot. Right now, it's just used for
                //holonomic and mechanum special movements.
                break;
             */
            case OMNIDRIVE:
                //Weird drive train, only two wheels move for the robot to go forward. Will need to
                // consider this when programming the robot to move.
                motor1 = hwMap.dcMotor.get("motor1");
                motor2 = hwMap.dcMotor.get("motor2");
                motor3 = hwMap.dcMotor.get("motor3");
                motor4 = hwMap.dcMotor.get("motor4");
                motor1.setDirection(DcMotor.Direction.FORWARD);
                motor2.setDirection(DcMotor.Direction.REVERSE);
                motor3.setDirection(DcMotor.Direction.FORWARD);
                motor3.setDirection(DcMotor.Direction.REVERSE);
                forward = new DcMotor[]{motor1, motor2, motor3, motor4};
                right = new DcMotor[]{motor1, motor3};
                left = new DcMotor[]{motor2, motor4};
                break;
            case HOLONOMIC:
                //Assign motors
                carouselMotor = hwMap.dcMotor.get("carouselMotor");
                motor1 = hwMap.dcMotor.get("motor1");
                motor2 = hwMap.dcMotor.get("motor2");
                motor3 = hwMap.dcMotor.get("motor3");
                motor4 = hwMap.dcMotor.get("motor4");
                //Set motor directions;
                motor1.setDirection(DcMotor.Direction.FORWARD);
                motor2.setDirection(DcMotor.Direction.REVERSE);
                motor3.setDirection(DcMotor.Direction.FORWARD);
                motor4.setDirection(DcMotor.Direction.REVERSE);
                //Set motor purposes
                forward = new DcMotor[]{motor1, motor2, motor3, motor4, carouselMotor};
                right = new DcMotor[]{motor2, motor4};
                left = new DcMotor[]{motor1, motor3};
                special = new DcMotor[]{motor1, motor4};
                unique = new DcMotor[]{motor2, motor3};
                break;
            case TANK:
                motor1 = hwMap.dcMotor.get("motor1");
                motor2 = hwMap.dcMotor.get("motor2");
                motor1.setDirection(DcMotor.Direction.FORWARD);
                motor2.setDirection(DcMotor.Direction.REVERSE);
                forward = new DcMotor[]{motor1, motor2};
                right = new DcMotor[]{motor1};
                left = new DcMotor[]{motor2};
                break;
            case WEST_COAST:
                motor1 = hwMap.dcMotor.get("motor1");
                motor2 = hwMap.dcMotor.get("motor2");
                motor3 = hwMap.dcMotor.get("motor3");
                motor4 = hwMap.dcMotor.get("motor4");
                motor1.setDirection(DcMotor.Direction.REVERSE);
                motor2.setDirection(DcMotor.Direction.FORWARD);
                motor3.setDirection(DcMotor.Direction.REVERSE);
                motor4.setDirection(DcMotor.Direction.REVERSE);
                forward = new DcMotor[]{motor1, motor2, motor3, motor4};
                right = new DcMotor[]{motor1, motor4};
                left = new DcMotor[]{motor2, motor3};
                break;
            case MECHANUM:
                //Map all motors to proper variables.
                motor1 = hwMap.dcMotor.get("motor1");
                motor2 = hwMap.dcMotor.get("motor2");
                motor3 = hwMap.dcMotor.get("motor3");
                motor4 = hwMap.dcMotor.get("motor4");
                armMotor = hwMap.dcMotor.get("armMotor");
                carouselMotor = hwMap.dcMotor.get("carouselMotor");
                servo1 = hwMap.servo.get("servo1");
               // sensorColor = hwMap.get(com.qualcomm.robotcore.hardware.ColorSensor.class, "sensorColorDistance");
                motor1.setDirection(DcMotor.Direction.REVERSE);
                motor2.setDirection(DcMotor.Direction.FORWARD);
                motor3.setDirection(DcMotor.Direction.REVERSE);
                motor4.setDirection(DcMotor.Direction.FORWARD);
                forward = new DcMotor[]{motor1, motor2, motor3, motor4};
                left = new DcMotor[]{motor1, motor3};
                right = new DcMotor[]{motor2, motor4};
                special = new DcMotor[]{motor2, motor3};
                unique = new DcMotor[]{motor1, motor4};
                front = new DcMotor[]{motor1, motor2};
                break;
            default:
                telemetry.addLine("Invalid type " + type + " passed to Anvil's init function. Nothing has been set up.");
                break;
        }
        if (forward != null) {
            for (DcMotor x : forward) {
                x.setPower(0);
                x.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            }
        }
    }

    //Movement, turning, and resting methods for the all current drive trains
    public void moveForward(double pace) {
        for (DcMotor x : forward) x.setPower(pace);
    }

    public void turnRight(double pace) {
        for (DcMotor x : right) x.setPower(-pace);
        for (DcMotor x : left) x.setPower(pace);
    }

    public void turnLeft(double pace) {
        for (DcMotor x : left) x.setPower(-pace);
        for (DcMotor x : right) x.setPower(pace);
    }

    public void moveBackward(double pace) {
        for (DcMotor x : forward)
            x.setPower(-pace);
    }

    public void rest() {
        for (DcMotor x : forward) {
            x.setPower(0);
        }
    }

    public void moveDiagonal(double pacex, double pacey, double speed) {
        double pace = (Math.abs(pacex) + Math.abs(pacey)) / 2;
        for (DcMotor x : special) x.setPower((Math.round(pacex + pacey) * pace)/speed);
        for (DcMotor x : unique) x.setPower((Math.round(pacey - pacex) * pace)/speed);
    }

    public void moveRight(double pace) {
        for (DcMotor x : unique) x.setPower(pace);
        for (DcMotor x : special) x.setPower(-pace);
    }

    public void moveLeft(double pace) {
        for (DcMotor x : unique) x.setPower(-pace);
        for (DcMotor x : special) x.setPower(pace);
    }

    public void armMove(double pace) {
        for (DcMotor x : forward)
            x.setPower(-pace);
    }

    //The functions below are used in autonomous for precise movements.
    //They use ticks to move, which is a unit of wheel rotation

    public double getRed(){
        return sensorColor.red();
    }

    public double getBlue(){
        return sensorColor.blue();
    }

    public double getGreen(){
        return sensorColor.green();
    }

    public double getAlpha(){
        return sensorColor.alpha();
    }

    public boolean ntarget(int ticks, DcMotor x){ // This method just a way to simplify the math of the following functions.
        if (x.getCurrentPosition() > ticks + 25 || x.getCurrentPosition() < ticks - 25) return true;
        else return false;
    }

    public void ticksPerCm(int ticks) {
        cm = ticks*20;
    }
    //Not Finished

    public void turnRightFT(int ticks, double speed) {
        this.rest();
        front[0].setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        front[0].setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        this.turnRight(speed);
        while (ntarget(ticks, front[0])) {
            continue;
        }
        for (DcMotor x : forward) {
            x.setPower(0);
            x.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        }
    }
    public void turnLeftFT(int ticks, double speed) {
        this.rest();
        front[0].setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        front[0].setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        this.turnLeft(speed);
        while (ntarget(-ticks, front[0])) {
            continue;
        }
        for (DcMotor x : forward) {
            x.setPower(0);
            x.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        }
    }
    public void moveRightFT(int ticks) {
        this.ticks = ticks;
        //Blocks until the robot has gotten to the desired location.
        this.rest();
        front[0].setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        front[0].setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        this.moveRight(0.5);
        while (ntarget(ticks, unique[0])) {
            continue;
        }
        for (DcMotor x : forward) {
            x.setPower(0);
            x.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        }
    }
    public void moveLeftFT(int ticks) {
        this.ticks = ticks;
        //Blocks until the robot has gotten to the desired location.
        this.rest();
        front[0].setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        front[0].setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        this.moveLeft(0.5);
        while (ntarget(-ticks, front[0])) {
            continue;
        }
        for (DcMotor x : forward) {
            x.setPower(0);
            x.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        }
    }
    public void moveForwardFT(int ticks, double speed) {
        //Blocks until the robot has gotten to the desired location.
        this.rest();

        front[0].setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        front[0].setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        this.moveForward(speed);
        while (ntarget(ticks, front[0])) {
            continue;
        }
        for (DcMotor x : forward) {
            x.setPower(0);
            x.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        }
    }
    public void moveBackwardFT(int ticks, double speed) {
        //Blocks until the robot has gotten to the desired location.
        this.rest();
        front[0].setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        front[0].setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        this.moveBackward(speed);
        while (ntarget(-ticks, front[0])) {
            continue;
        }
        for (DcMotor x : forward) {
            x.setPower(0);
            x.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        }
    }
    public void moveArmFT(int ticks, double speed) {
        this.rest();
        for (DcMotor x : front) {
        x.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        x.setTargetPosition(ticks);
        x.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }
        this.moveForward(speed);
        while (ntarget(ticks, front[0])) {
         continue;
        }
        for (DcMotor x : forward) {
            x.setPower(0);
            x.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        }
    }

}
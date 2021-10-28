package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.rev.RevColorSensorV3;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.matrices.OpenGLMatrix;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackable;
import org.firstinspires.ftc.robotcore.external.navigation.VuforiaTrackableDefaultListener;

public class Anvil {
    //Define servo and motor variables
    public DcMotor motor1, motor2, motor3, motor4, tmotor, fmotor1, fmotor2;
    DigitalChannel touchyBlock, touchSensor;
    ColorSensor sensorColor;
    DistanceSensor sensorDistance;
    public CRServo crservo1;
    public Servo servo1, rservo1, rservo2, skyServo, armServo;
    public DcMotor clawMotor, armMotor;
    public OpenGLMatrix lastLocation = null;
    int[] positions = {650, 4600, 5200};
    int target = positions[0];

    //Reference to mapped servo/motor controller
    private HardwareMap hwMap;

    public Telemetry telemetry;

    public DcMotor[] forward, front, right, left, special, unique, collect;

    private double ticksPerInch = 15.26;

    public boolean hs = true;

    public void moveForwardFT(int i) {
    }

    public enum Drivetrain {
        HOLONOMIC,
        MECHANUM,
        UNNAMED,
        TANK,
        WEST_COAST,
        OMNIDRIVE,
        EVAN,
        SAM,
        KARL
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
            case UNNAMED:
                motor1 = hwMap.dcMotor.get("motor1");
                motor2 = hwMap.dcMotor.get("motor2");
                motor3 = hwMap.dcMotor.get("motor3");
                motor4 = hwMap.dcMotor.get("motor4");
                fmotor1 = hwMap.dcMotor.get("fmotor1");
                fmotor2 = hwMap.dcMotor.get("fmotor2");
                armMotor = hwMap.dcMotor.get("armMotor");
                tmotor = hwMap.dcMotor.get("tmotor");
                armMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                armMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
                armServo = hwMap.servo.get("armServo");
                rservo1 = hwMap.servo.get("rservo1");
                rservo2 = hwMap.servo.get("rservo2");
                sensorColor = hwMap.get(ColorSensor.class, "colorDistanceSensor");
                sensorDistance = hwMap.get(DistanceSensor.class, "colorDistanceSensor");
                motor1.setDirection(DcMotor.Direction.REVERSE);
                motor2.setDirection(DcMotor.Direction.FORWARD);
                motor3.setDirection(DcMotor.Direction.FORWARD);
                motor4.setDirection(DcMotor.Direction.FORWARD);
                forward = new DcMotor[]{motor1, motor2, motor3, motor4};
                front = new DcMotor[]{motor1, motor2};
                right = new DcMotor[]{motor2, motor4};
                left = new DcMotor[]{motor1, motor3};
                special = new DcMotor[]{motor1, motor4};
                unique = new DcMotor[]{motor2, motor3};
                break;
            case KARL:
                motor1 = hwMap.dcMotor.get("motor1");
                motor2 = hwMap.dcMotor.get("motor2");
                servo1 = hwMap.servo.get("servo1");
                touchSensor = hwMap.get(DigitalChannel.class, "touchSensor");
                touchSensor.setMode(DigitalChannel.Mode.INPUT);
                motor1.setDirection(DcMotor.Direction.FORWARD);
                motor2.setDirection(DcMotor.Direction.REVERSE);
                forward = new DcMotor[]{motor1, motor2};
                right = new DcMotor[]{motor1};
                left = new DcMotor[]{motor2};
                break;
            case OMNIDRIVE:
                //Weird drive train, only two wheels move for the robot to go forward. Will need to
                // consider this when programming the robot to move.
                motor1 = hwMap.dcMotor.get("motor1");
                motor2 = hwMap.dcMotor.get("motor2");
                motor3 = hwMap.dcMotor.get("motor3");
                motor4 = hwMap.dcMotor.get("motor4");
                clawMotor = hwMap.dcMotor.get("clawMotor");
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
                clawMotor = hwMap.dcMotor.get("clawMotor");
                motor1 = hwMap.dcMotor.get("motor1");
                motor2 = hwMap.dcMotor.get("motor2");
                motor3 = hwMap.dcMotor.get("motor3");
                motor4 = hwMap.dcMotor.get("motor4");
                //Set motor directions
                motor1.setDirection(DcMotor.Direction.FORWARD);
                motor2.setDirection(DcMotor.Direction.REVERSE);
                motor3.setDirection(DcMotor.Direction.FORWARD);
                motor4.setDirection(DcMotor.Direction.REVERSE);
                //Set motor purposes
                forward = new DcMotor[]{motor1, motor2, motor3, motor4};
                right = new DcMotor[]{motor2, motor4};
                left = new DcMotor[]{motor1, motor3};
                special = new DcMotor[]{motor1, motor4};
                unique = new DcMotor[]{motor2, motor3};
                hs = false;
                break;
            case TANK:
                motor1 = hwMap.dcMotor.get("motor1");
                motor2 = hwMap.dcMotor.get("motor2");
                motor1.setDirection(DcMotor.Direction.FORWARD);
                motor2.setDirection(DcMotor.Direction.FORWARD);
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
            case EVAN:
                //Map all motors to proper variables.
                motor1 = hwMap.dcMotor.get("motor1");
                motor2 = hwMap.dcMotor.get("motor2");
                motor3 = hwMap.dcMotor.get("motor3");
                motor4 = hwMap.dcMotor.get("motor4");
                armMotor = hwMap.dcMotor.get("armMotor");
                rservo1 = hwMap.servo.get("rservo1");
                rservo2 = hwMap.servo.get("rservo2");
                skyServo = hwMap.servo.get("skyServo");
                touchyBlock = hwMap.get(DigitalChannel.class, "touchyBlock");
                touchyBlock.setMode(DigitalChannel.Mode.INPUT);
                sensorColor = hwMap.get(com.qualcomm.robotcore.hardware.ColorSensor.class, "sensorColorDistance");
                servo1 = hwMap.servo.get("servo1");
                motor1.setDirection(DcMotor.Direction.FORWARD);
                motor2.setDirection(DcMotor.Direction.REVERSE);
                motor3.setDirection(DcMotor.Direction.FORWARD);
                motor4.setDirection(DcMotor.Direction.REVERSE);
                armMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
                armMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
                forward = new DcMotor[]{motor1, motor2, motor3, motor4};
                left = new DcMotor[]{motor1, motor3};
                right = new DcMotor[]{motor2, motor4};
                special = new DcMotor[]{motor2, motor3};
                unique = new DcMotor[]{motor1, motor4};
                hs = false;
                break;
            case SAM:
                motor1 = hwMap.dcMotor.get("motor1");
                motor2 = hwMap.dcMotor.get("motor2");
                motor3 = hwMap.dcMotor.get("motor3");
                motor4 = hwMap.dcMotor.get("motor4");
                servo1 = hwMap.servo.get("servo1");
                motor1.setDirection(DcMotor.Direction.FORWARD);
                motor2.setDirection(DcMotor.Direction.REVERSE);
                motor3.setDirection(DcMotor.Direction.FORWARD);
                motor4.setDirection(DcMotor.Direction.FORWARD);
                forward = new DcMotor[]{motor1, motor2, motor3, motor4};
                left = new DcMotor[]{motor3, motor1};
                right = new DcMotor[]{motor4, motor2};
                special = new DcMotor[]{motor1, motor4};
                unique = new DcMotor[]{motor2, motor3};
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


    public void initCustom(HardwareMap ahwMap, Telemetry telem, DcMotor[] rightI, DcMotor[] leftI, DcMotor[] forwardI, DcMotor.Direction[] orderedDirections) {
        //Allows initialization of custom drive trains not in list programatically.
        telemetry = telem;
        hwMap = ahwMap;
        right = rightI;
        left = leftI;
        forward = forwardI;
        for (int x = 0; x < forward.length; x++) {
            forward[x].setDirection(orderedDirections[x]);
        }
    }

    //Movement, turning, and resting methods for the all current drive trains
    public void moveForward(double pace) {
        for (DcMotor x : forward) x.setPower(pace);
    }

    public void turnRight(double pace) {
        if (hs) {
            for (DcMotor x : right) x.setPower(-pace / 2);
            for (DcMotor x : left) x.setPower(pace / 2);
        } else {
            for (DcMotor x : right) x.setPower(-pace);
            for (DcMotor x : left) x.setPower(pace);
        }
    }

    public void turnLeft(double pace) {
        if (hs) {
            for (DcMotor x : left) x.setPower(-pace / 2);
            for (DcMotor x : right) x.setPower(pace / 2);
        } else {
            for (DcMotor x : left) x.setPower(-pace);
            for (DcMotor x : right) x.setPower(pace);
        }
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

    //Experimental function to turn while moving forward. Increases Maneuverability of robot.
    //ctx = controller x
    public void diff(double ctx, double pace) {
        for (DcMotor x : left) x.setPower(pace - (ctx * 2));
        for (DcMotor x : right) x.setPower(pace + (ctx * 2));
    }

    public void eDia(double pacex, double pacey) {
        double pace = (Math.abs(pacex) + Math.abs(pacey)) / 2;
        if (pacex < 0 && pacey < 0) { //Forward left
            for (DcMotor x : special) x.setPower(-pace);
            for (DcMotor x : unique) x.setPower(0);
        }
        if (pacex > 0 && pacey < 0) { //Forward right
            for (DcMotor x : special) x.setPower(0);
            for (DcMotor x : unique) x.setPower(-pace);
        }
        if (pacex < 0 && pacey > 0) { //Back left
            for (DcMotor x : special) x.setPower(0);
            for (DcMotor x : unique) x.setPower(pace);
        }
        if (pacex > 0 && pacey > 0) { //Back right
            for (DcMotor x : special) x.setPower(pace);
            for (DcMotor x : unique) x.setPower(0);
        }
    }

    public void moveDiagonal(double pacex, double pacey, double speed) {
        double pace = (Math.abs(pacex) + Math.abs(pacey)) / 2;
        for (DcMotor x : special) x.setPower((Math.round(pacex + pacey) * pace) / speed);
        for (DcMotor x : unique) x.setPower((Math.round(pacey - pacex) * pace) / speed);
    }

    //Holonomic specific movements
    public void holoMoveRight(double pace) {
        for (DcMotor x : unique) x.setPower(pace);
        for (DcMotor x : special) x.setPower(-pace);
    }

    public void holoMoveLeft(double pace) {
        for (DcMotor x : unique) x.setPower(-pace);
        for (DcMotor x : special) x.setPower(pace);
    }
    public void moveRight(double pace){
        for (DcMotor x : unique) x.setPower(-pace);
        for (DcMotor x : special) x.setPower(pace);
    }
    public void moveLeft(double pace) {
        for (DcMotor x : unique) x.setPower(pace);
        for (DcMotor x : special) x.setPower(-pace);
    }
    public void collectForTicks(int ticks, Telemetry telemetry) {
        for (DcMotor x : collect) {
            x.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            x.setTargetPosition(ticks);
            x.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        }
        this.collect(0.2);
        while (collect[0].getCurrentPosition() > -ticks - 5 && collect[0].getCurrentPosition() < -ticks + 5) {
            telemetry.addData("cencoder1", collect[0].getCurrentPosition());
            telemetry.update();
        }
        for (DcMotor x : collect) {
            x.setPower(0);
            x.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        }
    }

    public boolean touchyStatus() {
        return !touchyBlock.getState();
    }

    public void armMotorEMove(int t) {
        armMotor.setTargetPosition(t);
        armMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        armMotor.setPower(1);
        while (armMotor.getCurrentPosition() < t - 25 || armMotor.getCurrentPosition() > t + 25) {
            continue;
        }
        armMotor.setPower(0);
        armMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }

    public void armUpSpecial() {
        moveForward(0);
        if (touchyStatus()) {
            armMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            target = positions[0];
            armMotorEMove(target);
        } else if (target == positions[0]) {
            target = positions[1];
            armMotorEMove(target);
        } else if (target == positions[1]) {
            target = positions[2];
            armMotorEMove(target);
        }
    }

    public void armDownSpecial(Gamepad x) {
        moveForward(0);
        if (target == positions[0]) {
            clawMove(0);
            while (!touchyStatus()) {
                armMotor.setPower(-0.5);
                if (x.right_bumper) break;
            }
            clawMove(0.23);
        } else if (target == positions[1]) {
            target = positions[0];
            armMotorEMove(target);
        } else if (target == positions[2]) {
            target = positions[1];
            armMotorEMove(target);
        }
    }

    public void downOverride(Gamepad x) {
        moveForward(0);
        clawMove(0);
        while (!touchyStatus()) {
            armMotor.setPower(-1);
            if (x.right_bumper) break;
        }
        clawMove(0.23);
    }

    public void moveFastForTicks(int ticks) {
        //Blocks until the robot has gotten to the desired location.
        this.rest();
        for (DcMotor x : forward) {
            x.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            x.setTargetPosition(-ticks);
            x.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        }
        this.moveForward(0.9);
        while (forward[0].isBusy()) {
            continue;
        }
        for (DcMotor x : forward) {
            x.setPower(0);
            x.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        }
    }

    public void moveRServo(double x) {
        rservo1.setPosition(x);
        rservo2.setPosition(1 - x);
    }

    public void skyMove(double pos) {
        skyServo.setPosition(pos);
    }

    public void moveForTicksBadly(int ticks) {
        //Blocks until the robot has gotten to the desired location.
        this.rest();
        for (DcMotor x : forward) {
            x.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            x.setTargetPosition(-ticks);
            x.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        }
        this.moveForward(0.25);
        while (forward[0].isBusy()) {
            continue;
        }
        for (DcMotor x : forward) {
            x.setPower(0);
            x.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        }
    }

    public void clawMove(double pos) {
        servo1.setPosition(pos);
    }

    public void collect(double pow) {
        for (DcMotor x : collect) x.setPower(pow);
    }

    private void sleep(long milliseconds) {
        //Ripped right from the FTC OpMode specifications
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

  /*  public void moveX(float ox, float x) {
        this.moveByInches((int) ((ox - x) * 25.4));
    }

    public void moveY(float oy, float y) {
        this.moveByInches((int) ((oy - y) * 25.4));
    }

*/
    public double getX(VuforiaTrackable trackable) {
        if (((VuforiaTrackableDefaultListener) trackable.getListener()).isVisible()) {
            OpenGLMatrix robotLocationTransform = ((VuforiaTrackableDefaultListener) trackable.getListener()).getUpdatedRobotLocation();
            if (robotLocationTransform != null) {
                lastLocation = robotLocationTransform;
            }
        }
        if (lastLocation != null) {
            return lastLocation.getTranslation().get(0);
        } else {
            return 1000;
        }
    }

    public double getY(VuforiaTrackable trackable) {
        if (((VuforiaTrackableDefaultListener) trackable.getListener()).isVisible()) {
            OpenGLMatrix robotLocationTransform = ((VuforiaTrackableDefaultListener) trackable.getListener()).getUpdatedRobotLocation();
            if (robotLocationTransform != null) {
                lastLocation = robotLocationTransform;
            }
        }
        if (lastLocation != null) {
            return lastLocation.getTranslation().get(1);
        } else {
            return 1000;
        }
    }
    public boolean ntarget(int ticks, DcMotor x){
        if (x.getCurrentPosition() > ticks + 25 || x.getCurrentPosition() < ticks - 25) return true;
        else return false;
    }
    public void turnRightFT(int ticks, double speed) {
        this.rest();
        front[0].setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        front[0].setTargetPosition(ticks);
        front[0].setMode(DcMotor.RunMode.RUN_TO_POSITION);

        front[1].setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        front[1].setTargetPosition(-ticks);
        front[1].setMode(DcMotor.RunMode.RUN_TO_POSITION);

        this.turnRight(speed);
        while (ntarget(ticks, forward[0]) || ntarget(-ticks, forward[1])) {
            continue;
        }
        for (DcMotor x : forward) {
            x.setPower(0);
            x.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        }
    }
    public void turnLeftFT(int ticks, double speed) {
        this.rest();
        front[1].setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        front[1].setTargetPosition(ticks);
        front[1].setMode(DcMotor.RunMode.RUN_TO_POSITION);

        front[0].setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        front[0].setTargetPosition(-ticks);
        front[0].setMode(DcMotor.RunMode.RUN_TO_POSITION);

        this.turnLeft(speed);
        while (ntarget(-ticks, forward[0]) || ntarget(ticks, forward[1])) {
            continue;
        }
        for (DcMotor x : forward) {
            x.setPower(0);
            x.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        }
    }
    public void moveRightFT(int ticks) {
        //Blocks until the robot has gotten to the desired location.
        this.rest();
            front[1].setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            front[1].setTargetPosition(-ticks);
            front[1].setMode(DcMotor.RunMode.RUN_TO_POSITION);

            front[0].setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            front[0].setTargetPosition(ticks);
            front[0].setMode(DcMotor.RunMode.RUN_TO_POSITION);
        this.moveRight(0.3);
        while (ntarget(ticks, front[0]) || ntarget(-ticks, front[1])) {
            continue;
        }
        for (DcMotor x : forward) {
            x.setPower(0);
            x.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        }
    }
    public void moveLeftFT(int ticks) {
        //Blocks until the robot has gotten to the desired location.
        this.rest();
        front[0].setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        front[0].setTargetPosition(-ticks);
        front[0].setMode(DcMotor.RunMode.RUN_TO_POSITION);

        front[1].setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        front[1].setTargetPosition(ticks);
        front[1].setMode(DcMotor.RunMode.RUN_TO_POSITION);
        this.moveLeft(0.3);
        while (ntarget(-ticks, front[0]) || ntarget(ticks, front[1])) {
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
        for (DcMotor x : front) {
            x.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            x.setTargetPosition(ticks);
            x.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        }
        this.moveForward(speed);
        while (ntarget(ticks, front[0]) || ntarget(ticks, front[1])) {
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
        for (DcMotor x : front) {
            x.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            x.setTargetPosition(-ticks);
            x.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        }
        this.moveBackward(speed);
        while (ntarget(-ticks, front[0]) || ntarget(-ticks, front[1])) {
            continue;
        }
        for (DcMotor x : forward) {
            x.setPower(0);
            x.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        }
    }
    public void armMotorUp(){
        armMotor.setPower(1);
    }
    public void armMotorDown(){
        armMotor.setPower(-1);
    }
    public void liftClaw(){
        armServo.setPosition(0.1);
    }
    public void lowerClaw(){
        armServo.setPosition(0.75);
    }
   // public void fireRing() {cmotor1.setPower(1);}
   // public void collectRing(){cmotor1.setPower(-1);}

    public void highramp(){
        rservo1.setPosition(0.6);
        rservo2.setPosition(0.6);
    }
    public void loadRamp(){
        rservo1.setPosition(0.4);
        rservo2.setPosition(0.4);
    }
    public void halframp(){
        rservo1.setPosition(0);
        rservo2.setPosition(1);

    }
}
package org.firstinspires.ftc.teamcode.teleOp;

import static com.qualcomm.robotcore.hardware.DcMotor.ZeroPowerBehavior.BRAKE;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp
public class grabDriveCode2022 extends LinearOpMode {
    @Override
    public void runOpMode() {
        DcMotor motorFrontLeft = hardwareMap.dcMotor.get("motorFrontLeft"); // input 3
        DcMotor motorBackLeft = hardwareMap.dcMotor.get("motorBackLeft");  // input 2
        DcMotor motorFrontRight = hardwareMap.dcMotor.get("motorFrontRight"); // input 1
        DcMotor motorBackRight = hardwareMap.dcMotor.get("motorBackRight"); // input 0

        DcMotor motorLift = hardwareMap.dcMotor.get("motorLift"); // ex hub input 0
        Servo servoGrabber = hardwareMap.servo.get("servoGrabber"); //servo 5

        motorBackLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        motorFrontLeft.setDirection(DcMotorSimple.Direction.REVERSE);

        motorFrontLeft.setZeroPowerBehavior(BRAKE);
        motorFrontRight.setZeroPowerBehavior(BRAKE);
        motorBackLeft.setZeroPowerBehavior(BRAKE);
        motorBackRight.setZeroPowerBehavior(BRAKE);
        motorLift.setZeroPowerBehavior(BRAKE);
        //set motors to zero while not in use(stops robot from moving while joystick isn't pressed)
        waitForStart();

        if (isStopRequested()) return;

        while (opModeIsActive()) {

/*
            double leftForwardPower = gamepad1.left_trigger;
            double rightForwardPower = gamepad1.right_trigger;
            double driveForwardPower = -gamepad1.left_stick_y;
            double turnPower = gamepad1.right_stick_x;


            if (gamepad1.left_stick_y > 0 || gamepad1.left_stick_y < 0) {
                motorFrontRight.setPower(driveForwardPower);
                motorBackRight.setPower(driveForwardPower);
                motorFrontLeft.setPower(driveForwardPower);
                motorBackRight.setPower(driveForwardPower);
            }

            if (gamepad1.right_stick_x > 0 || gamepad1.right_stick_x < 0) {
                motorFrontLeft.setPower(turnPower);
                motorBackLeft.setPower(turnPower);
                motorFrontRight.setPower(turnPower);
                motorBackRight.setPower(turnPower);
            }


            if (gamepad1.right_trigger > 0) {
                motorFrontLeft.setPower(rightForwardPower);
                motorBackLeft.setPower(-rightForwardPower);
                motorFrontRight.setPower(-rightForwardPower);
                motorBackRight.setPower(rightForwardPower);
            }

            if (gamepad1.left_trigger > 0) {
                motorFrontLeft.setPower(-leftForwardPower);
                motorBackLeft.setPower(leftForwardPower);
                motorFrontRight.setPower(leftForwardPower);
                motorBackRight.setPower(-leftForwardPower);
            }

             */


            double y = -gamepad1.left_stick_y; // Remember, this is reversed!
            double x = gamepad1.left_stick_x * 1.1;
            double rx = gamepad1.right_stick_x;

            double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1);
            double frontLeftPower = (y + x + rx) / denominator;
            double backLeftPower = (y - x + rx) / denominator;
            double frontRightPower = (y - x - rx) / denominator;
            double backRightPower = (y + x - rx) / denominator;

            motorFrontLeft.setPower(frontLeftPower);
            motorBackLeft.setPower(backLeftPower);
            motorFrontRight.setPower(frontRightPower);
            motorBackRight.setPower(backRightPower);


       /*     double r = Math.hypot(gamepad1.left_stick_x * -1, gamepad1.left_stick_y);
            double robotAngle = Math.atan2(gamepad1.left_stick_y, gamepad1.left_stick_x * -1) - Math.PI / 4;
            double rightX = gamepad1.right_stick_x * -1;

            double lFront = r * Math.cos(robotAngle) + rightX;
            double rFront = r * Math.sin(robotAngle) - rightX;
            double lRear = r * Math.sin(robotAngle) + rightX;
            double rRear = r * Math.cos(robotAngle) - rightX;
            motorFrontLeft.setPower(lFront);
            motorFrontRight.setPower(rFront);
            motorBackLeft.setPower(lRear);
            motorBackRight.setPower(rRear);
            //drive code */

         /*   // Turn functionality with the gamepad triggers
            double strafe_left_power = gamepad1.left_trigger;
            double strafe_right_power = gamepad1.right_trigger;

            if (gamepad1.left_trigger > 0) {
                motorFrontLeft.setPower(strafe_left_power);
                motorFrontRight.setPower(-strafe_left_power);
                motorBackLeft.setPower(-strafe_left_power);
                motorBackRight.setPower(strafe_left_power);
            }
            if (gamepad1.right_trigger > 0) {
                motorFrontLeft.setPower(-strafe_right_power);
                motorFrontRight.setPower(strafe_right_power);
                motorBackLeft.setPower(strafe_right_power);
                motorBackRight.setPower(-strafe_right_power);
                }*/
            double motorPower = gamepad2.left_stick_y;
            if (gamepad2.left_stick_y > 0.1 || gamepad2.left_stick_y < -0.1) {
                motorLift.setPower(motorPower);
            }
            else {
                motorLift.setPower(0);
            }

            // if gamepad.y is false set the servo power to 0
            if (gamepad2.b) {
                servoGrabber.setPosition(0);
            } else if (gamepad2.x) {
                servoGrabber.setPosition(0.7);
            }
            // lift and drive code


        }
    }
}


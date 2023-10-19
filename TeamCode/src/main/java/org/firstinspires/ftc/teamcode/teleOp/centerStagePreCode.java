package org.firstinspires.ftc.teamcode.teleOp;

import static com.qualcomm.robotcore.hardware.DcMotor.ZeroPowerBehavior.BRAKE;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp
public class centerStagePreCode extends LinearOpMode {
    @Override
    public void runOpMode() {
        DcMotor motorFrontLeft = hardwareMap.dcMotor.get("motorFrontLeft"); // input 3
        DcMotor motorBackLeft = hardwareMap.dcMotor.get("motorBackLeft");  // input 2
        DcMotor motorFrontRight = hardwareMap.dcMotor.get("motorFrontRight"); // input 1
        DcMotor motorBackRight = hardwareMap.dcMotor.get("motorBackRight"); // input 0

        DcMotor motorLift = hardwareMap.dcMotor.get("motorLift"); // ex hub input 0

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
        }
    }
}
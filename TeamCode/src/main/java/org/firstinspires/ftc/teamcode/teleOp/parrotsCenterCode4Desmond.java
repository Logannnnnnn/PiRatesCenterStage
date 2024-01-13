package org.firstinspires.ftc.teamcode.teleOp;

import static com.qualcomm.robotcore.hardware.DcMotor.ZeroPowerBehavior.BRAKE;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp
public class parrotsCenterCode4Desmond extends LinearOpMode {
    @Override
    public void runOpMode() {
        DcMotor motorFrontLeft = hardwareMap.dcMotor.get("motorFrontLeft"); // input 3
        DcMotor motorBackLeft = hardwareMap.dcMotor.get("motorBackLeft");  // input 2
        DcMotor motorFrontRight = hardwareMap.dcMotor.get("motorFrontRight"); // input 1
        DcMotor motorBackRight = hardwareMap.dcMotor.get("motorBackRight"); // input 0

        DcMotor motorMount = hardwareMap.dcMotor.get("motorMount");
        DcMotor motorArmLift = hardwareMap.dcMotor.get("motorArmLift");
        DcMotor motorArmExtender = hardwareMap.dcMotor.get("motorArmExtender");
        DcMotor motorDroneShooter = hardwareMap.dcMotor.get("motorDroneShooter");


        motorBackRight.setDirection(DcMotorSimple.Direction.REVERSE);
        motorFrontRight.setDirection(DcMotorSimple.Direction.REVERSE);

        Servo servoArmClaw = hardwareMap.servo.get("servoArmClaw"); // servo 0
        Servo servoArmTilt = hardwareMap.servo.get("servoArmTilt"); // servo 5

        motorFrontLeft.setZeroPowerBehavior(BRAKE);
        motorFrontRight.setZeroPowerBehavior(BRAKE);
        motorBackLeft.setZeroPowerBehavior(BRAKE);
        motorBackRight.setZeroPowerBehavior(BRAKE);

        motorMount.setZeroPowerBehavior(BRAKE);
        motorArmLift.setZeroPowerBehavior(BRAKE);
        motorArmExtender.setZeroPowerBehavior(BRAKE);
        motorDroneShooter.setZeroPowerBehavior(BRAKE);

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

            double mountPower = gamepad2.right_stick_y;
            if (gamepad2.right_stick_y > 0.1 || gamepad2.right_stick_y < -0.1) {
                motorMount.setPower(mountPower);
            } else {
                motorMount.setPower(0);
            }


            double motorPower = gamepad2.left_stick_y;
            if (gamepad2.left_stick_y > 0.1 || gamepad2.left_stick_y < -0.1) {
                motorArmLift.setPower(motorPower);
            } else {
                motorArmLift.setPower(0);
            }

            if (gamepad2.y) {
                motorDroneShooter.setPower(-1);
            } else {
                motorDroneShooter.setPower(0);
            }


            double extenderPowerOut = (gamepad2.right_trigger);
            if (gamepad2.right_trigger > 0.01) {
                motorArmExtender.setPower(extenderPowerOut);
            } else {
                motorArmExtender.setPower(0);
            }
            double extenderPowerIn = (gamepad2.left_trigger);
            if (gamepad2.left_trigger > 0.01) {
                motorArmExtender.setPower(extenderPowerIn);
            } else {
                motorArmExtender.setPower(0);
            }

            if (gamepad2.dpad_up) {
                while (gamepad2.dpad_up) {
                    double position = servoArmTilt.getPosition();
                    servoArmTilt.setPosition(position + 0.05);
                }
            } else {
                servoArmTilt.setPosition(0);
            }
            if (gamepad2.dpad_down) {
                while (gamepad2.dpad_down) {
                    double position = servoArmTilt.getPosition();
                    servoArmTilt.setPosition(position - 0.05);
                }
            } else {
                servoArmTilt.setPosition(0.5);
            }

            if (gamepad2.x) {
                servoArmClaw.setPosition(0.4);
            } else if (gamepad2.b) {
                servoArmClaw.setPosition(0.6);
            }
        }
    }
}

package org.firstinspires.ftc.teamcode.auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;


@Autonomous
public class autoCodeOne extends LinearOpMode {

    private final ElapsedTime runtime = new ElapsedTime();

    @Override
    public void runOpMode() {
        DcMotor motorFrontLeft = hardwareMap.dcMotor.get("motorFrontLeft"); // input 3
        DcMotor motorBackLeft = hardwareMap.dcMotor.get("motorBackLeft");  // input 2
        DcMotor motorFrontRight = hardwareMap.dcMotor.get("motorFrontRight"); // input 1
        DcMotor motorBackRight = hardwareMap.dcMotor.get("motorBackRight"); // input 0

        // ex hub input 0
        Servo servoGrabber = hardwareMap.servo.get("servoGrabber"); //servo 0

        motorBackLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        motorFrontLeft.setDirection(DcMotorSimple.Direction.REVERSE);


        telemetry.addData("Status", "Initialized");
        telemetry.update();

        // Wait for the game to start (driver presses PLAY)
        waitForStart();
        // run until the end of the match (driver presses STOP)

       /* runtime.reset();
        while (opModeIsActive() && (runtime.milliseconds() <= 800)) {
            telemetry.addData("Status", "Running");
            telemetry.update();

            servoGrabber.setPosition(0);

            telemetry.addData("Stage 1", runtime.seconds());
            telemetry.update();
        }
        sleep(1200);
        runtime.reset();
        while (opModeIsActive() && (runtime.milliseconds() <= 100)) {
            telemetry.addData("Status", "Running");
            telemetry.update();

            motorLift.setPower(0.2);

            telemetry.addData("Stage 2", runtime.seconds());
            telemetry.update();
        }
        sleep(100);
        runtime.reset();
        while (opModeIsActive() && (runtime.milliseconds() <= 5)) {
            telemetry.addData("Status", "Running");
            telemetry.update();

            motorFrontLeft.setPower(0.8);
            motorBackLeft.setPower(0.8);
            motorFrontRight.setPower(0.8);
            motorBackRight.setPower(0.8);

            telemetry.addData("Stage 3", runtime.seconds());
            telemetry.update();
        }
        sleep(20);
        runtime.reset();
        while (opModeIsActive() && (runtime.milliseconds() <= 1200)) {
            telemetry.addData("Status", "Running");
            telemetry.update();

            motorFrontLeft.setPower(0);
            motorBackLeft.setPower(0);
            motorFrontRight.setPower(0);
            motorBackRight.setPower(0);

            telemetry.addData("Stage 4", runtime.seconds());
            telemetry.update();
        }
        sleep(1000);
        runtime.reset();
        while (opModeIsActive() && (runtime.milliseconds() <= 300)) {
            telemetry.addData("Status", "Running");
            telemetry.update();

            motorFrontLeft.setPower(-0.8);
            motorBackLeft.setPower(0.8);
            motorFrontRight.setPower(0.8);
            motorBackRight.setPower(-0.8);

            telemetry.addData("Stage 5", runtime.seconds());
            telemetry.update();
        }
        sleep(1750); */
        runtime.reset();
        while (opModeIsActive() && (runtime.milliseconds() <= 200)) {
            telemetry.addData("Status", "Running");
            telemetry.update();

            motorFrontLeft.setPower(-0.8);
            motorBackLeft.setPower(-0.8);
            motorFrontRight.setPower(-0.8);
            motorBackRight.setPower(-0.8);

            telemetry.addData("Stage 6", runtime.seconds());
            telemetry.update();
        }
        sleep(300);
        while (opModeIsActive() && (runtime.milliseconds() <= 300)) {
            telemetry.addData("Status", "Running");
            telemetry.update();

            servoGrabber.setPosition(0);

            telemetry.addData("Stage 7", runtime.seconds());
            telemetry.update();
        }

    }
}

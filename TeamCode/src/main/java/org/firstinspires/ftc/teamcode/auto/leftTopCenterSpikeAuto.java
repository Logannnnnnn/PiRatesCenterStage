package org.firstinspires.ftc.teamcode.auto;


import static com.qualcomm.robotcore.hardware.DcMotor.ZeroPowerBehavior.BRAKE;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous
public class leftTopCenterSpikeAuto extends LinearOpMode {
    @Override
    public void runOpMode() {
        DcMotor motorFrontLeft = hardwareMap.dcMotor.get("motorFrontLeft"); // input 3
        DcMotor motorBackLeft = hardwareMap.dcMotor.get("motorBackLeft");  // input 2
        DcMotor motorFrontRight = hardwareMap.dcMotor.get("motorFrontRight"); // input 1
        DcMotor motorBackRight = hardwareMap.dcMotor.get("motorBackRight"); // input 0


        DcMotor motorArmLift = hardwareMap.dcMotor.get("motorArmLift");
        DcMotor motorArmExtender = hardwareMap.dcMotor.get("motorArmExtender");

        motorBackRight.setDirection(DcMotorSimple.Direction.REVERSE);
        motorFrontRight.setDirection(DcMotorSimple.Direction.REVERSE);


        Servo servoArmClaw = hardwareMap.servo.get("servoArmClaw"); // servo 0
        //Servo servoArmTilt = hardwareMap.servo.get("servoArmTilt"); // servo 5


        motorFrontLeft.setZeroPowerBehavior(BRAKE);
        motorFrontRight.setZeroPowerBehavior(BRAKE);
        motorBackLeft.setZeroPowerBehavior(BRAKE);
        motorBackRight.setZeroPowerBehavior(BRAKE);


        motorArmLift.setZeroPowerBehavior(BRAKE);
        motorArmExtender.setZeroPowerBehavior(BRAKE);


        waitForStart();

        motorArmLift.setPower(0.1);
        sleep(100);
        motorArmLift.setZeroPowerBehavior(BRAKE);
        motorFrontLeft.setPower(0.5);
        motorFrontRight.setPower(0.5);
        motorBackLeft.setPower(0.5);
        motorBackRight.setPower(0.5);
        sleep(500);
        motorFrontLeft.setZeroPowerBehavior(BRAKE);
        motorFrontRight.setZeroPowerBehavior(BRAKE);
        motorBackLeft.setZeroPowerBehavior(BRAKE);
        motorBackRight.setZeroPowerBehavior(BRAKE);
        motorArmLift.setPower(-0.1);
        sleep(100);
        motorArmLift.setZeroPowerBehavior(BRAKE);
        servoArmClaw.setPosition(0.6);
        sleep(1000);
        motorArmLift.setPower(0.1);
        sleep(100);
        motorArmLift.setZeroPowerBehavior(BRAKE);
        motorFrontLeft.setPower(-0.5);
        motorFrontRight.setPower(0.5);
        motorBackLeft.setPower(-0.5);
        motorBackRight.setPower(0.5);
        sleep(250);
        motorFrontLeft.setZeroPowerBehavior(BRAKE);
        motorFrontRight.setZeroPowerBehavior(BRAKE);
        motorBackLeft.setZeroPowerBehavior(BRAKE);
        motorBackRight.setZeroPowerBehavior(BRAKE);
        sleep(250);
        motorFrontRight.setPower(0.5);
        motorBackRight.setPower(0.5);
        motorBackLeft.setPower(0.5);
        motorFrontLeft.setPower(0.5);
        sleep(500);
        motorFrontLeft.setZeroPowerBehavior(BRAKE);
        motorFrontRight.setZeroPowerBehavior(BRAKE);
        motorBackLeft.setZeroPowerBehavior(BRAKE);
        motorBackRight.setZeroPowerBehavior(BRAKE);

    }
}

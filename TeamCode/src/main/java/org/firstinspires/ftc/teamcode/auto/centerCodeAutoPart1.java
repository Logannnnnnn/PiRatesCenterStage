package org.firstinspires.ftc.teamcode.auto;

import static com.qualcomm.robotcore.hardware.DcMotor.ZeroPowerBehavior.BRAKE;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;


@Autonomous
public class centerCodeAutoPart1 extends LinearOpMode {

    private final ElapsedTime runtime = new ElapsedTime();

    @Override
    public void runOpMode() {

        DcMotor motorFrontRight = hardwareMap.dcMotor.get("motorFrontRight"); // input 0
        DcMotor motorBackRight = hardwareMap.dcMotor.get("motorBackRight"); // input 1
        DcMotor motorFrontLeft = hardwareMap.dcMotor.get("motorFrontLeft"); // input 2
        DcMotor motorBackLeft = hardwareMap.dcMotor.get("motorBackLeft");  // input 3

        DcMotor motorArmExtender = hardwareMap.dcMotor.get("motorArmExtender"); // Ex 0
        DcMotor motorMount = hardwareMap.dcMotor.get("motorMount"); // Ex 1
        DcMotor motorDroneShooter = hardwareMap.dcMotor.get("motorDroneShooter"); // Ex2

        Servo servoArmClaw = hardwareMap.servo.get("servoArmClaw"); // servo 0
        Servo servoArmVertical = hardwareMap.servo.get("servoArmVertical"); // servo 1
        //Servo servoDroneShooter = hardwareMap.servo.get("ServoDroneShooter"); // servo 2
        //Servo servoRobotMount = hardwareMap.servo.get("servoRobotMount"); // servo 3

        DistanceSensor distanceSensor = hardwareMap.get(DistanceSensor.class, "distanceSensor");

        motorBackLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        motorFrontLeft.setDirection(DcMotorSimple.Direction.REVERSE);

        motorFrontLeft.setZeroPowerBehavior(BRAKE);
        motorFrontRight.setZeroPowerBehavior(BRAKE);
        motorBackLeft.setZeroPowerBehavior(BRAKE);
        motorBackRight.setZeroPowerBehavior(BRAKE);

        motorArmExtender.setZeroPowerBehavior(BRAKE);
        motorMount.setZeroPowerBehavior(BRAKE);
        motorDroneShooter.setZeroPowerBehavior(BRAKE);

        telemetry.addData("Status", "Initialized");
        telemetry.update();

        waitForStart();

        double curDistance = distanceSensor.getDistance(DistanceUnit.INCH);
        while (opModeIsActive() && !isStopRequested() && curDistance > 12) {


        }


    }
}
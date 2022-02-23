// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import java.nio.Buffer;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class LEDSubsystem extends SubsystemBase {

  public AddressableLED led;
  public AddressableLEDBuffer lBuffer;

  /** Creates a new LEDSubsystem. */
  public LEDSubsystem() {
    led = new AddressableLED(0);
    lBuffer = new AddressableLEDBuffer(120);

    led.setLength(lBuffer.getLength());
    led.start();
  }

  public void setColorBulb(int index, int red, int green, int blue){
    lBuffer.setRGB(index, red, green, blue);
  }

  public void setColor(int red, int green, int blue, int red2, int green2, int blue2, int patternNum){
    int block = 0;
    for(int i = 0; i<lBuffer.getLength(); i++){
      if(i%patternNum == 0){
        block++;
      }

      if(block%2 == 1){
        setColorBulb(i, red, green, blue);
        setBufferToLED();
      }
      else{
        setColorBulb(i, red2, green2, blue2);
        setBufferToLED();
      } 
    }

    // for(int i = 0; i<lBuffer.getLength(); i++){
    //   setColorBulb(i, red, green, blue);
    //   setBufferToLED();
    // }
  }

  public void setBufferToLED(){
    led.setData(lBuffer);
  }

  public void setData(){
    led.setData(lBuffer);
  }

  public void stop(){
    led.stop();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}

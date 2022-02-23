// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.LEDSubsystem;

public class SetMVColorLED extends CommandBase {
  /** Creates a new SetMVColorLED. */
  LEDSubsystem mvLED;
  int patternLength;
  public Supplier<Boolean> getButton;

  public SetMVColorLED(LEDSubsystem mvLED, Supplier<Boolean> getButton) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.mvLED = mvLED;
    patternLength = 5;
    this.getButton = getButton;
  }

  public void mvColors(){
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    //mvColors();
    mvLED.setColor(Constants.purpleR, Constants.purpleG, Constants.purpleB, 
      Constants.goldR, Constants.goldG, Constants.goldB, patternLength);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    mvLED.setColor(Constants.purpleR, Constants.purpleG, Constants.purpleB, 
      Constants.goldR, Constants.goldG, Constants.goldB, patternLength);

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    mvLED.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return getButton.get();
  }
}

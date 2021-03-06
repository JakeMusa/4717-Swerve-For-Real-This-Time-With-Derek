// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.autos;


import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.SwerveSubSystem;

public class DriveOffLine extends CommandBase {
  private SwerveSubSystem swerveSub; 
  
  private boolean finish = false; 
  Timer timer; 


  /** Creates a new DriveOffLine. */
  public DriveOffLine(SwerveSubSystem s) {
      swerveSub = s; 
    addRequirements(swerveSub);
   
    
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    timer = new Timer(); 
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    timer.reset(); 
    timer.start();
    while(timer.get() < 1.5){
      swerveSub.driveOffLine();

    }
    swerveSub.stopModules();
    
    finish = true; 

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    swerveSub.stopModules();
    
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {

    return finish;
  }
}

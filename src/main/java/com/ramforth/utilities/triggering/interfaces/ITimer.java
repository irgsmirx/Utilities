package com.ramforth.utilities.triggering.interfaces;

/**
 *
 * @author Tobias Ramforth <tobias.ramforth at tu-dortmund.de>
 */
public interface ITimer extends Iterable<ITickable> {
  
  void start();
  void stop();
  boolean isRunning();
  
  void addTickable(ITickable value);
  void removeTickable(ITickable value);
  void removeTickableAt(int index);
  int numberOfTickables();

  long getInterval();
  void setInterval(long value);
  
  void tick(long time);
  
}

package com.ramforth.utilities.triggering.implementation;

import com.ramforth.utilities.triggering.interfaces.ITickable;
import com.ramforth.utilities.triggering.interfaces.ITimer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author Tobias Ramforth <tobias.ramforth at tu-dortmund.de>
 */
public class Timer implements ITimer {

  private List<ITickable> tickables = new ArrayList<>();
  
  private Thread thread = null; 
  
  private long interval = 10l;
  private boolean running = false;
    
  public Timer() {
    this.thread = new Thread(new TimerRunnable());
  }
  
  @Override
  public void start() {
    running = true;
    this.thread.start();
  }
  
  @Override
  public void stop() {
    running = false;
  }
  
  @Override
  public boolean isRunning() {
    return running;
  }
  
  @Override
  public void addTickable(ITickable value) {
    tickables.add(value);
  }

  @Override
  public void removeTickable(ITickable value) {
    tickables.remove(value);
  }

  @Override
  public void removeTickableAt(int index) {
    tickables.remove(index);
  }

  @Override
  public int numberOfTickables() {
    return tickables.size();
  }

  @Override
  public Iterator<ITickable> iterator() {
    return tickables.iterator();
  }

  @Override
  public void tick(long time) {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  @Override
  public long getInterval() {
    return interval;
  }

  @Override
  public void setInterval(long value) {
    this.interval = value;
  }

  private final class TimerRunnable implements Runnable {

    @Override
    public void run() {
      long t = 0l;
      long accumulator = 0l;
      long currentTime = System.currentTimeMillis();

      while (running) {
        long newTime = System.currentTimeMillis();
        long deltaTime = newTime - currentTime;

        if (deltaTime <= 0l) {
          continue;
        }

        currentTime = newTime;

        // update discrete time
        accumulator += deltaTime;

        while (accumulator >= interval) {
          //rigidBody.update(t / 1000f, dt / 1000f);
          tick(t);
          accumulator -= interval;
          t += interval;
        }
      }
    }
    
  }
  
  
}

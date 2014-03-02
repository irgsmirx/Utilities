/* 
 * Copyright (C) 2014 Tobias Ramforth
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
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
    for (ITickable tickable : tickables) {
        tickable.tick();
    }
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

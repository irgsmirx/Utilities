package com.ramforth.utilities.triggering.implementation;

import com.ramforth.utilities.triggering.interfaces.IAction;
import com.ramforth.utilities.triggering.interfaces.ICondition;
import com.ramforth.utilities.triggering.interfaces.IEvent;
import com.ramforth.utilities.triggering.interfaces.ITrigger;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Tobias Ramforth <tobias.ramforth at tu-dortmund.de>
 */
public class TriggerScheduler {
  
  private Timer timer = new Timer();
  private TimerTask timerTask = null;
  private long periodInMilliseconds = 1000;
  
  private boolean enabled = false;
  
  private List<ITrigger> triggers = new ArrayList<>();
  
  public TriggerScheduler() {
    timerTask = new TriggerSchedulerTimerTask();
  }
  
  public void start() {
    timer.scheduleAtFixedRate(timerTask, 0, periodInMilliseconds);    
    enabled = true;
  }
  
  public void stop() {
    timerTask.cancel();
    enabled = false;
  }

  public boolean getEnabled() {
    return enabled;
  }

  public void setEnabled(boolean value) {
    if (!enabled && value) {
      start();
    } else {
      enabled = false;
    }
  }
  
  public void addTrigger(ITrigger value) {
    triggers.add(value);
  }  
  
  public void removeTrigger(ITrigger value) {
    triggers.remove(value);
  }
  
  public void clearTriggers() {
    triggers.clear();
  }
  
  public final List<ITrigger> getTriggers() {
    return triggers;
  }
  
  private class TriggerSchedulerTimerTask extends TimerTask {

    @Override
    public void run() {
      for (ITrigger trigger : triggers) {
        boolean eventsOccurred = false;
        for (IEvent event : trigger.getEvents()) {
          try {
            eventsOccurred |= event.occurred();
          } catch (Exception eventException) {
            
          }
        }
        if (!eventsOccurred) {
          break;
        }
        
        boolean conditionsMet = true;
        for (ICondition condition : trigger.getConditions()) {
          try {
            if (!condition.isMet()) {
              conditionsMet = false;
              break;
            }
          } catch (Exception conditionException) {
          
          }
        }
        if (!conditionsMet) {
          break;
        }
        
        for (IAction action : trigger.getActions()) {
          try {
            action.perform();
          } catch (Exception actionException) {
            
          }
        }
      }
    }
    
  }
  
}

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

import com.ramforth.utilities.triggering.interfaces.ITrigger;
import com.ramforth.utilities.triggering.interfaces.ITriggers;
import java.util.Timer;
import java.util.TimerTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Tobias Ramforth <tobias.ramforth at tu-dortmund.de>
 */
public class TriggerScheduler {

    protected static final Logger LOGGER = LoggerFactory.getLogger(TriggerScheduler.class);

    private final Timer timer = new Timer();
    private TimerTask timerTask = null;
    private final long periodInMilliseconds = 1000;

    private boolean enabled = false;

    private final ITriggers triggers = new Triggers();

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
        triggers.append(value);
    }

    public void removeTrigger(ITrigger value) {
        triggers.remove(value);
    }

    public void clearTriggers() {
        triggers.clear();
    }

    public final ITriggers getTriggers() {
        return triggers;
    }

    private class TriggerSchedulerTimerTask extends TimerTask {

        @Override
        public void run() {
            triggers.evaluate();
        }

    }

}

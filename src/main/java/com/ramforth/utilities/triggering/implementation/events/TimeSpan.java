/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ramforth.utilities.triggering.implementation.events;

/**
 *
 * @author tobias
 */
public class TimeSpan implements Comparable<TimeSpan> {

    public static final TimeSpan ZERO = new TimeSpan(0L);
    public static final TimeSpan MIN_VALUE = new TimeSpan(Long.MIN_VALUE);
    public static final TimeSpan MAX_VALUE = new TimeSpan(Long.MAX_VALUE);
    private static final long TICKS_PER_DAY = 864000000000L;
    private static final long TICKS_PER_HOUR = 36000000000L;
    private static final long TICKS_PER_MINUTE = 600000000L;
    private static final long TICKS_PER_SECOND = 10000000L;
    private static final long TICKS_PER_MILLISECOND = 10000L;
    private long ticks;

    public TimeSpan(long ticks) {
        this.ticks = ticks;
    }

    public TimeSpan(int hours, int minutes, int seconds) {
        this.ticks = calculateTicks(0, hours, minutes, seconds, 0);
    }

    public TimeSpan(int days, int hours, int minutes, int seconds) {
        this.ticks = calculateTicks(days, hours, minutes, seconds, 0);
    }

    public TimeSpan(int days, int hours, int minutes, int seconds, int milliseconds) {
        this.ticks = calculateTicks(days, hours, minutes, seconds, milliseconds);
    }

    private static long calculateTicks(int days, int hours, int minutes, int seconds, int milliseconds) {
        // there's no overflow checks for hours, minutes, ...
        // so big hours/minutes values can overflow at some point and change expected values
        int hoursSeconds = ( hours * 3600 ); // break point at (Int32.MaxValue - 596523)
        int minutesSeconds = ( minutes * 60 );
        long t = ( (long) ( hoursSeconds + minutesSeconds + seconds ) * 1000L + (long) milliseconds );
        t *= 10000;

        boolean overflow = false;
        // days is problematic because it can overflow but that overflow can be 
        // "legal" (i.e. temporary) (e.g. if other parameters are negative) or 
        // illegal (e.g. sign change).
        if (days > 0) {
            long daysTicks = TICKS_PER_DAY * days;
            if (t < 0) {
                long ticks = t;
                t += daysTicks;
                // positive days -> total ticks should be lower
                overflow = ( ticks > t );
            } else {
                t += daysTicks;
                // positive + positive != negative result
                overflow = ( t < 0 );
            }
        } else if (days < 0) {
            long daysTicks = TICKS_PER_DAY * days;
            if (t <= 0) {
                t += daysTicks;
                // negative + negative != positive result
                overflow = ( t > 0 );
            } else {
                long ticks = t;
                t += daysTicks;
                // negative days -> total ticks should be lower
                overflow = ( t > ticks );
            }
        }

        if (overflow) {
            throw new RuntimeException(/*Locale.GetText (*/"The timespan is too big or too small."/*)*/);
        }

        return t;
    }

    public final long getTicks() {
        return ticks;
    }

    public int getDays() {
        return (int) ( ticks / TICKS_PER_DAY );
    }

    public int getHours() {
        return (int) ( ticks % TICKS_PER_DAY / TICKS_PER_HOUR );
    }

    public int getMinutes() {
        return (int) ( ticks % TICKS_PER_HOUR / TICKS_PER_MINUTE );
    }

    public int getSeconds() {
        return (int) ( ticks % TICKS_PER_MINUTE / TICKS_PER_SECOND );
    }

    public int getMilliseconds() {
        return (int) ( ticks % TICKS_PER_SECOND / TICKS_PER_MILLISECOND );
    }

    public double getTotalDays() {
        return (double) ticks / TICKS_PER_DAY;
    }

    public double getTotalHours() {
        return (double) ticks / TICKS_PER_HOUR;
    }

    public double getTotalMinutes() {
        return (double) ticks / TICKS_PER_MINUTE;
    }

    public double getTotalSeconds() {
        return (double) ticks / TICKS_PER_SECOND;
    }

    public double getTotalMilliseconds() {
        return (double) ticks / TICKS_PER_MILLISECOND;
    }

    public TimeSpan add(TimeSpan value) {
        return new TimeSpan(ticks + value.getTicks());
    }

    @Override
    public int compareTo(TimeSpan o) {
        return ticks < o.getTicks() ? -1 : ticks > o.getTicks() ? 1 : 0;
    }

    public TimeSpan duration() {
        return new TimeSpan(Math.abs(ticks));
    }

    public static TimeSpan fromDays(double value) {
        return from(value, TICKS_PER_DAY);
    }

    public static TimeSpan fromHours(double value) {
        return from(value, TICKS_PER_HOUR);
    }

    public static TimeSpan fromMinutes(double value) {
        return from(value, TICKS_PER_MINUTE);
    }

    public static TimeSpan fromSeconds(double value) {
        return from(value, TICKS_PER_SECOND);
    }

    public static TimeSpan fromMilliseconds(double value) {
        return from(value, TICKS_PER_MILLISECOND);
    }

    private static TimeSpan from(double value, long tickMultiplicator) {
        if (Double.isNaN(value)) {
            throw new RuntimeException(/*Locale.GetText (*/"Value cannot be NaN."/*), "value"*/);
        }

        if (Double.isInfinite(value) || ( value < MIN_VALUE.getTicks() ) || ( value > MAX_VALUE.getTicks() )) {
            throw new RuntimeException(/*Locale.GetText (*/"Outside range [MinValue,MaxValue]"/*)*/);
        }

        try {
            value = ( value * ( tickMultiplicator / TICKS_PER_MILLISECOND ) );

            long val = (long) Math.round(value);
            return new TimeSpan(val * TICKS_PER_MILLISECOND);
        }
        catch (RuntimeException e) {
            throw new RuntimeException(/*Locale.GetText (*/"Resulting timespan is too big."/*)*/);
        }
    }

    public static TimeSpan fromTicks(long value) {
        return new TimeSpan(value);
    }
}

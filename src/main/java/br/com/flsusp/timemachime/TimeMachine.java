package br.com.flsusp.timemachime;

import java.util.Calendar;
import java.util.Date;

/**
 * This class allows you to navigate on time using methods like
 * {@link #startNow()}, {@link #travelTo(Date)}, <code>forward...()</code> and
 * <code>backward...()</code>. The most useful usage scenario is for testing
 * applications that have strong time based functionalities. In these
 * applications, using <code>new Date()</code> is not a good idea because it
 * will become difficult to automate tests.
 * <p>
 * For these cases you can use this simple tool for retrieving the current date
 * without calling directly a constructor (methods {@link #getTime()} and
 * {@link #getTimeInMillis()}). And on tests you can use the navigation methods
 * to fast forward and backward the time used by the system.
 * 
 * @author Fabio Lima Santos
 */
public class TimeMachine {

    private Long timestamp;

    /**
     * Returns the current time in milliseconds. If the time machine is not
     * started, the method {@link System#currentTimeMillis()} will be called.
     * Otherwise, the timestamp where the time machine represents will be
     * returned.
     */
    public Long getTimeInMillis() {
        if (timestamp == null) {
            return System.currentTimeMillis();
        } else {
            return timestamp;
        }
    }

    /**
     * @see #getTimeInMillis()
     */
    public Long timeInMillis() {
        return getTimeInMillis();
    }

    /**
     * Returns the current date. If the time machine is not started, it has the
     * same result as <code>new Date()</code>. Otherwise, the returned date will
     * be defined by the timestamp represented by this time machine.
     */
    public Date getTime() {
        return new Date(getTimeInMillis());
    }

    /**
     * @see #getTime()
     */
    public Date time() {
        return getTime();
    }

    /**
     * Releases the timestamp, turning back to the JVM time control.
     */
    public TimeMachine release() {
        timestamp = null;
        return this;
    }

    /**
     * Take control over the time using the current timestamp.
     */
    public TimeMachine startNow() {
        timestamp = System.currentTimeMillis();
        return this;
    }

    /**
     * Take control over the time using the timestamp of the given date.
     */
    public TimeMachine travelTo(Date date) {
        timestamp = date.getTime();
        return this;
    }

    /**
     * Forward one minute on the time machine timestamp. If the timestamp is not
     * yet defined, the method {@link #startNow()} is called before the time
     * navigation.
     */
    public TimeMachine forwardOneMinute() {
        if (!started()) {
            startNow();
        }

        timestamp += 1000 * 60;
        return this;
    }

    /**
     * Forward one hour on the time machine timestamp. If the timestamp is not
     * yet defined, the method {@link #startNow()} is called before the time
     * navigation.
     */
    public TimeMachine forwardOneHour() {
        if (!started()) {
            startNow();
        }

        timestamp += 1000 * 60 * 60;
        return this;
    }

    /**
     * Forward one day on the time machine timestamp. If the timestamp is not
     * yet defined, the method {@link #startNow()} is called before the time
     * navigation.
     */
    public TimeMachine forwardOneDay() {
        if (!started()) {
            startNow();
        }

        timestamp += 1000 * 60 * 60 * 24;
        return this;
    }

    /**
     * Forward one month on the time machine timestamp. If the timestamp is not
     * yet defined, the method {@link #startNow()} is called before the time
     * navigation.
     */
    public TimeMachine forwardOneMonth() {
        if (!started()) {
            startNow();
        }

        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(timestamp);
        c.add(Calendar.MONTH, 1);

        timestamp = c.getTimeInMillis();
        return this;
    }

    /**
     * Forward one year on the time machine timestamp. If the timestamp is not
     * yet defined, the method {@link #startNow()} is called before the time
     * navigation.
     */
    public TimeMachine forwardOneYear() {
        if (!started()) {
            startNow();
        }

        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(timestamp);
        c.add(Calendar.YEAR, 1);

        timestamp = c.getTimeInMillis();
        return this;
    }

    /**
     * Backward one minute on the time machine timestamp. If the timestamp is
     * not yet defined, the method {@link #startNow()} is called before the time
     * navigation.
     */
    public TimeMachine backwardOneMinute() {
        if (!started()) {
            startNow();
        }

        timestamp -= 1000 * 60;
        return this;
    }

    /**
     * Backward one hour on the time machine timestamp. If the timestamp is not
     * yet defined, the method {@link #startNow()} is called before the time
     * navigation.
     */
    public TimeMachine backwardOneHour() {
        if (!started()) {
            startNow();
        }

        timestamp -= 1000 * 60 * 60;
        return this;
    }

    /**
     * Backward one day on the time machine timestamp. If the timestamp is not
     * yet defined, the method {@link #startNow()} is called before the time
     * navigation.
     */
    public TimeMachine backwardOneDay() {
        if (!started()) {
            startNow();
        }

        timestamp -= 1000 * 60 * 60 * 24;
        return this;
    }

    /**
     * Backward one month on the time machine timestamp. If the timestamp is not
     * yet defined, the method {@link #startNow()} is called before the time
     * navigation.
     */
    public TimeMachine backwardOneMonth() {
        if (!started()) {
            startNow();
        }

        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(timestamp);
        c.add(Calendar.MONTH, -1);

        timestamp = c.getTimeInMillis();
        return this;
    }

    /**
     * Backward one year on the time machine timestamp. If the timestamp is not
     * yet defined, the method {@link #startNow()} is called before the time
     * navigation.
     */
    public TimeMachine backwardOneYear() {
        if (!started()) {
            startNow();
        }

        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(timestamp);
        c.add(Calendar.YEAR, -1);

        timestamp = c.getTimeInMillis();
        return this;
    }

    /**
     * Informs if the time machine holds a timestamp.
     */
    public boolean started() {
        return timestamp != null;
    }
}

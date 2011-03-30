package br.com.flsusp.timemachime;

import java.util.Calendar;
import java.util.Date;

public class TimeMachine {

    private Long timestamp;

    public Long getTimeInMillis() {
        if (timestamp == null) {
            return System.currentTimeMillis();
        } else {
            return timestamp;
        }
    }

    public Long timeInMillis() {
        return getTimeInMillis();
    }

    public Date getTime() {
        return new Date(getTimeInMillis());
    }

    public Date time() {
        return getTime();
    }

    public TimeMachine reset() {
        timestamp = null;
        return this;
    }

    public TimeMachine startNow() {
        timestamp = System.currentTimeMillis();
        return this;
    }

    public TimeMachine travelTo(Date date) {
        timestamp = date.getTime();
        return this;
    }

    public TimeMachine forwardOneMinute() {
        if (!started()) {
            startNow();
        }

        timestamp += 1000 * 60;
        return this;
    }

    public TimeMachine forwardOneHour() {
        if (!started()) {
            startNow();
        }

        timestamp += 1000 * 60 * 60;
        return this;
    }

    public TimeMachine forwardOneDay() {
        if (!started()) {
            startNow();
        }

        timestamp += 1000 * 60 * 60 * 24;
        return this;
    }

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

    public TimeMachine backwardOneMinute() {
        if (!started()) {
            startNow();
        }

        timestamp -= 1000 * 60;
        return this;
    }

    public TimeMachine backwardOneHour() {
        if (!started()) {
            startNow();
        }

        timestamp -= 1000 * 60 * 60;
        return this;
    }

    public TimeMachine backwardOneDay() {
        if (!started()) {
            startNow();
        }

        timestamp -= 1000 * 60 * 60 * 24;
        return this;
    }

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

    public boolean started() {
        return timestamp != null;
    }
}

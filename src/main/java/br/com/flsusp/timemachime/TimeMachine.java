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

    public Date getTime() {
        return new Date(getTimeInMillis());
    }

    public void reset() {
        timestamp = null;
    }

    public void stop() {
        timestamp = System.currentTimeMillis();
    }

    public void travelTo(Date date) {
        timestamp = date.getTime();
    }

    public void forwardOneMinute() {
        if (!stopped()) {
            stop();
        }

        timestamp += 1000 * 60;
    }

    public void forwardOneHour() {
        if (!stopped()) {
            stop();
        }

        timestamp += 1000 * 60 * 60;
    }

    public void forwardOneDay() {
        if (!stopped()) {
            stop();
        }

        timestamp += 1000 * 60 * 60 * 24;
    }

    public void forwardOneMonth() {
        if (!stopped()) {
            stop();
        }
        
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(timestamp);
        c.add(Calendar.MONTH, 1);

        timestamp = c.getTimeInMillis();
    }

    public void forwardOneYear() {
        if (!stopped()) {
            stop();
        }
        
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(timestamp);
        c.add(Calendar.YEAR, 1);

        timestamp = c.getTimeInMillis();
    }

    public void backwardOneMinute() {
        if (!stopped()) {
            stop();
        }

        timestamp -= 1000 * 60;
    }

    public void backwardOneHour() {
        if (!stopped()) {
            stop();
        }

        timestamp -= 1000 * 60 * 60;
    }

    public void backwardOneDay() {
        if (!stopped()) {
            stop();
        }

        timestamp -= 1000 * 60 * 60 * 24;
    }

    public void backwardOneMonth() {
        if (!stopped()) {
            stop();
        }
        
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(timestamp);
        c.add(Calendar.MONTH, -1);

        timestamp = c.getTimeInMillis();
    }

    public void backwardOneYear() {
        if (!stopped()) {
            stop();
        }
        
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(timestamp);
        c.add(Calendar.YEAR, -1);

        timestamp = c.getTimeInMillis();
    }

    public boolean stopped() {
        return timestamp != null;
    }
}

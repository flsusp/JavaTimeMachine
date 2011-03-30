package br.com.flsusp.timemachime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

public class TimeMachineTest {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    @Test
    public void timeNavigation() throws ParseException {
        TimeMachine timeMachine = new TimeMachine();

        timeMachine.travelTo(data("2011-03-30 07:50"));

        timeMachine.forwardOneMinute();
        assertEquals("2011-03-30 07:51", timeMachine.time());

        timeMachine.forwardOneHour();
        assertEquals("2011-03-30 08:51", timeMachine.time());

        timeMachine.forwardOneDay();
        assertEquals("2011-03-31 08:51", timeMachine.time());

        timeMachine.backwardOneMinute();
        assertEquals("2011-03-31 08:50", timeMachine.time());

        timeMachine.backwardOneHour();
        assertEquals("2011-03-31 07:50", timeMachine.time());

        timeMachine.backwardOneDay();
        assertEquals("2011-03-30 07:50", timeMachine.time());

        timeMachine.backwardOneYear();
        assertEquals("2010-03-30 07:50", timeMachine.time());

        timeMachine.backwardOneMonth();
        assertEquals("2010-02-28 07:50", timeMachine.time());

        timeMachine.forwardOneMonth();
        assertEquals("2010-03-28 07:50", timeMachine.time());

        timeMachine.forwardOneYear();
        assertEquals("2011-03-28 07:50", timeMachine.time());
    }

    private void assertEquals(String expected, Date actual) {
        String actualString = dateFormat.format(actual);
        Assert.assertEquals(expected, actualString);
    }

    private Date data(String string) throws ParseException {
        return dateFormat.parse(string);
    }
}

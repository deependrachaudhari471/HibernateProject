package in.com.prestige.test;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;

public class TestDate {
	public static void main(String[] args) throws ParseException {
		Date d = new Date();
	    long time = d.getTime();
		Timestamp ts = new Timestamp(time);
		System.out.println(ts);
	}
}

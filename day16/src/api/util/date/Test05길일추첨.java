package api.util.date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class Test05길일추첨 {
	public static void main(String[] args) {
		Random r = new Random();

		// SimpleDateFormat dow = new SimpleDateFormat("E");
		SimpleDateFormat fmt = new SimpleDateFormat("y년 M월 d일 E요일");
		// System.out.println(fmt.format(d));
		while (true) {
			Calendar c = Calendar.getInstance();
			c.set(2025, 0, 1);
			c.add(Calendar.DATE, r.nextInt(365) + 1);
			int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);

			if (dayOfWeek == 1 || dayOfWeek == 7) {
				c.set(2025, 0, 1);
			} else {
				Date d = c.getTime();
				// System.out.println(dayOfWeek);
				System.out.println(fmt.format(d));
				break;
			}

		}
	}
}

package stein.stocks;

import java.util.Comparator;

public class DateComparator implements Comparator<DailyPrice>{

	@Override
	public int compare(DailyPrice dp1, DailyPrice dp2) {
		return dp1.getDate().compareTo(dp2.getDate());
	}
	

}

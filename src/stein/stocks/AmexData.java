package stein.stocks;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;

public class AmexData {

	private DateComparator dc = new DateComparator();
	private HashMap map;
	private SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

	public boolean contains(String symbol) {
		return map.containsKey(symbol);
	}

	public List getPrices(String symbol) {
		return (List) map.get(symbol);

	}

	public void readInData() throws IOException, NumberFormatException,
			ParseException {
		List list = new ArrayList<DailyPrice>();
		map = new HashMap();
		String[] names = new String[4];
		names[0] = "./resources/amex/AMEX_daily_prices_A.csv";
		names[1] = "./resources/amex/AMEX_daily_prices_B.csv";
		names[2] = "./resources/amex/AMEX_daily_prices_C.csv";
		names[3] = "./resources/amex/AMEX_daily_prices_D.csv";
		for(int i = 0; i<4; i++){
		String input = names[i];
		CSVReader reader = new CSVReader(new FileReader(input),',','\"',1);
		reader.readNext();
		String array[];
		while ((array = reader.readNext()) != null) {
			DailyPrice price = new DailyPrice(array[0], array[1],
					df.parse(array[2]), Double.parseDouble(array[3]),
					Double.parseDouble(array[4]), Double.parseDouble(array[5]),
					Double.parseDouble(array[6]), Integer.parseInt(array[7]),
					Double.parseDouble(array[8]));
			list = (List) map.get(price.getSymbol());
			if (list == null) {
				list = new ArrayList();
				map.put(price.getSymbol(), list);
			}
			list.add(price);
			Collections.sort(list, dc);
			map.put(price.getSymbol(), list);
		}
		reader.close();
		}
	}

	public List getPrices(String symbol, Date startDate, Date EndDate) {
		List list = (List) map.get(symbol);
		List newList = new ArrayList();
		for (int i = 0; i < list.size(); i++) {
			if (((DailyPrice) list.get(i)).getDate().compareTo(startDate) >= 0
					&& ((DailyPrice) list.get(i)).getDate().compareTo(EndDate) <= 0) {
				newList.add(list.get(i));
			}
			// get prices only if the symbol, start date and end date are within
			// boundries
		}
		return newList;

	}

}

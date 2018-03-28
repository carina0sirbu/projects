package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {

		FileReader f = null;
		BufferedReader buff = null;
		List<MonitoredData> monitoredData = new ArrayList<MonitoredData>();

		try {

			f = new FileReader("Activities.txt");
			buff = new BufferedReader(f);
			String currentLine;

			while ((currentLine = buff.readLine()) != null) {

				String[] s = currentLine.split("\\s{2,}");
				monitoredData.add(new MonitoredData(s[0], s[1], s[2]));
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {

			try {
				
				f.close();
				buff.close();

			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		
		int days = (int) monitoredData.stream().map(s -> s.getStartTime().toLocalDate()).distinct().count();
		System.out.println(days);
		
		Map<String, Long> actions = monitoredData.stream().collect(Collectors.groupingBy(MonitoredData::getActivityLabel, Collectors.counting()));
		
		actions.forEach((s, l) -> System.out.println(s + " " + l));
		
	}
}

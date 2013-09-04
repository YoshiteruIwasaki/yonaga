package yonaga.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class CSVReaderUtils {

	private static final String ALGORITH_FILENAME_EN = "algorithm_en.csv";

	private static final String ALGORITH_FILENAME_JP = "algorithm_jp.csv";

	private static final String ALGORITH_PATH = "yonaga/resources/";

	private static final String ALGORITH_ENCODE = "UTF-8";

	private static final String ALGORITH_CONCAT = ",";

	public static HashMap<Integer, ArrayList<String>> csvToListEn()
			throws IOException {
		return csvToList(ALGORITH_PATH + ALGORITH_FILENAME_EN);
	}

	public static HashMap<Integer, ArrayList<String>> csvToListJp()
			throws IOException {
		return csvToList(ALGORITH_PATH + ALGORITH_FILENAME_JP);
	}
	/**
	 * CSV読み込み
	 *
	 * @param path
	 * @return
	 * @throws IOException
	 */
	public static HashMap<Integer, ArrayList<String>> csvToList(String path)
			throws IOException {
		InputStream is = CSVReaderUtils.class.getClassLoader()
				.getResourceAsStream(path);

		BufferedReader bufferedreader = new BufferedReader(
				new InputStreamReader(is,ALGORITH_ENCODE));
		HashMap<Integer, ArrayList<String>> map = new HashMap<Integer, ArrayList<String>>();
		String line;
		int i = 0;
		while ((line = bufferedreader.readLine()) != null) {
			StringTokenizer stringTokenizerTest = new StringTokenizer(line, ALGORITH_CONCAT);
			ArrayList<String> arrayList = new ArrayList<String>();
			while (stringTokenizerTest.hasMoreTokens()) {
				arrayList.add(stringTokenizerTest.nextToken().toString());
			}
			map.put(i, arrayList);
			i++;
		}

		is.close();
		return map;
	}
}

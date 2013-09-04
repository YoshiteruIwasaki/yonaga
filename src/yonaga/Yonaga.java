package yonaga;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import yonaga.model.Algorithm;
import yonaga.model.Sentence;
import yonaga.model.Word;
import yonaga.utils.AnalyzeUtils;
import yonaga.utils.CSVReaderUtils;
import yonaga.utils.ConvertKanaUtils;
import yonaga.utils.WeightingUtils;

public class Yonaga {

	private static ArrayList<Algorithm> weightList;

	public static void init() {
		if (weightList == null) {
			try {
				weightList = new ArrayList<Algorithm>();
				HashMap<Integer, ArrayList<String>> listEn = CSVReaderUtils
						.csvToListEn();

				if (listEn != null && listEn.size() > 0) {
					for (Entry<Integer, ArrayList<String>> entry : listEn
							.entrySet()) {
						Algorithm algorithm = new Algorithm();
						algorithm.setAlgorithmId(entry.getKey());
						algorithm.setWord(entry.getValue().get(0));
						algorithm.setKana("");
						algorithm.setSpeech(entry.getValue().get(1));
						algorithm.setPoint(Double.parseDouble(entry.getValue()
								.get(2)));
						algorithm.setLang("en");
						weightList.add(algorithm);
					}
				}
				HashMap<Integer, ArrayList<String>> listJp = CSVReaderUtils
						.csvToListJp();

				if (listJp != null && listJp.size() > 0) {
					for (Entry<Integer, ArrayList<String>> entry : listJp
							.entrySet()) {
						Algorithm algorithm = new Algorithm();
						algorithm.setAlgorithmId(weightList.size()
								+ entry.getKey());
						algorithm.setWord(entry.getValue().get(0));
						algorithm.setKana(ConvertKanaUtils
								.zenkakuHiraganaToZenkakuKatakana(entry
										.getValue().get(1)));
						algorithm.setSpeech(entry.getValue().get(2));
						algorithm.setPoint(Double.parseDouble(entry.getValue()
								.get(3)));
						algorithm.setLang("jp");
						weightList.add(algorithm);
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 解析処理
	 *
	 * @param string
	 * @return
	 */
	public static Sentence analyze(String string) {
		Sentence bean = new Sentence();
		bean.setSentence(string);
		ArrayList<Word> arrayList = AnalyzeUtils.analyze(string);
		Double totalPoint = 0D;
		for (Word word : arrayList) {
			WeightingUtils.calcWeight(word);
			totalPoint = totalPoint + word.getPoint();
		}
		bean.setWordList(arrayList);
		bean.setPoint(totalPoint);
		return bean;
	}

	public static ArrayList<Algorithm> getWeightList() {
		return weightList;
	}

}

package yonaga.utils;

import yonaga.Yonaga;
import yonaga.model.Algorithm;
import yonaga.model.Word;

public class WeightingUtils {

	/**
	 * 重み付け処理
	 *
	 * @param Word
	 */
	public static void calcWeight(Word word) {
		Algorithm algorithm = getAlgorithmBySentence(word);
		word.setPoint(algorithm != null ? algorithm.getPoint() : 0D);
		word.setAlgorithmId(algorithm != null ? algorithm.getAlgorithmId()
				: null);
	}

	/**
	 * 重み付け検索
	 *
	 * @param word
	 * @return
	 */
	private static Algorithm getAlgorithmBySentence(Word word) {
		for (Algorithm algorithm : Yonaga.getWeightList()) {
			if ((algorithm.getLang().equals("jp")
					&& algorithm.getSpeech().equals(word.getPos()) && algorithm
					.getWord().equals(word.getSurface()))
					|| (algorithm.getLang().equals("en") && algorithm.getWord()
							.equals(word.getSurface()))) {
				return algorithm;
			}

		}
		return null;
	}


}

Yonaga
======

日本語による感情分析用Javaライブラリです。

システム要件
------

OS: Java をサポートする Windows または Unix 系 OS

JVM: Java 6 またはそれ以降

### 必要なモジュール ###

yonaga.jar をクラスパスに通して使用して下さい。

このモジュールには動作に必要な以下の依存モジュールが同封されています。

[lucene-gosen-4.4.0-ipadic.jar](https://code.google.com/p/lucene-gosen/ "lucene-gosen"): 形態素解析ライブラリ

使用方法
------

    yonaga.Yonaga.init();
    Yonaga.analyze("分析する文字列");

謝辞
------
単語の感情極性分類には高村大也氏（東京工業大学）の[Semantic Orientations of Words](http://www.lr.pi.titech.ac.jp/~takamura/pndic_en.html)を利用させていただきました。詳細は下記参考文献の通りです。記して感謝いたします。

参考文献
------
Hiroya Takamura, Takashi Inui, Manabu Okumura,
"Extracting Semantic Orientations of Words using Spin Model", In Proceedings of the 43rd Annual Meeting of the Association for Computational Linguistics (ACL2005) , pages 133--140, 2005.
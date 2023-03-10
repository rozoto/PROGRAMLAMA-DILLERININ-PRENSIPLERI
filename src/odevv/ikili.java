/**
*
* @author Nurgül Serin - nurgul.serin@ogr.sakarya.edu.tr
* @since 28/03/2022
* * <p>
* 1/A
* </p>
*/
package odevv;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ikili {
	// dosyayı okuyabilmek için String oluşturdum.
		String dosyaAd = " ";

		// Kaç tane operatör olduğunu bulduğumda sayısını atamak için
		ArrayList<String> ikiliSayisi = new ArrayList<String>();
		ArrayList<String> yorum_ = new ArrayList<String>();

		// bütün ikili operatörler için regex tanımladım.
		Pattern ikiliEsit = Pattern.compile("[ ][=][ ]");
		Pattern ikiliArti = Pattern.compile("[ ][+][ ]");
		Pattern ikiliEksi = Pattern.compile("[ ][-][ ]");
		Pattern ikiliCarpi = Pattern.compile("[ ][*][ ]");
		Pattern ikiliBolu = Pattern.compile("[ ][/][ ]|[/]");
		Pattern ikiliYuzde = Pattern.compile("[ ][%][ ]");
		Pattern ikiliVe = Pattern.compile("[ ][&][ ]");
		Pattern ikiliVeya = Pattern.compile("[ ][|][ ]");
		Pattern ikiliEksiEsit = Pattern.compile("[-][=]");
		Pattern ikiliArtiEsit = Pattern.compile("[+][=]");
		Pattern ikiliCarpiEsit = Pattern.compile("[*][=]");
		Pattern ikiliBoluEsit = Pattern.compile("[/][=]");
		Pattern ikiliVeyaEsit = Pattern.compile("[|][=]");
		Pattern ikiliVeEsit = Pattern.compile("[&][=]");
		Pattern ikiliYuzdeEsit = Pattern.compile("[%][=]");

		// yorum satırlarını bulup koddan çıkartmak için regex tanımladım
		Pattern yorum = Pattern.compile("[/][/]|[/][*]|[*][/]");
		Pattern yildizYorum = Pattern.compile("[*][ ]|[ ][*][ ]");

		// main'den okuyabilmek için bu fonksiyonu tanımladım.
		public void dosyaOku() {
			FileReader fr = null;
			{
				// hata varsa fırlatması için try-catch tanımladım.
				// ve kodu bunun içine yazdım.
				try {
					fr = new FileReader(dosyaAd);
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
				BufferedReader br = new BufferedReader(fr);

				// okunan dosyayı bu değişkenin içine yazdıracağım
				String satir = null;
				try {
					// while döngüsüyle dosyayı okumaya başladım.
					while ((satir = br.readLine()) != null) {

						// yorum satırları için 2 tane matcher tanımladım.
						Matcher yorum_matcher = yorum.matcher(satir);
						Matcher yildizYorumMatcher = yildizYorum.matcher(satir);

						// operatörler için matcher tanımladım.
						Matcher ikiliEsitMatcher = ikiliEsit.matcher(satir);
						Matcher ikiliArtiMatcher = ikiliArti.matcher(satir);
						Matcher ikiliEksiMatcher = ikiliEksi.matcher(satir);
						Matcher ikiliCarpiMatcher = ikiliCarpi.matcher(satir);
						Matcher ikiliBoluMatcher = ikiliBolu.matcher(satir);
						Matcher ikiliYuzdeMatcher = ikiliYuzde.matcher(satir);
						Matcher ikiliVeMatcher = ikiliVe.matcher(satir);
						Matcher ikiliVeyaMatcher = ikiliVeya.matcher(satir);

						Matcher ikiliEksiEsitMatcher = ikiliEksiEsit.matcher(satir);
						Matcher ikiliArtiEsitMatcher = ikiliArtiEsit.matcher(satir);
						Matcher ikiliCarpiEsitMatcher = ikiliCarpiEsit.matcher(satir);
						Matcher ikiliBoluEsitMatcher = ikiliBoluEsit.matcher(satir);
						Matcher ikiliVeEsitMatcher = ikiliVeEsit.matcher(satir);
						Matcher ikiliVeyaEsitMatcher = ikiliVeyaEsit.matcher(satir);
						Matcher ikiliYuzdeEsitMatcher = ikiliYuzdeEsit.matcher(satir);

						// if ile yorum satırı varsa continue yaptım.
						if (yorum_matcher.find()) {
							String yorum1 = yorum_matcher.group();
							if (yorum1.length() != 0) {
								yorum_.add(yorum1);
							}
							continue;
						}

						// if ile satır * ile başlıyorsa continue yaptım.
						if (yildizYorumMatcher.find()) {
							String yorum1 = yildizYorumMatcher.group();
							if (satir.startsWith(yorum1))
								continue;
						}

						// while döngüsünün içinde operatörleri find() fonksiyonuyla buldum.
						// gecici isimli bir String oluşturdum.
						// ve find() fonsiyonuyla buldurduğum eşleşmeleri group() ile grupladım.
						// eğer gecici sayısı 0'dan farklıysa ArrayList'e ekledim.
						// bunu bütün matcherler için tekrarladım.
						while (ikiliEsitMatcher.find()) {
							String geciciİkiliEsit = ikiliEsitMatcher.group();
							if (geciciİkiliEsit.length() != 0) {
								ikiliSayisi.add(geciciİkiliEsit);

							}
						}

						while (ikiliArtiMatcher.find()) {
							String geciciİkiliArti = ikiliArtiMatcher.group();
							if (geciciİkiliArti.length() != 0) {
								ikiliSayisi.add(geciciİkiliArti);

							}
						}

						while (ikiliEksiMatcher.find()) {
							String geciciİkiliEksi = ikiliEksiMatcher.group();
							if (geciciİkiliEksi.length() != 0) {
								ikiliSayisi.add(geciciİkiliEksi);

							}
						}

						while (ikiliCarpiMatcher.find()) {

							String geciciİkiliCarpi = ikiliCarpiMatcher.group();
							if (geciciİkiliCarpi.length() != 0) {
								ikiliSayisi.add(geciciİkiliCarpi);

							}
						}

						while (ikiliBoluMatcher.find()) {
							String geciciİkiliBolu = ikiliBoluMatcher.group();
							if (geciciİkiliBolu.length() != 0) {
								ikiliSayisi.add(geciciİkiliBolu);

							}
						}

						while (ikiliYuzdeMatcher.find()) {
							String geciciİkiliYuzde = ikiliYuzdeMatcher.group();
							if (geciciİkiliYuzde.length() != 0) {
								ikiliSayisi.add(geciciİkiliYuzde);

							}
						}

						while (ikiliVeMatcher.find()) {
							String geciciİkiliVe = ikiliVeMatcher.group();
							if (geciciİkiliVe.length() != 0) {
								ikiliSayisi.add(geciciİkiliVe);

							}
						}

						while (ikiliVeyaMatcher.find()) {
							String geciciİkiliVeya = ikiliVeyaMatcher.group();
							if (geciciİkiliVeya.length() != 0) {
								ikiliSayisi.add(geciciİkiliVeya);

							}
						}

						while (ikiliArtiEsitMatcher.find()) {
							String geciciİkiliArtiEsit = ikiliArtiEsitMatcher.group();
							if (geciciİkiliArtiEsit.length() != 0) {
								ikiliSayisi.add(geciciİkiliArtiEsit);

							}
						}

						while (ikiliEksiEsitMatcher.find()) {
							String geciciİkiliEksiEsit = ikiliEksiEsitMatcher.group();
							if (geciciİkiliEksiEsit.length() != 0) {
								ikiliSayisi.add(geciciİkiliEksiEsit);

							}
						}

						while (ikiliBoluEsitMatcher.find()) {
							String geciciİkiliBoluEsit = ikiliBoluEsitMatcher.group();
							if (geciciİkiliBoluEsit.length() != 0) {
								ikiliSayisi.add(geciciİkiliBoluEsit);

							}
						}

						while (ikiliCarpiEsitMatcher.find()) {
							String geciciİkiliCarpiEsit = ikiliCarpiEsitMatcher.group();
							if (geciciİkiliCarpiEsit.length() != 0) {
								ikiliSayisi.add(geciciİkiliCarpiEsit);

							}
						}

						while (ikiliVeEsitMatcher.find()) {
							String geciciİkiliVeEsit = ikiliVeEsitMatcher.group();
							if (geciciİkiliVeEsit.length() != 0) {
								ikiliSayisi.add(geciciİkiliVeEsit);

							}
						}

						while (ikiliVeyaEsitMatcher.find()) {
							String geciciİkiliVeyaEsit = ikiliVeyaEsitMatcher.group();
							if (geciciİkiliVeyaEsit.length() != 0) {
								ikiliSayisi.add(geciciİkiliVeyaEsit);

							}
						}

						while (ikiliYuzdeEsitMatcher.find()) {
							String geciciİkiliYuzdeEsit = ikiliYuzdeEsitMatcher.group();
							if (geciciİkiliYuzdeEsit.length() != 0) {
								ikiliSayisi.add(geciciİkiliYuzdeEsit);

							}
						}
					}

					// kodun başında açtığım try'ı burada kapattım. (catch ile)
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				// BufferedReader için açmış olduğum br değişkenini kapattım.
				try {
					br.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		}

		// operatör sayısını burada fonksiyonun içine yazdırdım.
		public void ikiliOperator() {
			// ArrayList'in içindeki operatörlerin sayısını bulmak için size() fonksiyonunu
			// kullandım.
			// ArrayList'in içine String olarak atamıştım size() ile sayısını bulmuş oldum.
			System.out.println("         İkili operator sayisi: " + ikiliSayisi.size());
		}

		// burayı da dosyayı main'den okumak için tanımladım.
		// parametreli değişken yaptım ki main'de okunan dosya için
		// atadığım parametreyi class için kullanabileyim.

		public void setdosyaAd(String dosya) {
			// parametre ile classın başında tanımladığım String değişkeni eşitledim
			// classta satir değişkeniyle okuma yapabilmek için.
			dosyaAd = dosya;
		}

}

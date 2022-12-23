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
	// dosyayý okuyabilmek için String oluþturdum.
		String dosyaAd = " ";

		// Kaç tane operatör olduðunu bulduðumda sayýsýný atamak için
		ArrayList<String> ikiliSayisi = new ArrayList<String>();
		ArrayList<String> yorum_ = new ArrayList<String>();

		// bütün ikili operatörler için regex tanýmladým.
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

		// yorum satýrlarýný bulup koddan çýkartmak için regex tanýmladým
		Pattern yorum = Pattern.compile("[/][/]|[/][*]|[*][/]");
		Pattern yildizYorum = Pattern.compile("[*][ ]|[ ][*][ ]");

		// main'den okuyabilmek için bu fonksiyonu tanýmladým.
		public void dosyaOku() {
			FileReader fr = null;
			{
				// hata varsa fýrlatmasý için try-catch tanýmladým.
				// ve kodu bunun içine yazdým.
				try {
					fr = new FileReader(dosyaAd);
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
				BufferedReader br = new BufferedReader(fr);

				// okunan dosyayý bu deðiþkenin içine yazdýracaðým
				String satir = null;
				try {
					// while döngüsüyle dosyayý okumaya baþladým.
					while ((satir = br.readLine()) != null) {

						// yorum satýrlarý için 2 tane matcher tanýmladým.
						Matcher yorum_matcher = yorum.matcher(satir);
						Matcher yildizYorumMatcher = yildizYorum.matcher(satir);

						// operatörler için matcher tanýmladým.
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

						// if ile yorum satýrý varsa continue yaptým.
						if (yorum_matcher.find()) {
							String yorum1 = yorum_matcher.group();
							if (yorum1.length() != 0) {
								yorum_.add(yorum1);
							}
							continue;
						}

						// if ile satýr * ile baþlýyorsa continue yaptým.
						if (yildizYorumMatcher.find()) {
							String yorum1 = yildizYorumMatcher.group();
							if (satir.startsWith(yorum1))
								continue;
						}

						// while döngüsünün içinde operatörleri find() fonksiyonuyla buldum.
						// gecici isimli bir String oluþturdum.
						// ve find() fonsiyonuyla buldurduðum eþleþmeleri group() ile grupladým.
						// eðer gecici sayýsý 0'dan farklýysa ArrayList'e ekledim.
						// bunu bütün matcherler için tekrarladým.
						while (ikiliEsitMatcher.find()) {
							String geciciÝkiliEsit = ikiliEsitMatcher.group();
							if (geciciÝkiliEsit.length() != 0) {
								ikiliSayisi.add(geciciÝkiliEsit);

							}
						}

						while (ikiliArtiMatcher.find()) {
							String geciciÝkiliArti = ikiliArtiMatcher.group();
							if (geciciÝkiliArti.length() != 0) {
								ikiliSayisi.add(geciciÝkiliArti);

							}
						}

						while (ikiliEksiMatcher.find()) {
							String geciciÝkiliEksi = ikiliEksiMatcher.group();
							if (geciciÝkiliEksi.length() != 0) {
								ikiliSayisi.add(geciciÝkiliEksi);

							}
						}

						while (ikiliCarpiMatcher.find()) {

							String geciciÝkiliCarpi = ikiliCarpiMatcher.group();
							if (geciciÝkiliCarpi.length() != 0) {
								ikiliSayisi.add(geciciÝkiliCarpi);

							}
						}

						while (ikiliBoluMatcher.find()) {
							String geciciÝkiliBolu = ikiliBoluMatcher.group();
							if (geciciÝkiliBolu.length() != 0) {
								ikiliSayisi.add(geciciÝkiliBolu);

							}
						}

						while (ikiliYuzdeMatcher.find()) {
							String geciciÝkiliYuzde = ikiliYuzdeMatcher.group();
							if (geciciÝkiliYuzde.length() != 0) {
								ikiliSayisi.add(geciciÝkiliYuzde);

							}
						}

						while (ikiliVeMatcher.find()) {
							String geciciÝkiliVe = ikiliVeMatcher.group();
							if (geciciÝkiliVe.length() != 0) {
								ikiliSayisi.add(geciciÝkiliVe);

							}
						}

						while (ikiliVeyaMatcher.find()) {
							String geciciÝkiliVeya = ikiliVeyaMatcher.group();
							if (geciciÝkiliVeya.length() != 0) {
								ikiliSayisi.add(geciciÝkiliVeya);

							}
						}

						while (ikiliArtiEsitMatcher.find()) {
							String geciciÝkiliArtiEsit = ikiliArtiEsitMatcher.group();
							if (geciciÝkiliArtiEsit.length() != 0) {
								ikiliSayisi.add(geciciÝkiliArtiEsit);

							}
						}

						while (ikiliEksiEsitMatcher.find()) {
							String geciciÝkiliEksiEsit = ikiliEksiEsitMatcher.group();
							if (geciciÝkiliEksiEsit.length() != 0) {
								ikiliSayisi.add(geciciÝkiliEksiEsit);

							}
						}

						while (ikiliBoluEsitMatcher.find()) {
							String geciciÝkiliBoluEsit = ikiliBoluEsitMatcher.group();
							if (geciciÝkiliBoluEsit.length() != 0) {
								ikiliSayisi.add(geciciÝkiliBoluEsit);

							}
						}

						while (ikiliCarpiEsitMatcher.find()) {
							String geciciÝkiliCarpiEsit = ikiliCarpiEsitMatcher.group();
							if (geciciÝkiliCarpiEsit.length() != 0) {
								ikiliSayisi.add(geciciÝkiliCarpiEsit);

							}
						}

						while (ikiliVeEsitMatcher.find()) {
							String geciciÝkiliVeEsit = ikiliVeEsitMatcher.group();
							if (geciciÝkiliVeEsit.length() != 0) {
								ikiliSayisi.add(geciciÝkiliVeEsit);

							}
						}

						while (ikiliVeyaEsitMatcher.find()) {
							String geciciÝkiliVeyaEsit = ikiliVeyaEsitMatcher.group();
							if (geciciÝkiliVeyaEsit.length() != 0) {
								ikiliSayisi.add(geciciÝkiliVeyaEsit);

							}
						}

						while (ikiliYuzdeEsitMatcher.find()) {
							String geciciÝkiliYuzdeEsit = ikiliYuzdeEsitMatcher.group();
							if (geciciÝkiliYuzdeEsit.length() != 0) {
								ikiliSayisi.add(geciciÝkiliYuzdeEsit);

							}
						}
					}

					// kodun baþýnda açtýðým try'ý burada kapattým. (catch ile)
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				// BufferedReader için açmýþ olduðum br deðiþkenini kapattým.
				try {
					br.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		}

		// operatör sayýsýný burada fonksiyonun içine yazdýrdým.
		public void ikiliOperator() {
			// ArrayList'in içindeki operatörlerin sayýsýný bulmak için size() fonksiyonunu
			// kullandým.
			// ArrayList'in içine String olarak atamýþtým size() ile sayýsýný bulmuþ oldum.
			System.out.println("         Ýkili operator sayisi: " + ikiliSayisi.size());
		}

		// burayý da dosyayý main'den okumak için tanýmladým.
		// parametreli deðiþken yaptým ki main'de okunan dosya için
		// atadýðým parametreyi class için kullanabileyim.

		public void setdosyaAd(String dosya) {
			// parametre ile classýn baþýnda tanýmladýðým String deðiþkeni eþitledim
			// classta satir deðiþkeniyle okuma yapabilmek için.
			dosyaAd = dosya;
		}

}

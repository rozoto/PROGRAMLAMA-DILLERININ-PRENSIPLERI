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

public class iliskisel {
	// dosyayı okuyabilmek için String oluşturdum.
		String dosyaAd = " ";

		// Kaç tane operatör olduğunu bulduğumda sayısını atamak için
		ArrayList<String> iliskiselSayisi = new ArrayList<String>();
		ArrayList<String> yorum_ = new ArrayList<String>();

		// bütün ikili operatörler için regex tanımladım.
		Pattern iliskisel = Pattern.compile("(\\<|\\>)");
		Pattern iliskiselKucukEsit = Pattern.compile("[<][=]");
		Pattern iliskiselBuyukEsit = Pattern.compile("[>][=]");
		Pattern iliskiselUnlemEsit = Pattern.compile("[!][=]");
		Pattern iliskiselEsitEsit = Pattern.compile("[=][=]");

		// yorum satırlarını bulup koddan çıkartmak için regex tanımladım
		Pattern yorum = Pattern.compile("[/][/]|[/][*]|[*][/]|[*][ ]|[ ][*][ ]");
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
						Matcher iliskiselMatcher = iliskisel.matcher(satir);
						Matcher iliskiselBuyukEsitMatcher = iliskiselBuyukEsit.matcher(satir);
						Matcher iliskiselKucukEsitMatcher = iliskiselKucukEsit.matcher(satir);
						Matcher iliskiselEsitEsitMatcher = iliskiselEsitEsit.matcher(satir);
						Matcher iliskiselUnlemEsitMatcher = iliskiselUnlemEsit.matcher(satir);

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
						while (iliskiselMatcher.find()) {
							String geciciİliskisel = iliskiselMatcher.group();
							if (geciciİliskisel.length() != 0) {
								iliskiselSayisi.add(geciciİliskisel);

							}
						}

						while (iliskiselBuyukEsitMatcher.find()) {
							String geciciİliskiselBuyukEsit = iliskiselBuyukEsitMatcher.group();
							if (geciciİliskiselBuyukEsit.length() != 0) {
								iliskiselSayisi.add(geciciİliskiselBuyukEsit);

							}
						}

						while (iliskiselKucukEsitMatcher.find()) {
							String geciciİliskiselKucukEsit = iliskiselKucukEsitMatcher.group();
							if (geciciİliskiselKucukEsit.length() != 0) {
								iliskiselSayisi.add(geciciİliskiselKucukEsit);

							}
						}

						while (iliskiselEsitEsitMatcher.find()) {
							String geciciİliskiselEsitEsit = iliskiselEsitEsitMatcher.group();
							if (geciciİliskiselEsitEsit.length() != 0) {
								iliskiselSayisi.add(geciciİliskiselEsitEsit);

							}
						}

						while (iliskiselUnlemEsitMatcher.find()) {
							String geciciİliskiselUnlemEsit = iliskiselUnlemEsitMatcher.group();
							if (geciciİliskiselUnlemEsit.length() != 0) {
								iliskiselSayisi.add(geciciİliskiselUnlemEsit);

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
		public void iliskiselOperator() {
			// ArrayList'in içindeki operatörlerin sayısını bulmak için size() fonksiyonunu
			// kullandım.
			// ArrayList'in içine String olarak atamıştım size() ile sayısını bulmuş oldum.
			System.out.println("         İliskisel Operator Sayisi: " + iliskiselSayisi.size());
		}

		// burayı da dosyayı main'den okumak için tanımladım.
		// parametreli değişken yaptım ki main'de okunan dosya için
		// atadığım parametreyi class için kullanabileyim.

		public void setdosyaAd(String dAd) {

			// parametre ile classın başında tanımladığım String değişkeni eşitledim
			// classta satir değişkeniyle okuma yapabilmek için.
			dosyaAd = dAd;
		}
}

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
	// dosyayý okuyabilmek için String oluþturdum.
		String dosyaAd = " ";

		// Kaç tane operatör olduðunu bulduðumda sayýsýný atamak için
		ArrayList<String> iliskiselSayisi = new ArrayList<String>();
		ArrayList<String> yorum_ = new ArrayList<String>();

		// bütün ikili operatörler için regex tanýmladým.
		Pattern iliskisel = Pattern.compile("(\\<|\\>)");
		Pattern iliskiselKucukEsit = Pattern.compile("[<][=]");
		Pattern iliskiselBuyukEsit = Pattern.compile("[>][=]");
		Pattern iliskiselUnlemEsit = Pattern.compile("[!][=]");
		Pattern iliskiselEsitEsit = Pattern.compile("[=][=]");

		// yorum satýrlarýný bulup koddan çýkartmak için regex tanýmladým
		Pattern yorum = Pattern.compile("[/][/]|[/][*]|[*][/]|[*][ ]|[ ][*][ ]");
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
						Matcher iliskiselMatcher = iliskisel.matcher(satir);
						Matcher iliskiselBuyukEsitMatcher = iliskiselBuyukEsit.matcher(satir);
						Matcher iliskiselKucukEsitMatcher = iliskiselKucukEsit.matcher(satir);
						Matcher iliskiselEsitEsitMatcher = iliskiselEsitEsit.matcher(satir);
						Matcher iliskiselUnlemEsitMatcher = iliskiselUnlemEsit.matcher(satir);

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
						while (iliskiselMatcher.find()) {
							String geciciÝliskisel = iliskiselMatcher.group();
							if (geciciÝliskisel.length() != 0) {
								iliskiselSayisi.add(geciciÝliskisel);

							}
						}

						while (iliskiselBuyukEsitMatcher.find()) {
							String geciciÝliskiselBuyukEsit = iliskiselBuyukEsitMatcher.group();
							if (geciciÝliskiselBuyukEsit.length() != 0) {
								iliskiselSayisi.add(geciciÝliskiselBuyukEsit);

							}
						}

						while (iliskiselKucukEsitMatcher.find()) {
							String geciciÝliskiselKucukEsit = iliskiselKucukEsitMatcher.group();
							if (geciciÝliskiselKucukEsit.length() != 0) {
								iliskiselSayisi.add(geciciÝliskiselKucukEsit);

							}
						}

						while (iliskiselEsitEsitMatcher.find()) {
							String geciciÝliskiselEsitEsit = iliskiselEsitEsitMatcher.group();
							if (geciciÝliskiselEsitEsit.length() != 0) {
								iliskiselSayisi.add(geciciÝliskiselEsitEsit);

							}
						}

						while (iliskiselUnlemEsitMatcher.find()) {
							String geciciÝliskiselUnlemEsit = iliskiselUnlemEsitMatcher.group();
							if (geciciÝliskiselUnlemEsit.length() != 0) {
								iliskiselSayisi.add(geciciÝliskiselUnlemEsit);

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
		public void iliskiselOperator() {
			// ArrayList'in içindeki operatörlerin sayýsýný bulmak için size() fonksiyonunu
			// kullandým.
			// ArrayList'in içine String olarak atamýþtým size() ile sayýsýný bulmuþ oldum.
			System.out.println("         Ýliskisel Operator Sayisi: " + iliskiselSayisi.size());
		}

		// burayý da dosyayý main'den okumak için tanýmladým.
		// parametreli deðiþken yaptým ki main'de okunan dosya için
		// atadýðým parametreyi class için kullanabileyim.

		public void setdosyaAd(String dAd) {

			// parametre ile classýn baþýnda tanýmladýðým String deðiþkeni eþitledim
			// classta satir deðiþkeniyle okuma yapabilmek için.
			dosyaAd = dAd;
		}
}

/**
*
* @author Nurg?l Serin - nurgul.serin@ogr.sakarya.edu.tr
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
	// dosyay? okuyabilmek i?in String olu?turdum.
		String dosyaAd = " ";

		// Ka? tane operat?r oldu?unu buldu?umda say?s?n? atamak i?in
		ArrayList<String> iliskiselSayisi = new ArrayList<String>();
		ArrayList<String> yorum_ = new ArrayList<String>();

		// b?t?n ikili operat?rler i?in regex tan?mlad?m.
		Pattern iliskisel = Pattern.compile("(\\<|\\>)");
		Pattern iliskiselKucukEsit = Pattern.compile("[<][=]");
		Pattern iliskiselBuyukEsit = Pattern.compile("[>][=]");
		Pattern iliskiselUnlemEsit = Pattern.compile("[!][=]");
		Pattern iliskiselEsitEsit = Pattern.compile("[=][=]");

		// yorum sat?rlar?n? bulup koddan ??kartmak i?in regex tan?mlad?m
		Pattern yorum = Pattern.compile("[/][/]|[/][*]|[*][/]|[*][ ]|[ ][*][ ]");
		Pattern yildizYorum = Pattern.compile("[*][ ]|[ ][*][ ]");

		// main'den okuyabilmek i?in bu fonksiyonu tan?mlad?m.
		public void dosyaOku() {
			FileReader fr = null;
			{
				// hata varsa f?rlatmas? i?in try-catch tan?mlad?m.
				// ve kodu bunun i?ine yazd?m.
				try {
					fr = new FileReader(dosyaAd);
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
				BufferedReader br = new BufferedReader(fr);

				// okunan dosyay? bu de?i?kenin i?ine yazd?raca??m
				String satir = null;
				try {
					// while d?ng?s?yle dosyay? okumaya ba?lad?m.
					while ((satir = br.readLine()) != null) {

						// yorum sat?rlar? i?in 2 tane matcher tan?mlad?m.
						Matcher yorum_matcher = yorum.matcher(satir);
						Matcher yildizYorumMatcher = yildizYorum.matcher(satir);

						// operat?rler i?in matcher tan?mlad?m.
						Matcher iliskiselMatcher = iliskisel.matcher(satir);
						Matcher iliskiselBuyukEsitMatcher = iliskiselBuyukEsit.matcher(satir);
						Matcher iliskiselKucukEsitMatcher = iliskiselKucukEsit.matcher(satir);
						Matcher iliskiselEsitEsitMatcher = iliskiselEsitEsit.matcher(satir);
						Matcher iliskiselUnlemEsitMatcher = iliskiselUnlemEsit.matcher(satir);

						// if ile yorum sat?r? varsa continue yapt?m.
						if (yorum_matcher.find()) {
							String yorum1 = yorum_matcher.group();
							if (yorum1.length() != 0) {
								yorum_.add(yorum1);
							}
							continue;
						}

						// if ile sat?r * ile ba?l?yorsa continue yapt?m.
						if (yildizYorumMatcher.find()) {
							String yorum1 = yildizYorumMatcher.group();
							if (satir.startsWith(yorum1))
								continue;
						}

						// while d?ng?s?n?n i?inde operat?rleri find() fonksiyonuyla buldum.
						// gecici isimli bir String olu?turdum.
						// ve find() fonsiyonuyla buldurdu?um e?le?meleri group() ile gruplad?m.
						// e?er gecici say?s? 0'dan farkl?ysa ArrayList'e ekledim.
						// bunu b?t?n matcherler i?in tekrarlad?m.
						while (iliskiselMatcher.find()) {
							String gecici?liskisel = iliskiselMatcher.group();
							if (gecici?liskisel.length() != 0) {
								iliskiselSayisi.add(gecici?liskisel);

							}
						}

						while (iliskiselBuyukEsitMatcher.find()) {
							String gecici?liskiselBuyukEsit = iliskiselBuyukEsitMatcher.group();
							if (gecici?liskiselBuyukEsit.length() != 0) {
								iliskiselSayisi.add(gecici?liskiselBuyukEsit);

							}
						}

						while (iliskiselKucukEsitMatcher.find()) {
							String gecici?liskiselKucukEsit = iliskiselKucukEsitMatcher.group();
							if (gecici?liskiselKucukEsit.length() != 0) {
								iliskiselSayisi.add(gecici?liskiselKucukEsit);

							}
						}

						while (iliskiselEsitEsitMatcher.find()) {
							String gecici?liskiselEsitEsit = iliskiselEsitEsitMatcher.group();
							if (gecici?liskiselEsitEsit.length() != 0) {
								iliskiselSayisi.add(gecici?liskiselEsitEsit);

							}
						}

						while (iliskiselUnlemEsitMatcher.find()) {
							String gecici?liskiselUnlemEsit = iliskiselUnlemEsitMatcher.group();
							if (gecici?liskiselUnlemEsit.length() != 0) {
								iliskiselSayisi.add(gecici?liskiselUnlemEsit);

							}
						}

					}
					// kodun ba??nda a?t???m try'? burada kapatt?m. (catch ile)
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				// BufferedReader i?in a?m?? oldu?um br de?i?kenini kapatt?m.
				try {
					br.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		}

		// operat?r say?s?n? burada fonksiyonun i?ine yazd?rd?m.
		public void iliskiselOperator() {
			// ArrayList'in i?indeki operat?rlerin say?s?n? bulmak i?in size() fonksiyonunu
			// kulland?m.
			// ArrayList'in i?ine String olarak atam??t?m size() ile say?s?n? bulmu? oldum.
			System.out.println("         ?liskisel Operator Sayisi: " + iliskiselSayisi.size());
		}

		// buray? da dosyay? main'den okumak i?in tan?mlad?m.
		// parametreli de?i?ken yapt?m ki main'de okunan dosya i?in
		// atad???m parametreyi class i?in kullanabileyim.

		public void setdosyaAd(String dAd) {

			// parametre ile class?n ba??nda tan?mlad???m String de?i?keni e?itledim
			// classta satir de?i?keniyle okuma yapabilmek i?in.
			dosyaAd = dAd;
		}
}

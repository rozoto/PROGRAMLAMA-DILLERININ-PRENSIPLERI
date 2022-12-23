/**
*
* @author Nurg�l Serin - nurgul.serin@ogr.sakarya.edu.tr
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
	// dosyay� okuyabilmek i�in String olu�turdum.
		String dosyaAd = " ";

		// Ka� tane operat�r oldu�unu buldu�umda say�s�n� atamak i�in
		ArrayList<String> ikiliSayisi = new ArrayList<String>();
		ArrayList<String> yorum_ = new ArrayList<String>();

		// b�t�n ikili operat�rler i�in regex tan�mlad�m.
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

		// yorum sat�rlar�n� bulup koddan ��kartmak i�in regex tan�mlad�m
		Pattern yorum = Pattern.compile("[/][/]|[/][*]|[*][/]");
		Pattern yildizYorum = Pattern.compile("[*][ ]|[ ][*][ ]");

		// main'den okuyabilmek i�in bu fonksiyonu tan�mlad�m.
		public void dosyaOku() {
			FileReader fr = null;
			{
				// hata varsa f�rlatmas� i�in try-catch tan�mlad�m.
				// ve kodu bunun i�ine yazd�m.
				try {
					fr = new FileReader(dosyaAd);
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
				BufferedReader br = new BufferedReader(fr);

				// okunan dosyay� bu de�i�kenin i�ine yazd�raca��m
				String satir = null;
				try {
					// while d�ng�s�yle dosyay� okumaya ba�lad�m.
					while ((satir = br.readLine()) != null) {

						// yorum sat�rlar� i�in 2 tane matcher tan�mlad�m.
						Matcher yorum_matcher = yorum.matcher(satir);
						Matcher yildizYorumMatcher = yildizYorum.matcher(satir);

						// operat�rler i�in matcher tan�mlad�m.
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

						// if ile yorum sat�r� varsa continue yapt�m.
						if (yorum_matcher.find()) {
							String yorum1 = yorum_matcher.group();
							if (yorum1.length() != 0) {
								yorum_.add(yorum1);
							}
							continue;
						}

						// if ile sat�r * ile ba�l�yorsa continue yapt�m.
						if (yildizYorumMatcher.find()) {
							String yorum1 = yildizYorumMatcher.group();
							if (satir.startsWith(yorum1))
								continue;
						}

						// while d�ng�s�n�n i�inde operat�rleri find() fonksiyonuyla buldum.
						// gecici isimli bir String olu�turdum.
						// ve find() fonsiyonuyla buldurdu�um e�le�meleri group() ile gruplad�m.
						// e�er gecici say�s� 0'dan farkl�ysa ArrayList'e ekledim.
						// bunu b�t�n matcherler i�in tekrarlad�m.
						while (ikiliEsitMatcher.find()) {
							String gecici�kiliEsit = ikiliEsitMatcher.group();
							if (gecici�kiliEsit.length() != 0) {
								ikiliSayisi.add(gecici�kiliEsit);

							}
						}

						while (ikiliArtiMatcher.find()) {
							String gecici�kiliArti = ikiliArtiMatcher.group();
							if (gecici�kiliArti.length() != 0) {
								ikiliSayisi.add(gecici�kiliArti);

							}
						}

						while (ikiliEksiMatcher.find()) {
							String gecici�kiliEksi = ikiliEksiMatcher.group();
							if (gecici�kiliEksi.length() != 0) {
								ikiliSayisi.add(gecici�kiliEksi);

							}
						}

						while (ikiliCarpiMatcher.find()) {

							String gecici�kiliCarpi = ikiliCarpiMatcher.group();
							if (gecici�kiliCarpi.length() != 0) {
								ikiliSayisi.add(gecici�kiliCarpi);

							}
						}

						while (ikiliBoluMatcher.find()) {
							String gecici�kiliBolu = ikiliBoluMatcher.group();
							if (gecici�kiliBolu.length() != 0) {
								ikiliSayisi.add(gecici�kiliBolu);

							}
						}

						while (ikiliYuzdeMatcher.find()) {
							String gecici�kiliYuzde = ikiliYuzdeMatcher.group();
							if (gecici�kiliYuzde.length() != 0) {
								ikiliSayisi.add(gecici�kiliYuzde);

							}
						}

						while (ikiliVeMatcher.find()) {
							String gecici�kiliVe = ikiliVeMatcher.group();
							if (gecici�kiliVe.length() != 0) {
								ikiliSayisi.add(gecici�kiliVe);

							}
						}

						while (ikiliVeyaMatcher.find()) {
							String gecici�kiliVeya = ikiliVeyaMatcher.group();
							if (gecici�kiliVeya.length() != 0) {
								ikiliSayisi.add(gecici�kiliVeya);

							}
						}

						while (ikiliArtiEsitMatcher.find()) {
							String gecici�kiliArtiEsit = ikiliArtiEsitMatcher.group();
							if (gecici�kiliArtiEsit.length() != 0) {
								ikiliSayisi.add(gecici�kiliArtiEsit);

							}
						}

						while (ikiliEksiEsitMatcher.find()) {
							String gecici�kiliEksiEsit = ikiliEksiEsitMatcher.group();
							if (gecici�kiliEksiEsit.length() != 0) {
								ikiliSayisi.add(gecici�kiliEksiEsit);

							}
						}

						while (ikiliBoluEsitMatcher.find()) {
							String gecici�kiliBoluEsit = ikiliBoluEsitMatcher.group();
							if (gecici�kiliBoluEsit.length() != 0) {
								ikiliSayisi.add(gecici�kiliBoluEsit);

							}
						}

						while (ikiliCarpiEsitMatcher.find()) {
							String gecici�kiliCarpiEsit = ikiliCarpiEsitMatcher.group();
							if (gecici�kiliCarpiEsit.length() != 0) {
								ikiliSayisi.add(gecici�kiliCarpiEsit);

							}
						}

						while (ikiliVeEsitMatcher.find()) {
							String gecici�kiliVeEsit = ikiliVeEsitMatcher.group();
							if (gecici�kiliVeEsit.length() != 0) {
								ikiliSayisi.add(gecici�kiliVeEsit);

							}
						}

						while (ikiliVeyaEsitMatcher.find()) {
							String gecici�kiliVeyaEsit = ikiliVeyaEsitMatcher.group();
							if (gecici�kiliVeyaEsit.length() != 0) {
								ikiliSayisi.add(gecici�kiliVeyaEsit);

							}
						}

						while (ikiliYuzdeEsitMatcher.find()) {
							String gecici�kiliYuzdeEsit = ikiliYuzdeEsitMatcher.group();
							if (gecici�kiliYuzdeEsit.length() != 0) {
								ikiliSayisi.add(gecici�kiliYuzdeEsit);

							}
						}
					}

					// kodun ba��nda a�t���m try'� burada kapatt�m. (catch ile)
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				// BufferedReader i�in a�m�� oldu�um br de�i�kenini kapatt�m.
				try {
					br.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		}

		// operat�r say�s�n� burada fonksiyonun i�ine yazd�rd�m.
		public void ikiliOperator() {
			// ArrayList'in i�indeki operat�rlerin say�s�n� bulmak i�in size() fonksiyonunu
			// kulland�m.
			// ArrayList'in i�ine String olarak atam��t�m size() ile say�s�n� bulmu� oldum.
			System.out.println("         �kili operator sayisi: " + ikiliSayisi.size());
		}

		// buray� da dosyay� main'den okumak i�in tan�mlad�m.
		// parametreli de�i�ken yapt�m ki main'de okunan dosya i�in
		// atad���m parametreyi class i�in kullanabileyim.

		public void setdosyaAd(String dosya) {
			// parametre ile class�n ba��nda tan�mlad���m String de�i�keni e�itledim
			// classta satir de�i�keniyle okuma yapabilmek i�in.
			dosyaAd = dosya;
		}

}

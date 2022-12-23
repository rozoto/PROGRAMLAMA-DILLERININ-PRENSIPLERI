/**
*
* @author Nurg�l Serin - nurgul.serin@ogr.sakarya.edu.tr
* @since 28/03/2022
* * <p>
* 1/A
* </p>
*/
package odevv;

public class program {
	public static void main(String[] args) {

		// komut sat�r�ndan girilecek dosyay� okumak i�in
		for (int i = 0; i < args.length; i++) {
		}

		// okunan dosyay� args[0]'a atad�m.
		String okunanDosya = args[0];

		// classlardan kal�t�m ald�m.
		tekli tekli = new tekli();
		ikili ikili = new ikili();
		iliskisel iliskisel = new iliskisel();
		mantiksal mantiksal = new mantiksal();

		// tekli s�n�f�ndaki fonksiyonlar� okuttum.
		tekli.setdosyaAd(okunanDosya);
		tekli.dosyaOku();
		tekli.tekliOperator();

		// ikili s�n�f�ndaki fonksiyonlar� okuttum.
		ikili.setdosyaAd(okunanDosya);
		ikili.dosyaOku();
		ikili.ikiliOperator();

		// tekli ve ikili operat�r say�s�n� toplay�p say�sal operat�r olarak yazd�rd�m.
		System.out
				.println("         Sayisal Operator Sayisi: " + (tekli.tekliSayisi.size() + ikili.ikiliSayisi.size()));

		// iliskisel s�n�f�ndaki fonksiyonlar� okuttum.
		iliskisel.setdosyaAd(okunanDosya);
		iliskisel.dosyaOku();
		iliskisel.iliskiselOperator();

		// mantiksal s�n�f�ndaki fonksiyonlar� okuttum.
		mantiksal.setdosyaAd(okunanDosya);
		mantiksal.dosyaOku();
		mantiksal.mantiksalOperator();

		// operand bilgisini hesaplatt�m.
		System.out.println("Operand Bilgisi:");
		System.out.println(
				"         Toplam Operand Sayisi: " + ((tekli.tekliSayisi.size()) + (ikili.ikiliSayisi.size()) * 2
						+ (mantiksal.mantiksalSayisi.size() * 2) + (iliskisel.iliskiselSayisi.size()) * 2));

	}

}

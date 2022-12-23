/**
*
* @author Nurgül Serin - nurgul.serin@ogr.sakarya.edu.tr
* @since 28/03/2022
* * <p>
* 1/A
* </p>
*/
package odevv;

public class program {
	public static void main(String[] args) {

		// komut satýrýndan girilecek dosyayý okumak için
		for (int i = 0; i < args.length; i++) {
		}

		// okunan dosyayý args[0]'a atadým.
		String okunanDosya = args[0];

		// classlardan kalýtým aldým.
		tekli tekli = new tekli();
		ikili ikili = new ikili();
		iliskisel iliskisel = new iliskisel();
		mantiksal mantiksal = new mantiksal();

		// tekli sýnýfýndaki fonksiyonlarý okuttum.
		tekli.setdosyaAd(okunanDosya);
		tekli.dosyaOku();
		tekli.tekliOperator();

		// ikili sýnýfýndaki fonksiyonlarý okuttum.
		ikili.setdosyaAd(okunanDosya);
		ikili.dosyaOku();
		ikili.ikiliOperator();

		// tekli ve ikili operatör sayýsýný toplayýp sayýsal operatör olarak yazdýrdým.
		System.out
				.println("         Sayisal Operator Sayisi: " + (tekli.tekliSayisi.size() + ikili.ikiliSayisi.size()));

		// iliskisel sýnýfýndaki fonksiyonlarý okuttum.
		iliskisel.setdosyaAd(okunanDosya);
		iliskisel.dosyaOku();
		iliskisel.iliskiselOperator();

		// mantiksal sýnýfýndaki fonksiyonlarý okuttum.
		mantiksal.setdosyaAd(okunanDosya);
		mantiksal.dosyaOku();
		mantiksal.mantiksalOperator();

		// operand bilgisini hesaplattým.
		System.out.println("Operand Bilgisi:");
		System.out.println(
				"         Toplam Operand Sayisi: " + ((tekli.tekliSayisi.size()) + (ikili.ikiliSayisi.size()) * 2
						+ (mantiksal.mantiksalSayisi.size() * 2) + (iliskisel.iliskiselSayisi.size()) * 2));

	}

}

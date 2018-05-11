/*
 * javalib k�nyvt�r
 * Csomag: extra
 * Format.java
 *
 * Angster Erzs�bet: OO tervez�s �s programoz�s, Java 1. k�tet
 * 2002.09.01.
 *
 * Sz�vegek igaz�t�sa:
 *
 * String left(String str, int len)       // balra igaz�t, lev�g
 * String right(String str, int len)      // jobbra igaz�t, lev�g
 * String leftNocut(String str, int len)  // balra igaz�t, nem v�g le
 * String rightNoCut(String str, int len) // jobbra igaz�t, nem v�g le
 *
 * Sz�mok igaz�t�sa (�rt�kes jegyet sosem v�g le):
 *
 * String left(long num, int len)
 * String right(long num, int len)
 * String left(double num, int len, int frac)
 * String right(double num, int len, int frac)
 */

package extra;
import java.text.*;
import java.util.*;

public class Format {
  // Az oszt�lyb�l nem lehet p�ld�nyt l�trehozni:
  private Format() {
  }

  /* Mindig tizedes lesz. Locale.HU (magyar k�rnyezet)
   * eset�n tizedesvessz� lenne, �s keveredn�nek a ki�r�sok.
   */
  private static NumberFormat nf =
      NumberFormat.getInstance(Locale.US);

  /* ---------------------------------------------------------------
   * String igaz�t�sa balra, adott hosszra.
   * Ha r�videbb, akkor jobbr�l sz�k�z�kkel kieg�sz�ti, ha
   * hosszabb, akkor jobbr�l lev�gja:
   */
  public static String left(String str, int len) {
    StringBuffer sb = new StringBuffer(str);
    for (int i = str.length(); i < len; i++)
      sb.append(' ');
    return sb.toString().substring(0,len);
  }

 /* ---------------------------------------------------------------
   * String igaz�t�sa balra, adott hosszra.
   * Ha r�videbb, akkor jobbr�l sz�k�z�kkel kieg�sz�ti.
   * Nem v�gja le jobbr�l:
   */
  public static String leftNocut(String str, int len) {
    StringBuffer sb = new StringBuffer(str);
    for (int i = str.length(); i < len; i++)
      sb.append(' ');
    return sb.toString();
  }

  /* ---------------------------------------------------------------
   * String igaz�t�sa jobbra, adott hosszra.
   * Ha r�videbb, akkor balr�l sz�k�z�kkel kieg�sz�ti, ha
   * hosszabb, akkor balr�l lev�gja:
   */
  public static String right(String str, int len) {
    StringBuffer sb = new StringBuffer(str);
    for (int i = str.length(); i < len; i++)
      sb.insert(0,' ');

    return sb.toString().substring(sb.length()-len);
  }

  /* ---------------------------------------------------------------
   * String igaz�t�sa jobbra, adott hosszra.
   * Ha r�videbb, akkor balr�l sz�k�z�kkel kieg�sz�ti.
   * Nem v�gja le balr�l:
   */
  public static String rightNocut(String str, int len) {
    StringBuffer sb = new StringBuffer(str);
    for (int i = str.length(); i < len; i++)
      sb.insert(0,' ');

    return sb.toString();
  }

  /* ---------------------------------------------------------------
   * long sz�m konvert�l�sa Stringg�. Igaz�t�s balra, len hosszon.
   * Ha r�videbb, akkor balr�l sz�k�z�kkel kieg�sz�ti.
   * �rt�kes jegyeket nem v�g le:
   */
  public static String left(long num, int len) {
    nf.setGroupingUsed(false);
    nf.setMaximumFractionDigits(0);
    return leftNocut(nf.format(num),len);
  }

  /* ---------------------------------------------------------------
   * long sz�m konvert�l�sa Stringg�. Igaz�t�s jobbra, len hosszon.
   * Ha r�videbb, akkor balr�l sz�k�z�kkel kieg�sz�ti.
   * �rt�kes jegyeket nem v�g le:
   */

  public static String right(long num, int len) {
    nf.setGroupingUsed(false);
    nf.setMaximumFractionDigits(0);
    return rightNocut(nf.format(num),len);
  }

  /* ---------------------------------------------------------------
   * double sz�m konvert�l�sa Stringg�. Igaz�t�s balra, len hosszon,
   * frac tizedesre. �rt�kes jegyeket nem v�g le:
   */
  public static String left(double num, int len, int frac) {
    nf.setGroupingUsed(false);         // nincs tagol�s
    nf.setMaximumFractionDigits(frac); // pontosan frac tizedes
    nf.setMinimumFractionDigits(frac);
    return leftNocut(nf.format(num),len);
  }

  // ---------------------------------------------------------------
  // double sz�m konvert�l�sa Stringg�. Igaz�t�s jobbra, len hosszon
  // frac tizedesre. �rt�kes jegyeket nem v�g le:
  public static String right(double num, int len, int frac) {
    nf.setGroupingUsed(false);         // nincs tagol�s
    nf.setMaximumFractionDigits(frac); // pontosan frac tizedes
    nf.setMinimumFractionDigits(frac);
    return rightNocut(nf.format(num),len);
  }
}

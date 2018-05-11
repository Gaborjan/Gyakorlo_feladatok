package karakterlanc_feladatok_16_fejezet;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex_proba {

   public static void main( String args[] ) {
      // String to be scanned to find the pattern.
      String line = "This order was placed for ZT3000! OK?";
      String pattern = "[RQZ]T\\d+";

      // Create a Pattern object
      Pattern r = Pattern.compile(pattern);

      // Now create matcher object.
      Matcher m = r.matcher(line);
      if (m.find( )) {
         System.out.println("Found value: " + m.group() );
        
      }else {
         System.out.println("NO MATCH");
      }
   }
}




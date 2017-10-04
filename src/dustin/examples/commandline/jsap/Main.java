package examples.dustin.commandline.jsap;

import static com.martiansoftware.jsap.JSAP.*;

import static java.lang.System.out;

import com.martiansoftware.jsap.FlaggedOption;
import com.martiansoftware.jsap.JSAPException;
import com.martiansoftware.jsap.JSAPResult;
import com.martiansoftware.jsap.Parameter;
import com.martiansoftware.jsap.SimpleJSAP;
import com.martiansoftware.jsap.Switch;

/**
 * Demonstrates processing command line arguments from
 * Java with JSAP 2.1.
 */
public class Main
{
   public static void main(final String[] arguments)
   {
      try
      {
         final SimpleJSAP jsap = new SimpleJSAP(
            "Main Application",
            "Demonstrate JSAP",
            new Parameter[]
               {new FlaggedOption("file", STRING_PARSER, NO_DEFAULT, REQUIRED, 'f', "file", "File path/name."),
                new Switch("verbose", 'v', "verbose", "Requests verbose output." )});
         final JSAPResult parsedResult = jsap.parse(arguments);
         if (jsap.messagePrinted())
         {
            out.println(jsap.getHelp());
            System.exit( -1 );
         }

         out.println("File path/name is '" + parsedResult.getString("file") + "'.");
         out.println("Verbosity level is " + parsedResult.getBoolean("verbose"));
      }
      catch (JSAPException jsapException)
      {
         out.println("Exception encountered during parsing command line arguments - " + jsapException);
      }
   }
}

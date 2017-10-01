package examples.dustin.commandline.jclap;

import static java.lang.System.out;

import snaq.util.jclap.CLAParser;
import snaq.util.jclap.Option;
import snaq.util.jclap.OptionException;

/**
 * Demonstrates use of JCLAP 1.4 to process command-line arguments.
 */
public class Main
{
   public static void main(final String[] arguments)
   {
      final CLAParser parser = new CLAParser();
      final Option<String> fileNameOption
         = parser.addStringOption("f", "file", "Path/name of the file.", 1, 1);
      final Option<Boolean> verbosityOption
         = parser.addBooleanOption("v", "verbose", "Verbosity enabled?");
      try
      {
         parser.parse(arguments);
         out.println("File path/name is " + parser.getOptionValue(fileNameOption));
         out.println("Verbosity is " + (parser.getOptionValue(verbosityOption) != null));
      }
      catch (OptionException optionException)
      {
         out.println("Exception: " + optionException);
         parser.printUsage(out, true);
      }
   }
}

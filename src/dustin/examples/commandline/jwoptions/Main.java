package examples.dustin.commandline.jwoptions;

import static java.lang.System.out;

import static ml.options.Options.*;

import ml.options.OptionSet;
import ml.options.Options;

/**
 * Demonstrates Java-based command line arguments processing
 * with the Options class featured in the JavaWorld article
 * "Processing command line arguments in Java: Case closed"
 * (https://www.javaworld.com/article/2074849/core-java/processing-command-line-arguments-in-java--case-closed.html).
 */
public class Main
{
   public static void main(final String[] arguments)
   {
      final Options options = new Options(arguments, Multiplicity.ZERO_OR_ONE);
      final OptionSet defaultOptions = options.getSet();
      defaultOptions.addOption("f", false, Separator.BLANK, Multiplicity.ONCE);
      defaultOptions.addOption("v", Multiplicity.ZERO_OR_ONE);
      if (!options.check(false, false))
      {
         out.println("ERROR: " + options.getCheckErrors());
         System.exit(-1);
      }
      out.println("File path/name is " + defaultOptions.getOption("f").getResultValue(0));
      out.println("Verbosity is set to " + defaultOptions.isSet("v"));
   }
}

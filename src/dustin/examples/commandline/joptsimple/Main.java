package examples.dustin.commandline.joptsimple;

import static java.lang.System.out;

import joptsimple.OptionParser;
import joptsimple.OptionSet;

import java.io.IOException;
import java.util.Arrays;

/**
 * Demonstrate command-line processes in Java with JOpt Simple.
 */
public class Main
{
   /**
    * Demonstration of command-line arguments processing with JOpt Simple.
    * @param arguments Command-line arguments.
    */
   public static void main(final String[] arguments)
   {
      final OptionParser optionParser = new OptionParser();
      final String[] fileOptions = {"f", "file"};
      optionParser.acceptsAll(Arrays.asList(fileOptions), "Path and name of file.").withRequiredArg().required();
      final String[] verboseOptions = {"v", "verbose"};
      optionParser.acceptsAll(Arrays.asList(verboseOptions), "Verbose logging.");
      final String[] helpOptions = {"h", "help"};
      optionParser.acceptsAll(Arrays.asList(helpOptions), "Display help/usage information").forHelp();
      final OptionSet options = optionParser.parse(arguments);
      if (options.has("help"))
      {
         printUsage(optionParser);
      }
      else
      {
         out.println("Will write to file " + options.valueOf("file") + " and verbosity is set to " + options.has("verbose"));
      }
   }

   /**
    * Write usage/help statement out to standard output using
    * the provided instance of {@code OptionParser}.
    *
    * @param parser Instance from which usage/help information
    *    will be written to standard output; must not be {@code null}.
    */
   private static void printUsage(final OptionParser parser)
   {
      try
      {
         parser.printHelpOn(out);
      }
      catch (IOException ioEx)
      {
         out.println("ERROR: Unable to print usage - " + ioEx);
      }
   }
}

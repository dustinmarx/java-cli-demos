package examples.dustin.commandline.joptsimple;

import static java.lang.System.out;
import static java.util.Arrays.asList;

import joptsimple.OptionParser;
import joptsimple.OptionSet;

import java.io.IOException;

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
      optionParser.acceptsAll(asList("f", "file"), "Path and name of file.").withRequiredArg().required();
      optionParser.acceptsAll(asList("v", "verbose"), "Verbose logging.");
      optionParser.acceptsAll(asList("h", "help"), "Display help/usage information").forHelp();
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

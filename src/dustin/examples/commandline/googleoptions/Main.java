package examples.dustin.commandline.googleoptions;

import com.google.devtools.common.options.OptionsParser;

import static java.lang.System.out;

import java.util.Collections;

/**
 * Demonstrates use of google-options to process command-line
 * options in Java code.
 */
public class Main
{
   public static void main(final String arguments[])
   {
      final OptionsParser optionsParser = OptionsParser.newOptionsParser(Options.class);
      optionsParser.parseAndExitUponError(arguments);
      final Options options = optionsParser.getOptions(Options.class);
      if (options.filePathAndName.isEmpty())
      {
         printUsage(optionsParser);
         System.exit(-1);
      }

      out.println(
           "Path/file name is '" + options.filePathAndName
         + "' and verbosity is '" + options.verbose + "'.");
   }

   private static void printUsage(OptionsParser parser)
   {
      out.println("Usage: java Main <Options>");
      out.println(parser.describeOptions(Collections.emptyMap(),
         OptionsParser.HelpVerbosity.LONG));
   }
}

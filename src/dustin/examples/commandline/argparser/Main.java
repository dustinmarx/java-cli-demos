package examples.dustin.commandline.argparser;

import static java.lang.System.out;

import argparser.ArgParser;
import argparser.BooleanHolder;
import argparser.StringHolder;

/**
 * Demonstrates use of argparser to process command-line
 * arguments from Java.
 */
public class Main
{
   public static void main(final String[] arguments)
   {
      final StringHolder file = new StringHolder();
      final BooleanHolder verbose = new BooleanHolder();

      final ArgParser parser = new ArgParser("java examples.dustin.commandline.argparser.Main");
      parser.addOption ("-f,--file %s #Path and name of file", file);
      parser.addOption ("-v,--verbose %v #Verbosity enabled?", verbose);
      parser.matchAllArgs(arguments);
      if (file.value == null)
      {
         out.println("ERROR: File path/name was not specified! Use -f or --file to specify file path/name.\n"
            + parser.getHelpMessage());
      }
      else
      {
         out.println("File path/name is: " + file.value);
         out.println("Verbosity is: " + verbose.value);
      }
   }
}

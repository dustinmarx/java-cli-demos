package examples.dustin.commandline.argparse4j;

import static java.lang.System.out;

import net.sourceforge.argparse4j.ArgumentParsers;
import net.sourceforge.argparse4j.inf.ArgumentParser;
import net.sourceforge.argparse4j.inf.ArgumentParserException;
import net.sourceforge.argparse4j.inf.Namespace;

/**
 * Demonstrate command-line processing in Java with argparse4j.
 */
public class Main
{
   /**
    * Main function demonstrating command-line processing via argparse4j.
    *
    * @param arguments Command-line arguments.
    */
   public static void main(final String[] arguments)
   {
      final ArgumentParser argumentParser =
         ArgumentParsers.newArgumentParser("Main", true);
      argumentParser.addArgument("-f", "--file")
                    .dest("file")
                    .required(true)
                    .help("Path and name of file");
      argumentParser.addArgument("-v", "--verbose")
                    .dest("verbose")
                    .type(Boolean.class)
                    .nargs("?")
                    .setConst(true)
                    .help("Enable verbose output.");

      try
      {
         final Namespace response = argumentParser.parseArgs(arguments);
         final String filePathAndName = response.getString("file");
         final Boolean verbositySet = response.getBoolean("verbose");
         out.println(
              "Path/name of file is '" + filePathAndName
            + "' and verbosity is "
            + (Boolean.TRUE.equals(verbositySet) ? "SET" : "NOT SET")
            + ".");
      }
      catch (ArgumentParserException parserEx)
      {
         argumentParser.handleError(parserEx);
      }
   }
}

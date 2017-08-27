package examples.dustin.commandline.jargs;

import static java.lang.System.out;

import jargs.gnu.CmdLineParser;
import jargs.gnu.CmdLineParser.Option;
import jargs.gnu.CmdLineParser.Option.BooleanOption;
import jargs.gnu.CmdLineParser.IllegalOptionValueException;
import jargs.gnu.CmdLineParser.Option.StringOption;
import jargs.gnu.CmdLineParser.UnknownOptionException;

/**
 * Demonstrate parsing command line arguments in Java with JArgs.
 */
public class Main
{
   public static void main(final String[] arguments)
   {
      final CmdLineParser cmdLineParser = new CmdLineParser();
      final Option fileOption = new StringOption('f', "file");
      cmdLineParser.addOption(fileOption);
      final Option verbosityOption = new BooleanOption('v', "verbose");
      cmdLineParser.addOption(verbosityOption);
      try
      {
         cmdLineParser.parse(arguments);
         final String filePathName = cmdLineParser.getOptionValue(fileOption, "null").toString();
         if (filePathName.equals("null"))
         {
            out.println("ERROR: File path/name must be provided.");
            System.exit(-2);
         }
         out.println(
              "File path/name is " + filePathName
            + " and verbosity is " + cmdLineParser.getOptionValue(verbosityOption, false)
            + ".");
      }
      catch (IllegalOptionValueException | UnknownOptionException exception)
      {
         out.println("Unable to parse command line options - " + exception);
         System.exit(-1);
      }
   }
}

package examples.dustin.commandline.commonsjclap;

import static java.lang.System.out;

import com.extremelogic.common.jclap.Argument;
import com.extremelogic.common.jclap.exception.ArgumentException;

/**
 * Demonstrates parsing of command-line arguments from Java
 * using jClap 2.0 from Jan So (extreme_logic).
 */
public class Main
{
   public static void main(final String[] arguments)
   {
      final Argument argument = new Argument(arguments);
      argument.addArgument("file", "Path/name of file", true, 1);
      argument.addBooleanArgument("verbose", "Enables verbosity", false);
      try
      {
         argument.processArguments();
         out.println("File path/name is '" + argument.getArgument("file") + "'.");
         out.println("Verbosity is set to " + argument.getArgument("verbose"));
      }
      catch (final ArgumentException argumentException)
      {
         out.println(
              "ERROR: Exception encountered while processing command-line arguments - "
            + argumentException);
         argument.displayOptions();
      }
   }
}

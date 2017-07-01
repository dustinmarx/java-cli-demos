package examples.dustin.commandline.commandline;

import static java.lang.System.out;

import com.github.jankroken.commandline.CommandLineParser;
import com.github.jankroken.commandline.OptionStyle;
import com.github.jankroken.commandline.annotations.LongSwitch;
import com.github.jankroken.commandline.annotations.Option;
import com.github.jankroken.commandline.annotations.Required;
import com.github.jankroken.commandline.annotations.ShortSwitch;
import com.github.jankroken.commandline.annotations.SingleArgument;
import com.github.jankroken.commandline.annotations.Toggle;
import jdk.nashorn.internal.runtime.regexp.joni.constants.Arguments;

import java.lang.reflect.InvocationTargetException;

/**
 * Demonstrate use of commandline to parse command-line parameters
 * in a Java application.
 */
public class Main
{
   /** Is verbosity enabled? */
   private boolean verbose;

   /** Name/path of applicable file. */
   private String fileName;

   @Option
   @ShortSwitch("v")
   @LongSwitch("verbose")
   @Toggle(true)
   public void setVerbose(final boolean newVerbose)
   {
      verbose = newVerbose;
   }

   @Option
   @ShortSwitch("f")
   @LongSwitch("file")
   @SingleArgument
   @Required
   public void setFileName(final String newFileName)
   {
      fileName = newFileName;
   }

   public static void main(final String[] arguments)
   {
      try
      {
         final Main main = CommandLineParser.parse(Main.class, arguments, OptionStyle.LONG_OR_COMPACT);
         out.println("You provided file name of '" + main.fileName + "' and verbose is set to '" + main.verbose + "'.");
      }
      catch (IllegalAccessException | InstantiationException | InvocationTargetException exception)
      {
         out.println("ERROR: Unable to parse command-line arguments: " + exception);
      }
   }
}

package examples.dustin.commandline.jewelcli;

import static java.lang.System.out;

import com.lexicalscope.jewel.cli.CliFactory;

/**
 * Demonstrates use of JewelCli for parsing command-line
 * parameters in Java.
 */
public class Main
{
   public static void main(final String[] arguments)
   {
      final MainCommandLine main = CliFactory.parseArguments(MainCommandLine.class, arguments);
      out.println("You specified file '" + main.getFile() + "' with verbosity setting of '" + main.isVerbose() + "'.");
   }
}

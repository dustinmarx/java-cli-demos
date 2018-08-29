package examples.dustin.commandline.jbock;

import net.jbock.CommandLineArguments;
import net.jbock.Description;
import net.jbock.LongName;
import net.jbock.ShortName;

/**
 * Demonstrates use of jbock to process command-line
 * arguments in a Java application.
 */
public class Main
{

   @CommandLineArguments
   abstract static class Arguments
   {

      @ShortName('v') @LongName("verbose") @Description("Verbosity enabled?")
      abstract boolean verbose();

      @ShortName('f') @LongName("file") @Description("File name and path")
      abstract String file();
   }

   public static void main(String[] arguments)
   {
      Arguments args = Main_Arguments_Parser.create().parseOrExit(arguments);
      System.out.println("The file '" + args.file() + "' was provided and verbosity is set to '" + args.verbose() + "'."),
   }
}

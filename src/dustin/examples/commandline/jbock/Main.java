package examples.dustin.commandline.jbock;

import static java.lang.System.out;

import net.jbock.CommandLineArguments;
import net.jbock.Description;
import net.jbock.LongName;
import net.jbock.ShortName;

import java.util.Optional;

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
      Main_Arguments_Parser.parse(arguments, System.out)
        .ifPresentOrElse(args ->
              System.out.println("The file '" + args.file() + "' was provided and verbosity is set to '" + args.verbose() + "'."),
              () -> System.exit(1));
   }
}

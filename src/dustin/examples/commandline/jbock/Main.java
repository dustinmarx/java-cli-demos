package examples.dustin.commandline.jbock;

import net.jbock.CommandLineArguments;
import net.jbock.Parameter;

import java.nio.file.Path;

/**
 * Demonstrates use of jbock to process command-line
 * arguments in a Java application.
 */
public class Main
{

   @CommandLineArguments
   abstract static class Arguments
   {

      /**
       * Verbosity enabled?
       */
      @Parameter(flag = true, shortName = 'v', longName = "verbose")
      abstract boolean verbose();

      /**
       * File name and path
       */
      @Parameter(shortName = 'f', longName = "file")
      abstract Path file();
   }

   public static void main(String[] arguments)
   {
      Arguments args = Main_Arguments_Parser.create().parseOrExit(arguments);
      System.out.println("The file '" + args.file() + "' was provided and verbosity is set to '" + args.verbose() + "'.");
   }
}

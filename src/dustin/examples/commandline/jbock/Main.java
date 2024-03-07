package examples.dustin.commandline.jbock;

import java.util.Optional;
import net.jbock.Command;
import net.jbock.Option;

/**
 * Demonstrates use of jbock 5.18 to process command-line
 * arguments in a Java application.
 */
public class Main
{

   @Command
   abstract static class Arguments
   {

      /**
       * Verbosity enabled?
       */
      @Option(names = {"-v", "--verbose"})
      abstract boolean verbose();

      /**
       * File name and path
       */
      @Option(names = {"-f", "--file"})
      abstract Optional<String> file();
   }

   public static void main(String[] arguments)
   {
      Arguments args = Main_ArgumentsParser.parseOrExit(arguments);
      System.out.println("The file '" + args.file() + "' was provided and verbosity is set to '" + args.verbose() + "'.");
   }
}

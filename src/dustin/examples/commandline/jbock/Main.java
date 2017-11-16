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
   private boolean verbose;
   private String file;

   @CommandLineArguments
   abstract static class Arguments
   {

      @ShortName('v') @LongName("verbose") @Description("Verbosity enabled?")
      abstract boolean verbose();

      @ShortName('f') @LongName("file") @Description("File name and path")
      abstract Optional<String> file();
   }

   public Main(Arguments arguments)
   {
      verbose = arguments.verbose();
      file = arguments.file().orElse("");
   }

   public String getFile()
   {
      return file;
   }

   public boolean isVerbose()
   {
      return verbose;
   }

   public static void main(final String[] arguments)
   {
      if (arguments.length < 1)
      {
         Main_Arguments_Parser.printUsage(out, 3);
         System.exit(-1);
      }
      final Main main = new Main(Main_Arguments_Parser.parse(arguments));
      out.println("The file '" + main.getFile() + "' was provided and verbosity is set to '" + main.isVerbose() + "'.");
   }
}

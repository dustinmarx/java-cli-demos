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
   public Main(
      @ShortName('v') @LongName("verbose") @Description("Verbosity enabled?")
      final boolean newVerbose,
      @ShortName('f') @LongName("file") @Description("File name and path")
      final Optional<String> newFileName)
   {
      verbose = newVerbose;
      file = newFileName.orElse("");
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
         Main_Parser.printUsage(out, 3);
         System.exit(-1);
      }
      final Main_Parser.Binder binder = Main_Parser.parse(arguments);
      final Main main = binder.bind();
      out.println("The file '" + main.getFile() + "' was provided and verbosity is set to '" + main.isVerbose() + "'.");
   }
}

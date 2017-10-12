package examples.dustin.commandline.airline;

import static java.lang.System.out;

import com.github.rvesse.airline.SingleCommand;
import com.github.rvesse.airline.annotations.Command;
import com.github.rvesse.airline.annotations.Option;
//import com.github.rvesse.airline.help.cli.CliCommandUsageGenerator;
//import com.github.rvesse.airline.model.CommandMetadata;
//import com.github.rvesse.airline.parser.ParseResult;

//import java.io.IOException;

/**
 * Demonstrate parsing command-line arguments from Java
 * using Airline 2.3.0.
 */
@Command(name="DemonstratingAirline", description="Demonstrates Airline 2")
public class Main
{
   @Option(title="file", name={"-f", "--file"}, description="Path and name of file.")
   private String file;

   @Option(title="verbose", name={"-v", "--verbose"}, description="Enable or disable verbosity.")
   private boolean verbose;

   public static void main(final String[] arguments)
   {
      final SingleCommand<Main> parser = SingleCommand.singleCommand(Main.class);
      /*
      // Seeing error message when trying to compile this:
      // "class file for com.github.rvesse.airline.io.printers.UsagePrinter not found"
      if (arguments.length < 1)
      {
         final CommandMetadata commandMetadata = parser.getCommandMetadata();
         CliCommandUsageGenerator usageGenerator = new CliCommandUsageGenerator();
         usageGenerator.usage("Main", new String[0],"Main", commandMetadata, null, out);
      }*/
      final Main main = parser.parse(arguments);
      if (main.file != null)
      {
         out.println("File path/name is '" + main.file + "'.");
         out.println("Verbosity is " + main.verbose);
      }
      else
      {
         out.println("ERROR: File path/name must be provided with -f or --file.");
      }
   }
}

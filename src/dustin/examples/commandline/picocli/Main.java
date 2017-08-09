package examples.dustin.commandline.picocli;

import static java.lang.System.out;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

/**
 * Demonstrate Java-based command-line processing with picocli.
 */
@Command(
   name="Main",
   description="@|bold Demonstrating picocli @|",
   headerHeading="@|bold,underline Demonstration Usage|@:%n%n")
public class Main
{
   @Option(names={"-v", "--verbose"}, description="Verbose output?")
   private boolean verbose;

   @Option(names={"-f", "--file"}, description="Path and name of file", required=true)
   private String fileName;

   @Option(names={"-h", "--help"}, description="Display help/usage.", help=true)
   boolean help;

   public static void main(final String[] arguments)
   {
      final Main main = CommandLine.populateCommand(new Main(), arguments);
      if (main.help)
      {
         CommandLine.usage(main, out, CommandLine.Help.Ansi.AUTO);
      }
      else
      {
         out.println("The provided file path and name is " + main.fileName + " and verbosity is set to " + main.verbose);
      }
   }
}

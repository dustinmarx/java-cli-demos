package examples.dustin.commandline.jcommander;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;

import static java.lang.System.out;

/**
 * Demonstrates use of JCommander for Java-based command-line processing.
 */
public class Main
{
   @Parameter(names={"-v","--verbose"},
              description="Enable verbose logging")
   private boolean verbose;

   @Parameter(names={"-f","--file"},
              description="Path and name of file to use",
              required=true)
   private String file;

   @Parameter(names={"-h", "--help"},
              description="Help/Usage",
              help=true)
   private boolean help;

   /**
    * Use JCommander to process the provided command-line arguments.
    * This method is an instance method (not static) to allow JCommander
    * to use this instance's JCommander-annotated fields.
    *
    * @param arguments Command-line arguments.
    */
   private void processCommandLineArguments(final String[] arguments)
   {
      final JCommander commander
         = JCommander.newBuilder()
         .programName("JCommander Demonstration")
         .addObject(this)
         .verbose(1)
         .build();
      commander.parse(arguments);
      if (help)
      {
         commander.usage();
      }
      else
      {
         out.println("The file name provided is '" + file + "' and verbosity is set to " + verbose);
      }
   }

   /**
    * Main executable function to demonstrate JCommander-based command-line processing.
    *
    * @param arguments Command-line arguments.
    */
   public static void main(final String[] arguments)
   {
      new Main().processCommandLineArguments(arguments);
   }
}

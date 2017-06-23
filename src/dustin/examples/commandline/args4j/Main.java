package examples.dustin.commandline.args4j;

import static java.lang.System.out;

import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;

import java.io.IOException;

/**
 * Demonstrate args4j.
 */
public class Main
{
   @Option(name="-v", aliases="--verbose", usage="Print verbose status.")
   private boolean verbose;

   @Option(name="-f", aliases="--file", usage="Fully qualified path and name of file.", required=true)
   private String fileName;

   private void doMain(final String[] arguments) throws IOException
   {
      final CmdLineParser parser = new CmdLineParser(this);
      if (arguments.length < 1)
      {
         parser.printUsage(out);
         System.exit(-1);
      }
      try
      {
         parser.parseArgument(arguments);
      }
      catch (CmdLineException clEx)
      {
         out.println("ERROR: Unable to parse command-line options: " + clEx);
      }
      out.println("The file '" + fileName + "' was provided and verbosity is set to '" + verbose + "'.");
   }

   /**
    * Executable function demonstrating Args4j command-line processing.
    *
    * @param arguments Command-line arguments to be processed with Args4j.
    */
   public static void main(final String[] arguments)
   {
      final Main instance = new Main();
      try
      {
         instance.doMain(arguments);
      }
      catch (IOException ioEx)
      {
         out.println("ERROR: I/O Exception encountered: " + ioEx);
      }
   }
}

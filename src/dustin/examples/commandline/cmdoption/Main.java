package examples.dustin.commandline.cmdoption;

import static java.lang.System.out;

import de.tototec.cmdoption.CmdOption;
import de.tototec.cmdoption.CmdlineParser;

/**
 * Demonstrate use of CmdOption to parse command-line arguments
 * in Java.
 */
public class Main
{
   @CmdOption(names={"--file","-f"}, description="File Path/Name", minCount=1, args={"filePathAndName"})
   private String file;

   @CmdOption(names={"--verbose","-v"}, description="Is verbosity enabled?", maxCount=0)
   private boolean verbose;

   @CmdOption(names={"--help", "-h"}, description = "Display this help message", isHelp=true)
   private boolean help;

   public static void main(final String[] arguments)
   {
      final Main instance = new Main();
      final CmdlineParser parser = new CmdlineParser(instance);
      parser.parse(arguments);
      if (!instance.help)
      {
         out.println("File path/name is '" + instance.file + "'.");
         out.println("Verbosity level is " + instance.verbose);
      }
      else
      {
         parser.usage(out);
      }
   }
}

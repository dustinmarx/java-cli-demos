package examples.dustin.commandline.cmdln;

import static java.lang.System.out;

import com.Ostermiller.util.CmdLn;
import com.Ostermiller.util.CmdLnOption;

/**
 * Demonstrates use of OstermillerUtils CmdLn for processing
 * command-line arguments in Java.
 */
public class Main
{
   public static void main(final String[] arguments)
   {
      final CmdLn cmdLn
         = new CmdLn(arguments).setDescription("Demonstrates CmdLn")
            .addOptions(new CmdLnOption[]{
               new CmdLnOption("help",'h'),
               new CmdLnOption("file",'f')
                  .setRequiredArgument()
                  .setArgumentBounds(1, 1)
                  .setDescription("Path and name of file"),
               new CmdLnOption("verbose", 'v')
                  .setOptionalArgument()
                  .setArgumentBounds(0, 0)
                  .setDescription("Enable verbosity")
            });

      if(cmdLn.getResult('h') != null)
      {
         cmdLn.printHelp();
         System.exit(0);
      }

      String fileName = null;
      if(cmdLn.getResult('f') != null)
      {
         fileName = cmdLn.getResult('f').getArgument();
      }
      else
      {
         out.println("Required parameter -f|--file not provided.\n" + cmdLn.getHelp());
         System.exit(-1);
      }

      boolean verbose = false;
      if (cmdLn.getResult('v') != null)
      {
         verbose = true;
      }
      out.println("File path/name is " + fileName + " and verbosity is set to " + verbose);
   }
}

package examples.dustin.commandline.jcommando;

import org.jcommando.ParseException;

import static java.lang.System.out;

/**
 * Demonstrates JCommando-based parsing of command-line
 * arguments from Java code.
 *
 * The {@code MainParser} class I extend is generated from
 * XML definition of options by JCommando.
 */
public class Main extends MainParser
{
   private String file;
   private boolean verbose;

   @Override
   public void setFile(final String newFilePathAndName)
   {
      file = newFilePathAndName;
   }

   @Override
   public void setVerbose()
   {
      verbose = true;
   }

   public static void main(final String[] arguments)
   {
      final Main instance = new Main();
      try
      {
         instance.parse(arguments);
      }
      catch (ParseException parseEx)
      {
         out.println("ERROR: " + parseEx);
         instance.printUsage();
      }
   }

   /**
    * Called by parser to execute the 'command'.
    */
   public void doExecute()
   {
      out.println("File path/name is " + file + " and verbosity is " + verbose);
   }
}

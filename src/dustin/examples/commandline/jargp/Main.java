package examples.dustin.commandline.jargp;

import org.jargp.ArgumentProcessor;
import org.jargp.BoolDef;
import org.jargp.ParameterDef;
import org.jargp.StringDef;

import static java.lang.System.out;

/**
 * Demonstrate Java-based command-line arguments
 * processing with JArgp.
 */
public class Main
{
   private static final ParameterDef[] PARAMETERS_DEFINITIONS =
   {
      new StringDef('f', "file", "File path and name"),
      new BoolDef('v', "verbose", "Verbosity level")
   };

   /** Will be populated by -f argument's value. */
   private String file;
   /** Will be populated by -v argument if specified. */
   private boolean verbose = false;

   /**
    * Demonstrates use of JArgp's static function
    * ArgumentProcessor.processArgs.
    *
    * @param arguments Command-line arguments.
    * @return Instance of me with fields populated by command-line
    *    arguments processing.
    */
   private static Main useStaticParsing(final String[] arguments)
   {
      final Main instance = new Main();
      // The integer returned by the next invocation is actually the
      // zero-based index of next argument to be processed
      final int numberArgumentsProcessed
         = ArgumentProcessor.processArgs(
         arguments, PARAMETERS_DEFINITIONS, instance);
      return instance;
   }

   /**
    * Demonstrates use of JArgp's instance method
    * ArgumentProcessor.processArgs.
    *
    * @param arguments Command-line arguments.
    * @return Instance of me with fields populated by command-line
    *    arguments processing.
    */
   private static Main useInstanceParsing(final String[] arguments)
   {
      final Main instance = new Main();
      final ArgumentProcessor argumentProcessor
         = new ArgumentProcessor(PARAMETERS_DEFINITIONS);
      argumentProcessor.processArgs(arguments, instance);
      argumentProcessor.listParameters(50, out);
      return instance;
   }

   public static void main(final String[] arguments)
   {
      if (arguments.length < 1)
      {
         out.println("ERROR: No arguments provided.");
         System.exit(-1);
      }

      final Main instance1 = useStaticParsing(arguments);
      out.println("File path/name is " + instance1.file + " and verbosity is " + instance1.verbose);
      final Main instance2 = useInstanceParsing(arguments);
      out.println("File path/name is " + instance2.file + " and verbosity is " + instance2.verbose);
   }
}

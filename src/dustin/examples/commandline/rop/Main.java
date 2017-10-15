package examples.dustin.commandline.rop;

import static java.lang.System.out;

import com.github.ryenus.rop.OptionParser;
import com.github.ryenus.rop.OptionParser.Command;
import com.github.ryenus.rop.OptionParser.Option;

/**
 * Demonstrates use of Rop for processing command line
 * parameters in Java.
 */
@Command(name="RopDemo", descriptions="Demonstrates ROP for command line processing.")
public class Main
{
   @Option(opt={"-f", "--file"}, description="Path and name of file.", required=true)
   private String file;

   @Option(opt={"-v", "--verbose"}, description="Indicates whether verbosity is enabled or not.")
   private boolean verbose;

   /**
    * Method called implicitly by Rop parser.
    *
    * @param parser Instance of {@code OptionParser} whose
    *    "parse" method led to my implicit invocation.
    */
   private void run(final OptionParser parser)
   {
      out.println("File path/name is " + file + " and verbosity is " + verbose);
//      displayStack();
   }

   /**
    * Displays the stack. Used in this demonstration to show that the
    * Rop-provided parser implicitly invokes the "run" method.
    */
   private void displayStack()
   {
      final StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
      final int numberOfElements = stackTrace.length;
      final String className = stackTrace[2].getClassName();
      final String methodName = stackTrace[2].getMethodName();
      out.println("\n\nStack of the " + className + "." + methodName + " method: ");
      for (int index = 2; index<numberOfElements; index++)
      {
         out.println("\t" + stackTrace[index]);
      }
   }

   public static void main(final String[] arguments)
   {
      final OptionParser parser = new OptionParser(Main.class);
      parser.parse(arguments);
   }
}

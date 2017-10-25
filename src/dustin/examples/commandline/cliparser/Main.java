package examples.dustin.commandline.cliparser;

import static java.lang.System.out;

import com.sampullara.cli.Args;
import com.sampullara.cli.Argument;

import java.util.List;

/**
 * Demonstrate use of CLI Parser (cli-parser) to parse
 * command-line arguments from Java.
 */
public class Main
{
   @Argument(alias="f", description="Path/name of the file", required=true)
   private String file;

   @Argument(alias="v", description="Verbosity enabled?")
   private boolean verbose;

   public static void main(final String[] arguments)
   {
      final Main instance = new Main();
      final List<String> unparsed = Args.parseOrExit(instance, arguments);
      if (!unparsed.isEmpty())
      {
         out.println("Unparsed arguments: " + unparsed);
      }
      out.println("File path/name is '" + instance.file + "' and verbosity is " + instance.verbose);
   }
}

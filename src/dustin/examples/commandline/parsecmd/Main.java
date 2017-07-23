package examples.dustin.commandline.parsecmd;

import static java.lang.System.out;

import ca.zmatrix.cli.ParseCmd;

import java.util.Map;

/**
 * Demonstrate use of parse-cmd to process command line arguments in Java.
 */
public class Main
{
   /** String displayed where there is a problem processing arguments. */
   private final static String USAGE =
      "java examples.dustin.commandline.parsecmd.Main --file <filePathAndName> [--verbose 1]";

   /**
    * Demonstrate use of parse-cmd to process the provided command-line
    * arguments contained in the "arguments" parameter.
    *
    * @param arguments Command-line arguments to be processed.
    */
   public static void main(final String[] arguments)
   {
      final ParseCmd parseCmd
         = new ParseCmd.Builder().parm("--file", "")
                                 .req()
                                 .parm("--verbose", "0")
                                 .help(USAGE)
                                 .build();
      final String errorString = parseCmd.validate(arguments);
      if (!errorString.isEmpty())
      {
         out.println("ERROR: " + errorString);
      }
      else
      {
         final Map<String, String> parsedArguments = parseCmd.parse(arguments);
         final String filePathAndName = parsedArguments.get("--file");
            out.println("The path/name of the file is '" + filePathAndName
               + "' and verbosity is set to '" + parsedArguments.get("--verbose") + "'.");
      }
   }
}

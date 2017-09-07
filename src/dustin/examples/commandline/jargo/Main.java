package examples.dustin.commandline.jargo;

import static java.lang.System.out;

import static se.softhouse.jargo.Arguments.*;

import se.softhouse.jargo.Argument;
import se.softhouse.jargo.ArgumentException;
import se.softhouse.jargo.CommandLineParser;
import se.softhouse.jargo.ParsedArguments;

/**
 * Demonstrates use of jargo to process command line options in Java.
 */
public class Main
{
   public static void main(final String[] arguments)
   {
      final Argument<?> helpArgument
         = helpArgument("--help", "-h");
      final Argument<String> filePathAndName
         = stringArgument().description("Path and name of file.")
                           .names("--file", "-f")
                           .required()
                           .build();
      // Use optionArgument() instead of booleanArgument() to avoid need
      // to specify true or false as arguments to --verbose/-v option
      final Argument<Boolean> verbose
         = optionArgument("--verbose", "-v")
                           .description("Enables verbosity.")
                           .names("--verbose", "-v")
                           .defaultValue(false)
                           .build();
      try
      {
         final ParsedArguments parsedArguments
            = CommandLineParser.withArguments(filePathAndName, verbose)
            .andArguments(helpArgument)
            .parse(arguments);

         out.println("File path/name is '" + parsedArguments.get(filePathAndName)
            + "' and verbosity is set to '" + parsedArguments.get(verbose) + "'.");
      }
      catch (ArgumentException argsEx)
      {
         out.println(argsEx.getMessageAndUsage());
      }
   }
}

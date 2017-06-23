package examples.dustin.commandline.cli;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import java.io.PrintWriter;
import java.util.Arrays;

import static java.lang.System.out;

/**
 * Demonstrate Apache Commons CLI using Option.builder.
 */
public class MainWithBuilder
{
   private final static String VERBOSE_OPTION = "verbose";
   private final static String FILE_OPTION = "file";

   /**
    * Executable function to demonstrate Apache Commons CLI
    * parsing of command-line arguments.
    *
    * @param arguments Command-line arguments to be parsed.
    */
   public static void main(final String[] arguments)
   {
      final Options options = generateOptions();

      if (arguments.length < 1)
      {
         printUsage(options);
         printHelp(options);
         System.exit(-1);
      }

      final CommandLine commandLine = generateCommandLine(options, arguments);

      // "interrogation" stage of processing with Apache Commons CLI
      if (commandLine != null)
      {
         final boolean verbose =
            commandLine.hasOption(VERBOSE_OPTION);
         final String fileName =
            commandLine.getOptionValue(FILE_OPTION);
         out.println("The file '" + fileName + "' was provided and verbosity is set to '" + verbose + "'.");
      }
   }

   /**
    * "Definition" stage of command-line parsing with Apache Commons CLI.
    * @return Definition of command-line options.
    */
   private static Options generateOptions()
   {
      final Option verboseOption = Option.builder("v")
         .required(false)
         .hasArg(false)
         .longOpt(VERBOSE_OPTION)
         .desc("Print status with verbosity.")
         .build();
      final Option fileOption = Option.builder("f")
         .required()
         .longOpt(FILE_OPTION)
         .hasArg()
         .desc("File to be processed.")
         .build();
      final Options options = new Options();
      options.addOption(verboseOption);
      options.addOption(fileOption);
      return options;
   }

   /**
    * "Parsing" stage of command-line processing demonstrated with
    * Apache Commons CLI.
    *
    * @param options Options from "definition" stage.
    * @param commandLineArguments Command-line arguments provided to application.
    * @return Instance of CommandLine as parsed from the provided Options and
    *    command line arguments; may be {@code null} if there is an exception
    *    encountered while attempting to parse the command line options.
    */
   private static CommandLine generateCommandLine(
      final Options options, final String[] commandLineArguments)
   {
      final CommandLineParser cmdLineParser = new DefaultParser();
      CommandLine commandLine = null;
      try
      {
         commandLine = cmdLineParser.parse(options, commandLineArguments);
      }
      catch (ParseException parseException)
      {
         out.println(
              "ERROR: Unable to parse command-line arguments "
            + Arrays.toString(commandLineArguments) + " due to: "
            + parseException);
      }
      return commandLine;
   }

   /**
    * Generate usage information with Apache Commons CLI.
    *
    * @param options Instance of Options to be used to prepare
    *    usage formatter.
    * @return HelpFormatter instance that can be used to print
    *    usage information.
    */
   private static void printUsage(final Options options)
   {
      final HelpFormatter formatter = new HelpFormatter();
      final String syntax = "Main";
      out.println("\n=====");
      out.println("USAGE");
      out.println("=====");
      final PrintWriter pw  = new PrintWriter(out);
      formatter.printUsage(pw, 80, syntax, options);
      pw.flush();
   }

   /**
    * Generate help information with Apache Commons CLI.
    *
    * @param options Instance of Options to be used to prepare
    *    help formatter.
    * @return HelpFormatter instance that can be used to print
    *    help information.
    */
   private static void printHelp(final Options options)
   {
      final HelpFormatter formatter = new HelpFormatter();
      final String syntax = "Main";
      final String usageHeader = "Example of Using Apache Commons CLI";
      final String usageFooter = "See http://marxsoftware.blogspot.com/ for further details.";
      out.println("\n====");
      out.println("HELP");
      out.println("====");
      formatter.printHelp(syntax, usageHeader, options, usageFooter);
   }
}

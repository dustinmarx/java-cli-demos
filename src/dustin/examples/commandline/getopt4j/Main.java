package examples.dustin.commandline.getopt4j;

import static java.lang.System.out;

import org.realityforge.getopt4j.CLArgsParser;
import org.realityforge.getopt4j.CLOption;
import org.realityforge.getopt4j.CLOptionDescriptor;
import org.realityforge.getopt4j.CLUtil;

import java.util.List;

/**
 * Demonstrate using getopt4j to parse command line
 * arguments in Java.
 */
public class Main
{
   public static void main(final String[] arguments)
   {
      final CLOptionDescriptor fileDescriptor
         = new CLOptionDescriptor("file",
            CLOptionDescriptor.ARGUMENT_REQUIRED,
            'f',
            "Path and name of file.");
      final CLOptionDescriptor verboseDescriptor
         = new CLOptionDescriptor("verbose",
            CLOptionDescriptor.ARGUMENT_DISALLOWED,
            'v',
            "Is verbosity enabled?");
      final CLOptionDescriptor[] optionsDefinitions
         = new CLOptionDescriptor[]{fileDescriptor, verboseDescriptor};
      final CLArgsParser parser = new CLArgsParser(arguments, optionsDefinitions);
      if (parser.getErrorString() != null)
      {
         out.println("ERROR : " + parser.getErrorString());
      }
      else
      {
         String filePathAndName = null;
         boolean verbose = false;
         final List<CLOption> options = parser.getArguments();
         for (final CLOption option : options)
         {
            switch(option.getId())
            {
               case 'f' :
                  filePathAndName = option.getArgument();
                  break;
               case 'v' :
                  verbose = true;
                  break;
            }
         }
         if (filePathAndName == null)
         {
            out.println("ERROR: The file path/name option is required but was not provided.\n\n"
               + CLUtil.describeOptions(optionsDefinitions));
         }
         else
         {
            out.println("File path/name is '" + filePathAndName + "' and verbosity is " + verbose);
         }
      }
   }
}

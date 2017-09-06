package examples.dustin.commandline.googleoptions;

import com.google.devtools.common.options.Option;
import com.google.devtools.common.options.OptionsBase;

/**
 * Represents command-line options to be processed via
 * google-options library. Fields must be annotated with
 * @Option and must be public.
 */
public class Options extends OptionsBase
{
   @Option(name="file",
           abbrev='f',
           help="Path and name of file",
           category="Startup",
           defaultValue="")
   public String filePathAndName;

   @Option(name="verbose",
           abbrev='v',
           help="Enable verbose output",
           category="Startup",
           defaultValue="false")
   public boolean verbose;
}

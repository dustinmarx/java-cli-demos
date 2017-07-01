package examples.dustin.commandline.jewelcli;

import com.lexicalscope.jewel.cli.Option;

/**
 * Interface defining JewelCli-friendly command-line parameters.
 */
public interface MainCommandLine
{
   @Option(shortName="f", description="Name and path of file to be used.")
   String getFile();

   @Option(shortName="v", description="Indicate whether status should be reported verbosely.")
   boolean isVerbose();

   @Option(helpRequest=true, description="Usage details on command-line arguments.")
   boolean getHelp();
}

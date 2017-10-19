/*
 * THIS IS A GENERATED FILE.  DO NOT EDIT.
 *
 * JCommando (http://jcommando.sourceforge.net)
 */

package examples.dustin.commandline.jcommando;

import org.jcommando.Command;
import org.jcommando.JCommandParser;
import org.jcommando.Option;
import org.jcommando.Grouping;
import org.jcommando.And;
import org.jcommando.Or;
import org.jcommando.Xor;
import org.jcommando.Not;

/**
 * JCommando generated parser class.
 */
public abstract class MainParser extends JCommandParser
{
   /**
     * JCommando generated constructor.
     */
   public MainParser()
   {
      Option file = new Option();
      file.setId("file");
      file.setShortMnemonic("f");
      file.setLongMnemonic("file");
      file.setDescription("Path and name of file");
      file.setOptionType("String");
      addOption(file);

      Option verbose = new Option();
      verbose.setId("verbose");
      verbose.setShortMnemonic("v");
      verbose.setLongMnemonic("verbose");
      verbose.setDescription("Verbosity enabled");
      addOption(verbose);

      Command execute = new Command();
      execute.setName("commandless");
      execute.setId("execute");
      execute.addOption(file);
      execute.setGrouping( createExecuteGrouping() );
      addCommand(execute);

   }

   /**
     * Called by parser to set the 'file' property.
     *
     * @param file the value to set.
     */
   public abstract void setFile(String file);

   /**
     * Called by parser to set the 'verbose' property.
     *
     */
   public abstract void setVerbose();

   /**
     * Called by parser to perform the 'execute' command.
     *
     */
   public abstract void doExecute();

   /**
    * Generate the grouping for the 'execute' command.
    */
   private Grouping createExecuteGrouping()
   {
      Or or1 = new Or();
      or1.addOption(getOptionById("file"));
      return or1;
   }
}

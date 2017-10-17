package examples.dustin.commandline.markutils;

import static java.lang.System.out;

import com.ziesemer.utils.cli.CliRunner;
import com.ziesemer.utils.cli.Parameter;
import org.apache.commons.cli.DefaultParser;

import java.util.concurrent.Callable;

/**
 * Demonstrates parsing command-line options in Java
 * using MarkUtils-CLI.
 */
public class Main implements Callable<Integer>
{
   @Parameter(name="f", longName="file", description="Path/name of file", required=true)
   public String file;

   @Parameter(name="v", longName="verbose", description="Verbosity enabled or not", argCount=0)
   public boolean verbose;

   public static void main(final String[] arguments)
   {
      final DefaultParser cmdLineParser = new DefaultParser();
      final CliRunner<Main> cliRunner = new CliRunner(cmdLineParser, Main.class);
      final Main instance = new Main();
      cliRunner.run(instance, instance, arguments);
   }

   @Override
   public Integer call() throws Exception
   {
      out.println("File path/name is '" + file + "' and verbosity is " + verbose);
      return file != null ? 0 : -1;
   }
}

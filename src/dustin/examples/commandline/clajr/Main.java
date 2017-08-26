package examples.dustin.commandline.clajr;

import static java.lang.System.out;

import clajr.CLAJR;

/**
 * Demonstrate use of CLAJR to process command-line arguments in Java.
 */
public class Main
{
   public static void main(final String[] arguments)
   {
      final Options options = new Options();
      try
      {
         CLAJR.parse(arguments, options);
         out.println("File is '" + options.getFile() + "' and verbosity is set to '"
            + options.isVerbose() + "'.");
      }
      catch (CLAJR.EmptyArgumentListException emptyArgsEx)
      {
         out.println("Usage: Main -f|--file <filePathAndName> [-v|--verbose]");
      }
      catch (CLAJR.HelpNeededException helpNeededEx)
      {
         System.out.println(CLAJR.getHelp());
      }
      catch (CLAJR.ParseException parseEx)
      {
         out.println(parseEx.getMessage());
         out.println(CLAJR.getHelp());
      }
      catch (Throwable throwable)  // CLAJR.parse throws Throwable
      {
         out.println(throwable.getMessage());
      }
   }

   /**
    * Used reflectively by CLAJR to parse and interrogate command line
    * options defined as fields in this class.
    */
   public static class Options
   {
      private String file;
      private boolean verbose;

      public void _v__verbose()
      {
         verbose = true;
      }

      public String help_v__verbose()
      {
         return "Enables verbosity of output.";
      }

      public boolean isVerbose()
      {
         return verbose;
      }

      public void _f__file(String newFilePathAndName)
      {
         file = newFilePathAndName;
      }

      public String help_f__file()
      {
         return "Path and name of file.";
      }

      public String getFile()
      {
         return file;
      }
   }
}

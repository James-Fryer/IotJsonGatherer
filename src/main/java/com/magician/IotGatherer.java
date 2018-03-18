package com.magician;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class IotGatherer
{
  private IotGatherer(final String fileName)
    {

      final Properties properties = new Properties();
      try (final FileReader reader = new FileReader(fileName))
      {
        properties.load(reader);
        final Set<Object> classList = properties.keySet();

        if (!classList.isEmpty())
        {
          final int classCount = classList.size();
          final ExecutorService executor = Executors.newFixedThreadPool(classCount);
          final List<Callable<Object>> callableList = new ArrayList<>(classCount);

          for (final String className : properties.stringPropertyNames()) {
            if (null != className && !className.startsWith("#")) {
              final String urlEntry = (String) properties.get(className);
              if (null != urlEntry) {
                callableList.add(new ParserCallable(className, urlEntry));
              } else {
                System.out.println("expected URL is null");
              }
            } else {
              System.out.println("expected className is null");
            }
          }

          System.out.println("invokingAll");
          executor.invokeAll(callableList);
          System.out.println("End of invoke");

        }
      }
      catch (IOException | InterruptedException e)
      {
        e.printStackTrace();
      }
    }

    public static void main(String[] args) {
        new IotGatherer(args.length == 0 ? "location.conf" : args[0]);
      System.out.println("END");
      System.exit(0);
    }

}

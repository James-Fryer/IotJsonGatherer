/*
 * Developed by Thales Australia, 2017
 */
package com.magician;

import com.magician.parsers.LocalParser;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadLocalRandom;

final class ParserCallable implements Callable<Object>
{

  private static final String COM_MAGICIAN_PARSERS = "com.magician.parsers.";

  private final String className;
  private final String urlEntry;

  ParserCallable(final String className, final String urlEntry)
  {
    this.className = className;
    this.urlEntry = urlEntry;
  }

  @Override
  public String call() {
    try {
//      Thread.sleep(ThreadLocalRandom.current().nextInt(7000));
      final String parserName = COM_MAGICIAN_PARSERS + className;
      final Constructor<?> constructor = Class.forName(parserName).getDeclaredConstructor(String.class);
      constructor.setAccessible(true);
      ((LocalParser) constructor.newInstance(urlEntry)).parse();

    } catch (ClassNotFoundException e) {
      System.out.println("Unable to find : " + COM_MAGICIAN_PARSERS + className);
    } catch (NoSuchMethodException e) {
      System.out.println("Unable to find constructor for : " + COM_MAGICIAN_PARSERS + className);
    }
    catch (IllegalAccessException | InstantiationException | InvocationTargetException e)
    {
      System.out.println("Unable to create a new instance of : " + COM_MAGICIAN_PARSERS + className);
    }
//    catch (InterruptedException e)
//    {
//      e.printStackTrace();
//    }
    return "Complete";
  }
}
/*
 * Developed by Thales Australia, 2017
 */
package com.magician.parsers;

class MinutParser extends LocalParser
{

  MinutParser(String stream)
  {
    super(stream);
  }

  @Override
  public void parse()
  {
    System.out.println("stream = " + stream);
  }
}
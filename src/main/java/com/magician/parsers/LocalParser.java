/*
 * Developed by Thales Australia, 2017
 */
package com.magician.parsers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

abstract public class LocalParser
{

  final String stream;

  LocalParser(String stream) {
    this.stream = stream;
  }

  abstract public void parse();

  static String readUrl(final String urlString) throws Exception {
    BufferedReader reader = null;
    try {
      final URL url = new URL(urlString);
      reader = new BufferedReader(new InputStreamReader(url.openStream()));
      final StringBuilder buffer = new StringBuilder();
      int read;
      final char[] chars = new char[1024];
      while ((read = reader.read(chars)) != -1) {
        buffer.append(chars, 0, read);
      }
      return buffer.toString();
    } finally {
      if (reader != null)
        reader.close();
    }
  }
}
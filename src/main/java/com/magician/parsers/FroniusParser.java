/*
 * Developed by Thales Australia, 2017
 */
package com.magician.parsers;

import org.json.JSONObject;
import org.json.JSONTokener;

import java.util.Iterator;

class FroniusParser extends LocalParser

{
  FroniusParser(String stream)
  {
    super(stream);
  }

  public void parse() {
    try {
      final String json = readUrl(stream);

      JSONTokener tokener = new JSONTokener(json);

      JSONObject body = new JSONObject(tokener).getJSONObject("Body");
      JSONObject data = body.getJSONObject("Data");
      JSONObject details = body.getJSONObject("Details");

      data.get


      for (Iterator<String> it = data.keys(); it.hasNext(); ) {
        String key = it.next();
        System.out.println(key);
      }
      //Page page = gson.fromJson(json, Page.class);

    } catch (Exception e) {
      System.out.println("unable to read : " + stream);
    }
  }

  private class FroniusData {
    double PowerApparent_S_Phase_1;
    double PowerApparent_S_Sum;
    int EnergyReactive_VArAC_Sum_Consumed;
    int EnergyReal_WAC_Phase_1_Consumed;
    double PowerFactor_Phase_1;
//    EnergyReal_WAC_Sum_Produced
//    PowerReactive_Q_Sum
//            PowerFactor_Sum
//    Visible
//            Enable
//    EnergyReactive_VArAC_Phase_1_Consumed
//            PowerReal_P_Sum
//    EnergyReal_WAC_Minus_Absolute
//            EnergyReal_WAC_Phase_1_Produced
//    PowerReactive_Q_Phase_1
//            PowerReal_P_Phase_1
//    Current_AC_Phase_1
//            TimeStamp
//    EnergyReactive_VArAC_Phase_1_Produced
//            Details
//    EnergyReal_WAC_Plus_Absolute
//            Frequency_Phase_Average
//    Current_AC_Sum
//            EnergyReactive_VArAC_Sum_Produced
//    EnergyReal_WAC_Sum_Consumed
//            Voltage_AC_Phase_1
//    Meter_Location_Current
  }
}
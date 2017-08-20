package com.andermaco.challenge.view.common.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static android.text.TextUtils.isEmpty;

/**
 * Created by andermaco@gmail.com on 3/08/17.
 */

/**
 * Define and old way of getting address subfields.
 */
@Deprecated
public class AndroidStopsManager implements StopsManager {


    @Override
    public String getAddressDirection(String address) {
     if (isEmpty(address) || isEmpty(",")) {
          return address;
      }
      int pos = address.lastIndexOf(",");
      if (pos == -1) {
          return address;
      }
      return address.substring(0, pos);
    }

    @Override
    public String getAddressNumber(String address) {
        if (isEmpty(address) || isEmpty(",")) {
          return address;
        }
        Pattern p = Pattern.compile(".*,\\s*(.*)");
        Matcher m = p.matcher(address);
        if (m.find()) {
            return (m.group(1));
        } else {
            return "";
        }
    }

    private final static long future_time_to_1h = 1000*3600;
    @Override
    public String getStartAtIn1h() {
        Date future_date = new Date(Calendar.getInstance().getTime().getTime()*future_time_to_1h);
        return new SimpleDateFormat("yyyy-MM-dd HH:mm").format(future_date);
    }
}

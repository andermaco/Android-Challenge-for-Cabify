package com.andermaco.challenge.common.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by andermaco@gmail.com on 3/08/17.
 */

public class AddressUtils {
    public static String getAnddressNumber(String address) {
        Pattern p = Pattern.compile(".*,\\s*(.*)");
        Matcher m = p.matcher(address);
        if (m.find()) {
            return (m.group(1));
        } else {
            return "";
        }
    }

}

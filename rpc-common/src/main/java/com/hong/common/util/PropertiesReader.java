package com.hong.common.util;

import java.io.UnsupportedEncodingException;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author wanghong
 * @date 2019/06/14 22:48
 * properties属性文件读取器
 **/
public class PropertiesReader {

    private ResourceBundle resourceBundle;

    public PropertiesReader(String propertiesHolder) {
        this.resourceBundle = ResourceBundle.getBundle(propertiesHolder, Locale.getDefault());
    }

    public String getLabel(String key) {
        String label;
        try {
            label = new String(resourceBundle.getString(key).getBytes("ISO-8859-1"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        return label;
    }
}

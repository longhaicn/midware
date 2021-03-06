package com.poly.midware.utils.driver;

import com.google.common.base.CaseFormat;
import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.scripting.LanguageDriver;
import org.apache.ibatis.scripting.xmltags.XMLLanguageDriver;
import org.apache.ibatis.session.Configuration;

import java.lang.reflect.Field;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SimpleUpdateLangDriver extends XMLLanguageDriver implements LanguageDriver {

    private final Pattern inPattern = Pattern.compile("\\(#\\{(\\w+)\\}\\)");

    @Override
    public SqlSource createSqlSource(Configuration configuration, String script, Class<?> parameterType) {
        Matcher matcher = inPattern.matcher(script);
        if (matcher.find()) {
            StringBuilder sb = new StringBuilder();
            sb.append("<set>");
            for (Field field : parameterType.getDeclaredFields()) {
                String key =  field.getName();
                if (!(parameterType.getSimpleName().substring(0, 1) + "_id").equals(key)) {
                    String tmp = "<if test=\"_field != null\">_column=#{_field},</if>";
                    sb.append(tmp.replaceAll("_field", field.getName()).replaceAll("_column",field.getName()));
                }
            }
            sb.deleteCharAt(sb.lastIndexOf(","));
            sb.append("</set>");
            script = matcher.replaceAll(sb.toString());
            script = "<script>" + script + "</script>";
        }
        return super.createSqlSource(configuration, script, parameterType);
    }
}
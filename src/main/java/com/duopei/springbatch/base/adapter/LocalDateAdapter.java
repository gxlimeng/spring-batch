package com.duopei.springbatch.base.adapter;

import org.joda.time.LocalDate;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * Created by Administrator on 2017/2/22.
 */
public class LocalDateAdapter extends XmlAdapter<String,LocalDate> {

    public LocalDate unmarshal(String v) throws Exception {
        return new LocalDate(v);
    }

    public String marshal(LocalDate v) throws Exception {
        return v.toString();
    }
}

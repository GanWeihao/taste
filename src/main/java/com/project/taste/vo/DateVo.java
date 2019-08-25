package com.project.taste.vo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateVo {
    SimpleDateFormat formatter = new SimpleDateFormat("M/dd/yyyy");

    private Date dates;

    private Integer num;

    public DateVo(Date dates, Integer num) {
        this.dates = dates;
        this.num = num;
    }

    public DateVo() {
        super();
    }

    public Date getDates() {
        return dates;
    }

    public void setDates(Date dates) {
        this.dates = dates;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}

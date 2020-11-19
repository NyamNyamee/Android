package com.example.calenderex01;

public class DateVO {
    private String solar;
    private String lunar;
    private String ganji;

    public DateVO() {

    }

    public DateVO(String solar, String lunar, String ganji) {
        this.solar = solar;
        this.lunar = lunar;
        this.ganji = ganji;
    }

    public String getSolar() {
        return solar;
    }

    public void setSolar(String solar) {
        this.solar = solar;
    }

    public String getLunar() {
        return lunar;
    }

    public void setLunar(String lunar) {
        this.lunar = lunar;
    }

    public String getGanji() {
        return ganji;
    }

    public void setGanji(String ganji) {
        this.ganji = ganji;
    }

    @Override
    public String toString() {
        return "DateVO{" +
                "solar='" + solar + '\'' +
                ", lunar='" + lunar + '\'' +
                ", ganji='" + ganji + '\'' +
                '}';
    }

    //-----------------------------------------------------------------------
    // 양력을 년/월/일/요일로 분리해서 얻는 메서드를 추가
    public String getSolarYear() {
        return solar.split("-")[0];
    }

    public String getSolarMonth() {
        return solar.split("-")[1];
    }

    public String getSolarDate() {
        return solar.split("-")[2].split(" ")[0];
    }

    public int getSolarWeek() {
        String w = "일월화수목금토";
        return w.indexOf(solar.split("-")[2].split(" ")[1].charAt(1));
    }

    // 음력을 년/월/일로 분리해서 얻는 메서드를 추가
    public String getLunarYear() {
        return lunar.split("-")[0];
    }

    public String getLunarMonth() {
        return lunar.split("-")[1];
    }

    public String getLunarDate() {
        return lunar.split("-")[2];
    }

    // 간지를 세차/월건/일진으로 분리해서 얻는 메서드를 추가
    public String getGanjiYearKor() {
        return ganji.split(" ")[0].substring(0, 2);
    }

    public String getGanjiMonthKor() {
        // 윤달의 경우 월건이 없다
        if (ganji.split(" ").length == 2) { // 윤달이다.
            return "";
        } else {
            return ganji.split(" ")[1].substring(0, 2);
        }
    }

    public String getGanjiDateKor() {
        // 윤달의 경우 월건이 없다
        if (ganji.split(" ").length == 2) { // 윤달이다.
            return ganji.split(" ")[1].substring(0, 2);
        } else {
            return ganji.split(" ")[2].substring(0, 2);
        }
    }

    public String getGanjiYearHan() {
        return ganji.split(" ")[0].substring(3, 5);
    }

    public String getGanjiMonthHan() {
        // 윤달의 경우 월건이 없다
        if (ganji.split(" ").length == 2) { // 윤달이다.
            return "";
        } else {
            return ganji.split(" ")[1].substring(3, 5);
        }
    }

    public String getGanjiDateHan() {
        // 윤달의 경우 월건이 없다
        if (ganji.split(" ").length == 2) { // 윤달이다.
            return ganji.split(" ")[1].substring(3, 5);
        } else {
            return ganji.split(" ")[2].substring(3, 5);
        }
    }

}

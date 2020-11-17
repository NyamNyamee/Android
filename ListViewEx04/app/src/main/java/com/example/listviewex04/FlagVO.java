package com.example.listviewex04;

public class FlagVO {
    private int flagID;
    private String flagName;

    public int getFlagID() {
        return flagID;
    }

    public void setFlagID(int flagID) {
        this.flagID = flagID;
    }

    public String getFlagName() {
        return flagName;
    }

    public void setFlagName(String flagName) {
        this.flagName = flagName;
    }

    @Override
    public String toString() {
        return "FlagVO{" +
                "flagID=" + flagID +
                ", flagName='" + flagName + '\'' +
                '}';
    }
}

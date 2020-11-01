package com.example.wargames;

public class level {
    private  String level_number;
    private boolean won;
    private  String level;
    private  String icon;

    public level(String level_number, boolean won, String level, String icon) {
        this.level_number = level_number;
        this.won = won;
        this.level = level;
        this.icon = icon;
    }

    public String getLevel_number() {
        return level_number;
    }

    public void setLevel_number(String level_number) {
        this.level_number = level_number;
    }

    public boolean isWon() {
        return won;
    }

    public void setWon(boolean won) {
        this.won = won;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}

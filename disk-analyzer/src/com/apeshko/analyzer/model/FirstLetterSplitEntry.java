package com.apeshko.analyzer.model;

public class FirstLetterSplitEntry {
    String letter;
    long filesCount;
    long dirCount;

    public FirstLetterSplitEntry(String letter) {
        this.letter = letter;
    }

    public FirstLetterSplitEntry(String letter, long filesCount, long dirCount) {
        this.letter = letter;
        this.filesCount = filesCount;
        this.dirCount = dirCount;
    }

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

    public long getFilesCount() {
        return filesCount;
    }

    public void setFilesCount(long filesCount) {
        this.filesCount = filesCount;
    }

    public long getDirCount() {
        return dirCount;
    }

    public void setDirCount(long dirCount) {
        this.dirCount = dirCount;
    }

    public void addFilesCount(long value) {
        this.setFilesCount(this.filesCount + value);
    }

    public void addDirCount(long value) {
        this.setDirCount(this.dirCount + value);
    }

    @Override
    public String toString() {
        return "FirstLetterSplitEntry{" +
                "letter='" + letter + '\'' +
                ", filesCount=" + filesCount +
                ", dirCount=" + dirCount +
                '}';
    }
}

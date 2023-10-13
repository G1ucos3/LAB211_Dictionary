package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;

/**
 *
 * @author ASUS
 */
public class Translate_Words implements Serializable {

    private String EnglishWord;
    private String VietnameseWord;
    private HashMap<String, Translate_Words> tMap = new HashMap<>();

    public String getEnglishWord() {
        return EnglishWord;
    }

    public void setEnglishWord(String EnglishWord) {
        this.EnglishWord = EnglishWord;
    }

    public String getVietnameseWord() {
        return VietnameseWord;
    }

    public void setVietnameseWord(String VietnameseWord) {
        this.VietnameseWord = VietnameseWord;
    }

    public HashMap<String, Translate_Words> gettMap() {
        return tMap;
    }

    public void settMap(HashMap<String, Translate_Words> tMap) {
        this.tMap = tMap;
    }

    public HashMap<String, Translate_Words> loadData(String filename) {
        try {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
                return (HashMap<String, Translate_Words>) ois.readObject();
            }
        } catch (ClassNotFoundException | IOException e) {
            return new HashMap<>();
        }
    }

    public void updateDatabase(HashMap<String, Translate_Words> tMap, String filename) {
        HashMap<String, Translate_Words> dataWrite = loadData(filename);
        if (dataWrite == null) {
            dataWrite = tMap;
        } else {
            dataWrite.putAll(tMap);
        }
        try {
            try (ObjectOutputStream ous = new ObjectOutputStream(new FileOutputStream(filename))) {
                ous.writeObject(dataWrite);
                ous.flush();
            }
        } catch (IOException e) {
            System.err.println(e);
        }

    }
}

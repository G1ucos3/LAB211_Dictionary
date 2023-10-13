package repository;

import common.Validate;
import dataAccess.DictionaryDao;
import java.util.HashMap;
import model.Translate_Words;

/**
 *
 * @author ASUS
 */
public class DictionaryRepository {

    Validate validate = new Validate();

    public void addWord(HashMap<String, Translate_Words> tMap, Translate_Words tw) {
        String choice = "Y";
        while (choice.equalsIgnoreCase("Y")) {
            if (!DictionaryDao.Instance().addWord(tMap, tw)) {
                System.out.println("Word exist.");
                if (validate.inputYN("Update meaning? (Y/N)")) {
                    tw.setVietnameseWord(validate.checkString("Enter Vietnamese"));
                    System.out.println("Update success.");
                }
            } else {
                System.out.println("Add success.");
            }
            choice = validate.checkString("Do you want to add more? (Y/N)");
        }
    }

    public void deleteWord(HashMap<String, Translate_Words> tMap, Translate_Words tw) {
        if (tMap.isEmpty()) {
            System.out.println("Dictionary is empty.");
        }
        if (!DictionaryDao.Instance().deleteWord(tMap, tw)) {
            System.out.println("Word not exist.");
        } else {
            System.out.println("Delete success.");
        }
    }

    public void search(HashMap<String, Translate_Words> tMap, Translate_Words tw) {
        if (tMap.isEmpty()) {
            System.out.println("Dictionary is empty.");
        }
        if (!DictionaryDao.Instance().search(tMap, tw)) {
            System.out.println("Word not exist.");
        } else {
            System.out.println("Vietnamese: " + tMap.get(tw.getEnglishWord()).getVietnameseWord());
        }
    }
}

package dataAccess;

import common.Validate;
import java.util.HashMap;
import model.Translate_Words;

/**
 *
 * @author ASUS
 */
public class DictionaryDao {

    private static DictionaryDao instance = null;
    Validate validate = new Validate();

    public static DictionaryDao Instance() {
        if (instance == null) {
            synchronized (DictionaryDao.class) {
                if (instance == null) {
                    instance = new DictionaryDao();
                }
            }
        }
        return instance;
    }

    public boolean addWord(HashMap<String, Translate_Words> tMap, Translate_Words tw) {
        tw.setEnglishWord(validate.checkString("Enter English"));
        if (validate.checkExist(tMap, tw.getEnglishWord())) {
            return false;
        }
        tw.setVietnameseWord(validate.checkString("Enter Vietnamese"));
        tMap.put(tw.getEnglishWord(), tw);
        return true;
    }

    public boolean deleteWord(HashMap<String, Translate_Words> tMap, Translate_Words tw) {
        tw.setEnglishWord(validate.checkString("Enter English"));
        if (!validate.checkExist(tMap, tw.getEnglishWord())) {
            return false;
        }
        tMap.remove(tw.getEnglishWord());
        return true;
    }

    public boolean search(HashMap<String, Translate_Words> tMap, Translate_Words tw) {
        tw.setEnglishWord(validate.checkString("Enter English"));
        if (!validate.checkExist(tMap, tw.getEnglishWord())) {
            return false;
        }
        return true;
    }
}

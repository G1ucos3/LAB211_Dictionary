package repository;

import java.util.HashMap;
import model.Translate_Words;

/**
 *
 * @author ASUS
 */
public interface IDictionary {

    void addWord(HashMap<String, Translate_Words> tMap, Translate_Words tw);

    void deleteWord(HashMap<String, Translate_Words> tMap, Translate_Words tw);

    void search(HashMap<String, Translate_Words> tMap, Translate_Words tw);
    
}

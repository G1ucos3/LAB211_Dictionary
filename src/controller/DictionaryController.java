package controller;

import model.Translate_Words;
import repository.DictionaryRepository;
import view.Menu;

/**
 *
 * @author ASUS
 */
public class DictionaryController extends Menu<Translate_Words>{
    private static String[] mc = {"Add Word", "Delete Word", "Translate", "Exit"};
    Translate_Words tw;
    DictionaryRepository dr;
    
    public DictionaryController(){
        super("Dictionary program", mc);
        tw = new Translate_Words();
        dr = new DictionaryRepository();
        tw.settMap(tw.loadData("dictionary.dat"));
    }
    

    @Override
    public void execute(int choice) {
        switch(choice){
            case 1:
                System.out.println("------------- Add -------------");
                dr.addWord(tw.gettMap(), tw);
                break;
            case 2:
                System.out.println("------------ Delete ----------------");
                dr.deleteWord(tw.gettMap(), tw);
                break;
            case 3:
                System.out.println("------------ Translate ----------------");
                dr.search(tw.gettMap(), tw);
                break;
            case 4:
                System.out.println("Closed..");
                tw.updateDatabase(tw.gettMap(), "dictionary.dat");
                System.exit(0);
            default:
                System.out.println("Choose again");
        }
    }
    
}

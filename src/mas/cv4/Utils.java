package mas.cv4;

import mas.cv4.onto.BookInfo;
import mas.cv4.onto.AgentInfo;
import mas.cv4.onto.Goal;

import java.util.ArrayList;

/**
 * Created by Martin Pilat on 15.4.14.
 *
 * Trida obsahujici zakladni utility, ktere se mohou hodit.
 */
public class Utils {


    /** Funkce vypocitava uzitek agenta na zaklade knih, ktere vlastni a jeho cilu.
     *
     *  Uzitek se rovna souctu uzitku z knih, ktere agent vlastni a ma je v cilich a penez, ktere agent ma.
     *  Knihy, ktere agent vlastni, a nejsou v jeho cilich se vubec nezapocitavaji.
    **/
    public static double computeUtility(AgentInfo ai) {

        double util = ai.getMoney();

        ArrayList<Goal> goals = ai.getGoals();
        ArrayList<BookInfo> books = ai.getBooks();

        boolean allGoals = true;
        for (Goal g : goals) {

            for (int i = 0; i < books.size(); i++) {
                if (books.get(i).getBookName().equals(g.getBook().getBookName())) {
                    util += g.getValue();
                    break;
                }
                allGoals = false;
            }
        }

        return util;

    }

    public static boolean hasAllBooks(AgentInfo ai) {

        ArrayList<Goal> goals = ai.getGoals();
        ArrayList<BookInfo> books = ai.getBooks();

        int nBooks = 0;
        for (Goal g : goals) {

            for (int i = 0; i < books.size(); i++) {
                if (books.get(i).getBookName().equals(g.getBook().getBookName())) {
                    nBooks++;
                    break;
                }
            }
        }

        return nBooks == goals.size();

    }
}

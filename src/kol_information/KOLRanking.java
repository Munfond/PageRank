package kol_information;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class KOLRanking extends KOL {

    public KOLRanking(String kolUrl, ArrayList<String> listFollowers, ArrayList<Tweet> listTweets, String kolUsername, double point) {
        super(kolUrl, listFollowers, listTweets, kolUsername, point);
    }

    // Phương thức sắp xếp danh sách các KOL theo point tăng dần
    public static void sortKOLsByPoint(ArrayList<KOL> listKOL) {
        Collections.sort(listKOL, new Comparator<KOL>() {
            @Override
            public int compare(KOL o1, KOL o2) {
                return Double.compare(o2.getPoint(), o1.getPoint());
            }
        });
    }
}

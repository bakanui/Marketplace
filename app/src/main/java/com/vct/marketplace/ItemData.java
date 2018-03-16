package com.vct.marketplace;

import java.util.ArrayList;

/**
 * Created by bakan on 3/14/2018.
 */

public class ItemData {
    public static String[][] data = new String[][]{
            {"Hosico", "Scottish Fold", "http://www.catster.com/wp-content/uploads/2017/02/Hosico1.png", "Russia", "Hosico is a representative of the breed Scottish Straight (Scottish Shorthair SFS 71). Hosico\\'s Diet consists of baby food - chicken with rice or buckwheat, beef with pumpkin or zucchini. He also eats dry food for cats. And almost every day he gets a fillet of raw turkey or beef. Normal Hosico\\'s weight is about 5 kg, in the winter it decreases to 4.5 kg. By the end of the summer he can score up to 5.5 kg."},
            {"Guppy", "Fat Cat", "https://www.popdaily.com.tw/static/article/13308/1475472899tkx3j8.jpg", "Japan", "Fat Cat"}
    };
    public static ArrayList<Items> getListData() {
        Items items = null;
        ArrayList<Items> list = new ArrayList<>();
        for (int i = 0; i < data.length; i++) {
            items = new Items();
            items.setName(data[i][0]);

            list.add(items);
        }

        return list;
    }
}

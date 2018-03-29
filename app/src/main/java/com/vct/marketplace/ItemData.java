package com.vct.marketplace;

import java.util.ArrayList;

/**
 * Created by bakan on 3/14/2018.
 */

public class ItemData {
    public static String[][] data = new String[][]{
            {"Nike Epic React Flyknit",
                    "Rp2.279.000",
                    "5",
                    "The Nike Epic React Flyknit Mens Running Shoe provides crazy comfort that lasts as long as you can run. Its Nike React foam cushioning is responsive yet lightweight, durable yet soft. This attraction of opposites creates a sensation that not only enhances the feeling of moving forwards, but makes running feel fun, too.",
                    "US 7.5\\nUS 8\\nUS 10\\nUS 10.5\\nUS 13",
                    "College Navy/Racer Blue/Pink Blast/College Navy\nWhite/Racer Blue/White\nBlack/Racer Blue/Black\nBlack/Dark Grey/Pure Platinum/Black\nWolf Grey/Cool Grey/Pure Platinum/White",
                    "NIKE",
                    "@drawable/epicreactflyknitrunningshoe",
                    "@drawable/nike_logo"}

    };
    public static ArrayList<Items> getListData() {
        Items items = null;
        ArrayList<Items> list = new ArrayList<>();
        for (int i = 0; i < data.length; i++) {
            items = new Items();
            items.setName(data[i][0]);
            items.setPrice(data[i][1]);
            items.setStock(data[i][2]);
            items.setDesc(data[i][3]);
            items.setSizes(data[i][4]);
            items.setColors(data[i][5]);
            items.setSeller(data[i][6]);
            items.setImg(data[i][7]);
            items.setProfile(data[i][8]);
            list.add(items);
        }

        return list;
    }
}

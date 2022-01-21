package zjelles.jelles.items.bags;

import zjelles.jelles.items.bags.abstraction.BagBase;
import zjelles.jelles.items.bags.abstraction.BagColors;
import zjelles.jelles.items.bags.abstraction.BagSize;

import java.util.ArrayList;

public class CustomBag extends BagBase {
    public CustomBag(BagSize bagSize, BagColors bagColor) {
        super(bagSize, bagColor);
    }
    public CustomBag(BagSize bagSize, BagColors bagColor, String name) {
        super(bagSize, bagColor, name);
    }

    public CustomBag(BagSize bagSize, BagColors bagColor, String name, ArrayList<String> lore) {
        super(bagSize, bagColor, name, lore);
    }
}

package MachineCodingRound.SwiggyMachineCoding;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Menu {
    private String id;
    private String menuName;

    private List<Item> items;

    public Menu(String menuName) {
        this.id = UUID.randomUUID().toString();
        this.menuName = menuName;
        this.items = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void addItems(Item item) {
        this.items.add(item);
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}

package pt.forkit.androidlx_2014.domain;

/**
 
 */
public class Menu {

    private String menuTitle;
    private int menuIconDrawableId;

    public Menu(String menuTitle, int menuIconDrawableId) {
        this.menuTitle = menuTitle;
        this.menuIconDrawableId = menuIconDrawableId;
    }

    public String getMenuTitle() {
        return menuTitle;
    }

    public int getMenuIconDrawableId() {
        return menuIconDrawableId;
    }
}

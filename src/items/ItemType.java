package items;

public enum ItemType {
    KNIFE(1, 1), SWORD(2, 1), GUN(3, 4), BULLET(4, 42), MEAT(5, 64);
    // You never know what you might need in your game

    private final int id;
    private final int maxStackSize;
    private ItemType(int id, int maxStackSize) {
        this.id = id;
        this.maxStackSize = maxStackSize;
    }
}
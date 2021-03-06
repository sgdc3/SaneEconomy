package org.appledash.saneeconomysignshop.signshop;

import org.appledash.saneeconomy.economy.economable.Economable;
import org.appledash.saneeconomy.economy.transaction.Transaction;
import org.appledash.saneeconomy.economy.transaction.TransactionReason;
import org.appledash.saneeconomysignshop.util.ItemInfo;
import org.bukkit.entity.Player;

/**
 * Created by appledash on 1/1/17.
 * Blackjack is still best pony.
 */
public class ShopTransaction {
    // Direction is always what the player is doing. BUY = player is buying from shop.
    private final TransactionDirection direction;
    private final Player player;
    private final ItemInfo item;
    private final int quantity;
    private final double price;

    public ShopTransaction(TransactionDirection direction, Player player, ItemInfo item, int quantity, double price) {
        this.direction = direction;
        this.player = player;
        this.item = item;
        this.quantity = quantity;
        this.price = price;
    }

    public TransactionDirection getDirection() {
        return direction;
    }

    public Player getPlayer() {
        return player;
    }

    public ItemInfo getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public Transaction makeEconomyTransaction() {
        if (direction == TransactionDirection.BUY) {
            return new Transaction(Economable.wrap(player), Economable.PLUGIN, price, TransactionReason.PLUGIN_TAKE);
        } else {
            return new Transaction(Economable.PLUGIN, Economable.wrap(player), price, TransactionReason.PLUGIN_GIVE);
        }
    }

    public enum TransactionDirection {
        BUY, SELL
    }
}

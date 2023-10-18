import java.util.*;

class Order {
    String stockSymbol;
    String orderType;
    double price;
    int quantity;
    long timestamp;
    String userID;
    boolean allOrNone;

    public Order(String stockSymbol, String orderType, double price, int quantity, long timestamp, String userID, boolean allOrNone) {
        this.stockSymbol = stockSymbol;
        this.orderType = orderType;
        this.price = price;
        this.quantity = quantity;
        this.timestamp = timestamp;
        this.userID = userID;
        this.allOrNone = allOrNone;
    }
}

class TradeLog {
    double executedPrice;
    int quantity;
    String buyerID;
    String sellerID;

    public TradeLog(double executedPrice, int quantity, String buyerID, String sellerID) {
        this.executedPrice = executedPrice;
        this.quantity = quantity;
        this.buyerID = buyerID;
        this.sellerID = sellerID;
    }
}

public class Trader {
    Queue<Order> orderQueue = new LinkedList<>();
    List<TradeLog> tradeLogs = new ArrayList<>();

    public void pushOrder(Order order) {
        if (order.orderType.equals("Cancel")) {
            cancelOrder(order.timestamp);
        } else {
            orderQueue.add(order);
        }
    }

    private void cancelOrder(long timestamp) {
        orderQueue.removeIf(order -> order.timestamp == timestamp);
    }

    public void execute() {
        Queue<Order> tempQueue = new LinkedList<>();
        while (!orderQueue.isEmpty()) {
            Order order = orderQueue.poll();
            if (order.orderType.equals("Sell")) {
                for (Order potentialBuy : tempQueue) {
                    if (potentialBuy.stockSymbol.equals(order.stockSymbol) && potentialBuy.price >= order.price) {
                        int transactedQuantity = Math.min(order.quantity, potentialBuy.quantity);
                        if ((order.allOrNone && order.quantity == transactedQuantity)
                                || (potentialBuy.allOrNone && potentialBuy.quantity == transactedQuantity)
                                || (!order.allOrNone && !potentialBuy.allOrNone)) {
                            tradeLogs.add(new TradeLog(order.price, transactedQuantity, potentialBuy.userID, order.userID));
                            order.quantity -= transactedQuantity;
                            potentialBuy.quantity -= transactedQuantity;
                            if (potentialBuy.quantity == 0) {
                                tempQueue.remove(potentialBuy);
                            }
                            if (order.quantity == 0) {
                                break;
                            }
                        }
                    }
                }
            }
            if (order.quantity > 0) {
                tempQueue.add(order);
            }
        }
        orderQueue = tempQueue;
    }

    public static void main(String[] args) {
        Trader trader = new Trader();
        trader.pushOrder(new Order("AAPL", "Sell", 50, 10, 1, "user1", false));
        trader.pushOrder(new Order("AAPL", "Buy", 60, 15, 2, "user2", false));
        trader.pushOrder(new Order("AAPL", "Sell", 55, 5, 3, "user3", false));
        trader.pushOrder(new Order("AAPL", "Cancel", 0, 0, 3, "user3", false));
        trader.pushOrder(new Order("AAPL", "Buy", 52, 5, 4, "user4", false));
        trader.execute();

        for (TradeLog log : trader.tradeLogs) {
            System.out.println("Executed Price: " + log.executedPrice + " Quantity: " + log.quantity + " BuyerID: " + log.buyerID + " SellerID: " + log.sellerID);
        }
    }
}

public class BookingService implements SlotBookingService{
    private Order[] orders = new Order[10];
    private User[] users = new User[10];
    private Slot[] slots = new Slot[10];

    private static int baseSizeOrders = 0;

    public BookingService(Order[] orders, User[] users, Slot[] slots) {
        this.orders = orders;
        this.users = users;
        this.slots = slots;
    }

    @Override
    public void bookSlot(long userId, long slotId) {
        Slot currentSlot = findSlotById(slotId);
        ValidationUtils.isValidSlot(currentSlot);
        currentSlot.setStatus(SlotStatus.BOOKED);
        double price = countPrice(findUserById(userId),currentSlot);

        Order newOrder = createOrder(price,userId,slotId);
        addOrder(newOrder);
    }

    @Override
    public void cancelOrder(long orderId) {
        Order currentOrder = findOrderById(orderId);
        currentOrder.setStatus(OrderStatus.CANCELLED);
    }

    private User findUserById(long userId) {
        for (int i = 0; i < users.length; i++) {
            if (users[i].getId() == userId) {
                return users[i];
            }
        }
        return null;
    }

    private Slot findSlotById(long slotId) {
        for (int i = 0; i < slots.length; i++) {
            if (slots[i].getId() == slotId) {
                return slots[i];
            }
        }
        return null;
    }

    private Order findOrderById(long orderId) {
        for (int i = 0; i < orders.length; i++) {
            if (orders[i].getId() == orderId) {
                return orders[i];
            }
        }
        return null;
    }

    private Order createOrder(double price, long userId, long slotId) {
        Order order = new Order(GenerateId.generateId(),
                userId,
                slotId,
                System.currentTimeMillis(),
                OrderStatus.CREATED,
                price
                );
        order.validate();
        return order;
    }


    private void addOrder(Order order) {
        if (baseSizeOrders == orders.length) {
            Order[] newOrdersArray = new Order[orders.length*2];
            for (int i = 0; i < orders.length; i++) {
                newOrdersArray[i] = orders[i];
            }
            orders = newOrdersArray;
        }
        orders[baseSizeOrders] = order;
        baseSizeOrders++;
    }

    private double countPrice(User user, Slot slot) {
        if(user.hasActivePromo()){
           return slot.calculatePricePromo(user.getPromoCode());
        }else{
            return slot.calculatePrice();
        }
    }
}

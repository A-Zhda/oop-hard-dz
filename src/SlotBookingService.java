public interface SlotBookingService {
    void bookSlot(long userId,long slotId);
    void cancelOrder(long orderId);
}

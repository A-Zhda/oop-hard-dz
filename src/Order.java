public class Order implements Validatable,Identifiable{
    private final long id;
    private final long userId;
    private final long slotId;
    private final long createdAt;
    private final double priceCents;
    private OrderStatus status;

    public long getUserId() {
        return userId;
    }

    public long getSlotId() {
        return slotId;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public double getPriceCents() {
        return priceCents;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Order(long id, long userId, long slotId, long createdAt, OrderStatus status, double priceCents) {
        this.id = id;
        this.userId = userId;
        this.slotId = slotId;
        this.createdAt = createdAt;
        this.priceCents = priceCents;
        this.status = status;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void validate() {

        ValidationUtils.isValidDate(createdAt);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", userId=" + userId +
                ", slotId=" + slotId +
                ", createdAt=" + createdAt +
                ", priceCents=" + priceCents +
                ", status=" + status +
                '}';
    }
}

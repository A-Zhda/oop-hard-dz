
public class Slot implements Validatable,Identifiable,SlotPricing{
    private final long id;
    private final long startAt;
    private final long endAt;
    private final double basePriceCents;
    private SlotStatus status;

    public Slot(long id, long startAt, long endAt, double basePriceCents, SlotStatus status) {
        this.id = id;
        this.startAt = startAt;
        this.endAt = endAt;
        this.basePriceCents = basePriceCents;
        this.status = status;
    }

    public void setStatus(SlotStatus status) {
        this.status = status;
    }

    public long getStartAt() {
        return startAt;
    }

    public long getEndAt() {
        return endAt;
    }

    public double getBasePriceCents() {
        return basePriceCents;
    }

    public SlotStatus getStatus() {
        return status;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void validate() {
        ValidationUtils.isValidDate(startAt,endAt);
    }

    @Override
    public String toString() {
        return "Slot{" +
                "id=" + id +
                ", startAt=" + startAt +
                ", endAt=" + endAt +
                ", basePriceCents=" + basePriceCents +
                ", status=" + status +
                '}';
    }

    @Override
    public double calculatePrice() {
        return basePriceCents;
    }

    @Override
    public double calculatePricePromo(String promo) {
        ValidationUtils.isValidPromo(promo);
        return basePriceCents * 0.9;
    }
}

public class User implements Validatable,Identifiable{
    private long id;
    private String email;
    private String fullName;
    private long createdAt;
    private String promoCode;
    private boolean isPromo = false;

    public User(long id, String email, String fullName, long createdAt) {
        this.id = id;
        this.email = email;
        this.fullName = fullName;
        this.createdAt = createdAt;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public String getPromoCode() {
        return promoCode;
    }

    public void setPromoCode(String promoCode) {
        ValidationUtils.isValidPromo(promoCode);
        this.promoCode = promoCode;
        this.isPromo = true;
    }

    public boolean hasActivePromo(){
        return isPromo;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void validate() {
        ValidationUtils.isValidEmail(email);
        ValidationUtils.isValidName(fullName);
        ValidationUtils.isValidDate(createdAt);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", fullName='" + fullName + '\'' +
                ", createdAt=" + createdAt +
                ", promoCode='" + promoCode + '\'' +
                '}';
    }
}

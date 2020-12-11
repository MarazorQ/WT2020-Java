package dao;

public class Filter {

    private Integer toyId;
    private String email;
    private Integer customerId;

    public boolean existTestId() {
        return toyId != null;
    }

    public int getToyId() {
        return toyId;
    }

    public void setToyId(int toyId) {
        this.toyId = toyId;
    }

    public boolean existEmail() {
        return email != null;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean existCustomerId() {
        return customerId != null;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }
}

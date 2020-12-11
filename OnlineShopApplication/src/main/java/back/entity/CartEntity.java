package entity;

public class CartEntity extends Entity{
    protected int cartId;
    private ToyEntity toy;
    private String text;

    public CartEntity(String text) {
        this.text = text;
    }

    public PianoEntity getToy() {
        return toy;
    }

    public String getText() {
        return text;
    }
//---------------------------------------------------------

    public void setText(String text) {
        this.text = text;
    }

    public void setToy(PianoEntity toy) {
        this.toy = toy;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }
}

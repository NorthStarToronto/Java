package OOP3;

public class Button {

    private String title; // class field
    private OnClickListener onClickListener; // declare field with interface type

    public Button(String title) { // constructor initialize title
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    // Setter method for interface field
    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    // Method for calling a method from interface and passing class field as a parameter
    public void onClick() {
        this.onClickListener.onClick(this.title);
    }

    public interface OnClickListener { // creating inner interface
        public void onClick(String title);
    }

}


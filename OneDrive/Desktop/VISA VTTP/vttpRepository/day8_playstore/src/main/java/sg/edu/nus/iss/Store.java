package sg.edu.nus.iss;

public class Store {
    private String app;
    private String category;
    private double rating;

    public Store(String app, String category, double rating) {
        this.app = app;
        this.category = category;
        this.rating = rating;
    }

    public String getApp() {
        return app;
    }

    public String getCategory() {
        return category;
    }

    public double getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return "Store [app=" + app + ", category=" + category + ", rating=" + rating + "]";
    }

    
}

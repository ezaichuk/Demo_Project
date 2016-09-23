package util;

/**
 * Created by rgolovatyi on 9/23/2016.
 */
public enum OurProductFilter {

    DEFAULT("Default sorting"),
    POPULARITY("Sort by popularity"),
    RATING("Sort by average rating"),
    DATE("Sort by newness"),
    PRICE("Sort by price: low to high"),
    PRICE_DESC("Sort by price: high to low");

    OurProductFilter(String value) {
        this.value = value;
    }

    private final String value;

    public String getValue() {
        return value;
    }

    public static OurProductFilter getFilterFromValue(String value) {
        for (OurProductFilter e : OurProductFilter.values()) {
            if (value.equals(e.value)) return e;
        }
        return null;
    }
}

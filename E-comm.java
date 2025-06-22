class ProductSearch {
    String productId, productName, category;

    ProductSearch(String id, String name, String cat) {
        this.productId = id;
        this.productName = name;
        this.category = cat;
    }
}

class SearchFunction {
    public static int linearSearch(ProductSearch[] products, String name) {
        for (int i = 0; i < products.length; i++)
            if (products[i].productName.equals(name)) return i;
        return -1;
    }

    public static int binarySearch(ProductSearch[] products, String name) {
        int l = 0, r = products.length - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            int cmp = products[m].productName.compareTo(name);
            if (cmp == 0) return m;
            if (cmp < 0) l = m + 1;
            else r = m - 1;
        }
        return -1;
    }
}

public class SearchApp {
    public static void main(String[] args) {
        ProductSearch[] items = {
            new ProductSearch("P1", "Bag", "Travel"),
            new ProductSearch("P2", "Laptop", "Electronics"),
            new ProductSearch("P3", "Phone", "Electronics")
        };
        Arrays.sort(items, Comparator.comparing(p -> p.productName));
        System.out.println(SearchFunction.binarySearch(items, "Phone"));
    }
}


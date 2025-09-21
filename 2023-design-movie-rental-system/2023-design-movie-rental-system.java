import java.util.*;

class MovieRentingSystem {

    static class Entry {
        int shop, movie, price;
        Entry(int s, int m, int p) {
            shop = s; movie = m; price = p;
        }
    }

    // Map of (shop,movie) -> Entry (to find price easily)
    private Map<String, Entry> entryMap = new HashMap<>();
    // For each movie: all unrented entries sorted by (price, shop)
    private Map<Integer, TreeSet<Entry>> available = new HashMap<>();
    // All rented entries sorted by (price, shop, movie)
    private TreeSet<Entry> rented = new TreeSet<>(
        (a, b) -> a.price != b.price ? a.price - b.price :
                  a.shop != b.shop ? a.shop - b.shop :
                                     a.movie - b.movie
    );

    public MovieRentingSystem(int n, int[][] entries) {
        for (int[] e : entries) {
            Entry entry = new Entry(e[0], e[1], e[2]);
            entryMap.put(key(e[0], e[1]), entry);
            available.computeIfAbsent(e[1], k -> new TreeSet<>(
                (a, b) -> a.price != b.price ? a.price - b.price :
                          a.shop - b.shop
            )).add(entry);
        }
    }

    public List<Integer> search(int movie) {
        List<Integer> res = new ArrayList<>();
        if (!available.containsKey(movie)) return res;
        TreeSet<Entry> set = available.get(movie);
        int count = 0;
        for (Entry e : set) {
            res.add(e.shop);
            if (++count == 5) break;
        }
        return res;
    }

    public void rent(int shop, int movie) {
        Entry e = entryMap.get(key(shop, movie));
        available.get(movie).remove(e);
        rented.add(e);
    }

    public void drop(int shop, int movie) {
        Entry e = entryMap.get(key(shop, movie));
        rented.remove(e);
        available.get(movie).add(e);
    }

    public List<List<Integer>> report() {
        List<List<Integer>> res = new ArrayList<>();
        int count = 0;
        for (Entry e : rented) {
            res.add(Arrays.asList(e.shop, e.movie));
            if (++count == 5) break;
        }
        return res;
    }

    private String key(int shop, int movie) {
        return shop + "#" + movie;
    }
}

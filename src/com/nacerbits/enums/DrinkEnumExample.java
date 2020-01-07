package com.nacerbits.enums;

import java.util.*;

public final class DrinkEnumExample {

    public interface CategoryInterface {
        String getDisplayableType();
    }

    public static enum Category implements CategoryInterface {

        A("Category A"), B("Category B");

        private final String type;

        private Category(final String type) {
            this.type = type;
        }

        public String getDisplayableType() {
            return type;
        }
    }

    public static enum SubCategory implements CategoryInterface {

        A1("Subcategory A1 of Category A", Category.A),
        A2("Subcategory A2 of Category A", Category.A),
        B1("Subcategory B1 of Category B", Category.B),
        B2("Subcategory B2 of Category B", Category.B),
        B3("Subcategory B3 of Category B", Category.B);

        private final String label;

        private final Category type;

        private SubCategory(String label, Category type) {
            this.label = label;
            this.type = type;
        }

        public String getDisplayableType() {
            return type.getDisplayableType();
        }

        public String getLabel() {
            return label;
        }
    }

    public DrinkEnumExample() {
        super();
    }

    public static void main(String[] args) {
        // populate coffee map
        Map<Enum, List<Enum>> map = new HashMap<Enum, List<Enum>>();
        List<Enum> coffeeList = new ArrayList<Enum>();
        coffeeList.add(SubCategory.A1);
        coffeeList.add(SubCategory.A2);
        map.put(Category.A, coffeeList);
        // populate tea map
        List<Enum> teaList = new ArrayList<Enum>();
        teaList.add(SubCategory.B3);
        teaList.add(SubCategory.B2);
        teaList.add(SubCategory.B1);
        map.put(Category.B, teaList);

        // Using iterators
        Iterator<Map.Entry<Enum, List<Enum>>> itr = map.entrySet().iterator();
        while (itr.hasNext()) {
            Map.Entry<Enum, List<Enum>> entry = itr.next();
            System.out.println("\nKey = " + entry.getKey());

            Arrays.sort(entry.getValue().toArray());
            for (int i = 0; i < entry.getValue().size(); i++) {
                System.out.print(" " + entry.getValue().get(i) + " ");
            }
        }
    }

    private static void displayDrink(SubCategory drink) {
        displayType(drink);
        System.out.print(" - ");
        System.out.print(drink.getLabel());
    }

    private static void displayType(CategoryInterface displayable) {
        System.out.print(displayable.getDisplayableType());
    }
}

public class WarehouseInventoryBalancer {

    public static void analyzeInventory(int[] sectionA, int[] sectionB) {
        if (sectionA.length != sectionB.length) {
            System.out.println("Arrays must be of equal length");
            return;
        }

        int totalA = 0, totalB = 0;
        int maxQty = Integer.MIN_VALUE;
        String maxSection = "";
        int maxIndex = -1;   // 1-based

        for (int i = 0; i < sectionA.length; i++) {
            totalA += sectionA[i];
            totalB += sectionB[i];

            if (sectionA[i] > maxQty) {
                maxQty = sectionA[i];
                maxSection = "A";
                maxIndex = i + 1;
            }
            if (sectionB[i] > maxQty) {
                maxQty = sectionB[i];
                maxSection = "B";
                maxIndex = i + 1;
            }
        }

        String status = (totalA == totalB) ? "Balanced" : "Not Balanced";

        System.out.printf(
            "Section A Total: %d | Section B Total: %d | Status: %s | Highest Quantity: %d (Section %s, Item %d)%n",
            totalA, totalB, status, maxQty, maxSection, maxIndex
        );
    }

    public static void main(String[] args) {
        System.out.println("--- Warehouse Inventory Balancer ---");
        analyzeInventory(new int[]{20, 15, 30}, new int[]{25, 10, 30});
    }
}
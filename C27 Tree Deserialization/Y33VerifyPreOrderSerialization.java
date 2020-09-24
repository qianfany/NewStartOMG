public class Y33VerifyPreOrderSerialization {

    public boolean isValid (String preOrder) {
        // number of available slots
        int slots = 1;
        for(String node : preOrder.split(",")) {
            // one node takes one slot
            --slots;
            // no more slots available
            if (slots < 0) return false;
            // non-empty node creates two children slots
            if (!node.equals("#")) slots += 2;
        }
        // all slots should be used up
        return slots == 0;
    }

    public static void main (String[] args) {
        Y33VerifyPreOrderSerialization sol = new Y33VerifyPreOrderSerialization();
        String preOrder = "9,#,#";
        System.out.print(sol.isValid(preOrder));
    }
}

package _277;

public class Solution {
    public int findCelebrity(int n) {
        int celebrity = 0;
        for (int i = 1; i < n; i++) {
            if (knows(celebrity, i))
                celebrity = i;
        }

        for (int i = 0; i < n; i++) {
            if (i != celebrity) {
                if (knows(celebrity, i) || !knows(i, celebrity))
                    return -1;
            }
        }

        return celebrity;
    }

    private boolean knows(int celebrity, int i) {
        return false;
    }
}


class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();

        for (int asteroid : asteroids) {
            // Process collisions only when moving in opposite directions
            while (!st.isEmpty() && st.peek() > 0 && asteroid < 0) {
                int top = st.pop();
                if (Math.abs(top) > Math.abs(asteroid)) {  
                    st.push(top);  // The larger asteroid survives
                    asteroid = 0;  // The new asteroid is destroyed, prevent pushing it
                } else if (Math.abs(top) == Math.abs(asteroid)) {
                    asteroid = 0;  // Both explode
                }
                // If Math.abs(top) < Math.abs(asteroid), the loop continues
            }
            
            if (asteroid != 0) {
                st.push(asteroid);  // Only push if asteroid is still alive
            }
        }

        // Convert stack to array (order correction)
        int[] result = new int[st.size()];
        for (int i = st.size() - 1; i >= 0; i--) {
            result[i] = st.pop();
        }

        return result;
    }
}
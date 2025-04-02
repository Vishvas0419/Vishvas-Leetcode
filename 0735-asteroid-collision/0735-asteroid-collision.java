class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        // List to store the resulting asteroids after collisions
        List<Integer> list = new ArrayList<>();

        // Loop through each asteroid in the array
        for (int i = 0; i < asteroids.length; i++) {
            // If the current asteroid is moving to the right (positive direction)
            if (asteroids[i] > 0) {
                // Add it directly to the list (no collision with left-moving asteroids)
                list.add(asteroids[i]);
            }
            // If the current asteroid is moving to the left (negative direction)
            else {
                // Check for collisions with right-moving asteroids in the list
                while (!list.isEmpty() && list.get(list.size() - 1) > 0 &&
                        list.get(list.size() - 1) < Math.abs(asteroids[i])) {
                    // Remove the smaller right-moving asteroid since it collides and explodes
                    list.remove(list.size() - 1);
                }

                // If the list is empty or the last asteroid in the list is also moving to the left,
                // or there are no more right-moving asteroids to collide with
                if (list.isEmpty() || list.get(list.size() - 1) < 0) {
                    // Add the current left-moving asteroid to the list
                    list.add(asteroids[i]);
                }
                // If the last asteroid in the list is the same size but moving in the opposite direction
                else if (list.get(list.size() - 1) == Math.abs(asteroids[i])) {
                    // Both asteroids destroy each other (equal in magnitude), so remove the last one
                    list.remove(list.size() - 1);
                }
                // If the current left-moving asteroid is smaller, it is destroyed by the larger right-moving asteroid,
                // and we do not add it to the list (handled implicitly by not adding it to the list).
            }
        }

        // Convert the List of remaining asteroids to an array to return as the result
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
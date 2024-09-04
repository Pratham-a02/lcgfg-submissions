class Pair {
    int x;
    int y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        return x == pair.x && y == pair.y;
    }

    @Override
    public int hashCode() {
        return 31 * x + y;
    }
}

class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        int orgX = 0;
        int orgY = 0;
        boolean north = true;
        boolean south = false;
        boolean east = false;
        boolean west = false;

        HashSet<Pair> hs = new HashSet<>();

        for (int[] obstacle : obstacles) {
            int u = obstacle[0];
            int v = obstacle[1];
            hs.add(new Pair(u, v));
        }
        int max = 0;            
        int idx = 0;
        while (idx < commands.length) {
            int val = commands[idx];
            if (val == -1 || val == -2) {
                if (val == -1) {
                    if (north) {
                        north = false;
                        east = true;
                    } else if (south) {
                        west = true;
                        south = false;
                    } else if (east) {
                        south = true;
                        east = false;
                    } else {
                        north = true;
                        west = false;
                    }
                } 
                else{
                    if (north) {
                        north = false;
                        west = true;
                    } else if (south) {
                        east = true;
                        south = false;
                    } else if (east) {
                        north = true;
                        east = false;
                    } else {
                        south = true;
                        west = false;
                    }
                }
            } else {
                int k = 0;
                while (k < val) {
                    int nextX = orgX;
                    int nextY = orgY;

                    if (north) {
                        nextY++;
                    } else if (south) {
                        nextY--;
                    } else if (west) {
                        nextX--;
                    } else if (east) {
                        nextX++;
                    }
                    if (hs.contains(new Pair(nextX, nextY))) {
                        break;
                    }
                    orgX = nextX;
                    orgY = nextY;
                    k++;
                }
            }
            max = Math.max(max,orgX * orgX + orgY * orgY);
            idx++;
        }

        return max;
    }
}

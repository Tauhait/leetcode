class SnakeGame {
    /** Initialize your data structure here.
        @param width - screen width
        @param height - screen height 
        @param food - A list of food positions
        E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    private int width;
    private int height;
    private int[][] food;
    
    private LinkedList<List<Integer>> snake;
    private Set<List<Integer>> set;
    private int foodIndex;
    
    private static final Map<Character, int[]> dir = new HashMap<>();
    static {
        dir.put('U', new int[]{-1, 0});
        dir.put('L', new int[]{0, -1});
        dir.put('R', new int[]{0, 1});
        dir.put('D', new int[]{1, 0});
    }
    
    public SnakeGame(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        this.food = food;
        foodIndex = 0;
        
        snake = new LinkedList<>();
        List<Integer> list = new ArrayList<>(Arrays.asList(0, 0));
        snake.add(list);
        
        set = new HashSet<>();
        set.add(snake.peekFirst());
    }
    
    /** Moves the snake.
        @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down 
        @return The game's score after the move. Return -1 if game over. 
        Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
        for(char chr: direction.toCharArray()) {
            int[] d = dir.get(chr);
            List<Integer> ll = snake.peekFirst();
            int a = ll.get(0);
            int b = ll.get(1);
            int r = a + d[0];
            int c = b + d[1];
            if(r < 0 || r >= height || c < 0 || c >= width) return -1;
            
            if(foodIndex < food.length && r == food[foodIndex][0] && c == food[foodIndex][1]) {
                snake.addFirst(new ArrayList<>(Arrays.asList(r, c)));
                set.add(snake.peekFirst());
                foodIndex++;
            } else {
                set.remove(snake.pollLast());
                List<Integer> list = new ArrayList<>(Arrays.asList(r, c));
                if(set.contains(list)) return -1;
                snake.addFirst(list);
                set.add(list);
            }
        }
        return foodIndex;
    }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */
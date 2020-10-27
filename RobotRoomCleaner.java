public class RobotRoomCleaner {
    private Set<String> visited = new HashSet<>();
     private final int[][] dirs= {{-1,0},{0,-1},{1,0},{0,1}};
     public void cleanRoom(Robot robot) {
         dfs(robot,0,0,0);    
     }
     private void dfs(Robot robot, int x, int y, int dir){
         // 4 directions that the robot can go: up, left, down, right. Each increment will make the robot the turnLeft. 
         
         //if this cell is already visited(AKA cleaned), we will skip and return
         if(visited.contains(x+","+ y)){
             return;
         }
         //otherwise we will clean this cell and mark this cell in the visited 
         robot.clean();
         visited.add(x+","+y);
         //backtracking: at current cell, the robot can go 4 direction and we will try at its current direction, if the robot cannot move, we will turn and increment the dir by 1 until we can move or go back to the last recursion.
         for(int i =0;i<4;i++){
             
             if(robot.move()){
                 //if the robot can move(meaning there's no physical obstacle)
                 dfs(robot,x+dirs[dir][0],y+dirs[dir][1],dir);
                 robot.turnRight();
                 robot.turnRight();
                 robot.move();
                 robot.turnRight();
                 robot.turnRight();
             }
             robot.turnLeft();
             dir = (dir+1)%4;
         }
     }
 }

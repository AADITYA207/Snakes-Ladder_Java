import java.util.*;


public class start{
   public static floor temp = new floor();
   public static player tempP = new player();
   public static dice d = new dice(2);
   public static ArrayList<floor> game = new ArrayList<floor>();
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your name");
        String name = sc.nextLine();
        player p1 = new player(name);
        int step=0;
        temp.createGame(game);
        floor current=game.get(0);
        System.out.println(current.getTypeFloor());
        
        String repeat = "Hit enter to roll dice";
        
            System.out.println("WELCOME " + p1.getName());
            System.out.println("The setup is ready");
            //System.out.println(repeat);
            boolean flag=false;
            while(true){
            System.out.println(repeat);
            String enter = sc.nextLine();
            
            if(enter.equals("")){
                
                d.roll();
                System.out.println(d.toString());
                if(!flag){
                    if(d.getFaceValue()==1){
                        flag=true;
                    }
                    else{
                        System.out.println("Game cant start till 1 comes");
                    }
                }
                if(flag){
                int tempStep = step;
                step += d.getFaceValue();
                
                if(step>13){
                    System.out.println("Not possible");
                    step=tempStep;
                    //System.out.println(repeat);
                    
                }
                else{
                current =game.get(step);
                current.changeScore(p1);
                System.out.println("Player " + p1.getName() + " is on floor number " + current.getFloorNo());
                System.out.println("This is a/an " + current.getTypeFloor());
                System.out.println("Current score of player = " + p1.points);
                //System.out.println(repeat);
                step += current.jump;
                if(current.jump!=0){
                current=game.get(step);
                System.out.println("Player " + p1.getName() + " is on floor number " + current.getFloorNo() + " which is a " + current.getTypeFloor());
                
                current.changeScore(p1);
                System.out.println("Current score of player = " + p1.points);
                //System.out.println(repeat);
                }
                if(current.getTypeFloor()=="Finish"){
                    System.out.println("You ended the game, your current score is " + p1.points);
                    break;
                }
            }   
                

            }
           
        }
        else{
            System.out.println("Only press enter");
            
        }
        }


    }


}
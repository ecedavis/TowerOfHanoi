//  Code Interview for eMeasurematics
//  August 22, 2018
//  Mark Davis

//  Problem Description:
//  The candidate has to resolve "Tower of Hanoi" problem.
//  When a program runs, it should ask for  "Number of Towers" (max 10) & "Number of Disks" (max 40)
//  The program should show each step in output.



import java.util.*;

public class Main{
    public static void main(String []args){

        int N = 0;
        int K = 0;
        Scanner scan = new Scanner(System.in);

        System.out.println("\nWelcome to Towers of Hanoi Solver!\n");

        do{
            System.out.print("Enter the number of towers between 3 and 40: <0 to exit> ");
            K = scan.nextInt();
            System.out.print("Enter the number of disks between 3 and 10: <0 to exit> ");
            N = scan.nextInt();

            if (N>40 || K>10) {
                System.out.println("<Invalid entry>");
                continue;
            }
            if (N==0 || K==0) {
                System.out.println("Thanks for playing!");
            }

            HanoiBoard thisBoard = new HanoiBoard(N, K);
            thisBoard.solve();

        }while(N>=3 && K>=3);
    }
}

class HanoiBoard{
    int num_disks;
    int num_pegs;
    public Stack<Integer> A;
    public Stack<Integer> B;
    public Stack<Integer> C;
    public Stack<Integer> D;
    public Stack<Integer> E;
    public Stack<Integer> F;
    public Stack<Integer> G;
    public Stack<Integer> H;
    public Stack<Integer> I;
    public Stack<Integer> J;

    // Constructor
    HanoiBoard (int num_disks, int num_pegs){
        this.num_disks = num_disks;
        this.num_pegs = num_pegs;


        A = new Stack<Integer>();
        B = new Stack<Integer>();
        C = new Stack<Integer>();
        if(num_pegs>=4) D = new Stack<Integer>();
        if(num_pegs>=5) E = new Stack<Integer>();
        if(num_pegs>=6) F = new Stack<Integer>();
        if(num_pegs>=7) G = new Stack<Integer>();
        if(num_pegs>=8) H = new Stack<Integer>();
        if(num_pegs>=9) I = new Stack<Integer>();
        if(num_pegs>=10) J = new Stack<Integer>();

        // Pushing disks to the starting peg
        for (int i=num_disks; i>0; i--){
            A.push(i);
        }
    }

    // Helper method for recursion
    void solve(){
        //print board's initial state
        printBoard();


        switch (num_pegs){
            case 3:     move(num_disks, A, C, B);
                break;
            case 4:     move(num_disks, A, D, C, B);
                break;
            case 5:     move(num_disks, A, E, C, D, B);
                break;
            case 6:     move(num_disks, A, F, E, D, C, B);
                break;
            case 7:     move(num_disks, A, G, F, E, D, C, B);
                break;
            case 8:     move(num_disks, A, H, G, F, E, D, C, B);
                break;
            case 9:     move(num_disks, A, I, H, G, F, E, D, C, B);
                break;
            case 10:    move(num_disks, A, J, I, H, G, F, E, D, C, B);
                break;
            default:    System.out.println("Invalid number of pegs");


        }
    }

    // Recursive method for moving disks
    void move(int n, Stack<Integer> source, Stack<Integer> target, Stack<Integer> aux){ //working
        if (n>0){
            move(n - 1, source, aux, target);
            target.push(source.pop());
            printBoard();
            //move(n-1, auxiliary, target, source);
            move(n - 1, aux, target, source);
        }
    }
    void move(int n, Stack<Integer> source, Stack<Integer> target, Stack<Integer> aux1, Stack<Integer> aux2){// working
        if (n>0){

            //move(n-1, source, aux, target);
            move(n - 1, source, aux1, aux2, target);
            target.push(source.pop());
            printBoard();
            //move(n-1, auxiliary, target, source);
            move(n - 1, aux1, target, source, aux2);
        }
    }
    void move(int n, Stack<Integer> source, Stack<Integer> target, Stack<Integer> aux1, Stack<Integer> aux2, Stack<Integer> aux3){//working
        if (n>0){
            //move(n-1, source, aux, target);
            move(n - 1, source, aux1, aux2, aux3, target);
            target.push(source.pop());
            printBoard();
            //move(n-1, auxiliary, target, source);
            move(n - 1, aux1, target, source, aux2, aux3);
        }
    }
    void move(int n, Stack<Integer> source, Stack<Integer> target, Stack<Integer> aux1, Stack<Integer> aux2, Stack<Integer> aux3, Stack<Integer> aux4){
        if (n>0){
            //move(n-1, source, aux, target);
            move(n - 1, source, aux1, aux2, aux3, aux4, target);
            target.push(source.pop());
            printBoard();
            //move(n-1, auxiliary, target, source);
            move(n - 1, aux1, target, source, aux2, aux3, aux4);
        }
    }
    void move(int n, Stack<Integer> source, Stack<Integer> target, Stack<Integer> aux1, Stack<Integer> aux2, Stack<Integer> aux3, Stack<Integer> aux4, Stack<Integer> aux5){
        if (n>0){
            //move(n-1, source, aux, target);
            move(n - 1, source, aux1, aux2, aux3, aux4, aux5, target);
            target.push(source.pop());
            printBoard();
            //move(n-1, auxiliary, target, source);
            move(n - 1, aux1, target, source, aux2, aux3, aux4, aux5);
        }
    }
    void move(int n, Stack<Integer> source, Stack<Integer> target, Stack<Integer> aux1, Stack<Integer> aux2, Stack<Integer> aux3, Stack<Integer> aux4, Stack<Integer> aux5, Stack<Integer> aux6){
        if (n>0){
            //move(n-1, source, aux, target);
            move(n - 1, source, aux1, aux2, aux3, aux4, aux5, aux6, target);
            target.push(source.pop());
            printBoard();
            //move(n-1, auxiliary, target, source);
            move(n - 1, aux1, target, source, aux2, aux3, aux4, aux5, aux6);
        }
    }
    void move(int n, Stack<Integer> source, Stack<Integer> target, Stack<Integer> aux1, Stack<Integer> aux2, Stack<Integer> aux3, Stack<Integer> aux4, Stack<Integer> aux5, Stack<Integer> aux6, Stack<Integer> aux7){
        if (n>0){
            //move(n-1, source, aux, target);
            move(n - 1, source, aux1, aux2, aux3, aux4, aux5, aux6, aux7, target);
            target.push(source.pop());
            printBoard();
            //move(n-1, auxiliary, target, source);
            move(n - 1, aux1, target, source, aux2, aux3, aux4, aux5, aux6, aux7);
        }
    }
    void move(int n, Stack<Integer> source, Stack<Integer> target, Stack<Integer> aux1, Stack<Integer> aux2, Stack<Integer> aux3, Stack<Integer> aux4, Stack<Integer> aux5, Stack<Integer> aux6, Stack<Integer> aux7, Stack<Integer> aux8){
        if (n>0){
            //move(n-1, source, aux, target);
            move(n - 1, source, aux1, aux2, aux3, aux4, aux5, aux6, aux7, aux8, target);
            target.push(source.pop());
            printBoard();
            //move(n-1, auxiliary, target, source);
            move(n - 1, aux1, target, aux2, aux3, aux4, aux5, aux6, aux7, aux8, source);
        }
    }

    // Easily print the current board state
    void printBoard(){
        System.out.println(A);
        System.out.println(B);
        System.out.println(C);
        if(num_pegs>=4) System.out.println(D);
        if(num_pegs>=5) System.out.println(E);
        if(num_pegs>=6) System.out.println(F);
        if(num_pegs>=7) System.out.println(G);
        if(num_pegs>=8) System.out.println(H);
        if(num_pegs>=9) System.out.println(I);
        if(num_pegs>=10) System.out.println(J);
        System.out.println("###################");
    }
}




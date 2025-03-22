import java.util.Arrays;

/**
 * Model a 1D elementary cellular automaton.
 * 
 * Lab 7 Part 3 Questions
 * 
 *  Question 29. Yes it changes the automaton's behaviour. Since it is
* part of the loop it executes at the same time, the cells are being
* printed following the direction the last cell was on instead of
* changing after the loop.

* Question 28
* left = (i == 0) ? 0 : state[i-1];
* center = state[i];
* right = (i+1 < state.length) ? state[i+1] : 0;
            
            
 * @author David J. Barnes and Michael Kölling
 * @version  2016.02.29 - version 1
 */
    public class Automaton
{
    // The number of cells.
    private final int numberOfCells;
    // The state of the cells.
    private int[] state;
    
    /**
     * Create a 1D automaton consisting of the given number of cells.
     * @param numberOfCells The number of cells in the automaton.
     */
    public Automaton(int numberOfCells)
    {
        this.numberOfCells = numberOfCells;
        state = new int[numberOfCells];
        // Seed the automaton with a single 'on' cell in the middle.
        state[numberOfCells/ 2] = 1;
    }
    
    /**
     * Print the current state of the automaton.
     */
    public void print()
    {
        for(int cellValue : state) {
            if(cellValue == 1) {
                System.out.print("*");
            }
            else {
                System.out.print(" ");
            }
        }
        System.out.println();
    }   
    
    /**
     * Update the automaton to its next state.
     */
    public void update()
    {
        // Build the new state in a separate array.
        int[] nextState = new int[state.length];
        
        // Question 31
        int left = 0;
        int center = state[0];
        for(int i=0; i< state.length; i++) {
            int right = i + 1 < state.length ? state[i+1]: 0;
            nextState[i]= (left + center + right) % 2;
            left = center;
            center = right;
        }
        state = nextState;
    }

    /**
     * Reset the automaton.
     */
    public void reset()
    {
        Arrays.fill(state, 0);
        // Seed the automaton with a single 'on' cell.
        state[numberOfCells / 2] = 1;
            
    }
    
    //Question 32
    public int calculateNextState(int left, int center, int right) 
    {
        int[] nextState = new int[state.length];
        int i= 0;
        nextState[i] = (left + center + right) % 2;
        return i;
    }
}
package com.guessinggame;

import java.util.*;
class BTNode<E>  //extends java.lang.Object
{  //where E is an object
    E data;
    BTNode<E> left, right;

    public BTNode(E initialData, BTNode<E> initialLeft, BTNode<E> initialRight)  //parameterized constructor
    {
        //Initialize a BTNode with a specified initial data and links its children.
        data = initialData;
        left = initialLeft;
        right = initialRight;
    }

    public E getData( )   //getting the current node's data
    {
        //T.C=O(1)
        return data;
    }

    public BTNode<E> getLeft( )  //getting the current node's left child data
    {
        //T.C=O(1)
        return left;
    }

    public BTNode<E> getRight( )  //getting the current node's right child data
    {
        //T.C=O(1)
        return right;
    }

/*	public E getLeftmostData( )  //to get the leftmost node's data
	{
		//T.C=O(1)
	   if (left != null)
	   {
	     return left.getLeftmostData( );
	   }
	   else
	   {
	      return data;
	   }
	}
	public E getRightmostData( )  //to get the rightmost node's data
	   {
			//T.C=O(1)
	      if (right != null)
	      {
	        return left.getRightmostData( );
	      }
	      else
	      {
	         return data;
	      }
	   }
*/

    boolean isLeaf(BTNode<E> localRoot)  //to check if the current node is a leaf node or not
    {
        //T.C=O(1)
        if(localRoot==null)
            return false;
        else if(localRoot.left==null && localRoot.right==null)
            return true;
        else
            return false;
    }

    public void inorder(BTNode<E> root, int level)  //printing in-order traversal of the tree
    {
        //T.C=O(n)
        //where level : to traverse each node of the tree and print the indentations at the correct position
        if (root==null)
        {
            return;
        }
        else
        {
            if (left != null)
                inorder(root.left, level+1);
            for (int i = 1; i <= level; i++)
                System.out.print("    ");
            System.out.println(root.data);
            if (right != null)
                inorder(root.right, level+1);
        }
    }
    public void preorder(BTNode<E> root, int level)  //printing pre-order traversal of the tree
    {
        //T.C=O(n)
        //where level : to traverse each node of the tree and print the indentations at the correct position
        if (root==null)
        {
            return;
        }
        else
        {
            for (int i = 1; i <= level; i++)
                System.out.print("    ");
            System.out.println(root.data);
            if (left != null)
                preorder(root.left,level+1);
            if (right != null)
                preorder(root.right,level+1);
        }
    }
    public void postorder(BTNode<E> root, int level)  //printing post-order traversal of the tree
    {
        //T.C=O(n)
        //where level : to traverse each node of the tree and print the indentations at the correct position
        if (root==null)
        {
            return;
        }
        else
        {
            if(left!=null)
                postorder(root.left,level+1);
            if(right!=null)
                postorder(root.right,level+1);
            for (int i = 1; i <= level; i++)
                System.out.print("    ");
            System.out.println(root.data);
        }
    }

/*	BTNode<E> removeLeftMost()  //to remove the leftmost node
	{
		//T.C=O(1)
		if(left!=null)
		{
			left=left.removeLeftMost();
			return left;
		}
		else
			return right;
	}

	BTNode<E> removeRightMost()  //to remove the rightmost node
	{
		//T.C=O(1)
		if(right!=null)
		{
			right=right.removeRightMost();
			return right;
		}
		else
			return left;
	}
*/

    public void setData(E newData)  //to set the data of the current node
    {
        //T.C=O(1)
        data = newData;
    }
    public void setLeft(BTNode<E> newLeft)  //to set the data for the left child of the current node
    {
        //T.C=O(1)
        left = newLeft;
    }
    public void setRight(BTNode<E> newRight)  //to set the data for the right child of the current node
    {
        //T.C=O(1)
        right = newRight;
    }
}

public class GuessTheDS   //MAIN CLASS
{
    private static final Scanner sc=new Scanner(System.in);
    public static void main(String[] args)
    {
        //T.C=O(n)
        BTNode<String> root;  //declared root node for the tree using the BTNode<E> class
        instruct( );
        root = Tree( );  //creation of the tree

        do
        {
            playGame(root);
        }
        while (validate("Want to play again?"));  //continue with the game till the user enters a N/no/NO/No
        System.out.println("Thanks for playing the game and for teaching us a new Data Structure!");

        int ch;
        do {
            System.out.println ("\nWould you like to check out one of the following options? : ");
            System.out.println("1.INORDER traversal of the tree\n2.PREORDER traversal of the tree\n3.POSTORDER traversal of the tree");
            System.out.println("4.Exit");
            ch=sc.nextInt();
            switch(ch)
            {
                case 1: root.inorder(root, 1);
                    break;
                case 2: root.preorder(root, 1);
                    break;
                case 3: root.postorder(root, 1);
                    break;
                case 4: System.out.println("THE END.");
                    break;
                default:System.out.println("Please enter a valid choice!");
            }
        }while(ch!=4);
    }

    public static void instruct( )  //to give basic instructions to the user before the game begins
    {
        //T.C=O(1)
        System.out.println("Think of A Data Structure!");
        System.out.println("We will ask some yes/no questions to try to figure out which Data Structure you're thinking of.");
    }

    public static BTNode<String> Tree()  //creating the tree by hard-coding the questions and answers for 'Guessing the Data Structure' game
    {
        //T.C=O(1)
        //initializing all nodes of the tree to null
        BTNode<String> root =null;
        BTNode<String> node2=null;
        BTNode<String> node3=null;
        BTNode<String> node4=null;
        BTNode<String> node5=null;
        BTNode<String> node6=null;
        BTNode<String> node7=null;
        BTNode<String> node8=null;
        BTNode<String> node9=null;
        BTNode<String> node10=null;
        BTNode<String> node11=null;
        BTNode<String> node12=null;
        BTNode<String> node13=null;
        BTNode<String> node14=null;
        BTNode<String> node15=null;
        BTNode<String> node16=null;
        BTNode<String> node17=null;
        BTNode<String> node18=null;
        BTNode<String> node19=null;

        //hard-coding questions and answers for the tree
        final String ROOT_QUESTION1="Is it a Linear DATA STRUCTURE? ";
        final String QUESTION2="Does it implement some rules to access its elements? ";
        final String QUESTION3="This DS is not a Hierarchical one, am I right? ";
        final String QUESTION4="Does it follow the LIFO (Last In First Out) rule? ";
        final String QUESTION5="Is it a Static Data Structure? ";
        final String QUESTION6="Does this Data Structure map a key to a value? ";
        final String QUESTION7="Does this Data Structure have cycles? ";
        final String QUESTION8="Is it a single dimensional Data Structure? ";
        final String QUESTION9="Is there an ordering in terms of how the nodes are arranged? ";

        final String ANSWER1="STACK";
        final String ANSWER2="QUEUE";
        final String ANSWER3="ARRAY";
        final String ANSWER4="MATRIX";
        final String ANSWER5="LINKED LIST";
        final String ANSWER6="HASH";
        final String ANSWER7="HEAP";
        final String ANSWER8="GRAPH";
        final String ANSWER9="BINARY SEARCH TREE";
        final String ANSWER10="BINARY TREE";

        //creation of tree
        root=new BTNode<String>(ROOT_QUESTION1, null, null);
        node2 =new BTNode<String>(QUESTION2,node4,node5);
        root.setLeft(node2);

        node3=new BTNode<String>(QUESTION3, node6, node7);
        root.setRight(node3);

        node4=new BTNode<String>(QUESTION4, node8, node9);
        node2.setLeft(node4);

        node5=new BTNode<String>(QUESTION5, node10, node11);
        node2.setRight(node5);

        node6=new BTNode<String>(QUESTION6, node12, node13);
        node3.setLeft(node6);

        node7=new BTNode<String>(QUESTION7, node14, node15);
        node3.setRight(node7);

        node8=new BTNode<String>(ANSWER1,null,null);
        node4.setLeft(node8);

        node9=new BTNode<String>(ANSWER2, null, null);
        node4.setRight(node9);

        node10=new BTNode<String>(QUESTION8, node16, node17);
        node5.setLeft(node10);

        node11=new BTNode<String>(ANSWER5, null, null);
        node5.setRight(node11);

        node12=new BTNode<String>(ANSWER6, null, null);
        node6.setLeft(node12);

        node13=new BTNode<String>(ANSWER7, null, null);
        node6.setRight(node13);

        node14=new BTNode<String>(ANSWER8,null,null);
        node7.setLeft(node14);

        node15=new BTNode<String>(QUESTION9, node18, node19);
        node7.setRight(node15);

        node16=new BTNode<String>(ANSWER3,null,null);
        node10.setLeft(node16);

        node17=new BTNode<String>(ANSWER4, null, null);
        node10.setRight(node17);

        node18=new BTNode<String>(ANSWER9,null,null);
        node15.setLeft(node18);

        node19=new BTNode<String>(ANSWER10, null,null);
        node15.setRight(node19);

        return root;
    }

    public static void playGame(BTNode<String> curr)
    {
        //T.C=O(n)
        //to guess the Data Structure the user has thought of
        //yes=go to the left side in the tree & no=go to the right side in the tree

        while(!curr.isLeaf(curr))  //keep repeating till we reach a leaf node of the tree, which are the hard-coded ANSWERS to our QUESTIONS as seen above^
        {
            if(validate(curr.getData()))  //if response = Y
                curr=curr.getLeft();
            else
                curr=curr.getRight();     //if response = N
        }

        System.out.print("My guess is "+curr.getData()+"!");
        if(validate(" Am I right? : "))  //if response = Y
            System.out.println("I have guessed the DATA STRUCTURE you had in mind!:)");
        else							//if response = N
            learnDS(curr);  //if not, then go to learnDS() method
    }

    public static void learnDS(BTNode<String> curr)  //to add a new Data Structure which is not present in the original tree
    {
        //T.C=O(1)
        String guessedDS;    // The Data Structure that was just guessed by the machine
        String correctDS;    // The Data Structure that the user was thinking of
        String newQuestion;  // A new question to add in the Binary Tree to distinguish the two Data Structures

        guessedDS=curr.getData();
        System.out.print("I give up! What Data Structure did you think of ? ");
        correctDS=sc.nextLine();
        System.out.println("Please type in a yes/no question that will distinguish a "+correctDS+ " from a " + guessedDS + ".");
        newQuestion=sc.nextLine();

        curr.setData(newQuestion);
        System.out.println("For the Data Structure - "+correctDS+", "+newQuestion);
        //yes=go to the left side in the tree & no=go to the right side in the tree
        if(validate("Your answer: "))	//if response = Y
        {
            curr.setLeft(new BTNode<String>(correctDS,null,null));
            curr.setRight(new BTNode<String>(guessedDS,null,null));
        }
        else 							//if response = N
        {
            curr.setLeft(new BTNode<String>(guessedDS,null,null));
            curr.setRight(new BTNode<String>(correctDS,null,null));
        }
    }

    public static boolean validate(String Str)  //displaying a question/message string, taking in the response of the user and validating it
    {
        //T.C=O(n) where n:number of times user enters a wrong response
        String response="";
        System.out.println(Str + " [ Y or N ]: ");
        response = sc.nextLine( );
        response=response.toUpperCase( );

        while(!response.startsWith("Y") && !response.startsWith("N"))
        {
            System.out.print("Invalid response. Please enter Y or N: ");
            response = sc.nextLine( );
            response=response.toUpperCase( );
        }

        if(response.startsWith("Y"))
            return true;
        else
            return false;
    }
}
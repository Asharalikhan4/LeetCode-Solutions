//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class GFG {
    
	public static void main (String[] args) throws Exception{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
	        while(t > 0){
	            int n=Integer.parseInt(br.readLine().trim());
	            String s[] = br.readLine().trim().split(" ");

	            int target=Integer.parseInt(br.readLine().trim());
    	    	Node root = null;
                for(int i=0;i<n;i++){
                    root=insert(root,Integer.parseInt(s[i]));
                }
        	    Solution g = new Solution();
        	    System.out.println(g.maxDifferenceBST(root,target));
                t--;
            
        }
    }

    public static Node insert(Node tree, int val) {
        Node temp = null;
        if (tree == null) return new Node(val);
    
        if (val < tree.data) {
            tree.left = insert(tree.left, val);
        } else if (val > tree.data) {
            tree.right = insert(tree.right, val);
        }
    
        return tree;
    }
  
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public static int find(Node root,int target,Node[] targetNode)
    {
        if(root==null) return Integer.MIN_VALUE;
        if(root.data==target){
          targetNode[0]=root;  
          return target;
        }
        
        
        if(target>root.data) 
                    return root.data+find(root.right,target,targetNode);
        else                 
                    return root.data+find(root.left,target,targetNode);
        
       
    }
    public static int solve(Node root)
    {
        if(root==null) return Integer.MAX_VALUE/2;
        if(root.left==null && root.right==null) return root.data;
        
        
        int left=root.data+solve(root.left);
        int right=root.data+solve(root.right);
        
        
            return Math.min(left,right);
    }
    public static int maxDifferenceBST(Node root,int target)
    {
        Node[] targetNode={null};
        int rootToTarget=find(root,target,targetNode);
        
        if(targetNode[0]==null) return -1;
        
        
        int targetToLeaf=solve(targetNode[0]);
        
            return rootToTarget-targetToLeaf;
    }
}
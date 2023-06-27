//{ Driver Code Starts
#include<bits/stdc++.h>
using namespace std;

struct Node
{
	int data;
	struct Node* next;
	
	Node(int x){
	    data = x;
	    next = NULL;
	}
	
};


// } Driver Code Ends
/*
// structure of the node is as follows

struct Node
{
	int data;
	struct Node* next;
	
	Node(int x){
	    data = x;
	    next = NULL;
	}
	
};

*/
class Solution
{
    public:
    struct Node* makeUnion(struct Node* head1, struct Node* head2)
    {
        // code here
        set<int>st;
        Node* head = head1;
        while(head!=NULL)
        {
            st.insert(head->data);
            head = head->next;
        }
        Node* head9 = head2;
        while(head9!=NULL)
        {
            st.insert(head9->data);
            head9 = head9->next;
        }
        vector<int>v;
        for(auto x:st)
        {
            v.push_back(x);
            //cout<<x<<" ";
        }
        //cout<<'\n';
        head = new Node(v[0]);
        Node* temp = head;
        int i=1;
        while(i<st.size())
        {
            Node* head3 = new Node(v[i]);
            temp->next = head3;
            temp=temp->next;
            i++;
        }
        return head;
    }
};


//{ Driver Code Starts.

struct Node* buildList(int size)
{
    int val;
    cin>> val;
    
    Node* head = new Node(val);
    Node* tail = head;
    
    for(int i=0; i<size-1; i++)
    {
        cin>> val;
        tail->next = new Node(val);
        tail = tail->next;
    }
    
    return head;
}

void printList(Node* n)
{
    while(n)
    {
        cout<< n->data << " ";
        n = n->next;
    }
    cout<< endl;
}


int main()
{
    int t;
    cin>>t;
    while(t--)
    {
        int n, m;
        
        cin>>n;
        Node* first = buildList(n);
        
        cin>>m;
        Node* second = buildList(m);
        Solution obj;
        Node* head = obj.makeUnion(first,second);
        printList(head);
    }
    return 0;
}

// } Driver Code Ends
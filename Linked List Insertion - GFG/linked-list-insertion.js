//{ Driver Code Starts
//Initial Template for javascript
'use strict';

process.stdin.resume();
process.stdin.setEncoding('utf-8');

let inputString = '';
let currentLine = 0;

process.stdin.on('data', inputStdin => {
    inputString += inputStdin;
});

process.stdin.on('end', _ => {
    inputString = inputString.trim().split('\n').map(string => {
        return string.trim();
    });
    
    main();    
});

function readLine() {
    return inputString[currentLine++];
}

class Node{
    constructor(data){
        this.data = data;
        this.next = null;
    }
}

function printlist(head){
    let current = head; 
    let s='';
    while (current !== null)
    {
        s+=current.data+" ";
        current = current.next;
    }
    console.log(s);
}

function main() {
    let t = parseInt(readLine());
    let i = 0;
    for(;i<t;i++)
    {
        let n = parseInt(readLine());
        let input_ar1 = readLine().split(' ').map(x=>parseInt(x));
        let head = null;
        for(let i=0;i<2*n;i+=2){
            if(input_ar1[i+1] === 1){
                let obj = new Solution();
                head = obj.insertAtEnd(head, input_ar1[i]); 
            }
            else{
                let obj = new Solution();
                head = obj.insertAtBegining(head, input_ar1[i]); 
            }
        }
        printlist(head);
        
    }
}
// } Driver Code Ends


//User function Template for javascript

/**
 * @param {Node} head
 * @param {number} newData
 * @returns {Node}
*/

/*
class Node{
    constructor(data){
        this.data = data;
        this.next = null;
    }
}
*/

class Solution {
    //Function to insert a node at the beginning of the linked list.
    insertAtBegining(head, newData)
    {
        //your code here
        const newNode = new Node(newData);
        if(!head){
            head = newNode;
            return head;
        }
        newNode.next = head;
        head = newNode;
        return head;
    }
    //Function to insert a node at the end of the linked list.
    insertAtEnd(head, newData)
    {
        //your code here
        const newNode = new Node(newData);
        if (!head) {
            // If the list is empty, the new node becomes the head.
            return newNode;
        }

        let current = head;
        while (current.next) {
            current = current.next;
        }
        current.next = newNode;
        return head; // Head remains the same.
    }
}
#include <stdio.h>
#include <stdlib.h>

struct ListNode {
    int val;
    struct ListNode *next;
};
 
typedef struct ListNode listnode;
 
listnode* listnode_new(int val) {
    listnode* node = (listnode *) malloc(sizeof(listnode));

    node->val = val;
    node->next = NULL;
    return node;
}

listnode* insert(listnode* head, int elem)
{
    listnode* temp = head;
    
    head = listnode_new(elem);
    head->next = temp;

    return head;
}

void printLinkedList(listnode* head, FILE* fp)
{
   while(head != NULL)
   {
       fprintf(fp, "%d ", head->val);
       head = head->next;
   } 
}

int lengthList(listnode* head)
{
    if(head == NULL) return 0;
    int length = 1;
    while(head->next != NULL) 
    {
        head = head->next;
        length++;
    }
    
    return length;
}

listnode* addTwoNumbers(listnode* A, listnode* B) {
    int lA = lengthList(A);
    int lB = lengthList(B);
    
    if(lB < lA)
    {
        int temp = lB;
        lB = lA;
        lA = temp;
        
        listnode* tempList = B;
        B = A;
        A = tempList;
    }
    
    int carry = 0;
    int i = 0;
    listnode *cA = A;
    listnode *cB = B;
    listnode *pcB = B;
    
    //printf("Length A: %d, Length B: %d", lA, lB);
    
    for(i = 0; i < lA; i++)
    {
        int y = cA->val + cB->val + carry;
        
        cB->val = y % 10;
        if(y >= 10) carry = y/10;
        else carry = 0;
        
        cA = cA->next;
        pcB = cB;
        cB = cB->next;
    }
    
    while(carry && cB!=NULL)
    {
        int y = cB->val + carry;
        cB->val = y % 10;
        
        if(y >= 10) carry = y/10;
        else carry = 0;
        
        pcB = cB;
        cB = cB->next;
    }
    
    if(carry)
        pcB->next = listnode_new(carry);
        
    return B;
    
}

int main()
{
    //Create first Linked List
    FILE *input = fopen("input06.txt", "r");
    FILE *output = fopen("output06.txt", "w");
    int ll1, ll2;
    int i = 0;
    fscanf(input, "%d", &ll1);
    fscanf(input, "%d", &ll2);
    listnode* a;
    listnode* b;
   
    for(i=0; i < ll1; i++)
    {
        int x; 
        
        fscanf(input, "%d", &x);
        a = insert(a,x); 
    }

    for(i=0; i < ll2; i++)
    {
        int x; 
        
        fscanf(input, "%d", &x);
        b = insert(b,x); 
    }
    
    a = addTwoNumbers(a, b);

    printLinkedList(a, output);
    fclose(input);
    fclose(output);
}

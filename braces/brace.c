#include <stdio.h>

char stack[65535];
int top = -1;

void push(char c)
{
    stack[++top] = c;
}

char pop()
{
    return stack[top--];
}

int isEmpty()
{
    return top < 0;
}

char getTop()
{
    return stack[top];
}

char getSecondTop()
{
    return stack[top-1];
}

int main()
{
    char *s = "(a)";
    int top = -1;

    char *t = s;
    while(*t)
    {
        if((*t != '}') && (*t != ']') && (*t != ')'))
        {
            push(*t);
        }
        else
        {
            switch(*t)
            {
                case '}':
                     if(getTop() == '{' || getSecondTop() == '{')
                     {
                        printf("Redundant\n");
                        return 0;
                     }
                     while(pop() != '{')
                         ;
                    break;
                case ']':
                     if(getTop() == '[' || getSecondTop() == '[')
                     {
                        printf("Redundant\n");
                        return 0;
                     }
                     while(pop() != '[')
                         ;
                    break;
                case ')':
                     if(getTop() == '(' || getSecondTop() == '(')
                     {
                        printf("Redundant\n");
                        return 0;
                     }
                     while(pop() != '(')
                         ;
                    break;
            }
        }
        t++;
    }
    printf("Non redundant\n");
    return 0;
}

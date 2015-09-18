#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <unistd.h>

#define BUFFSIZE 80000

int main()
{
    char *buf = (char *) malloc(sizeof(char) * BUFFSIZE);
    char *s = (char *) malloc(sizeof(char) * 20);
    int count = 0;
    int first = 1;
    int n;
    int k;
    int i = 0;
    int bytes_read = 0;

    while((bytes_read = read(0 , buf, BUFFSIZE)) > 0)
    {
       char *t = buf;
       int counter = 0;

       while(counter < bytes_read)
       {
           if((*t != '\n') && (*t != ' ')) 
           {
               i = 10 * i + (*t - '0');
           }
           else if(*t == ' ')
           {
               if(first) { n = i; i = 0; }
           }
           else
           {
               if(first) { k = i; first = 0;}
               else if(i % k == 0) count++;
               i = 0;
           }
           t++;
           counter++;
       }

       bzero(buf, BUFFSIZE);
    }

    printf("%d",count);
    free(s);
    free(buf);

    return 0;
}

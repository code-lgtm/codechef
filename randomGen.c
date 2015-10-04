#include <stdlib.h>
#include <stdio.h>
#include <assert.h>

/* Returns an integer in the range [0, n).
 *
 * Uses rand(), and so is affected-by/affects the same seed.
 */
int randint(int n) {
  if ((n - 1) == RAND_MAX) {
    return rand();
  } else {
    // Chop off all of the values that would cause skew...
    long end = RAND_MAX / n; // truncate skew
    assert (end > 0L);
    end *= n;

    // ... and ignore results from rand() that fall above that limit.
    // (Worst case the loop condition should succeed 50% of the time,
    // so we can expect to bail out of this loop pretty quickly.)
    int r;
    while ((r = rand()) >= end);

    return r % n;
  }
}

int main()
{
    FILE *fp = fopen("input06.txt", "w");
    
    fputs("1000 65535", fp);
    int i = 0;
    for(i = 0; i < 1000; i++)
        fprintf(fp, "%d ", randint(10));
   
    fprintf(fp, "\n");

    for(i = 0; i < 65535; i++)
        fprintf(fp, "%d ", randint(10));

    fclose(fp);

    return 0;
}

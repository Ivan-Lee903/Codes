#include <stdlib.h>

struct alloc_info {
       int freed;
       void * memloc;
       int size;
};

int leaked();

int findSlot(void *memloc);

void *lmalloc(int size);

void lfree(void * memloc);
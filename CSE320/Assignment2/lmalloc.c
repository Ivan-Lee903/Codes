#include <stdlib.h>

#define TRACKINGSLOTS 1024

struct alloc_info {
       int freed;
       void * memloc;
       int size;
};

static struct alloc_info allocInfo[TRACKINGSLOTS];
static int next_slot = 0;


int leaked() {
  int i;
  int leaked = 0;

  for (i = 0; i < next_slot; i++) {
    if (!allocInfo[i].freed) {
      leaked += allocInfo[i].size;
    }
  }
  return leaked;

}

int findSlot(void *memloc) {
    int i;
    for (i = 0; i < next_slot; i++) {
      if (allocInfo[i].memloc == memloc) {
	return i;
      }
    }
    return -1;
}

void *lmalloc(int size) {
  allocInfo[next_slot].memloc = malloc (size);
  allocInfo[next_slot].freed = 0;
  allocInfo[next_slot].size = size;
  return allocInfo[next_slot++].memloc;
}

void lfree(void * memloc) {
  int slot = findSlot(memloc);
     
  if (slot != -1) {
    allocInfo[slot].freed = 1;
    free(memloc);
  }

}


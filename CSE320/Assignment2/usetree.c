//Min Hang Lee CSE320 Assignment #2
#include "tree.h"
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include "lmalloc.h"


int main(int argc, char **argv) {

  // Create tree for expression '(z - a) * (b - c)'
  struct tnode *multnode = newNode();
  struct tnode *sub1node = newNode();
  struct tnode *sub2node = newNode();
  struct tnode *anode = newNode();
  struct tnode *bnode = newNode();
  struct tnode *znode = newNode();
  struct tnode *cnode = newNode();
  struct tnode *retval = 0;
  char *prebuf = (char *) lmalloc(256);
  char *postbuf = (char *) lmalloc(256);
  char *inbuf = (char *) lmalloc(256);
  char arg1 = 'a'; 
  char arg2 = 'b';
  char arg3 = 'z';
  char arg4 = 'c';
  char mop = '*';
  char sop = '-';
  // set pointer types for data

  setData(sub1node, &sop, CHAR_TYPE);
  setData(sub2node, &sop, CHAR_TYPE);

  setData(multnode, &mop, CHAR_TYPE);
  setData(anode, &arg1, CHAR_TYPE);
  setData(bnode, &arg2, CHAR_TYPE);
  setData(znode, &arg3, CHAR_TYPE);
  setData(cnode, &arg4, CHAR_TYPE);
  
  retval = insertLeft(sub1node, znode);
  retval = insertRight(sub1node, anode);
  retval = insertLeft(sub2node, bnode);
  retval = insertRight(sub2node, cnode);
  retval = insertLeft(multnode, sub1node);
  retval = insertRight(multnode, sub2node);
  walk(PRE_ORDER, multnode, &prebuf);

  printf("Tree (preorder): %s\n", prebuf);

  walk(POST_ORDER, multnode, &postbuf);

  printf("Tree (postorder): %s\n", postbuf);

  walk(IN_ORDER, multnode, &inbuf);

  printf("Tree (inorder): %s\n", inbuf);

  printf("Memory Still Allocated: %d\n", leaked());

  freeNode(multnode);
  printf("Memory Still Allocated after freeNode(): %d\n", leaked());

  lfree(prebuf);
  lfree(postbuf);
  lfree(inbuf);

  printf("Memory final balance: %d\n", leaked());
}

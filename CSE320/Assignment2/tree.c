#include "tree.h"
#include <string.h>
#include <stdio.h>
#include <stdlib.h>
#include "lmalloc.h"

struct tnode *newNode(void) {
  struct tnode *retnode = 0;

  retnode = (struct tnode *)lmalloc(sizeof(struct tnode));
  // Initialize fields:
  retnode->dtype = NULL_TYPE;
  retnode->data = NULL;
  retnode->lson = NULL;
  retnode->rson = NULL;
  // TODO : Initialize remaining fields with null/0 cast to correct type.
  // Then return the created node
  return retnode;
}

void freeNode(struct tnode *node2free) {

  if (node2free != 0) { // Only free if the value is non-null
    // TODO : Free child nodes of this node
    freeNode(node2free->lson);
    freeNode(node2free->rson);
    // free contents of data
    if (node2free->dtype != 0) {
      lfree (node2free->data);
    }
    // TODO : Free the node itself
    freeNode(node2free);
  }
}


//
// insertRight - Inserts a node into the right son of another node
// parameters - root [tnode *] - Node who's child will be replaced
//              child [tnode *] - New child node
// returns [tnode *] - Pointer to node that was replaced or null
//                     if son was empty.
struct tnode *insertRight(struct tnode *root, struct tnode *child) {
  struct tnode *ret = root->rson;

  root->rson = child;
  return ret;
}

//
// insertLeft - Inserts a node into the left son of another node
// parameters - root [tnode *] - Node who's child will be replaced
//              child [tnode *] - New child node
// returns [tnode *] - Pointer to node that was replaced or null
//                     if son was empty.
//
struct tnode *insertLeft(struct tnode *root, struct tnode *child) {
  struct tnode *ret = root->lson;

  root->lson = child;
  return ret;
}

//
// setData - Sets the data type and data pointer in a node
// parameters - node [tnode *] - Node which is to be updated
//              data (void *) - Pointer to node data
//              dtype (enum datatype) - Type of data being inserted
//
// returns [null]
//
void setData(struct tnode *node, void *data2add, enum datatype dtype) {
  // TODO : Set the dtype and data fields from the parameters passed in
  node->dtype = dtype;
  node->data = data2add;
}

//
// encode - Encodes data from a node into a buffer
//
//
void encode(struct tnode *root, char **buffer) {

    // Process data
    switch (root->dtype) {
    case CHAR_TYPE:
      sprintf(*buffer, "%c", * (char *)root->data);
      break;
    case SHORT_TYPE:
      sprintf(*buffer, "%hi", * (short *)root->data);
      break;
      // TODO : encode short field into a character buffer
    case LONG_TYPE:
      sprintf(*buffer, "%li", * (long *)root->data);
      break;
      // TODO : encode short field into a character buffer
    case STRING_TYPE:
      sprintf(*buffer, "%s",  (char *)root->data);
      break;
      // TODO : encode short field into a character buffer
    default:
      break;
    } 
}

//
// walk - Walk a binary tree in the given order, PRE_ORDER, POST_ORDER,
//        or IN_ORDER. The walk is performed recursively.
//
// parameters - wt - (enum walktype) - Type of tree walk
//              root - (struct tnode *) - Root node of tree
//              buffer - (char **buffer) - String of data from the
//                nodes of the tree. This is a double pointer so
//                caller can send in the address of an array.
// 
// returns [void]
//

void Preorder (struct tnode *root, char **buffer, char *buf){
  
  if(root == NULL) return;

  encode(root, buffer);
  strcat(buf, *buffer);
  Preorder(root->lson, buffer, buf);
  Preorder(root->rson, buffer, buf);
}

void Postorder (struct tnode *root, char **buffer, char *buf){

  if(root == NULL) return;

  Postorder(root->lson, buffer, buf);
  Postorder(root->rson, buffer, buf);
  encode(root, buffer);
  strcat(buf, *buffer);
}

void Inorder (struct tnode *root, char **buffer, char *buf){

  if(root == NULL) return;

  Inorder(root->lson, buffer, buf);
  encode(root, buffer);
  strcat(buf, *buffer);
  Inorder(root->rson, buffer, buf);
}
void walk(enum walktype wt, struct tnode *root, char **buffer) {
  // TODO : Use the wt parameter to determine which walk to do.
  // You may add methods for each of the different types of tree walk. The
  // processing of the tree must be recursive, NOT iterative.

  char buf[256];
  if (wt == PRE_ORDER){
    buf[0] = '\0';
    Preorder(root, buffer, buf);
  }
  
  else if(wt == POST_ORDER){
    buf[0] = '\0';
    Postorder(root, buffer, buf);
  }

  else if(wt == IN_ORDER){
    buf[0] = '\0';
    Inorder(root, buffer, buf);  
  } 

  strcpy(*buffer, buf);
}

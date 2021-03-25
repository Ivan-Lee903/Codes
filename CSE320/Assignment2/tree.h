
enum datatype {NULL_TYPE, CHAR_TYPE, SHORT_TYPE, LONG_TYPE, STRING_TYPE};
enum walktype {PRE_ORDER, IN_ORDER, POST_ORDER};

struct tnode {
  enum datatype dtype;
  void *data;
  struct tnode *lson;
  struct tnode *rson;
};

struct tnode *newNode(void);

void freeNode(struct tnode *node2free);

struct tnode *insertRight(struct tnode *root, struct tnode *child);

struct tnode *insertLeft(struct tnode *root, struct tnode *child);

void setData(struct tnode *node, void *data2add, enum datatype dtype);

void encode(struct tnode *node, char **buffer);

void prewalk(struct tnode *root, char **buffer);

void postwalk(struct tnode *root, char **buffer);

void inwalk(struct tnode *root, char **buffer);

void walk(enum walktype wt, struct tnode *root, char **buffer);


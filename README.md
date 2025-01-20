# AVL tree implementation in Java
The **AvlTree** class is used to represent the tree. To avoid using *null*, all occurrences of **Node** are wrapped with *Optional*. Children of leaves are represented as *Optional.empty()*. The empty tree is also denoted by *Optional.empty()*. Using *Optional* may help to prevent bugs during development, but it causes some performance overhead, which can be significant in the case of large trees. The implementation is more of a playful experiment driven by my curiosity.
In a real codebase, it might have been a better idea to use *null* within the **AvlTree** and **Node** classes for private members and use *Optional* exclusively for parts exposed to API consumers.
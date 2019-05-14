组合模式（Composite Pattern），又叫部分整体模式，是用于把一组相似的对象当做一个单一的对象。组合模式依据树形结构来组合对象，用来表示部分以及整体层次。这种类型的设计模式属于结构型模式，它创建了对象组的树形结构。

- 优点：
    0. 高层模块调用简单
    1. 节点自由增加
- 缺点
    0. 在使用组合模式时，其叶子和树枝的声明都是实现类，而不是接口，违反了依赖倒置原则
    
关键代码：树枝内部组合该接口，并且含有内部属性List，里面放Component。
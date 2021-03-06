享元模式（Flyweight Pattern）主要用于减少创建对象的数量，以减少内存占用和提高性能。这种类型的设计模式属于结构型模式，它提供了减少对象数量从而改善应用所需的对象结构的方式。<br/>
享元模式尝试使用现有的同类对象，如果未匹配到的对象，则创建新对象。<br/>
- 关键代码：用户HashMap存储这些对象。
- 优点
    0. 大大减少了对象的创建，降低系统的内存，使效率提高。
- 缺点
    0. 提高了系统的复杂度，需要分离出外部状态和内部状态，而且外部状态具有固有化的性质，不应该随着内部状态的变化而变化，否则会造成系统的混乱。
- 注意事项
    0. 注意划分外部状态和内部状态，否则可能引起线程安全问题。
    1. 这些类必须有个工厂类来控制。
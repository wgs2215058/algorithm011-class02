学习笔记
1.Map集合概述和特点
Map接口提供了三个集合视图，允许将Map的内容视为一组键、一组值或一组键-值映射。映射的顺序被定义为映射集合视图上的迭代器返回元素的顺序。一些映射实现，比如TreeMap类，对它们的顺序做出了特定的保证;其他类，比如HashMap，则不需要。
注意:如果使用可变对象作为映射键，必须非常小心。如果对象是映射中的键，而对象的值以影响相等比较的方式更改，则不指定映射的行为。这种禁令的一个特殊情况是，不允许映射将自己包含为键。虽然允许映射将自己包含为值，但是要特别注意:equals和hashCode方法在这样的映射中不再被很好地定义。
所有通用映射实现类都应该提供两个“标准”构造函数:一个是void(无参数)构造函数，它创建一个空映射;另一个是带有一个类型为map的参数的构造函数，它创建一个具有与它的参数相同的键-值映射的新映射。实际上，后一个构造函数允许用户复制任何映射，生成所需类的等效映射。没有办法强制执行这一建议(因为接口不能包含构造函数)，但是JDK中的所有通用映射实现都遵循这一建议。
此接口中包含的“破坏性”方法，即修改它们所操作的映射的方法，被指定为在该映射不支持操作时抛出UnsupportedOperationException。如果是这种情况，如果调用对映射没有影响，这些方法可能(但不是必需的)抛出UnsupportedOperationException。例如，在不可修改的映射上调用putAll(Map)方法，如果要“叠加”的映射为空的映射可能(但不是必需的)抛出异常。
有些map实现对它们可能包含的键和值有限制。例如，有些实现禁止空键和值，而有些则限制其键的类型。试图插入不合格的键或值会抛出未检查的异常，通常是NullPointerException或ClassCastException。试图查询是否存在不合格的键或值可能会抛出异常，或者它可能仅仅返回false;有些实现会显示前一种行为，有些则会显示后一种行为。更普遍的情况是，尝试对不符合条件的键或值执行操作，如果完成操作不会导致在映射中插入不符合条件的元素，则可能会抛出异常或成功，具体取决于实现的选项。这种异常在该接口的规范中被标记为“可选”。
集合框架接口中的许多方法都是根据equals方法定义的。例如，containsKey(对象键)方法的规范说:“当且仅当这个映射包含一个键k的映射，这样(key==null ?k = = null: key.equals (k))。”此规范不应被解释为暗示调用映射。包含一个非空参数key的containsKey会导致key.equals(k)被任何key k调用。实现可以自由地实现优化，从而避免调用equals，例如，首先比较两个key的哈希码。(Object.hashCode()规范保证两个哈希码不相等的对象不能相等。)更普遍的是，在实现者认为合适的地方，各种集合框架接口的实现可以自由地利用底层对象方法的指定行为。
对映射执行递归遍历的某些映射操作可能会失败，但对于映射直接或间接包含自身的自引用实例则例外。这包括clone()、equals()、hashCode()和toString()方法。实现可以选择性地处理自引用场景，但是当前大多数实现都不这样做。
2.Map集合的功能概述
1).添加功能
V put(K key,V value):添加元素。这个其实还有另一个功能?替换如果键是第一次存储，就直接存储元素，返回null,如果键不是第一次存在，就用值把以前的值替换掉，返回以前的值
2):删除功能
void clear():移除所有的键值对元素 V remove(Object key)：根据键删除键值对元素，并把值返回
3):判断功能
boolean containsKey(Object key)：判断集合是否包含指定的键
boolean containsValue(Object value):判断集合是否包含指定的值
boolean isEmpty()：判断集合是否为空
4):获取功能
Set<Map.Entry<K,V>> entrySet(): 返回一个键值对的Set集合
V get(Object key):根据键获取值
Set keySet():获取集合中所有键的集合
Collection values():获取集合中所有值的集合
5):长度功能
int size()：返回集合中的键值对的对数
3.Map集合的遍历之键找值
获取所有键的集合,遍历键的集合，获取到每一个键,根据键找值;获取所有键值对对象的集合,遍历键值对对象的集合，获取到每一个键值对对象,根据键值对对象找键和值.一般来说建议使用entrySet遍历方式，其效率高.
4.LinkedHashMap的概述和使用
LinkedHashMap的概述:	Map 接口的哈希表和链接列表实现，具有可预知的迭代顺序LinkedHashMap的特点：底层的数据结构是链表和哈希表元素有序并且唯一元素的有序性由链表数据结构保证唯一性由哈希表数据结构保证Map集合的数据结构只和键有关
5.TreeMap集合
TreeMap 键不允许插入null
TreeMap: 键的数据结构是红黑树,可保证键的排序和唯一性,排序分为自然排序和比较器排序,线程是不安全的效率比较高
TreeMap集合排序：
实现Comparable接口，重写CompareTo方法
使用比较器

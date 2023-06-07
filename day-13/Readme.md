# Map and other utility collection classes

## Map

- a collection of key/value (entry) objects
- unlike the List, where we have an index (auto generated) to access an element, we have to provide a key while storing the value, which can be used later to get the value back
- A Map represents:
  - a Set of keys
  - a Collection of values
  - a Set of Entry objects
    - An Entry is a key/value pair

```plantuml
interface Map<K, V>{
    + size(): int
    + isEmpty(): boolean
    + put(key: K, value: V): V
    + get(key: K): V
    + remove(key: K): V
    + containsKey(key: K): boolean
    + containsValue(value: V): boolean
    + keySet(): Set<K>
    + values(): Collection<V>
    + entrySet(): Set<Entry<K, V>>
}

interface SortedMap{}
interface NavigableMap{}
abstract class AbstractMap{}

Map <|.. HashMap
Map <|.. AbstractHashMap
AbstractMap <|-- HashMap
HashMap <|-- LinkedHashMap
Map <|.. LinkedHashMap
Map <|.. Hashtable
Map <|.. AbstractMap

Map <|-- SortedMap
SortedMap <|-- NavigableMap
NavigableMap <|.. TreeMap
AbstractMap <|-- TreeMap
Hashtable <|-- Properties
Dictionary <|-- Hashtable


```

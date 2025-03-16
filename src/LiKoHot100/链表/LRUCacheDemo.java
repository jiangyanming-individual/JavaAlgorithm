package LiKoHot100.链表;

import sun.misc.LRUCache;

import java.util.HashMap;
import java.util.Map;

public class LRUCacheDemo {


    /**
     * LRU进行缓存操作: 哈希表 + 双向链表
     * （1）哈希表用于存储键值对，key 是节点， value是节点所处的链表的下标
     *  (2) 使用双向链表存储节点，头插入法插入节点，尾部删除节点。
     */

    // 双向链表节点：
    class Node {

        int key;
        int value;
        Node pre;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private  Map<Integer,Node> cachedMap;

    // 缓存容量
    private  int capacity;

    // 当前链表大小
    private int size;

    // 头节点
    private Node dummyHead;

    // 尾节点
    private Node dummyTail;

    // 初始化,设置缓存以及容量大小
    public LRUCacheDemo(int capacity){
        this.cachedMap=new HashMap<>();
        this.capacity=capacity;
        this.size=0;
        this.dummyHead =new Node(-1,-1);
        this.dummyTail=new Node( -1,-1);
        dummyHead.next=dummyTail;
        dummyTail.pre=dummyHead;
    }

    /**
     * (1)如果键存在于缓存中：
     * 将对应的节点移动到链表头部（表示最近使用）。
     * 返回节点的值。
     * (2)如果键不存在于缓存中：
     * 返回 -1。
     * @param key
     * @return
     */
    public int get(int key){
        if (!cachedMap.containsKey(key)){
            return -1;
        }
        Node node = cachedMap.get(key);
        // 移动到头
        moveToHead(node);
        return node.value;
    }

    /**
     *(1) 如果键存在于缓存中：
     * 更新节点的值。
     * 将节点移动到链表头部。
     * (2)如果键不存在于缓存中：
     * 创建一个新节点，并将其插入链表头部。
     * 将键值对存入哈希表。
     * 如果缓存已满，删除链表尾部的节点（最久未使用），并从哈希表中移除对应的键。
     * @param key
     * @param value
     */
    public void  put(int key ,int value){
        if (cachedMap.containsKey(key)){
            Node node = cachedMap.get(key);
            // 更新节点的值：
            node.value=value;
            // 移动到头部
            moveToHead(node);
        }else {
            // 插入新的节点
            Node node = new Node(key, value);
            // 放入到缓存中
            cachedMap.put(key,node);
            // 插入到头
            addToHead(node);
            size++;

            if (size>capacity){
                // 删除尾部节点
                Node tail = removeTail();
                // 删除缓存
                cachedMap.remove(tail.key);
                // size --
                size--;
            }
        }
    }

    // 将节点移动到链表头部
    public void moveToHead(Node node){
        // 删除当前节点所在位置
        removeNode(node);
        // 然后将当前节点在头部进行插入
        addToHead(node);
    }

    // 将节点插入链表头部,头插法
    public void addToHead(Node node){
        node.pre=dummyHead;
        node.next=dummyHead.next;
        // 改变节点指向
        dummyHead.next.pre=node;
        dummyHead.next=node;
    }
    // 从链表中移除节点, 也需要改变指针指向
    public void removeNode(Node node){
        node.pre.next=node.next;
        node.next.pre=node.pre;
    }
    // 移除链表尾部的节点
    public Node removeTail(){
        // 获取尾节点
        Node tail=dummyTail.pre;
        // 删除尾节点
        removeNode(tail);
        return tail;
    }
}

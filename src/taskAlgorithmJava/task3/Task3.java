//хэш-таблица
package taskAlgorithmJava.task3;

public class Task3 {
    public static void main(String[] args) {
        HashMap hm = new HashMap();
        for(int i=0; i<10; i++){
            hm.add(i, i*i);
        }
        hm.add(150, 45);
        hm.del(5);
        hm.del(13);
        //hm.print();

        System.out.println(hm.find(150));
        System.out.println(hm.find(143));
    }

    public static class HashMap {
        // key -> value
        // key -> hash -> index
        // problem: hash(A) == hash(B)
        static final int INIT_BASKET_COUNT = 16;
        private Basket[] baskets;
        public HashMap(){
            this(INIT_BASKET_COUNT);
        }
        public HashMap(int size){
            baskets = new Basket[size];
        }
        public int calcIndex(int key){
            return key % baskets.length;
        }
        public Integer find(int key){
            int index = calcIndex(key);
            Basket basket = baskets[index];
            if(basket == null){
                return null;
            }

            return basket.find(key);
        }
        public boolean add(int key, int value){
            int index = calcIndex(key);
            Entity entity = new Entity();
            entity.key = key;
            entity.value = value;

            Basket basket = baskets[index];
            if(basket == null){
                basket = new Basket();
                baskets[index] = basket;
            }

            return basket.add(entity);
        }

        public boolean del(int key){
            int index = calcIndex(key);

            Basket basket = baskets[index];
            if(basket == null){
                return false;
            }

            return basket.del(key);
        }

        public void print(){
            for(int i=0; i<baskets.length; i++) {
                if(baskets[i] == null)
                    System.out.printf("Empty");
                else
                    baskets[i].print();
                System.out.println();
            }
        }

        private class Entity{
            int key;
            int value;
        }
        private class Basket{
            Node head;
            private class Node{
                Entity value;
                Node next;
            }
            public Integer find(int key){
                if(head != null){
                    Node current = head;
                    while(current != null){
                        if(current.value.key == key){
                            return current.value.value;
                        }
                        current = current.next;
                    }
                }
                return null;
            }
            public boolean add(Entity entity){
                Node node = new Node();
                node.value = entity;
                if(head == null){
                    head = node;
                }else{
                    Node current = head;
                    while(current.next != null){
                        if(current.value.key == entity.key){
                            return false;
                        }
                        current = current.next;
                    }
                    current.next = node;
                }
                return true;
            }
            public boolean del(int key){
                if(head == null){
                    return false;
                }else{
                    if(head.value.key == key){
                        head = head.next;
                        return true;
                    }else{
                        Node current = head;
                        while(current.next != null){
                            if(current.next.value.key == key){
                                current.next = current.next.next;
                                return true;
                            }
                            current = current.next;
                        }
                        return false;
                    }
                }
            }

            public void print(){
                Node cur = head;
                while(cur != null){
                    System.out.printf("(key: %d, value: %d); ", cur.value.key, cur.value.value);
                    cur=cur.next;
                }
            }
        }
    }
}

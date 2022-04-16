package company;


    public class MyArrayList<T> implements MyList<T> {
        private Object[] arr;
        private int length = 0;
        private int capacity = 3;

        public MyArrayList() {
            arr = new Object[capacity];
        }

        public void add(T item) {
            if (length == capacity)
                increaseCapacity();
            arr[length++] = item;
        }

        public void add(T item, int index){
            if(index >= length){
                throw new IndexOutOfBoundsException();
            }
            increaseCapacity();
            for(int i = length; i >= index; i--){
                arr[i] = arr[i - 1];
            }
            arr[index] = item;
        }

        private void increaseCapacity() {
            capacity = 2 * capacity;
            Object[] old = arr;
            arr = new Object[capacity];

            for (int i = 0; i < old.length; i++)
                arr[i] = old[i];
        }

        public int size() {
            return length;
        }

        public boolean remove(T item){
            for(int i = 0; i < length; i++){
                if(item == arr[i]){
                    remove(i);
                    return true;
                }
            }
            return false;
        }

        public T remove(int index) {
            for(int i = index; i < length - 1; i++){
                arr[i] = arr[i + 1];
            }
            arr[length - 1] = null;
            length--;
            return null;
        }

        public void clear() {
            for(int i = 0; i < length; i++){
                arr[i] = null;
            }
            length = 0;
        }
        
        public T get(int index) {
            return (T)arr[index];
        }

        public int indexOf(Object o){
            for(int i = 0; i < length; i++) {
                if (o == arr[i]) {
                    return i;
                }
            }
            return -1;
        }

        public void sort() {
            for(int i = 0; i < length - 1; i++){
                for(int j = 0; j < length - i - 1; j++){
                    if((Integer)arr[j] > (Integer)arr[j + 1]){
                        Object temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }
                }
            }
        }

        public boolean contains(Object o){
            for(int i = 0; i < arr.length; i++){
                if(o.equals(arr[i])) {
                    return true;
                }
            }
            return false;
        }
        public int lastIndexOf(Object o) {
            for(int i = length - 1; i > 0;i++){
                if(o == arr[i])){
                    return i;
                }
            }
            return -1;
        }
        public T get(int index) {
            return (T)arr[index];
        }


    }


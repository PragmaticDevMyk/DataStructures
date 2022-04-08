package ds;

public class BasicQueue<X> {
    private X[] data;
    private int front;
    private int end;

    public BasicQueue(){
        this(100);
    }

    public BasicQueue(int size){
        this.front = -1;
        this.end = -1;
        data = (X[]) new Object[size];
    }
    public  int size(){
//        if queue is empty return 0
        if(front == -1 && end == -1){
            return 0;
        }
        else {
//            otherwise, we add 1 to get the inclusive subtraction value
            return end - front + 1;
        }
    }
    public void enQueue(X item){
//        first see if Queue is full
        if((end + 1) % data.length == front){
            throw new IllegalStateException("The queue is full!");
        }
//        otherwise, check if items have been added on the queue yet
        else if(size() == 0) {
            front++;
            end++;
            data[end] = item;
        }

    }
    public X deQueue(){
        X item = null;

//        if the queue is empty, nothing to dequeue
        if(size() == 0){
            throw new IllegalStateException("Queue empty, cant dequeue!");
        }
        else if(front == end){
            item = data[front];
            data[front] = null;
            front= -1;
            end = -1;
        }
//        otherwise, grab the front of the queue, return it and adjust the front pointer
        else{
            item = data[front];
            data[front] = null;
            front++;
        }
        return item;

    }
    public boolean contains(X item){
        boolean found = false;
//        if queue is empty just return false
        if(size() ==0){
            return found;
        }
        for(int i = front; i < end; i++){
            if(data[i].equals(item)){
                found = true;
                break;
            }
        }
        return found;
    }
    public X access(int position){
        if(size() == 0 || position > size()){
            throw new IllegalArgumentException("No items in the queue or position is greter than the size of the queue!");
        }
        int trueIndex = 0;
        for(int i = front; i < end; i++){
            if(trueIndex == position){
                return data[i];
            }
            trueIndex++;
        }
//        if we dont find the item, throw an exception
        throw new IllegalArgumentException("Could not find the item at Position: " +position);

    }
}

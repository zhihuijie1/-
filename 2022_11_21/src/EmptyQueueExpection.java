public class EmptyQueueExpection extends RuntimeException{
    public EmptyQueueExpection() {
        super();
    }
    public EmptyQueueExpection(String message){
        super(message);
    }
}

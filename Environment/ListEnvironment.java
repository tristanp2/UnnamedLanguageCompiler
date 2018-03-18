package Environment;
import AST.*;
import Types.*;
import java.util.List;
import java.util.ArrayList;

public class ListEnvironment implements Environment<String, Object>{
    private ListNode<String, Object> front;
    private int scope;
    
    public ListEnvironment(){
        scope = 0;
    }
    public void beginScope(){
        scope++;
    }
    //End scope. Find start of current scope from front of list, and then disconnect
    //  scope from rest of list, then decrement scope
    public void endScope(){
        if(front == null) return;

        ListNode<String,Object> temp = front;
        ListNode<String,Object> prev = front;

        while(temp != null && temp.scope != scope){
            prev = temp;
            temp = temp.next;
        }

        prev.next = null;
        if(prev.scope == scope)
            prev = null;
        front = prev;
        scope--;
    }
    public void debugPrintScope(){
        System.out.println("scope");
        ListNode<String,Object> temp = front;
        while(temp != null){
            System.out.println(temp.key + ": " + temp.scope);
            temp = temp.next;
        }
    }
    //Should start at front because list goes from widest scope to most local
    //End of list is always most local scope
    public boolean inCurrentScope(String key){
        ListNode<String, Object> temp = getNode(key);
        
        if(temp == null)
            return false;
        else
            return temp.scope == scope;
    }
    //return list of current scope
    public List<Object> getList() {
        List<Object> returnList = new ArrayList<Object>();
        ListNode<String, Object> n = front;
        while(n != null) {
            returnList.add(n);
            n = n.next;
        }
        return returnList;
    }
        
    public void add(String key, Object value){
        ListNode<String,Object> new_node = new ListNode<String,Object>(key,value,scope,front);

        front = new_node;
    }
    // This returns the value rather than just the node
    public Object lookup(String key){
        ListNode<String,Object> temp = getNode(key);
        if(temp != null)
            return temp.value;
        else
            return null;
    }
    private int calcSize() {
        int s = 0;
        ListNode<String,Object> n = front;

        while(n != null){
            n = n.next;
            s++;
        }
        return s;
    }
    private ListNode<String,Object> getNode(String key){
        ListNode<String,Object> temp = front;
        while(temp != null){
            if(temp.key.equals(key)){
                return temp;
            }
            else{
                temp = temp.next;
            }
        }
        return null;
    }
}

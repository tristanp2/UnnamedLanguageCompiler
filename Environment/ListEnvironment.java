package Environment;
import AST.*;
import Types.*;

public class ListEnvironment implements Environment<String, Type>{
    private ListNode<String, Type> front;
    private int scope;
    
    public ListEnvironment(){
        scope = 0;
    }
    public void beginScope(){
        scope++;
    }
    public void endScope(){
        scope--;
    }
    public boolean inCurrentScope(String key){
        ListNode<String, Type> temp = getNode(key);
        
        if(temp == null)
            return false;
        else
            return temp.scope == scope;
    }
    public void add(String key, Type value){
        ListNode<String,Type> new_node = new ListNode<String,Type>(key,value,scope,front);

        front = new_node;
    }
    public Type lookup(String key){
        ListNode<String,Type> temp = getNode(key);
        if(temp != null)
            return temp.value;
        else
            return null;
    }
    private ListNode<String,Type> getNode(String key){
        ListNode<String,Type> temp = front;
        while(temp != null){
            if(temp.key == key){
                return temp;
            }
            else{
                temp = temp.next;
            }
        }
        return null;
    }
}

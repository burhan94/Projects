//Burhan Hamid




class HashedBST <Key, Value>{
    private class TreeNode{
	    private TreeNode left;
	    private TreeNode right;
	    private Value head;
	    private Key theKey;
	    private TreeNode(Key theKey, Value head){
	        this.left = null;
	        this.right = null;
	        this.head = head;
	        this.theKey= theKey;
	    }
	}
	private class ValueNode{
	    private Key key;
	    private Value value;
	    private ValueNode next;
	    private ValueNode(Key key, Value value, ValueNode next){
	        this.key = key;
	        this.value = value;
	        this.next = next;
	        
	    }
	}
    private TreeNode Tree;
        
	public HashedBST()
	{
		Tree = new TreeNode(null, null);
	   
	}
	
	public Value get(Key key)
        {
            int theKey1 = hash(key);
            TreeNode here = Tree;
            while (here != null)
            {
                int theKey2=hash(here.theKey);
               
                
                if(theKey1 < theKey2 )
                {
                here = here.left;
                }
                else if(theKey1>theKey2)
                    here = here.right;
                else
                {
                    
                    return here.head;
                }
            }
            throw new IllegalArgumentException("Value associated with the key not found");
            
        }
	
	private int hash(Key key)
        {
            if(key != null)
                return Math.abs(key.hashCode());
            else
                return 0;
        }
	
	public int height()
        
    {
        return height(Tree);
    }
    
    private int height(TreeNode Tree)
    {
        if(Tree == null)
            return 0;
        else
        {
            int leftCount = height(Tree.left);
            int rightCount = height(Tree.right);
            if(leftCount > rightCount)
                return leftCount+1;
            else
                return rightCount+1;
        }
    }
        
	
	public void put(Key key, Value value)
        {
            ValueNode newnode = new ValueNode(key, value, null);
            if(Tree == null)
            {
                Tree = new TreeNode(key, value);
            }
            else
            {
                TreeNode here = Tree;
                int index = hash(key);
                
               
                while(true)
                {
                    int theKey1=hash(here.theKey);
                    ;
                    if(index < theKey1)
                    {
                        if(here.left == null)
                        {
                            here.left = new TreeNode(key, value);
                            return;
                        }
                        else
                        {
                            here = here.left;
                        }
                    }
                    else if(index > theKey1)
                    {
                        if(here.right == null)
                        {
                            here.right = new TreeNode(key, value);
                            return;
                        }
                        else
                        {
                            here = here.right;
                        }
                    }
                    else
                    {
                        ValueNode temp = null;
                        ValueNode b = new ValueNode(key, value, null);
                        while (b.next != null)
                        {
                            temp = b;
                            b = b.next;
                        }
                        temp.next = new ValueNode(key, value, null);
                        return;
                    }
                }
            }
        }
}



class project3 
{ 
     private final static String[] reserved = 
       { "abstract",     "assert",    "boolean",     "break", 
         "byte",         "case",      "catch",       "char", 
         "class",        "const",     "continue",    "default", 
         "do",           "double",    "else",        "extends", 
         "final",        "finally",   "float",       "for", 
         "goto",         "if",        "implements",  "import", 
         "instanceof",   "int",       "interface",   "long", 
         "native",       "new",       "package",     "private", 
         "protected",    "public",    "return",      "short", 
         "static",       "super",     "switch",      "synchronized", 
         "this",         "throw",     "throws",      "transient", 
         "try",          "void",      "volatile",    "while" }; 
     
      public static void main(String [] args) 
      { 
        HashedBST<String, Integer> hbst = new HashedBST<String, Integer>(); 
     
        for (int index = 0; index < reserved.length; index += 1) 
        { 
          hbst.put(reserved[index], index); 
        } 
     
        System.out.println(hbst.height()); 
     
        for (int index = 0; index < reserved.length; index += 1) 
        { 
          System.out.format("%02d %s", hbst.get(reserved[index]), reserved[index]); 
          System.out.println(); 
        } 
      } 
}


/* OUTPUT
17                                                                                                                                                                                                                                                      
00 abstract                                                                                                                                                                                                                                             
01 assert                                                                                                                                                                                                                                               
02 boolean                                                                                                                                                                                                                                              
03 break                                                                                                                                                                                                                                                
04 byte                                                                                                                                                                                                                                                 
05 case                                                                                                                                                                                                                                                 
06 catch                                                                                                                                                                                                                                                
07 char                                                                                                                                                                                                                                                 
08 class                                                                                                                                                                                                                                                
09 const                                                                                                                                                                                                                                                
10 continue                                                                                                                                                                                                                                             
11 default                                                                                                                                                                                                                                              
12 do                                                                                                                                                                                                                                                   
13 double                                                                                                                                                                                                                                               
14 else                                                                                                                                                                                                                                                 
15 extends                                                                                                                                                                                                                                              
16 final                                                                                                                                                                                                                                                
17 finally                                                                                                                                                                                                                                              
18 float                                                                                                                                                                                                                                                
19 for                                                                                                                                                                                                                                                  
20 goto                                                                                                                                                                                                                                                 
21 if                                                                                                                                                                                                                                                   
22 implements                                                                                                                                                                                                                                           
23 import                                                                                                                                                                                                                                               
24 instanceof                                                                                                                                                                                                                                           
25 int                                                                                                                                                                                                                                                  
26 interface                                                                                                                                                                                                                                            
27 long                                                                                                                                                                                                                                                 
28 native                                                                                                                                                                                                                                               
29 new                                                                                                                                                                                                                                                  
30 package                                                                                                                                                                                                                                              
31 private                                                                                                                                                                                                                                              
32 protected                                                                                                                                                                                                                                            
33 public                                                                                                                                                                                                                                               
34 return                                                                                                                                                                                                                                               
35 short                                                                                                                                                                                                                                                
36 static                                                                                                                                                                                                                                               
37 super                                                                                                                                                                                                                                                
38 switch                                                                                                                                                                                                                                               
39 synchronized                                                                                                                                                                                                                                         
40 this                                                                                                                                                                                                                                                 
41 throw                                                                                                                                                                                                                                                
42 throws                                                                                                                                                                                                                                               
43 transient
44 try                                                                                                                                                                                                                                                  
45 void                                                                                                                                                                                                                                                 
46 volatile                                                                                                                                                                                                                                             
47 while 
*/
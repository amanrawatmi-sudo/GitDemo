import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;

// Create a code to count total number of names that starts with "A"
public class javaLecture1 {

    @Test
    public void Regular() {
        ArrayList<String> names = new ArrayList<String>();
        names.add("Aman");
        names.add("Tang");
        names.add("Amit");
        names.add("Sumit");
        names.add("Aansh");
        int count=0;
        for(int i =0; i<names.size();i++)
        {
        	String name = names.get(i);
        	if(name.startsWith("A"))
        	{
        		count++;
        	}
        }
        System.out.println(count);
    }
    
    @Test
    public void usingStream()
    {
    	ArrayList<String> names = new ArrayList<String>();
        names.add("Pman");
        names.add("Tang");
        names.add("Amit");
        names.add("Sumit");
        names.add("Aansh");
        // In place of adding name like this we can also do so and also directly use the filters:-
       // Stream.of("Aman", "Asish", "Amit", "Harshit");
        //Stream.of("Aman", "Asish", "Amit", "Harshit").filter(name->name.startsWith("A")).count();
        // Create Stream
        // Intermediate operation
        // Terminal operation
        // There is no life for intermediate operation if there is no terminal operation
        // Terminal operation will execute only if intermediate operation return true
        // we can create stream
        // How to use filter in Stream Api
        //Long c = names.stream().filter(name->name.startsWith("A")).count();
        // If action is more than one line then we can write this as:- 
        Long d = names.stream().filter(name->
        {name.startsWith("A");
        	return true;
        }).count();
        System.out.println(d);
        
        // Print names with length more than 4 letters
        names.stream().filter(name->name.length()>4).forEach(name->System.out.println(name));
        // We can also limit the output
        names.stream().filter(name->name.length()>4).limit(1).forEach(name->System.out.println(name));
    }
    
    @Test
    public void streamMap()
    {
    	ArrayList<String> names = new ArrayList<String>();
        names.add("Lman");
        names.add("Tang");
        names.add("Amit");
        names.add("Sumit");
        names.add("Aansh");
    	// Print the names with last letter as A and convert it to upper case
    	// Mapping to change to upper case 
    	Stream.of("Aman", "Prakhar", "Harshita", "Aditya").filter(s->s.endsWith("a")).map(s->s.toUpperCase()).forEach(s->System.out.println(s));
    	
    	// Print names that starts with letter "A" to upper case and also sort it
    	List<String> nam = Arrays.asList("Aman", "Prakhar", "Harshita", "Aditya");
    	nam.stream().filter(s->s.startsWith("A")).map(s->s.toUpperCase()).sorted().forEach(s->System.out.println(s));
    	
    	//Merge two lists and then sort it
    	Stream<String> newStream = Stream.concat(names.stream(), nam.stream());
    	newStream.sorted().forEach(s->System.out.println(s));
    	// Find a name using Match 
    	// Match is directly returning True or false as response 
    	Stream<String> newStream1 = Stream.concat(names.stream(), nam.stream());
    	boolean flag = newStream1.anyMatch(s->s.equalsIgnoreCase("Sumit"));
    	System.out.println(flag);
    	Assert.assertTrue(flag);
    }
    
    @Test
    public void streamCollect()
    {
    	// Collect method is used to collect all the results and convert it back to a list
    	// perform an action on a list and convert it into a new list
    	List<String> ls = Stream.of("Aman", "Prakhar", "Harshita", "Aditya").filter(s->s.endsWith("a")).map(s->s.toUpperCase()).collect(Collectors.toList());
    	System.out.println(ls.get(0));
    	
    	// Now Pick Unique numbers from array and sort it
    	// Using Distinct to get unique number from array list
    	// Then print only 3rd index value
    	List<Integer> num = Arrays.asList(3,2,1,4,5,6,3,2,5);
    	num.stream().distinct().sorted().forEach(n->System.out.println(n));
    	List<Integer>numList = num.stream().distinct().sorted().collect(Collectors.toList());
    	System.out.println("Value at third index is "+numList.get(2));
    	
    }
}
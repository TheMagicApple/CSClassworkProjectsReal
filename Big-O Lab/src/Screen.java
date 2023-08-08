import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Screen extends JPanel implements ActionListener{
	private MyArrayList<Student> database=new MyArrayList<>();
	private JTextArea students;
	private JTextField search;
	private JButton binarySearch;
	private JButton linearSearch;
	private JButton scramble;
	private JButton bubbleSort;
	private JButton mergeSort;
	private int pass=0;
	private Student searchStudent;
	public Screen() throws IOException {
		File f=new File("names.txt");
		BufferedReader br= new BufferedReader(new FileReader(f));
		String ss;
		while((ss=br.readLine())!=null) {
			String[] student=ss.split(" ");
			//System.out.println(student[1]);
			if(database.size()==0) {
				//System.out.println("ADDED TO FRONT");
				database.add(new Student(student[0],student[1],(int)(Math.random()*5+14)));
			}
			else {
				if(binarySearch(database,student[1],0,database.size()-1)==database.size()) {
					database.add(new Student(student[0],student[1],(int)(Math.random()*5+14)));
					//System.out.println("ADDED TO END");
				}else {
					//System.out.println("ADDED AT INDEX "+binarySearch(database,student[1],0,database.size()-1));
					database.add(binarySearch(database,student[1],0,database.size()-1),new Student(student[0],student[1],(int)(Math.random()*5+14)));
					
				}
				//System.out.println(binarySearch(database,student[1],0,database.size()-1));
				
			}
			
			
		}
		
		setLayout(null);
		students = new JTextArea();
		students.setSize(400,400);  
		students.setVisible(true);
		students.setEditable(false);
	    add(students);
	    JScrollPane scroll=new JScrollPane(students);
	    scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	    scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	    scroll.setBounds(10,10,480,250);
	    add(scroll);
	    
	    search=new JTextField();
	    search.setBounds(70,300,200,50);
	    add(search);
	    linearSearch=new JButton("Sequential search");
	    binarySearch=new JButton("Binary search");
	    scramble=new JButton("Scramble");
	    bubbleSort=new JButton("Bubble sort");
	    mergeSort=new JButton("Merge sort");
	    linearSearch.setBounds(320,340,150,50);
	    binarySearch.setBounds(320,270,150,50);
	    scramble.setBounds(50,430,100,50);
	    bubbleSort.setBounds(190,430,120,50);
	    mergeSort.setBounds(350,430,100,50);
	    add(linearSearch);
	    add(binarySearch);
	    add(scramble);
	    add(bubbleSort);
	    add(mergeSort);
	    linearSearch.addActionListener(this);
	    binarySearch.addActionListener(this);
	    scramble.addActionListener(this);
	    bubbleSort.addActionListener(this);
	    mergeSort.addActionListener(this);
	}
	public JTextArea get() {
		return students;
	}
	public Dimension getPreferredSize() {
		return new Dimension(500,500);
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		String studentString="";
		int counter=1;
		for(Student student:database) {
			studentString+=counter+". "+student.getLastName()+", "+student.getFirstName()+" - "+student.getAge()+"\n";
			counter++;
		}
		students.setText(studentString);
		g.setFont(new Font("Arial",Font.PLAIN,30));
		g.drawString("Passes: "+pass, 100, 400);
		g.setFont(new Font("Arial",Font.PLAIN,15));
		if(searchStudent!=null) {
			g.drawString("Searched student: "+searchStudent.getLastName()+", "+searchStudent.getFirstName()+" - "+searchStudent.getAge(), 15,290);
		}else {
			g.drawString("Searched student: None", 15,290);
		}
	}
	public static int binarySearch (MyArrayList<Student> list, String value, int start_pos, int end_pos ){
	    if(start_pos<=end_pos){
	      
	    
	      int mid=(end_pos+start_pos)/2;
	     
	      if(list.get(mid).getLastName().compareTo(value)==0){
	       // System.out.println("FOUND");
	        return mid;
	      }
	      else if(list.get(mid).getLastName().compareTo(value)>0){
	        //System.out.println("SPLIT");
	        return binarySearch(list,value,start_pos,mid-1);
	      }
	      else if(list.get(mid).getLastName().compareTo(value)<0){
	        //System.out.println("SPLIT");
	        return binarySearch(list,value,mid+1,end_pos);
	      }
	    }
	    return start_pos;
	    
	    
	  }
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		pass=0;
		if(e.getSource()==linearSearch) {
			String lastName=search.getText();
			boolean foundStudent=false;
			for(Student student:database) {
				if(student.getLastName().equals(lastName)) {
					searchStudent=student;
					foundStudent=true;
				}
				pass++;
			}
			if(!foundStudent) {
				searchStudent=null;
			}
		}
		if(e.getSource()==binarySearch) {
			String lastName=search.getText();
			
			int index=binarySearch(database,0,database.size()-1,lastName);
			if(index==-1) {
				searchStudent=null;
			}else {
				searchStudent=database.get(index);
			}
			
			
		}
		if(e.getSource()==scramble) {
			for(int i=0;i<database.size();i++) {
				int random=(int)(Math.random()*database.size());
				Student temp=database.get(i);
				database.set(i, database.get(random));
				database.set(random, temp);
				pass++;
			}
			searchStudent=null;
		}
		if(e.getSource()==bubbleSort) {
			for(int i=0;i<database.size();i++) {
				for(int k=0;k<database.size()-1;k++) {
					if(database.get(k).getLastName().compareTo(database.get(k+1).getLastName())>0) {
						Student temp=database.get(k);
						database.set(k, database.get(k+1));
						database.set(k+1, temp);
						
					}
					pass++;
				}
			}
			searchStudent=null;
		}
		if(e.getSource()==mergeSort) {
			mergeSort(database,0,database.size());
			searchStudent=null;
		}
		repaint();
		
	}
	private void mergeSort(MyArrayList<Student> array, int start, int end){

	    int mid = (start+end)/2;

	    if( mid == start )
	      return;
	    
	    mergeSort(array, start, mid); //Split the first half
	    mergeSort(array, mid, end); //Split the second half

	    //Once all the recursive calls are done
	    //merge is called.
	    merge(array, start, end); 
	    
	  }

	  private void merge(MyArrayList<Student> array, int start, int end){
	   
	    
	    

	    //Split the array into two halves
	    Student[] temp = new Student[end-start];
	    int mid=(start+end)/2;
	    
	    //Set the starting position for each halves
	    int i=start;
	    int j=mid;

	    //Place the numbers between the split array locations
	    //into to a temp array where the lowest number 
	    //is placed first.
	    int k=0;//This is used to track the index of the temp array
	    while( i<mid && j<end){
	      if(array.get(i).getLastName().compareTo(array.get(j).getLastName()) < 0){
	        temp[k] = array.get(i);
	        i++;
	      } else {
	        temp[k] = array.get(j);
	        j++;
	      }
	     pass++;
	      k++;
	    }
	   
	    //If i or j has left over numbers, place them at the end.
	    while( i<mid ){
	      temp[k] = array.get(i);
	      i++;
	      k++;
	      pass++;
	    }
	    while( j<end ){
	      temp[k] = array.get(j);
	      j++;
	      k++;
	      pass++;
	    }

	    //Put the sorted temp array back into array.
	    for(i=0; i<end-start; i++){
	      array.set(start+i, temp[i]);
	      pass++;
	    }

	}
	/*
	void merge(MyArrayList<Student> arr, int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;
        //n1 is 2 n2 is 1
        
        Student L[] = new Student[n1];
        Student R[] = new Student[n2];
  
       
        for (int i = 0; i < n1; i++)
            L[i] = arr.get(l+i);
        for (int j = 0; j < n2; j++)
            R[j] = arr.get(m+j);
  
       
  
        // Initial indexes of first and second subarrays
        int i = 0, j = 0;
  
        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
           
        	if (L[i].getLastName().compareTo(R[j].getLastName())<0) {
                arr.set(k, L[i]);
                i++;
            }
            else {
                arr.set(k,R[j]);
                j++;
            }
            k++;
        }
  
      
        while (i < n1) {
            arr.set(k, L[i]);
            i++;
            k++;
        }
  
       
        while (j < n2) {
            arr.set(k,R[j]);
            j++;
            k++;
        }
    }
  
    // Main function that sorts arr[l..r] using
    // merge()
    void sort(MyArrayList<Student> arr, int l, int r)
    {
        if (l < r) {
            // Find the middle point
            int m =l+ (r-l)/2;
  
            // Sort first and second halves
            System.out.println("SORTING BETWEEN"+l+" AND "+m);
            sort(arr, l, m);
            System.out.println("SORTING BETWEEN"+(m+1)+" AND "+r);
            sort(arr, m + 1, r);
            System.out.println("MERGING "+l+" "+m+" "+r);
            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }
    */
	private int binarySearch(MyArrayList<Student> arr, int l, int r,String lastName)
	{
	    if (r >= l) {
	        int mid = l + (r - l) / 2;
	        if (arr.get(mid).getLastName().equals(lastName)) {
	        	
	        	return mid;
	        }
	        if (arr.get(mid).getLastName().compareTo(lastName)>0) {
	        	pass++;
	        	return binarySearch(arr, l, mid - 1, lastName);
	        }
	        pass++;
	        return binarySearch(arr, mid + 1, r, lastName);
	    }
	   
	    return -1;
	}

}

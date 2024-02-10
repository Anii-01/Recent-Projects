// Customised Database Management System
 
class node
{
    private static int Counter = 1;     // Auto incremeter   // primary key

    // col
    public int Rno;
    public String Name;
    public String City;
    public int Marks;

    // next pointer
    public node next;

    public node(String B, String C, int D)
    {
        Rno = Counter;
        Counter ++;

        Name = B;
        City = C;
        Marks = D;
        next = null;
    }
}

class DBMS
{
    private node first;

    public DBMS()
    {
        first = null;
        System.out.println("DBMS initailised succesfully...");
        System.out.println("Student Table gets created succesfully...");
    }

    // InsertLast
    // insert into table student values(1,'Amit','Pune',89);
    public void InsertIntoTable(String Name, String City, int Marks)
    {
        node newn = new node(Name,City,Marks);

        if(first == null)
        {
            first = newn;
        }
        else
        {
            node temp = first;
            while(temp.next != null)
            {
                temp = temp.next;
            }

            temp.next = newn;
        }
        System.out.println("One record gets inserted succesfully...");
    }

    // Display
    // select * from student
    public void SelectStarFrom()
    {
        System.out.println("Data from the student table is : ");

        node temp = first;

        System.out.println("--------------------------------------------------------------");
        while(temp != null)
        {
            System.out.println(temp.Rno+"\t"+temp.Name+"\t"+temp.City+"\t"+temp.Marks);
            temp = temp.next;
        }
        System.out.println("--------------------------------------------------------------");
    }

    // function overlodding
     // select * from student where cit = '------';
    // public void SelectStarFrom()

    public void SelectStarFromWhereCity(String str)
     {
         System.out.println("Data from the student table where city is : "+str);
 
         node temp = first;
 
         System.out.println("--------------------------------------------------------------");
         while(temp != null)
         {
            if(str.equals(temp.City))
            {
                System.out.println(temp.Rno+"\t"+temp.Name+"\t"+temp.City+"\t"+temp.Marks);
            }
            temp = temp.next;
         }
         System.out.println("--------------------------------------------------------------");
     }

     //select Count(Marks) from student
     public void SelectCount()
     {
        node temp = first;
        int iCnt = 0;

        while(temp != null)
        {
            temp = temp.next;
            iCnt ++ ;
        }

        System.out.println("Number of records in the table :" + iCnt);

     }

     //select Sum(Marks) from student;
     public void SelectSum()
     {
        node temp = first;
        int iSum = 0;

        while(temp != null)
        {
            iSum = iSum + temp.Marks;
            temp = temp.next;
        }

        System.out.println("Summation of Marks column is :" + iSum);

     }

     //select Avg(Marks) from student;
     public void SelectAvg()
     {
        node temp = first;
        int iSum = 0;
        int iCnt = 0;

        while(temp != null)
        {
            iSum = iSum + temp.Marks;
            temp = temp.next;
            iCnt ++;
        }

        System.out.println("Average of Marks column is :" +(float)((float)iSum/(float)iCnt));

     }

     //select Max(Marks) from student;
     public void SelectMax()
     {
        node temp = first;
        int iMax = 0;

        if(temp != null)
        {
            iMax = temp.Marks;
        }

        while(temp != null)
        {
            if(temp.Marks > iMax)
            {
                iMax = temp.Marks;
            }

            temp = temp.next;

        }

        System.out.println("Maximum of Marks column is :" + iMax);

     }    

     //select Min(Marks) from student;
     public void SelectMin()
     {
        node temp = first;
        int iMin = 0;

        if(temp != null)
        {
            iMin = temp.Marks;    // bcz of exception...(avoid exception)
        }

        while(temp != null)
        {
            if(temp.Marks < iMin)
            {
                iMin = temp.Marks;
            }

            temp = temp.next;
        }

        System.out.println("Minimum of Marks column is :" + iMin);
     }    

    // select * from student where name = "----";
    public void SelectStarFromName(String str)
    {
        node temp = first;

        if(temp == null)
        {
            return;
        }

        System.out.println("Information about student whose name is "+str+ ": ");
        while(temp != null)
        {
            if((str).equals(temp.Name))
            {
                System.out.println(temp.Rno+"\t"+temp.Name+"\t"+temp.City+"\t"+temp.Marks);
            }
            temp = temp.next;
        }
    }

    //update student set City = "----" where Rno = "----";
    public void UpdateCity(int no, String str)
    {
        node temp = first;

        while(temp != null)
        {
            if(temp.Rno == no)
            {
                temp.City = str;
                break;
            }
            temp = temp.next;
        }

        System.out.println("Record gets updated..!");
    }


    //11 : delete from student where Rno = ----;
    public void DeleteFrom(int no)
    {
        node temp = first;

        if(temp == null)
        {
            return;
        }
        // if first node is the targated node
        if(temp.Rno == no)
        {
            first = first.next;
            return;
        }

        else
        {
            while(temp.next != null)
            {
                if(temp.next.Rno == no)
                {
                    temp.next = temp.next.next;
                    break;
                }
                temp = temp.next;
            }
        }
    }
}

class CustomDBMS
{
    public static void main(String Arg[])
    {
        DBMS obj = new DBMS();

        obj.InsertIntoTable("Amit","Pune",89);
        obj.InsertIntoTable("Pooja","Mumbai",95);
        obj.InsertIntoTable("Gauri","Pune",90);
        obj.InsertIntoTable("Amit","Nagar",89);
        obj.InsertIntoTable("Rahul","Satara",80);
        obj.InsertIntoTable("Neha","Pune",78);
        obj.InsertIntoTable("Rukmini","Kolhapur",77);

        obj.SelectStarFrom();
        obj.SelectStarFromWhereCity("Pune");

        obj.SelectSum();

        obj.SelectCount();

        obj.SelectAvg();

        obj.SelectMax();

        obj.SelectMin();
        
        obj.SelectStarFromName("Amit");

        obj.UpdateCity(3, "Nashik");

        obj.SelectStarFrom();

        obj.DeleteFrom(5);

        obj.SelectStarFrom();

    }
}


/*

Supported Queries

1 : insert into student values('Amit','pune',78);
2 : select * from student;
3 : select * from student where City == 'Pune';

// Aggregate functions

4 : select Count(Marks) from student;
5 :  select Sum(Marks) from student;
6 : select Avg(Marks) from student;
7 : select Max(Marks) from student;
8 : select Min(Marks) from student;

9 : select * from student where name = "----";

10 : update student set City = "----" where Rno = "----";

11 : delete from student where Rno = ----;


*/

//  
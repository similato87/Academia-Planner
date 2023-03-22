# Academia-Planner
The system we are going to build is a course registration system.  
## Software Patterns
- **Singleton**  
Classes: Database
- **Proxy** (enrollments)  
Classes: EnrollmentProxy
- **Builder** (enrollments)
Classes: EnrollmentBuilder
- **Factory method** (department)
Interface: Department, DepartmentFactory Classes: CSDepartment(Factory), SWEDepartment(Factory), ECEDepartment(Factory)
- **Adaptor** (record, recordAdaptor)
Classes: Record, RecordAdaptor
- **Iterator** (students, courses)
Interface: Iterator, Classes: StudentIterator, CourseIterator
- **Composite** (enrollment, transcript)
Interface: Registration, Classes: Transcript
## Result
Demo: Example to create a student's transcript
```
CS1073 Java I A 16.0  
Transcript of John Doe(ID:3333333)  
Java I	4	90.0  
Java II	4	70.0  
Software Design Patterns and Architecture	4	85.0  
Average Percentage: 81.66666666666667  

Student: John Doe(3333333), Business, Fredericton  
Course[code='CS1073', name='Java I']  
  
Process finished with exit code 0  
```


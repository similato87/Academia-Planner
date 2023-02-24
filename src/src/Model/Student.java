package Model;

public class Student {
    private int studentID;
    private String name;
    private String campus;
    private String program;

    public Student(){
    }

    public Student(int studentID, String name, String campus, String program){
        this.studentID=studentID;
        this.name=name;
        this.campus=campus;
        this.program=program;
    }

    public int getStudentID(){ return studentID; }
    //Restricted functionality? Should be private probably since we're emulating this being a PK
    public void setStudentID(int id){ this.studentID=id; }
    
    public String getName(){ return name; }
    public void setName(String name){ this.name=name; }

    public String getCampus(){ return campus; }
    public void setCampus(String campus){ this.campus=campus; }

    public String getProgram(){ return program; }
    public void setProgram(String program){ this.program=program; }
    //Equals method needed?
}

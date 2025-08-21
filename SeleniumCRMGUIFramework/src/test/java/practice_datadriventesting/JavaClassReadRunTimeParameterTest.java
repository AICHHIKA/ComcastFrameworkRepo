package practice_datadriventesting;

public class JavaClassReadRunTimeParameterTest {

	public static void main(String[] args) {
		//How to read data from the Command line with normal java program, Goto notepad(java file), open cmd,Give location of file,compile java file
        //cd C:\Users\User\Desktop\code
		//javac JavaClassReadRunTimeParameterTest.java, Execute: cmd: java JavaClassReadRunTimeParameterTest
		System.out.println(args.length);
		//length is: 0,  in cmd: java JavaClassReadRunTimeParameterTest Aichhika qspiders 9819872546
		//length is: 3
		//Display the content of the argument use for loop, copy this for... paste it to the notepad(java file)
		for(String var: args) {
			System.out.println(var);
		}
		
	}

}

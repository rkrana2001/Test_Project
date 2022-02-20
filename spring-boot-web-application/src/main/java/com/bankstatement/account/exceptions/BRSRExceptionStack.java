package com.bankstatement.account.exceptions;

import java.io.PrintStream;

public class BRSRExceptionStack extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	private String stackTrace;
	
	protected BRSRExceptionStack() {
		
	}
	
protected BRSRExceptionStack(String message) {
		super(message);
	}

protected BRSRExceptionStack(String message, Throwable throwable) {
	super(message == null ? throwable != null ? throwable.toString():null:message);
	if(throwable != null)
		preserveStackTrace(throwable);
}

protected BRSRExceptionStack(Throwable throwable) {
	super(throwable != null ? throwable.toString():null,throwable);
	if(throwable != null)
		preserveStackTrace(throwable);
}

@Override
public void printStackTrace() {
	
	PrintStream printStream = System.err;
	super.printStackTrace(printStream);
	if(stackTrace != null) {
		printStream.print(stackTrace);
		printStream.flush();
		printStream.close();
	}
}

@Override
public void printStackTrace(PrintStream printStream) {
	
	super.printStackTrace(printStream);
	if(stackTrace != null) {
		printStream.print(stackTrace);
		printStream.flush();
		printStream.close();
	}
}



private void preserveStackTrace(Throwable throwable) {
	stackTrace = throwable.toString();
}

}

package no.item.domino.swagger.wink.exceptions;

import java.io.Serializable;


public class AnException extends Exception implements Serializable{

	private static final long serialVersionUID = 8767078643913717295L;
	private int code;
	
	public AnException (int code, String msg) {
		super(msg);
		this.code = code;
	}
}

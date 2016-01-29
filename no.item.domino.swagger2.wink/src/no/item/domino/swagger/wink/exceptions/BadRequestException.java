package no.item.domino.swagger.wink.exceptions;

import java.io.Serializable;

public class BadRequestException extends AnException implements Serializable{

	private static final long serialVersionUID = 2334011338800910201L;
	private int code;

	public BadRequestException (int code, String msg) {
		super(code, msg);
		this.code = code;
	}
}

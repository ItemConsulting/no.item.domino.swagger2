package no.item.domino.swagger.wink.exceptions;

import java.io.Serializable;

public class NotFoundException extends AnException implements Serializable {

	private static final long serialVersionUID = 729252138903769356L;
	private int code;
	public NotFoundException (int code, String msg) {
		super(code, msg);
		this.code = code;
	}
}

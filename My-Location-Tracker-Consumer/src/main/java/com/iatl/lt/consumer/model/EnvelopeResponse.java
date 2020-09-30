package com.iatl.lt.consumer.model;

import lombok.Data;

/**
 * @author Apu Das Gupta
 *
 */

@Data
public class EnvelopeResponse {
	private int status;
	private String message;
	private Object data;
}



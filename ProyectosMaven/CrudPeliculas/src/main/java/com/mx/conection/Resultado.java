package com.mx.conection;

public class Resultado {

	// Atributos
	// Cuando se guarde el servido me va a dar una respuesta
	String mensaje;
	String respuesta;
	Object obj;

	public Resultado() {
	}

	public Resultado(String mensaje, String respuesta, Object obj) {
		this.mensaje = mensaje;
		this.respuesta = respuesta;
		this.obj = obj;
	}

	@Override
	public String toString() {
		return "Resultado [mensaje=" + mensaje + ", respuesta=" + respuesta + ", obj=" + obj + "]";
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getRespuesta() {
		return respuesta;
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}

}

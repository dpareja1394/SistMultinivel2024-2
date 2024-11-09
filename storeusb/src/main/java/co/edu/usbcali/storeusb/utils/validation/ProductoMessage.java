package co.edu.usbcali.storeusb.utils.validation;

public class ProductoMessage {
    public static final String REFERENCIA_NO_NULA = "La referencia no puede ser nula ni vacía";
    public static final String VALIDACION_REFERENCIA_CARACTERES = "La referencia no puede superar el tamaño de 10 caracteres";
    public static final String NOMBRE_NO_NULO = "El nombre no puede ser nulo ni vacío";
    public static final String VALIDACION_NOMBRE_CARACTERES = "El nombre no puede tener menos de 3 caracteres y más de 50 caracteres";
    public static final String VALIDACION_DESCRIPCION_CARACTERES = "La descripción no puede no puede superar los 255 caracteres";
    public static final String PRECIO_UNITARIO_NO_NULO = "El precio unitario no puede ser nulo";
    public static final String UNIDADES_DISPONIBLES_NO_NULA = "Las unidades disponibles no puede ser nulas";
    public static final String CATEGORIA_ID_NO_NULA = "Debe tener un valor en categoria_id";

    public static final String EXISTE_REFERENCIA_EN_CATEGORIA = "Ya existe la referencia %s en la categoria %d - %s";
}

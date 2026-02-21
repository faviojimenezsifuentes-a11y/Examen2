package com.examen.full_Api_Pc.enums;

public enum EstadoContribuyente {
    ACTIVO,
    BAJA,
    SUSPENDIDO,
    DESCONOCIDO;
    public static EstadoContribuyente fromProvider(String s){
        if(s == null) return DESCONOCIDO;
        return switch (s.trim().toUpperCase()){
            case "ACTIVO" -> ACTIVO;
            case "BAJA" -> BAJA;
            case "SUSPENDIDO" -> SUSPENDIDO;
            default -> DESCONOCIDO;
        };
    }
}

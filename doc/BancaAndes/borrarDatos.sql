
'DELETEFROM'||TABLE_NAME||''                                                                                                                
--------------------------------------------------------------------------------------------------------------------------------------------
DELETE FROM A_GERENTEOFICINA
DELETE FROM A_PRESTAMO
DELETE FROM A_OFICINA
DELETE FROM A_USUARIO
DELETE FROM A_PUNTODEATENCION
DELETE FROM A_CLIENTE
DELETE FROM A_ABRIRCDT
DELETE FROM A_ABRIRCUENTA
DELETE FROM A_ACCIONES
DELETE FROM A_ACTIVARCUENTA
DELETE FROM A_ADMINISTRADOR

'DELETEFROM'||TABLE_NAME||''                                                                                                                
--------------------------------------------------------------------------------------------------------------------------------------------
DELETE FROM A_APROBARPRESTAMO
DELETE FROM A_BAR
DELETE FROM A_BEBEDOR
DELETE FROM A_BEBIDA
DELETE FROM A_CAJERO
DELETE FROM A_CDT
DELETE FROM A_CERRARCDT
DELETE FROM A_CERRARCUENTA
DELETE FROM A_CERRARPRESTAMO
DELETE FROM A_CONSIGNARCUENTA
DELETE FROM A_CUENTA

'DELETEFROM'||TABLE_NAME||''                                                                                                                
--------------------------------------------------------------------------------------------------------------------------------------------
DELETE FROM A_DESACTIVARCUENTA
DELETE FROM A_GERENTEGENERAL
DELETE FROM A_GUSTAN
DELETE FROM A_OPERACIONACCION
DELETE FROM A_PAGOCUOTA
DELETE FROM A_PAGOCUOTAEXTRAORDINARIA
DELETE FROM A_RECHAZARPRESTAMO
DELETE FROM A_RENOVARCDT
DELETE FROM A_SIRVEN
DELETE FROM A_SOLICITARPRESTAMO
DELETE FROM A_TIPOBEBIDA

'DELETEFROM'||TABLE_NAME||''                                                                                                                
--------------------------------------------------------------------------------------------------------------------------------------------
DELETE FROM A_TRANSFERENCIACUENTA
DELETE FROM A_VISITAN

35 filas seleccionadas. 


'DELETEFROM'||TABLE_NAME||';'                                                                                                                
---------------------------------------------------------------------------------------------------------------------------------------------
DELETE FROM A_GERENTEOFICINA;
DELETE FROM A_PRESTAMO;
DELETE FROM A_OFICINA;
DELETE FROM A_USUARIO;
DELETE FROM A_PUNTODEATENCION;
DELETE FROM A_CLIENTE;
DELETE FROM A_ABRIRCDT;
DELETE FROM A_ABRIRCUENTA;
DELETE FROM A_ACCIONES;
DELETE FROM A_ACTIVARCUENTA;
DELETE FROM A_ADMINISTRADOR;

'DELETEFROM'||TABLE_NAME||';'                                                                                                                
---------------------------------------------------------------------------------------------------------------------------------------------
DELETE FROM A_APROBARPRESTAMO;
DELETE FROM A_BAR;
DELETE FROM A_BEBEDOR;
DELETE FROM A_BEBIDA;
DELETE FROM A_CAJERO;
DELETE FROM A_CDT;
DELETE FROM A_CERRARCDT;
DELETE FROM A_CERRARCUENTA;
DELETE FROM A_CERRARPRESTAMO;
DELETE FROM A_CONSIGNARCUENTA;
DELETE FROM A_CUENTA;

'DELETEFROM'||TABLE_NAME||';'                                                                                                                
---------------------------------------------------------------------------------------------------------------------------------------------
DELETE FROM A_DESACTIVARCUENTA;
DELETE FROM A_GERENTEGENERAL;
DELETE FROM A_GUSTAN;
DELETE FROM A_OPERACIONACCION;
DELETE FROM A_PAGOCUOTA;
DELETE FROM A_PAGOCUOTAEXTRAORDINARIA;
DELETE FROM A_RECHAZARPRESTAMO;
DELETE FROM A_RENOVARCDT;
DELETE FROM A_SIRVEN;
DELETE FROM A_SOLICITARPRESTAMO;
DELETE FROM A_TIPOBEBIDA;

'DELETEFROM'||TABLE_NAME||';'                                                                                                                
---------------------------------------------------------------------------------------------------------------------------------------------
DELETE FROM A_TRANSFERENCIACUENTA;
DELETE FROM A_VISITAN;

35 filas seleccionadas. 


Error que empieza en la línea: 1 del comando :
TRUNCATE TABLE table_name
CASCADE
Informe de error -
ORA-00942: la tabla o vista no existe
00942. 00000 -  "table or view does not exist"
*Cause:    
*Action:

Error que empieza en la línea: 1 del comando :
TRUNCATE TABLE table_name
CASCADE
Informe de error -
ORA-00942: la tabla o vista no existe
00942. 00000 -  "table or view does not exist"
*Cause:    
*Action:

'TRUNCATETABLE'||TABLE_NAME||';'                                                                                                                
------------------------------------------------------------------------------------------------------------------------------------------------
truncate table A_GERENTEOFICINA;
truncate table A_PRESTAMO;
truncate table A_OFICINA;
truncate table A_USUARIO;
truncate table A_PUNTODEATENCION;
truncate table A_CLIENTE;
truncate table A_ABRIRCDT;
truncate table A_ABRIRCUENTA;
truncate table A_ACCIONES;
truncate table A_ACTIVARCUENTA;
truncate table A_ADMINISTRADOR;

'TRUNCATETABLE'||TABLE_NAME||';'                                                                                                                
------------------------------------------------------------------------------------------------------------------------------------------------
truncate table A_APROBARPRESTAMO;
truncate table A_BAR;
truncate table A_BEBEDOR;
truncate table A_BEBIDA;
truncate table A_CAJERO;
truncate table A_CDT;
truncate table A_CERRARCDT;
truncate table A_CERRARCUENTA;
truncate table A_CERRARPRESTAMO;
truncate table A_CONSIGNARCUENTA;
truncate table A_CUENTA;

'TRUNCATETABLE'||TABLE_NAME||';'                                                                                                                
------------------------------------------------------------------------------------------------------------------------------------------------
truncate table A_DESACTIVARCUENTA;
truncate table A_GERENTEGENERAL;
truncate table A_GUSTAN;
truncate table A_OPERACIONACCION;
truncate table A_PAGOCUOTA;
truncate table A_PAGOCUOTAEXTRAORDINARIA;
truncate table A_RECHAZARPRESTAMO;
truncate table A_RENOVARCDT;
truncate table A_SIRVEN;
truncate table A_SOLICITARPRESTAMO;
truncate table A_TIPOBEBIDA;

'TRUNCATETABLE'||TABLE_NAME||';'                                                                                                                
------------------------------------------------------------------------------------------------------------------------------------------------
truncate table A_TRANSFERENCIACUENTA;
truncate table A_VISITAN;

35 filas seleccionadas. 

